
package VaccinationProgram;

import java.io.*;
import javax.swing.JOptionPane;



public class FrmModifyApptSelectVaccine extends javax.swing.JFrame {
    String apptID, vacDate, vacTime, vacLocation, vacName, accID, name, user, frmAccID;
    
    FrmModifyApptSelectVaccine(String aID, String ID, String L, String d, String t, String name, String u, String frmID, String[] va){
        this.apptID = aID;
        this.accID = ID;
        this.vacLocation = L;
        this.vacDate = d;
        this.vacTime = t;
        this.name = name;
        this.user = u;
        this.frmAccID = frmID;

        initComponents();
        
        cmbVaccineName.removeAllItems();
        for(int i=0; i<va.length; i++){
            cmbVaccineName.addItem(va[i]);
        }
    }
    
    public FrmModifyApptSelectVaccine() {
        initComponents();      
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbVaccineName = new javax.swing.JComboBox<>();
        btnModifyAppt = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("COVID-19 Vaccination Appointment");

        jLabel2.setText("Please select a vaccine type available:");

        cmbVaccineName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pfizer", "AstraZeneca", "Sinovac" }));
        cmbVaccineName.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cmbVaccineNameComponentShown(evt);
            }
        });

        btnModifyAppt.setText("Modify Appointment");
        btnModifyAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyApptActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModifyAppt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnModifyAppt)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModifyApptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyApptActionPerformed
        //Get all appointment details from user input
        vacName = cmbVaccineName.getSelectedItem().toString();
        //Confirm Modified Appointment Details from user
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int confirm = JOptionPane.showConfirmDialog(this, "Please confirm your new appointment details below:"
                + "\nAppointment ID: "+apptID+"\nDate: "+vacDate+"\nTime: "+vacTime+"\nLocation: "+vacLocation
                +"\nVaccine Name: "+vacName+"\nAccount ID: "+accID,
                "Appointment Details Confirmation", dialogButton);
        if(confirm == 0){
            User u = new User();
            boolean modified = u.modifyAppointment(apptID, vacDate, vacTime, vacLocation, vacName, accID);
            if(modified == true){
                JOptionPane.showMessageDialog(null, "Appointment is modified succesfully.", "Appointment Details Modified",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                //Go back to Main Menu for respective user
                if(user == "Personnel"){
                    new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
                }
                else if(user == "People"){
                    new FrmPeopleMainMenu(frmAccID, name).setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
                this.dispose();
            
                if(user == "Personnel"){
                    new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
                }
                else if(user == "People"){
                    new FrmPeopleMainMenu(frmAccID, name).setVisible(true);
                }
            }
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Operation cancelled!", "Appointment",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
            if(user == "Personnel"){
                new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
            }
            else if(user == "People"){
                new FrmPeopleMainMenu(frmAccID, name).setVisible(true);
            }
            
        }
        
        
        
    }//GEN-LAST:event_btnModifyApptActionPerformed

    private void cmbVaccineNameComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cmbVaccineNameComponentShown
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbVaccineNameComponentShown

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
            
        if(user == "Personnel"){
            new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
        }
        else if(user == "People"){
            new FrmPeopleMainMenu(frmAccID, name).setVisible(true);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
            
        if(user == "Personnel"){
            new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
        }
        else if(user == "People"){
            new FrmPeopleMainMenu(frmAccID, name).setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmModifyApptSelectVaccine().setVisible(true);
            }          
        });       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModifyAppt;
    private javax.swing.JComboBox<String> cmbVaccineName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
