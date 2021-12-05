
package VaccinationProgram;

import static VaccinationProgram.FrmMainLogin.cmbBoxUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class People extends User{
    
    private String icOrPassport;
    private Boolean citizenship;
    private String dob;
    private String phoneNumber;
    private String residenceLocation;
    private Boolean medicalHistory;
    private Boolean tncAgreement;
    private String vaccinationStatus;
    
    //Constructors
    public People(String accountID, String password, String name){
        
    }
    
    public People(){
        
    }
    
    //Get Set Methods
    public void setIcOrPassport(String icpp){
        this.icOrPassport = icpp;
    }
    
    public String getIcOrPassport(){
        return icOrPassport;
    }
    
    public void setCitizenship(Boolean c){
        this.citizenship = c;
    }
    
    public Boolean getCitizenship(){
        return citizenship;
    }
    
    public void setDob(String d){
        this.dob = d;
    }
    
    public String getDob(){
        return dob;
    }
    
    public void setPhoneNumber(String num){
        this.phoneNumber = num;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setResidenceLocation(String rl){
        this.residenceLocation = rl;
    }
    
    public String getResidenceLocation(){
        return residenceLocation;
    }
    
    public void setMedicalHistory(Boolean mh){
        this.medicalHistory = mh;
    }
    
    public Boolean getMedicalHistory(){
        return medicalHistory;
    }
    
    public void setTncAgreement(Boolean tnc){
        this.tncAgreement = tnc;
    }
    
    public Boolean getTncAgreement(){
        return tncAgreement;
    }
    
    public void setVaccinationStatus(String vs){
        this.vaccinationStatus = vs;
    }
    public String getVaccinationStatus(){
        return vaccinationStatus;
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
            File file = new File("People.txt");
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
        if(verifyExistence == true && "Citizen/Non-Citizen".equals(cmbBoxUser.getItemAt(cmbBoxUser.getSelectedIndex())))
        {
            loginVerified = true;                 
        }
        return loginVerified;
    }
    //Method: Search Vaccine Center
    @Override
    public void searchVaccineCenter(String centerID){
        boolean found = false;
        try{
            File file = new File("CenterSupplies.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)FrmCenterNSupplyPeople.tblVaccineSupply.getModel();
            Object[] lines = br.lines().toArray();
            model.setRowCount(0); //Clear content in table
            for(int i = 0; i<lines.length;i++){                
                String[] row = lines[i].toString().split(";");
                //if search text matches Appointment ID or account ID, display it
                if(row[0].equals(centerID)){
                    int vacCount = Integer.parseInt(row[2]);
                    
                    for(int j = 0; j<vacCount; j++){
                        String[] loadVaccine = {row[(j+1)*3], row[1+(j+1)*3], row[2+(j+1)*3]};
                        model.addRow(loadVaccine);
                        found = true;
                    }
                }                
            }
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!"
                    + "\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        try{
            File file = new File("VaccinationCenter.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));           
            Object[] lines = br.lines().toArray();
            //Load records from text file row by row
            for(int i = 0; i<lines.length;i++){
                String[] row = lines[i].toString().split(";");
                if(row[0].equals(centerID)){
                    FrmCenterNSupplyPeople.lblCenterID.setText(row[0]);
                    FrmCenterNSupplyPeople.lblCenterLocation.setText(row[1]);
                    FrmCenterNSupplyPeople.lblCenterDay.setText(row[2]);
                    FrmCenterNSupplyPeople.lblCenterTime.setText(row[3]);
                }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        if(found == false){
            FrmCenterNSupplyPeople.lblCenterID.setText("");
            FrmCenterNSupplyPeople.lblCenterLocation.setText("");
            FrmCenterNSupplyPeople.lblCenterDay.setText("");
            FrmCenterNSupplyPeople.lblCenterTime.setText("");
            JOptionPane.showMessageDialog(null, "No records found.", "Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Overload Method from User
    //Method: View Appointment Details 
    public String[] viewAppointmentDetails(String accID,String appID){
        String frmAccID = accID;
        String apptID = appID;
        String[] apptDetails = new String[6];
        
        //Get appointment details based on appointment ID
        try{
            File file = new File("Appointment.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));           
            Object[] lines = br.lines().toArray();
            //Load records from text file row by row
            for(int i = 0; i<lines.length;i++){
                String[] row = lines[i].toString().split(";");
                if(row[0].equals(apptID)){
                    apptDetails[0] = row[5];
                    apptDetails[1] = row[0];
                    apptDetails[2] = row[3];
                    apptDetails[3] = row[1];
                    apptDetails[4] = row[2];
                    apptDetails[5] = row[4];                   
                }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!"
                    + "\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return apptDetails;
    }
    
    //Method: Modify Registration Details
    @Override
    public boolean ModifyRegistration(){
       String FullName, IC_Passport, Citizen_NonCitizen, Residence, Password, RePassword,HealthStat, TnC, DOB,PhoneNumber,vacStat;
       boolean validation = false;
       boolean modified = false;
       try{
            Date date1 = FrmModifyRegistrationPeople.dateChooserDOB.getDate();
            int age = Period.between(date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            DOB = df.format(date1);
            FullName = FrmModifyRegistrationPeople.txtBoxName.getText();
            IC_Passport = FrmModifyRegistrationPeople.txtBoxIC.getText();
            Citizen_NonCitizen = FrmModifyRegistrationPeople.cmbBoxCitz.getItemAt(FrmModifyRegistrationPeople.cmbBoxCitz.getSelectedIndex());
            Residence = FrmModifyRegistrationPeople.cmbBoxRes.getItemAt(FrmModifyRegistrationPeople.cmbBoxRes.getSelectedIndex());
            Password = FrmModifyRegistrationPeople.txtBoxPass.getText();
            RePassword = FrmModifyRegistrationPeople.txtBoxRePass.getText();
            HealthStat = FrmModifyRegistrationPeople.cmbBoxHA.getItemAt(FrmModifyRegistrationPeople.cmbBoxHA.getSelectedIndex());
            TnC = FrmModifyRegistrationPeople.cmbBoxTNC.getItemAt(FrmModifyRegistrationPeople.cmbBoxTNC.getSelectedIndex());
            PhoneNumber = FrmModifyRegistrationPeople.txtBoxPN.getText();
            //People user not allowed to change vaccination status
            vacStat = FrmModifyRegistrationPeople.lblStatus.getText();
        
            //Check are there the same account ID/phone num/IC or Passport in the system
            File f = new File("People.txt");
            BufferedReader be = new BufferedReader(new FileReader(f));
            String checkLine = null;
            boolean verifyExistence = false;
            while((checkLine = be.readLine()) != null)
            {
                String [] temp = checkLine.split(";");
                if(temp[0].equals(PhoneNumber) ||temp[2].equals(IC_Passport) )
                    {
                        //Phone number is still the same as before
                        if(PhoneNumber.equals(FrmModifyRegistrationPeople.lblPhone.getText())){
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
            //Less than 12 Years Old
            else if(age<12){
                JOptionPane.showMessageDialog(null, "The COVID-19 Vaccine is only available for those who are 12 and above!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Invalid Medical History (not suitable for program)
            else if(HealthStat.equals("Yes"))
            {
                JOptionPane.showMessageDialog(null, "Please Consult A Healthcare Professional Before Registering!", "Error",JOptionPane.WARNING_MESSAGE);
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
                    if(registration[0].equals(FrmModifyRegistrationPeople.lblID.getText())){
                        bw.append(FrmModifyRegistrationPeople.txtBoxPN.getText()+";");
                        bw.append(FrmModifyRegistrationPeople.txtBoxPass.getText()+";");
                        bw.append(FrmModifyRegistrationPeople.txtBoxName.getText()+";");
                        bw.append(FrmModifyRegistrationPeople.txtBoxIC.getText()+";");
                        bw.append(FrmModifyRegistrationPeople.cmbBoxCitz.getItemAt(FrmModifyRegistrationPeople.cmbBoxCitz.getSelectedIndex())+";");
                        Date date1 = FrmModifyRegistrationPeople.dateChooserDOB.getDate();
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        DOB = df.format(date1);
                        bw.append(DOB+";");
                        bw.append(FrmModifyRegistrationPeople.txtBoxPN.getText()+";");
                        bw.append(FrmModifyRegistrationPeople.cmbBoxRes.getItemAt(FrmModifyRegistrationPeople.cmbBoxRes.getSelectedIndex())+";");
                        bw.append(FrmModifyRegistrationPeople.cmbBoxHA.getItemAt(FrmModifyRegistrationPeople.cmbBoxHA.getSelectedIndex())+";");
                        bw.append(FrmModifyRegistrationPeople.cmbBoxTNC.getItemAt(FrmModifyRegistrationPeople.cmbBoxTNC.getSelectedIndex())+";");
                        bw.append(FrmModifyRegistrationPeople.lblStatus.getText()+"\n");
               
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
                        FrmVaccineInformationPeople.lblID.setText(temp[0]);
                        FrmVaccineInformationPeople.lblName.setText(temp[1]);
                        FrmVaccineInformationPeople.lblCOO.setText(temp[2]);
                        FrmVaccineInformationPeople.lblDoses.setText(temp[3]);
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
}
