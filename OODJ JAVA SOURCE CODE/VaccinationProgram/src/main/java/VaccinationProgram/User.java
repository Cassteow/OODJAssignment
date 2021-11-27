package VaccinationProgram;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void addNewAppointment(String apptID, String d, String t, String L, String vacName, String accID){
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
                JOptionPane.showMessageDialog(null, "An error has occured!\nPlease try again later!", "Error",JOptionPane.WARNING_MESSAGE);
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
    public void RegisterNewAccount(String id, String pw, String icOrP, Boolean citizen, String dob,
            String phone, String location, Boolean mh, Boolean tnc, String vs){
        
    }
    
    //Method: Login to Account
    public void LoginAccount(String id, String pw, String usert){
        
    }
    
    //Method: Modify Registration Details
    public void ModifyRegistration(String id){
       
    }
    
    //Method to View Specific Registration Record
    public void ViewRegistration(String id){
        
    }
    
    //Method to Search Vaccination Center
    public void searchVaccineCenter(String search){
        
    }
    
}
