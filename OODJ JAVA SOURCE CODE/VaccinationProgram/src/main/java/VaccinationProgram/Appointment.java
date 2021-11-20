
package VaccinationProgram;


public class Appointment {
    public String appointmentID;
    public String appointmentDate;
    public String appointmentLocation;
    public String vaccineName;
    public String accountID;
    
    public Appointment(String apptID, String d, String L, String vacName, String accID){
        this.appointmentID = apptID;
        this.appointmentDate = d;
        this.appointmentLocation = L;
        this.vaccineName = vacName;
        this.accountID = accID;
    }
    
    
}


