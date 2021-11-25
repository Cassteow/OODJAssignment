
package VaccinationProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VaccineCenter {
    public String centerID;
    public String centerLocation;
    public String centerDay;
    public String centerTime;
    public String vaccineSupplyName;
    public String vaccineSupplyCount;
    
    //Constructor with 1 attribute
    public VaccineCenter(String id){
        this.centerID = id;
    }
    
    public VaccineCenter(String id, String L){
        this.centerID = id;
        this.centerLocation = L;
    }
    
    public String getCenterID(){
        return centerID;
    }
    
    public void setCenterID(String id){
        this.centerID = id;
    }
    
    //Method to search Vaccine center using ID
    public void searchVaccineCenter(String search){
        boolean found = false;
        try{
            File file = new File("CenterSupplies.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)FrmCenterNSupplyPersonnel.tblVaccineSupply.getModel();
            Object[] lines = br.lines().toArray();
            model.setRowCount(0); //Clear content in table
            for(int i = 0; i<lines.length;i++){                
                String[] row = lines[i].toString().split(";");
                //if search text matches Appointment ID or account ID, display it
                if(row[0].equals(search)){
                    int vacCount = Integer.parseInt(row[2]);
                    
                    for(int j = 0; j<vacCount; j++){
                        String[] loadVaccine = {row[1+(j+1)*2], row[2+(j+1)*2]};
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
                if(row[0].equals(search)){
                    FrmCenterNSupplyPersonnel.lblCenterID.setText(row[0]);
                    FrmCenterNSupplyPersonnel.lblCenterLocation.setText(row[1]);
                    FrmCenterNSupplyPersonnel.lblCenterDay.setText(row[2]);
                    FrmCenterNSupplyPersonnel.lblCenterTime.setText(row[3]);
                }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        if(found == false){
            FrmCenterNSupplyPersonnel.lblCenterID.setText("");
            FrmCenterNSupplyPersonnel.lblCenterLocation.setText("");
            FrmCenterNSupplyPersonnel.lblCenterDay.setText("");
            FrmCenterNSupplyPersonnel.lblCenterTime.setText("");
            JOptionPane.showMessageDialog(null, "No records found.", "Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
}




