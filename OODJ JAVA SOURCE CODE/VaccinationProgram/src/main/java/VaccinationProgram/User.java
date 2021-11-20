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
    public User(String id, String pw, String n){
        this.accountID = id;
        this.password = pw;
        this.name = n;
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
    
    
    //Method to Register New Account
    public void RegisterNewAccount(String id, String pw, String icOrP, Boolean citizen, String dob,
            String phone, String location, Boolean mh, Boolean tnc, String vs){
        
    }
    
    //Method Login to Account
    public void LoginAccount(String id, String pw, String usert){
        
    }
    
    //Method to Modify Registration Details
    public void ModifyRegistration(String id){
        
    }
    
    //Method to View Specific Registration Record
    public void ViewRegistration(String id){
        
    }
    
    //Method to Add New Appointment
    public void AddNewAppointment(String id){
        File file = new File("Appointment.txt");
        
        FileWriter fw;
        try{
            fw = new FileWriter(file, true);
            
        } catch(IOException ex){
            
        }
        
    }
    
    //Method to Cancel Existing Appointment
    public void CancelAppointment(String apptID){
        
    }
    
    //Method to View Existing Appointment
    public void ViewAppointment(String apptID){
        
    }
    
    //Method to View Vaccine Center Details
    public void ViewCenter(String centID){
        
    }
    
    //Method to Search Vaccine Center Details
    public void SearchCenter(String search){
        
    }
    
    //Method to View Vaccine Information 
    public void ViewVaccine(String vacID){
        
    }
    
    //Method to Search Vaccine Information
    public void SearchVaccine(String search){
        
    }
}
