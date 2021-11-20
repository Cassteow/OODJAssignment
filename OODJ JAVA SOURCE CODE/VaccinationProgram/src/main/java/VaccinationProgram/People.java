
package VaccinationProgram;


public class People extends User {
    private String icOrPassport;
    private Boolean citizenship;
    private String dob;
    private String phoneNumber;
    private String residenceLocation;
    private Boolean medicalHistory;
    private Boolean tncAgreement;
    private String vaccinationStatus;
    
    
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
    
    @Override
    public void ModifyRegistration(String id){
        
    }
    
}
