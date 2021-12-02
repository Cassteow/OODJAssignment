package VaccinationProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;


public class FrmModifyCenterPersonnel extends javax.swing.JFrame {
    String frmAccID, name, centerID;

    FrmModifyCenterPersonnel(String aID, String n, String cID){
        this.frmAccID = aID;
        this.name = n;
        this.centerID = cID;
        initComponents();
        
        try{
            File file = new File("VaccinationCenter.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));           
            Object[] lines = br.lines().toArray();
            //Load records from text file row by row
            for(int i = 0; i<lines.length;i++){
                String[] row = lines[i].toString().split(";");
                if(row[0].equals(centerID)){
                    lblCenterID.setText(row[0]);
                    lblCenterLocation.setText(row[1]);
                    lblCenterDay.setText(row[2]);
                    lblCenterTime.setText(row[3]);
                }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
        }
     
    }
    public FrmModifyCenterPersonnel() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCenterID = new javax.swing.JLabel();
        lblCenterLocation = new javax.swing.JLabel();
        lblCenterDay = new javax.swing.JLabel();
        lblCenterTime = new javax.swing.JLabel();
        btnModifyCenter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbStartTime = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbEndTime = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        chbSunday = new javax.swing.JCheckBox();
        chbMonday = new javax.swing.JCheckBox();
        chbTuesday = new javax.swing.JCheckBox();
        chbWednesday = new javax.swing.JCheckBox();
        chbThursday = new javax.swing.JCheckBox();
        chbFriday = new javax.swing.JCheckBox();
        chbSaturday = new javax.swing.JCheckBox();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblCenterID.setText("SBJ");

        lblCenterLocation.setText("Stadium Bukit Jalil");

        lblCenterDay.setText("Mon - Sun");

        lblCenterTime.setText("10.00am - 6.00pm");

        btnModifyCenter.setText("Modify Information");
        btnModifyCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyCenterActionPerformed(evt);
            }
        });

        jLabel5.setText("Center ID:");

        jLabel6.setText("Location:");

        jLabel7.setText("Operating Days:");

        jLabel8.setText("Operating Time:");

        jLabel2.setText("Current Information");

        jLabel3.setText("Vaccination Center Information");

        jLabel9.setText("Operating Days:");

        jLabel10.setText("Operating Time:");

        jLabel13.setText("Start Time");

        cmbStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6:00 am", "7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm" }));
        cmbStartTime.setSelectedIndex(3);

        jLabel14.setText("End Time");

        cmbEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm" }));
        cmbEndTime.setSelectedIndex(5);

        jLabel15.setText("New Information");

        chbSunday.setText("Sunday");
        chbSunday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSundayActionPerformed(evt);
            }
        });

        chbMonday.setText("Monday");
        chbMonday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbMondayActionPerformed(evt);
            }
        });

        chbTuesday.setText("Tuesday");
        chbTuesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbTuesdayActionPerformed(evt);
            }
        });

        chbWednesday.setText("Wednesday");
        chbWednesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbWednesdayActionPerformed(evt);
            }
        });

        chbThursday.setText("Thursday");
        chbThursday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbThursdayActionPerformed(evt);
            }
        });

        chbFriday.setText("Friday");

        chbSaturday.setText("Saturday");

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
                        .addGap(136, 136, 136)
                        .addComponent(btnModifyCenter))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(chbTuesday))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chbSunday)
                            .addComponent(chbMonday)
                            .addComponent(chbWednesday)
                            .addComponent(chbThursday)
                            .addComponent(chbFriday)
                            .addComponent(chbSaturday))))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCenterTime)
                            .addComponent(lblCenterLocation)
                            .addComponent(lblCenterID)
                            .addComponent(lblCenterDay))
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(122, 122, 122))))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnBack))
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblCenterID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblCenterLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCenterDay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblCenterTime))
                .addGap(66, 66, 66)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(chbSunday))
                .addGap(1, 1, 1)
                .addComponent(chbMonday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbTuesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbWednesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbThursday)
                .addGap(1, 1, 1)
                .addComponent(chbFriday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbSaturday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModifyCenter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModifyCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyCenterActionPerformed
        String days = "";
        
        //Get Operating days
        if(FrmModifyCenterPersonnel.chbSunday.isSelected()){
            days = days+"Sun,";
        }
        if(FrmModifyCenterPersonnel.chbMonday.isSelected()){
            days = days+"Mon,";
        }
        if(FrmModifyCenterPersonnel.chbTuesday.isSelected()){
            days = days+"Tue,";
        }
        if(FrmModifyCenterPersonnel.chbWednesday.isSelected()){
            days = days+"Wed,";
        }
        if(FrmModifyCenterPersonnel.chbThursday.isSelected()){
            days = days+"Thu,";
        }
        if(FrmModifyCenterPersonnel.chbFriday.isSelected()){
            days = days+"Fri,";
        }
        if(FrmModifyCenterPersonnel.chbSaturday.isSelected()){
            days = days+"Sat,";
        }
        
        if (days.endsWith(",")) {
            days = days.substring(0, days.length() - 1);
        }
        //Ask for confirmation to modify center information
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int confirm = JOptionPane.showConfirmDialog(this, "Please confirm the new Vaccination Center information details below:"
                + "\nCenter ID: "+centerID+"\nCenter Location: "+lblCenterLocation.getText()+"\nOperating Days: "+days+
                "\nOperating Time: "+cmbStartTime.getSelectedItem().toString()
                +" - "+cmbEndTime.getSelectedItem().toString(),
                "Vaccination Center Information Confirmation", dialogButton);
        if(confirm == 0){
            //Call Modify Center Info Method
            Personnel personnel = new Personnel();
            boolean modified = personnel.modifyCenterInfo();
            if(modified == true){
                JOptionPane.showMessageDialog(null, "Vaccination Center information "
                        + "is modified succesfully.", "Vaccination Center Modified",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new FrmCenterNSupplyPersonnel(frmAccID, name).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Modification error!"
                        + "\nPlease try again later", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Operation cancelled!", "Appointment",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnModifyCenterActionPerformed

    private void chbSundayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSundayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbSundayActionPerformed

    private void chbMondayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbMondayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbMondayActionPerformed

    private void chbTuesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbTuesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbTuesdayActionPerformed

    private void chbWednesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbWednesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbWednesdayActionPerformed

    private void chbThursdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbThursdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbThursdayActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new FrmCenterNSupplyPersonnel(frmAccID, name).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        new FrmCenterNSupplyPersonnel(frmAccID, name).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmModifyCenterPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmModifyCenterPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmModifyCenterPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmModifyCenterPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmModifyCenterPersonnel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModifyCenter;
    public static javax.swing.JCheckBox chbFriday;
    public static javax.swing.JCheckBox chbMonday;
    public static javax.swing.JCheckBox chbSaturday;
    public static javax.swing.JCheckBox chbSunday;
    public static javax.swing.JCheckBox chbThursday;
    public static javax.swing.JCheckBox chbTuesday;
    public static javax.swing.JCheckBox chbWednesday;
    public static javax.swing.JComboBox<String> cmbEndTime;
    public static javax.swing.JComboBox<String> cmbStartTime;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCenterDay;
    public static javax.swing.JLabel lblCenterID;
    public static javax.swing.JLabel lblCenterLocation;
    private javax.swing.JLabel lblCenterTime;
    // End of variables declaration//GEN-END:variables
}
