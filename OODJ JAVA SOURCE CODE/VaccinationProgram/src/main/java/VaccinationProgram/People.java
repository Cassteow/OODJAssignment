
package VaccinationProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return apptDetails;
    }
}
