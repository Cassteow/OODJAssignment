package VaccinationProgram;

import static VaccinationProgram.FrmAddRegistration.dateChooserDOB;
import static VaccinationProgram.FrmMainLogin.cmbBoxUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Personnel extends User{
    
    public Personnel(String accountID, String password, String name){
        
    }
    
    public Personnel(){
        
    }
    
    //Method: Login for People User
    @Override
    public Boolean LoginAccount(String id, String pw){
        String frmAccID = id;
        String password = pw;
        Boolean verifyExistence = false;
        Boolean loginVerified = false;
        //to check for existing Account ID and password records
        try{
            File file = new File("Personnel.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String checkLine = null;
            verifyExistence = false;
            while((checkLine = br.readLine()) != null)
            {
                String [] temp = checkLine.split(";");
                if(temp[0].equals(frmAccID) && temp[1].equals(password))
                    {
                        verifyExistence = true;
                        break;
                    }
            }   
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system.\n"
                    + "Please try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //if statements for trasitions after login button
        if(verifyExistence == true && "Personnel".equals(cmbBoxUser.getItemAt(cmbBoxUser.getSelectedIndex())))
        {
            loginVerified = true;                 
        }
        return loginVerified;
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
                JOptionPane.showMessageDialog(null, "There is an error in the system!"
                        + "\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "There is an error in the system!"
                        + "\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
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
    
    //Method: Search for Registration Record
    public boolean searchRegistration(String searchID){
        boolean found = false;       
        try{
            File file = new File("People.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)FrmRegistrationRecordsPersonnel.tblAccDetails.getModel();
            Object[] lines = br.lines().toArray();
            model.setRowCount(0);
            for(int i = 0; i<lines.length;i++){                
                String[] row = lines[i].toString().split(";");
                //if search text matches Appointment ID or account ID, display it
                if(row[0].equals(searchID) || row[5].equals(searchID)){
                    String[] record = {row[0],row[2],row[3],row[10]};
                    model.addRow(record);
                    found = true;
                }                
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        return found;
    }
    
    //Method: Modify Registration Details
    @Override
    public boolean ModifyRegistration(){
       String FullName, IC_Passport, Citizen_NonCitizen, Residence, Password, RePassword,HealthStat, TnC, DOB,PhoneNumber,vacStat;
       boolean validation = false;
       boolean modified = false;
       try{
            Date date1 = FrmModifyRegistrationPersonnel.dateChooserDOB.getDate();
            int age = Period.between(date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            DOB = df.format(date1);
            FullName = FrmModifyRegistrationPersonnel.txtBoxName.getText();
            IC_Passport = FrmModifyRegistrationPersonnel.txtBoxIC.getText();
            Citizen_NonCitizen = FrmModifyRegistrationPersonnel.cmbBoxCitz.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxCitz.getSelectedIndex());
            Residence = FrmModifyRegistrationPersonnel.cmbBoxRes.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxRes.getSelectedIndex());
            Password = FrmModifyRegistrationPersonnel.txtBoxPass.getText();
            RePassword = FrmModifyRegistrationPersonnel.txtBoxRePass.getText();
            HealthStat = FrmModifyRegistrationPersonnel.cmbBoxHA.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxHA.getSelectedIndex());
            TnC = FrmModifyRegistrationPersonnel.cmbBoxTNC.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxTNC.getSelectedIndex());
            PhoneNumber = FrmModifyRegistrationPersonnel.txtBoxPN.getText();
            vacStat = FrmModifyRegistrationPersonnel.cmbBoxVac.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxVac.getSelectedIndex());
        
            //Check are there the same account ID/phone num/IC or Passport in the system
            File f = new File("People.txt");
            BufferedReader be = new BufferedReader(new FileReader(f));
            String checkLine = null;
            boolean verifyExistence = false;
            while((checkLine = be.readLine()) != null)
            {
                String [] temp = checkLine.split(";");
                if(temp[0].equals(PhoneNumber))
                    {
                        //Phone number is still the same as before
                        if(PhoneNumber.equals(FrmModifyRegistrationPersonnel.lblPhone.getText())){
                            verifyExistence = false;
                        }else{
                            verifyExistence = true;
                        }
                        break;
                    }
            }
            be.close();
            
            //Checks for Empty Fields, Password = Repeat Password, health stat = no, TnC = yes
            //Invalid Phone Number/Account ID
            if(verifyExistence == true)
            {
                JOptionPane.showMessageDialog(null, "User Is Already Registered!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Empty Text Fields
            else if(FullName.equals("") || PhoneNumber.equals("") || IC_Passport.equals("") ||
                    DOB.equals("") || RePassword.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please ensure all fields are filled!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Invalid IC for Citizen
            else if(Citizen_NonCitizen.equals("Citizen") && IC_Passport.length()<12)
            {
                JOptionPane.showMessageDialog(null, "Invalid IC Number!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Invalid Passport for Non-Citizen
            else if(Citizen_NonCitizen.equals("Non-Citizen") && IC_Passport.length()<5)
            {
                JOptionPane.showMessageDialog(null, "Invalid Passport Number!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Invalid Passport
            else if (!Password.equals(RePassword) || Password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Invalid Password!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Invalid Medical History (not suitable for program)
            else if(HealthStat.equals("Yes"))
            {
                JOptionPane.showMessageDialog(null, "Please Consult A Healthcare Professional Before Registering!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Less than 12 Years Old
            else if(age<12){
                JOptionPane.showMessageDialog(null, "The COVID-19 Vaccine is only available for those who are 12 and above!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Disagree to TnC
            else if (TnC.equals("No"))
            {
                JOptionPane.showMessageDialog(null, "Please Read The Terms & Conditions To Proceed!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Every detail is validated
            else
            {
                validation = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There is an error with the system."
                    + "\nPlease try again later!", "Error",JOptionPane.WARNING_MESSAGE);
        }
       
       //If validation is true, modify it from the text file
        File file = new File("People.txt");
        File tempFile = new File("Temp.txt");
        
        if(validation == true){
            //Clear the temp file
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
                    String[] registration = line.split(";");
                    if(registration[0].equals(FrmModifyRegistrationPersonnel.lblID.getText())){
                        bw.append(FrmModifyRegistrationPersonnel.txtBoxPN.getText()+";");
                        bw.append(FrmModifyRegistrationPersonnel.txtBoxPass.getText()+";");
                        bw.append(FrmModifyRegistrationPersonnel.txtBoxName.getText()+";");
                        bw.append(FrmModifyRegistrationPersonnel.txtBoxIC.getText()+";");
                        bw.append(FrmModifyRegistrationPersonnel.cmbBoxCitz.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxCitz.getSelectedIndex())+";");
                        Date date1 = FrmModifyRegistrationPersonnel.dateChooserDOB.getDate();
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        DOB = df.format(date1);
                        bw.append(DOB+";");
                        bw.append(FrmModifyRegistrationPersonnel.txtBoxPN.getText()+";");
                        bw.append(FrmModifyRegistrationPersonnel.cmbBoxRes.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxRes.getSelectedIndex())+";");
                        bw.append(FrmModifyRegistrationPersonnel.cmbBoxHA.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxHA.getSelectedIndex())+";");
                        bw.append(FrmModifyRegistrationPersonnel.cmbBoxTNC.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxTNC.getSelectedIndex())+";");
                        bw.append(FrmModifyRegistrationPersonnel.cmbBoxVac.getItemAt(FrmModifyRegistrationPersonnel.cmbBoxVac.getSelectedIndex())+"\n");
               
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
       return modified;
    }
    
    //Method: Search and View Vaccine
    @Override
    public boolean viewVaccine(String searchID){
        boolean found = false;
        try{
            File file = new File("Vaccine.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String checkLine = null;
            while((checkLine = br.readLine()) != null)
            {
                String [] temp = checkLine.split(";");
                if(temp[0].equals(searchID) || temp[1].equals(searchID))
                    {
                        FrmVaccineInformationPersonnel.lblID.setText(temp[0]);
                        FrmVaccineInformationPersonnel.lblName.setText(temp[1]);
                        FrmVaccineInformationPersonnel.lblCOO.setText(temp[2]);
                        FrmVaccineInformationPersonnel.lblDoses.setText(temp[3]);
                        found = true;
                        break;
                    }
            }
            br.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "There is an error in the system.\n"
             + "Please try again later.", "Error",JOptionPane.WARNING_MESSAGE);        
        }
        return found;
    }
    
    //Method: Modify Vaccine
    public boolean modifyVaccine(String vacID, String newID, String n, String c, String d){
        boolean modified = false, modifiedFile2 = false, modifiedFile1 = false;
        File file = new File("Vaccine.txt");
        File file2 = new File("CenterSupplies.txt");
        File tempFile = new File("Temp.txt");
        
        //Modify Vaccine.txt Text File
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
                String[] vaccine = line.split(";");
                if(vaccine[0].equals(vacID)){
                    bw.append(newID+";");
                    bw.append(n+";");
                    bw.append(c+";");
                    bw.append(d+"\n");
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
            modifiedFile1 = true;
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Modify Center Supply text file
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
            BufferedReader br = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while((line = br.readLine())!= null){
                String[] vaccine = line.split(";");
                for(int i = 0; i<vaccine.length; i++){
                    if(vaccine[i].equals(vacID)){
                        vaccine[i] = newID;
                        vaccine[i+1] = n;
                    }
                }
                for(int j = 0; j< vaccine.length;j++){
                    bw.append(vaccine[j]+";");
                }
                bw.append("\n");
            }
            bw.close();
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Empty the original file
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            bw.write("");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Write modified data into original file
        try{
            BufferedReader br = new BufferedReader(new FileReader(tempFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            String line;
            while((line = br.readLine())!= null){
                //remove semicolon if line ends with semicolon
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                bw.append(line+"\n");
            } 
            bw.close();
            br.close();
            modifiedFile2 = true;
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        if(modifiedFile1 ==true && modifiedFile2 ==true){
            modified = true;
        }
        return modified;
    }
    
    //Method: Add New Vaccine
    public boolean addVaccine(String vacID, String vacName, String vacCOO, String vacDoses){
        boolean addFile1 = false,addFile2 = false, add = false;
        File file = new File("Vaccine.txt");
        File file2 = new File("CenterSupplies.txt");
        File tempFile = new File("Temp.txt");
        
        //wrtites into Vaccine.txt to add the new vaccine
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
            bf.write(vacID + ";");
            bf.write(vacName+";");
            bf.write(vacCOO+";");
            bf.write(vacDoses);
            bf.write("\n");
            bf.close();
            addFile1 = true;
        }
        catch(IOException ioe)
        {
           JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Modify Center Supply text file to add vaccine
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
            BufferedReader br = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while((line = br.readLine())!= null){
                String[] vaccine = line.split(";");
                vaccine[2] = String.valueOf(Integer.valueOf(vaccine[2])+1);
                String[] addVac = new String[vaccine.length+3];                
                for(int j = 0; j< vaccine.length;j++){
                    addVac[j] = vaccine[j];
                }
                addVac[vaccine.length] = vacID;
                addVac[vaccine.length+1] = vacName;
                addVac[vaccine.length+2] = String.valueOf(0);
                
                //Write into the temp file
                for(int i =0; i<addVac.length;i++){
                    bw.append(addVac[i]+";");
                }       
                bw.append("\n");
            }
            bw.close();
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Empty the original file
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            bw.write("");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Write modified data into original file
        try{
            BufferedReader br = new BufferedReader(new FileReader(tempFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            String line;
            while((line = br.readLine())!= null){
                //remove semicolon if line ends with semicolon
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                bw.append(line+"\n");
            } 
            bw.close();
            br.close();
            addFile2 = true;
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        if(addFile1 == true && addFile2 ==true){
            add = true;
        }
        return add;
    }
    
    //Method to delete vaccine
    public boolean deleteVaccine(String vacID){
        boolean deleteFile1 = false, deleteFile2 = false, deleted = false;
        File file = new File("Vaccine.txt");
        File file2 = new File("CenterSupplies.txt");
        File tempFile = new File("Temp.txt");
        //Delete vaccine from Vaccine.txt
        //Empty the temp file
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
                String[] vaccine = line.split(";");
                if(vaccine[0].equals(vacID)){
                    //Do not append if vaccine ID is a match
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
            deleteFile1 = true;
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Delete vaccine from Center Supplies
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
            BufferedReader br = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while((line = br.readLine())!= null){
                String[] vaccine = line.split(";");
                vaccine[2] = String.valueOf(Integer.valueOf(vaccine[2])-1);
                String[] deleteVac = new String[vaccine.length-3];
                int vacPosition = 0;
                //Find position of vaccine to be deleted
                for(int i = 0; i<vaccine.length; i++){
                    if(vaccine[i].equals(vacID)){
                        vacPosition = i;
                    }
                }
                int k = 0;
                //Remove vaccine from each line based on the vaccine position
                for(int j = 0; j< vaccine.length;j++){
                    if(j == vacPosition){
                        j = j+2;
                        k = k-1;
                    }else{
                        deleteVac[k] = vaccine[j];                      
                    }
                    k+=1;
                }
                
                
                //Write into the temp file
                for(int i =0; i<deleteVac.length;i++){
                    bw.append(deleteVac[i]+";");
                }       
                bw.append("\n");
            }
            bw.close();
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Empty the original file
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            bw.write("");
            bw.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Write modified data into original file
        try{
            BufferedReader br = new BufferedReader(new FileReader(tempFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            String line;
            while((line = br.readLine())!= null){
                //remove semicolon if line ends with semicolon
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                bw.append(line+"\n");
            } 
            bw.close();
            br.close();
            deleteFile2 = true;
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        if(deleteFile1 == true && deleteFile2 == true){
            deleted = true;
        }
        return deleted;
    }
}
