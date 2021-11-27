package VaccinationProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Personnel extends User{
    
    public Personnel(String accountID, String password, String name){
        
    }
    
    public Personnel(){
        
    }
    
    
    //Method: Personnel Search Vaccine Center
    @Override
    public void searchVaccineCenter(String search){
        boolean found = false;
        try{
            File file = new File("CenterSupplies.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)FrmCenterNSupplyPersonnel.tblVaccineSupply.getModel();
            Object[] lines = br.lines().toArray();
            model.setRowCount(0); //Clear content in table
            for(int i = 0; i<lines.length;i++){                
                String[] row = lines[i].toString().split(";");
                //if search text matches Appointment ID or account ID, display it
                if(row[0].equals(search)){
                    int vacCount = Integer.parseInt(row[2]);
                    
                    for(int j = 0; j<vacCount; j++){
                        String[] loadVaccine = {row[(j+1)*3], row[1+(j+1)*3], row[2+(j+1)*3]};
                        model.addRow(loadVaccine);
                        found = true;
                    }
                }                
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        try{
            File file = new File("VaccinationCenter.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));           
            Object[] lines = br.lines().toArray();
            //Load records from text file row by row
            for(int i = 0; i<lines.length;i++){
                String[] row = lines[i].toString().split(";");
                if(row[0].equals(search)){
                    FrmCenterNSupplyPersonnel.lblCenterID.setText(row[0]);
                    FrmCenterNSupplyPersonnel.lblCenterLocation.setText(row[1]);
                    FrmCenterNSupplyPersonnel.lblCenterDay.setText(row[2]);
                    FrmCenterNSupplyPersonnel.lblCenterTime.setText(row[3]);
                }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        if(found == false){
            FrmCenterNSupplyPersonnel.lblCenterID.setText("");
            FrmCenterNSupplyPersonnel.lblCenterLocation.setText("");
            FrmCenterNSupplyPersonnel.lblCenterDay.setText("");
            FrmCenterNSupplyPersonnel.lblCenterTime.setText("");
            JOptionPane.showMessageDialog(null, "No records found.", "Error",JOptionPane.WARNING_MESSAGE);
        }
    } 
    
    
    //Method: Modify Center Information
    public boolean modifyCenterInfo(){
        Boolean modified = false;
        Boolean validateTime = false;
        String centerID = FrmModifyCenterPersonnel.lblCenterID.getText();
        String centerLocation = FrmModifyCenterPersonnel.lblCenterLocation.getText();
        String days = "";
        
        //Get Operating days
        if(FrmModifyCenterPersonnel.chbSunday.isSelected()){
            days = days+"Sun,";
        }
        if(FrmModifyCenterPersonnel.chbMonday.isSelected()){
            days = days+"Mon,";
        }
        if(FrmModifyCenterPersonnel.chbTuesday.isSelected()){
            days = days+"Tue,";
        }
        if(FrmModifyCenterPersonnel.chbWednesday.isSelected()){
            days = days+"Wed,";
        }
        if(FrmModifyCenterPersonnel.chbThursday.isSelected()){
            days = days+"Thu,";
        }
        if(FrmModifyCenterPersonnel.chbFriday.isSelected()){
            days = days+"Fri,";
        }
        if(FrmModifyCenterPersonnel.chbSaturday.isSelected()){
            days = days+"Sat,";
        }
        
        if (days.endsWith(",")) {
            days = days.substring(0, days.length() - 1);
        }
        
        
        String startTime = FrmModifyCenterPersonnel.cmbStartTime.getSelectedItem().toString();
        String endTime = FrmModifyCenterPersonnel.cmbEndTime.getSelectedItem().toString();
        
        //Validate Operating Time
        try{
            Date st = new SimpleDateFormat("hh:mm a").parse(startTime);
            Calendar sc = Calendar.getInstance();
            sc.setTime(st);
            sc.add(Calendar.DATE, 1);
            
            Date et = new SimpleDateFormat("hh:mm a").parse(endTime);
            Calendar ec = Calendar.getInstance();
            ec.setTime(et);
            ec.add(Calendar.DATE, 1);
            
            if(st.before(et)){
                validateTime = true;
            }
            
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        
        //If time is validated, modify data
        if(validateTime = true){
            //Modify Center Data
            File file = new File("VaccinationCenter.txt");
            File tempFile = new File("Temp.txt");
        
            //Empty the temp file content
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
                bw.write("");
                bw.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Read original file and write modified data into temp file
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
                String line;
                while((line = br.readLine())!= null){
                    String[] currentAppt = line.split(";");
                    if(currentAppt[0].equals(centerID)){
                        bw.append(centerID+";");
                        bw.append(centerLocation+";");
                        bw.append(days+";");
                        bw.append(startTime+" - "+endTime+"\n");                    
                    }
                    else{
                        bw.append(line+"\n");
                    }
                }
                bw.close();
                br.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
            }
        
            //Empty the original file
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("");
                bw.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
            }
        
            //Write modified data into original file
            try{
                BufferedReader br = new BufferedReader(new FileReader(tempFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                String line;
                while((line = br.readLine())!= null){
                    bw.append(line+"\n");
                } 
                bw.close();
                br.close();
                modified = true;
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There is an error with the new operating day and time!\nPlease try again.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        return modified;
    }
    
    //Method: modify Vaccination Center Vaccine Supply
    public Boolean modifyCenterSupply(String centerID){
        boolean modified = false;
        File file = new File("CenterSupplies.txt");
        File tempFile = new File("Temp.txt");
        
        //Empty the temp file content
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            bw.write("");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        //Read original file and write modified data into temp file
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while((line = br.readLine())!= null){
                String[] row = line.split(";");
                if(row[0].equals(centerID)){
                    int vacCount = Integer.valueOf(row[2].toString());
                    String[] vaccineID = new String[vacCount];
                    String[] vaccineName = new String[vacCount];
                    int[] vacSupply = new int[vacCount];
                    
                    for(int i = 0; i< vacCount; i++){
                        vaccineID[i] = FrmCenterNSupplyPersonnel.tblVaccineSupply.getValueAt(i, 0).toString();
                        vaccineName[i] = FrmCenterNSupplyPersonnel.tblVaccineSupply.getValueAt(i, 1).toString();
                        try{
                            vacSupply[i] = Integer.parseInt(FrmCenterNSupplyPersonnel.tblVaccineSupply.getValueAt(i, 2).toString());
                        }
                        catch(NumberFormatException e)
                        {
                            e.printStackTrace();
                        }                        
                    }
                    bw.append(centerID+";");
                    bw.append(FrmCenterNSupplyPersonnel.lblCenterLocation.getText()+";");
                    bw.append(String.valueOf(vacCount));
                    for(int j = 0; j<vacCount; j++){
                        bw.append(";"+vaccineID[j]);
                        bw.append(";"+vaccineName[j]);
                        bw.append(";"+String.valueOf(vacSupply[j]));
                    }
                    bw.append("\n");
                    modified = true;
                }
                else{
                    bw.append(line+"\n");
                }
            }
            bw.close();
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Empty the original file
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Write modified data into original file
        try{
            BufferedReader br = new BufferedReader(new FileReader(tempFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line;
            while((line = br.readLine())!= null){
                bw.append(line+"\n");
            } 
            bw.close();
            br.close();
            modified = true;
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        return modified;
    } 
}
