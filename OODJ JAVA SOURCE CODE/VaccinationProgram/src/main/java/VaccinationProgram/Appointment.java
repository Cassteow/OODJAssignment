
package VaccinationProgram;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

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
    
    public void setAppointmentID(String apptID){
        this.appointmentID = apptID;
    }
    
    public String getAppointmentID(){
        return appointmentID;
    }
    
    public void setAppointmentDate(String apptD){
        this.appointmentID = apptD;
    }
    
    public String getAppointmentDate(){
        return appointmentDate;
    }
    
    public void setAppointmentLocation(String apptL){
        this.appointmentLocation = apptL;
    }
    
    public String getAppointmentTime(){
        return appointmentTime;
    }
    
    public void setAppointmentTime(String apptT){
        this.appointmentTime = apptT;
    }
    
    public String getAppointmentLocation(){
        return appointmentLocation;
    }
    
    public void setApptVaccineName(String v){
        this.apptVaccineName = v;
    }
    
    public String getApptVaccineName(){
        return apptVaccineName;
    }
    
    public void setAccountID(String accID){
        this.accountID = accID;
    }
    
    public String getAccountID(){
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
                            int vacSupply = Integer.parseInt(temp[2+(3*i)]);
                            if(vacSupply>500){//Check whether there are enough supply
                                vacCountAvailable +=1;
                            }
                        }
                        //Get Position of vaccines available in the text file
                        int[] vacPosition = new int[vacCountAvailable];
                        int j = 0;
                        for(int i = 1; i<=vacCount; i++){
                            int vacSupply = Integer.parseInt(temp[2+(3*i)]);
                            if(vacSupply>500){//Check whether there are enough supply
                                vacPosition[j] = 1+(3*i);
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
    
    //Method to verify selected day is valid or not (check date after today's date AND available during operating days
    public boolean verifyApptDay(Date selectedDay, String centerName){
        boolean verified = false;
        boolean verifyDay = false; //verify whether date is on an operating day
        boolean verifyAfterToday = false; //verify whether date is after current date
        
        String apptDay = null;
        Calendar c = Calendar.getInstance();
        apptDay = new SimpleDateFormat("EE").format(selectedDay);
                
        //Get current date for today
        Date currentDate = new Date();
        //Verify date is after today
        if(selectedDay.after(currentDate)){
            verifyAfterToday = true;
        }
        //Get Operating days of selected location
        String[] operatingDays = new String[1];
        try{
            File file = new File("VaccinationCenter.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));           
            String checkLine = null;
            //Load records from text file row by row
            while((checkLine = br.readLine())!=null){
                String[] row = checkLine.split(";");
                if(row[1].equals(centerName)){
                   String[] temp = row[2].toString().split(",");
                   operatingDays = new String[temp.length];
                   for(int j = 0; j< temp.length; j++){
                       operatingDays[j] = temp[j];
                   }
                }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Check selected day is one of the operating days or not
        for(int cnt = 0; cnt<operatingDays.length; cnt++){
            if(operatingDays[cnt].equals(apptDay)){
                verifyDay = true;
            }
        }
        
        if(verifyDay == true && verifyAfterToday == true){
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
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return apptDetails;
    }
    
    //Method to Modify Appointment Details
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
    
}
