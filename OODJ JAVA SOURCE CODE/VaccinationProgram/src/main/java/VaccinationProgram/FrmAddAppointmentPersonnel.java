
package VaccinationProgram;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class FrmAddAppointmentPersonnel extends javax.swing.JFrame {
    String frmAccID, name;
    String user = "Personnel";
    
    public FrmAddAppointmentPersonnel(String id, String n) {
        this.frmAccID = id;
        this.name = n;
        initComponents();
    }
   
    public FrmAddAppointmentPersonnel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAccountID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbLocation = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        dcApptDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("COVID-19 Vaccination Appointment");

        jLabel2.setText("Enter Account ID:");

        txtAccountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountIDActionPerformed(evt);
            }
        });
        txtAccountID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccountIDKeyTyped(evt);
            }
        });

        jLabel3.setText("Select Location:");

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stadium Bukit Jalil", "World Trade Center KL", "Stadium Shah Alam" }));
        cmbLocation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLocationItemStateChanged(evt);
            }
        });

        jLabel4.setText("Select Preferred Date:");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dcApptDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dcApptDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAccountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountIDActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        //Get appointment details into respective variables
        String accID, vacLocation, vacDate, vacTime = null;
        accID = txtAccountID.getText();
        vacLocation = cmbLocation.getItemAt(cmbLocation.getSelectedIndex());
        
        //Get Vaccination Appointment Time based on Location
        switch (cmbLocation.getSelectedIndex()) {
            case 0:
                try{
                    File file = new File("VaccinationCenter.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String checkLine = null;
                    while((checkLine = br.readLine())!=null){
                        String[] temp = checkLine.split(";");
                        if(temp[0].equals("SBJ")){
                            vacTime = temp[3];
                            break;
                        }
                    }
                    br.close();
                }
                catch(IOException ex){
                    JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
                }   break;
            case 1:
                try{
                    File file = new File("VaccinationCenter.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String checkLine = null;
                    while((checkLine = br.readLine())!=null){
                        String[] temp = checkLine.split(";");
                        if(temp[0].equals("WTCKL")){
                            vacTime = temp[3];
                            break;
                        }
                    }
                    br.close();
                }
                catch(IOException ex){
                    JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
                }   break;
            case 2:
                try{
                    File file = new File("VaccinationCenter.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String checkLine = null;
                    while((checkLine = br.readLine())!=null){
                        String[] temp = checkLine.split(";");
                        if(temp[0].equals("SSA")){
                            vacTime = temp[3];
                            break;
                        }
                    }
                    br.close();
                }
                catch(IOException ex){
                    JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
                }   break;
            default:
                break;
        }
        //Get Appointment Date
        Date date = dcApptDate.getDate();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        vacDate = df.format(date);
         
        //create new appointment class object
        Appointment appt = new Appointment(accID, vacDate, vacTime, vacLocation);
        //Get vaccines available for the selected location
        String[] vaccineAvailable = appt.checkVaccineAvailable(vacLocation);
        //Use Method to Verify Account ID entered by Personnel
        Boolean verifyAccountID = appt.verifyAccountID(accID);
        
        //Use Method to ensure center do not exceed appointment limit
        Boolean verifyLimit = appt.checkAppointmentLimit(vacLocation, vacDate);
        //Call FrmSelectVaccine if all conditions are validated
        if(verifyLimit == true){
            if(verifyAccountID == true){
                this.setVisible(false);
                new FrmSelectVaccineAppt(appt.accountID, appt.appointmentLocation,appt.appointmentDate, appt.appointmentTime, name, user, frmAccID, vaccineAvailable).setVisible(true);

            }else{
                JOptionPane.showMessageDialog(null, "Account ID is invalid or already has an appointment record!", "Error",JOptionPane.WARNING_MESSAGE);
            }   
        }
        else{
            JOptionPane.showMessageDialog(null, "The vaccination center is fully booked for the selected date."
                    + "\nPlease select another location or date for the appointment.", "Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    //Ensure only digit is entered into the account ID textfield
    private void txtAccountIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountIDKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_txtAccountIDKeyTyped

    private void cmbLocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLocationItemStateChanged
        
    }//GEN-LAST:event_cmbLocationItemStateChanged

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAddAppointmentPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddAppointmentPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddAppointmentPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddAppointmentPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddAppointmentPersonnel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> cmbLocation;
    private com.toedter.calendar.JDateChooser dcApptDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAccountID;
    // End of variables declaration//GEN-END:variables
}
