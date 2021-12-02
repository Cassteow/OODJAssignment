package VaccinationProgram;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class FrmAddAppointmentPeople extends javax.swing.JFrame {
    String frmAccID, name;
    String user = "People";

    FrmAddAppointmentPeople(String id, String n){
        this.frmAccID=id;
        this.name =n;
        initComponents();
    }
    public FrmAddAppointmentPeople() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbLocation = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        dcApptDate = new com.toedter.calendar.JDateChooser();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("COVID-19 Vaccination Appointment");

        jLabel3.setText("Select Location:");

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stadium Bukit Jalil", "World Trade Center KL", "Stadium Shah Alam" }));

        jLabel4.setText("Select Preferred Date:");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcApptDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dcApptDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnNext)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
    //Get appointment details into respective variables
        String accID = frmAccID, vacLocation, vacDate, vacTime = null;
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
        //Use Method to Verify Account ID entered 
        Boolean verifyAccountID = appt.verifyAccountID(accID);
        //Use Method to verify date of appointment
        Boolean verifyDay = appt.verifyApptDay(dcApptDate.getDate(), vacLocation);    
        
        //Use Method to ensure center do not exceed appointment limit
        Boolean verifyLimit = appt.checkAppointmentLimit(vacLocation, vacDate);
        //Call FrmSelectVaccine if all conditions are validated
        if(verifyLimit == true){
            if(verifyAccountID == true){
                if(verifyDay == true){
                    this.dispose();
                    new FrmSelectVaccineAppt(appt.accountID, appt.appointmentLocation,appt.appointmentDate, appt.appointmentTime, name, user, frmAccID, vaccineAvailable).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selected Date is not available!\n Please select another date!", "Error",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Account ID is invalid or already has an appointment record!", "Error",JOptionPane.WARNING_MESSAGE);
            }   
        }
        else{
            JOptionPane.showMessageDialog(null, "The vaccination center is fully booked for the selected date."
                    + "\nPlease select another location or date for the appointment.", "Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new FrmPeopleMainMenu(frmAccID, name).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new FrmPeopleMainMenu(frmAccID, name).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    
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
            java.util.logging.Logger.getLogger(FrmAddAppointmentPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddAppointmentPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddAppointmentPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddAppointmentPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddAppointmentPeople().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> cmbLocation;
    private com.toedter.calendar.JDateChooser dcApptDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
