
package VaccinationProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.util.Date;
import java.util.*;


public class VaccineCenter {
    public String centerID;
    public String centerLocation;
    public String centerDay;
    public String centerTime;
    public String vaccineSupplyName;
    public String vaccineSupplyCount;
    
    //Constructor with 1 attribute
    public VaccineCenter(String id){
        this.centerID = id;
    }
    
    public VaccineCenter(String id, String L){
        this.centerID = id;
        this.centerLocation = L;
    }
    
    public String getCenterID(){
        return centerID;
    }
    
    public void setCenterID(String id){
        this.centerID = id;
    }
    
    public String getCenterLocation(){
        return centerLocation;
    }
    
    public void setCenterLocation(String L){
        this.centerLocation = L;
    }
    
    public String getCenterDay(){
        return centerDay;
    }
    
    //Method to search Vaccine center using ID (for Personnel)
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
    
    //Method to modify vaccination center information
    public Boolean modifyCenterInfo(){
        Boolean modified = false;
        Boolean validateTime = false;
        String centerID = FrmModifyCenterPersonnel.lblCenterID.getText();
        String centerLocation = FrmModifyCenterPersonnel.lblCenterLocation.getText();
        
        String startDay = FrmModifyCenterPersonnel.cmbStartDay.getSelectedItem().toString();
        String endDay = FrmModifyCenterPersonnel.cmbEndDay.getSelectedItem().toString();
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
                        bw.append(startDay+" - "+endDay+";");
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
    
    //Method to modify vaccine supplies of vaccination center
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




