package VaccinationProgram;
import static VaccinationProgram.FrmAddRegistration.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;     


public class User {
    protected String accountID;
    protected String password;
    protected String name;
    
    //Constructor
    public User(){
        
    }
    //Get Set Methods for User Class Attributes
    public void setAccountID(String id){
        this.accountID = id;
    }
    
    public String getAccountID(){
        return accountID;
    }
    
    public void setPassword(String pw){
        this.password = pw;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public String getName(){
        return name;
    }
    
    //Method: Add New Appointment Record into Text File
    public void addNewAppointment(String apptID, String d, String t, String L, 
            String vacName, String accID){
        try{
                File file = new File("Appointment.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                bw.append(apptID+";");
                bw.append(d+";");
                bw.append(t+";");
                bw.append(L+";");
                bw.append(vacName+";");
                bw.append(accID+"\n");
                bw.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "An error has occured!"
                        + "\nPlease try again later!", "Error",JOptionPane.WARNING_MESSAGE);
            }
    }
    //Method: display Appointment Details 
    public String[] viewAppointmentDetails(String aID){
        String[] apptDetails = new String[6];
        try{
            File file = new File("Appointment.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));           
            Object[] lines = br.lines().toArray();
            //Load records from text file row by row
            for(int i = 0; i<lines.length;i++){
                String[] row = lines[i].toString().split(";");
                if(row[0].equals(aID)){
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
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return apptDetails;
    }
    
    //Method: Modify Appointment
    public Boolean modifyAppointment(String apptID, String d, String t, String L, String vacName, String accID){
        File file = new File("Appointment.txt");
        File tempFile = new File("Temp.txt");
        boolean modified = false;
        
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
                if(currentAppt[0].equals(apptID)){
                    bw.append(apptID+";");
                    bw.append(d+";");
                    bw.append(t+";");
                    bw.append(L+";");
                    bw.append(vacName+";");
                    bw.append(accID+"\n");
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
    
    //Method to cancel appointment
    public boolean cancelAppointment(String apptID){
        boolean modified = true;
        File file = new File("Appointment.txt");
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
                if(currentAppt[0].equals(apptID)){
                    //Do not append if the current line matches the appointment ID (Deletion)
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
    
    //Method: Register New Account
    public boolean RegisterNewAccount(){
        String FullName, IC_Passport, Citizen_NonCitizen, Residence, Password, RePassword,HealthStat, TnC, DOB,PhoneNumber;
        Boolean registered = false;
        try{
            //Assign variables with information from form
            Date date = FrmAddRegistration.dateChooserDOB.getDate();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            DOB = df.format(date);
            FullName = (peopleRegistrationFullNameTxtBox.getText());
            IC_Passport = peopleRegistrationIdentityCardTxtBox.getText();
            Citizen_NonCitizen = cmbBoxCitizen.getItemAt(cmbBoxCitizen.getSelectedIndex());
            Residence = peopleRegistrationResidenceLocationCmbBox.getItemAt(peopleRegistrationResidenceLocationCmbBox.getSelectedIndex());
            PhoneNumber = peopleRegistrationPhoneNumberTxtBox.getText();
            Password = peopleRegistrationPasswordTxtBox.getText();
            RePassword = peopleRegistrationRepeatPasswordTxtBox.getText();
            HealthStat = cmbBoxHealthStat.getItemAt(cmbBoxHealthStat.getSelectedIndex());
            TnC = CmbBoxTnC.getItemAt(CmbBoxTnC.getSelectedIndex());
        
             
            File file = new File("People.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String checkLine = null;
            Boolean verifyExistence = false;
            while((checkLine = br.readLine()) != null)
            {
                String [] temp = checkLine.split(";");
                if(temp[0].equals(PhoneNumber) || temp[3].equals(IC_Passport))
                        {
                            verifyExistence = true;
                            break;
                        }
            }
            br.close();
            
        
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
            //Disagree to TnC
            else if (TnC.equals("No"))
            {
                JOptionPane.showMessageDialog(null, "Please Read The Terms & Conditions To Proceed!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Every detail is validated, add registration into text file
            else
            {
            //wrtites into the file and shows a success message
                File f = new File("People.txt");
                BufferedWriter bf = new BufferedWriter(new FileWriter("People.txt", true));
                bf.write(PhoneNumber + ";");
                bf.write(Password+";");
                bf.write(FullName+";");
                bf.write(IC_Passport+";");
                bf.write(Citizen_NonCitizen+";");
                bf.write(DOB+";");
                bf.write(PhoneNumber+";");
                bf.write(Residence+";");               
                bf.write(HealthStat+";");
                bf.write(TnC+";");
                bf.write("Not Vaccinated");
                bf.write("\n");
                bf.close();
                registered = true;                  
            }           
        }
        
        catch(Exception ioe)
        {
            JOptionPane.showMessageDialog(null, "There is an error in your input!\nPlease ammend input information.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        return registered;
    }
    
    //Method: Modify Registration
    public boolean ModifyRegistration(){
       boolean modified = false;
       return modified;
    }
    
    //Method: Login to Account
    public Boolean LoginAccount(String id, String pw){
        Boolean login = false;
        return login;
    }
    
    
      
    //Method to View Specific Registration Record
    public void ViewRegistration(String id){
        
    }
    
    //Method to Search Vaccination Center
    public void searchVaccineCenter(String search){
        
    }
    
    //Method: Search and View Vaccine
    public boolean viewVaccine(String searchID){
        boolean found = false;
        return found;
    }
}
