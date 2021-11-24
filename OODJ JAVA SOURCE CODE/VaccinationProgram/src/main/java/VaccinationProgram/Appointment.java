
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
    
    //Constructor method with 1 attributes
    public Appointment(String aID){
        this.appointmentID = aID;
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
    
    //Method to get array of vaccines available for the selected vaccination center location
    public String[] checkVaccineAvailable(String vacLocation){
        String[] vaccineAvailable = new String[1];
        try{
            File file = new File("CenterSupplies.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String checkLine = null;
            while((checkLine = br.readLine())!=null){
                String[] temp = checkLine.split(";");         
                    if(temp[1].equals(vacLocation)){
                        int vacCount = Integer.parseInt(temp[2]);
                        int vacCountAvailable =0;
                        
                        //Get How many vaccines are available to initialize the vaccine position integer array
                        for(int i = 1; i<=vacCount; i++){
                            int vacSupply = Integer.parseInt(temp[2+(i*2)]);
                            if(vacSupply>2){
                                vacCountAvailable +=1;
                            }
                        }
                        //Get Position of vaccines available in the text file
                        int[] vacPosition = new int[vacCountAvailable];
                        int j = 0;
                        for(int i = 1; i<=vacCount; i++){
                            int vacSupply = Integer.parseInt(temp[2+(i*2)]);
                            if(vacSupply>2){
                                vacPosition[j] = 1+(i*2);
                                j +=1;
                            }
                        }
                        
                        //Get array of vaccine names available
                        vaccineAvailable = new String[vacCountAvailable];
                        for(int i = 0; i<vacCountAvailable; i++){
                            vaccineAvailable[i] = temp[vacPosition[i]];
                        }
                        break;
                    }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return vaccineAvailable;
    }
    
    //Method to Check Vaccination Center Appointment Limit
    public Boolean checkAppointmentLimit(String vacLocation, String vacDate){
        Boolean limitNotExceeded = false;
        int appointmentCount = 0;
        int appointmentLimit = 500; //Limit for one location at one day is set at 500 appointments
        try{
            File file = new File("Appointment.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(file));
            String checkLine = null;
            while((checkLine = br1.readLine())!=null){
                String[] temp = checkLine.split(";");            
                    if(temp[3].equals(vacLocation)){
                        if(temp[1].equals(vacDate)){
                            appointmentCount += 1;
                        }
                    }
            }
            br1.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        if(appointmentCount < appointmentLimit){
            limitNotExceeded = true;
        }
        return limitNotExceeded;
    } 
    
    //Method to display Appointment Details 
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
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return apptDetails;
    }
}


