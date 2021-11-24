
package VaccinationProgram;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


public class Appointment {
    public String appointmentID;
    public String appointmentDate;
    public String appointmentTime;
    public String appointmentLocation;
    public String apptVaccineName;
    public String accountID;
    
    
    //Constructor method with all attributes
    public Appointment(String apptID, String d,String t, String L, String vacName, String accID){
        this.appointmentID = apptID;
        this.appointmentDate = d;
        this.appointmentTime = t;
        this.appointmentLocation = L;
        this.apptVaccineName = vacName;
        this.accountID = accID;
    }
    
    //Constructor method with 4 attributes
    public Appointment(String accID, String d, String t, String L){
        this.appointmentDate = d;
        this.appointmentTime = t;
        this.appointmentLocation = L;
        this.accountID = accID;
    }
    
    public void getAppointmentID(String apptID){
        this.appointmentID = apptID;
    }
    
    public String setAppointmentID(){
        return appointmentID;
    }
    
    public void getAppointmentDate(String apptD){
        this.appointmentID = apptD;
    }
    
    public String setAppointmentDate(){
        return appointmentDate;
    }
    
    public void getAppointmentLocation(String apptL){
        this.appointmentLocation = apptL;
    }
    
    public String setAppointmentLocation(){
        return appointmentLocation;
    }
    
    public void getApptVaccineName(String v){
        this.apptVaccineName = v;
    }
    
    public String setApptVaccineName(){
        return apptVaccineName;
    }
    
    public void getAccountID(String accID){
        this.accountID = accID;
    }
    
    public String setAccountID(){
        return accountID;
    }
    
    //Method to verify account ID to make appointment
    public Boolean verifyAccountID(String accID){
        Boolean verified = false;
        Boolean verifyExistence = false; //verify existence of account ID in records
        Boolean verifyHistory = false; //verify are there any previous appointment record of this account ID
        try{
            File file = new File("People.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String checkLine = null;
            while((checkLine = br.readLine())!=null){
                String[] temp = checkLine.split(";");         
                    if(temp[0].equals(accID)){
                        verifyExistence = true;
                        break;
                    }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Verify whether there is no previous appointment record for this account ID
        try{
            File file = new File("Appointment.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(file));
            String checkLine = null;
            while((checkLine = br1.readLine())!=null){
                String[] temp = checkLine.split(";");            
                    if(temp[5].equals(accID)){
                        verifyHistory = true;
                        break;
                    }
            }
            br1.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //change Verified to true if both conditions are verified and validated
        if(verifyExistence == true && verifyHistory == false){
            verified = true;
        }
        return verified;
    }
    
    //Method to Add New Appointment Record into Text File
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
}


