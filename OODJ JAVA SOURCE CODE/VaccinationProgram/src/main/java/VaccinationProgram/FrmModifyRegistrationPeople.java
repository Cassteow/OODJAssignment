/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaccinationProgram;

/**
 *
 * @author eugen
 */
public class FrmModifyRegistrationPeople extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddRegistrationPeople
     */
    public FrmModifyRegistrationPeople() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        peopleRegistrationHealthStatusYesRadioBtn = new javax.swing.JRadioButton();
        peopleRegistrationHealthStatusNoRadioBtn = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        peopleRegistrationTermsYesRadioBtn = new javax.swing.JRadioButton();
        peopleRegistrationTermsNoRadioBtn = new javax.swing.JRadioButton();
        modifyBtn = new javax.swing.JButton();
        accountIDTxtBox = new javax.swing.JTextField();
        peopleRegistrationPhoneNumberTxtBox = new javax.swing.JTextField();
        peopleRegistrationIdentityCardTxtBox = new javax.swing.JTextField();
        peopleRegistrationCalendar = new com.toedter.calendar.JCalendar();
        peopleRegistrationResidenceLocationCmbBox = new javax.swing.JComboBox<>();
        peopleRegistrationPasswordTxtBox = new javax.swing.JTextField();
        peopleRegistrationRepeatPasswordTxtBox = new javax.swing.JTextField();
        poepleRegistrationCitizenRadioBtn = new javax.swing.JRadioButton();
        poepleRegistrationNonCitizenRadioBtn = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        peopleRegistrationFullNameTxtBox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registration Details");

        jLabel2.setText("Full Name :");

        jLabel3.setText("IC/PAssport No:");

        jLabel4.setText("Select:");

        jLabel5.setText("Phone Number:");

        jLabel6.setText("Date Of Birth:");

        jLabel7.setText("Residence Location:");

        jLabel8.setText("Password:");

        jLabel9.setText("Repeat Password:");

        jLabel10.setText("Health Status:");

        jLabel11.setText("Do you have any history of severe allergic reactions?");

        peopleRegistrationHealthStatusYesRadioBtn.setText("Yes");
        peopleRegistrationHealthStatusYesRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleRegistrationHealthStatusYesRadioBtnActionPerformed(evt);
            }
        });

        peopleRegistrationHealthStatusNoRadioBtn.setText("No");
        peopleRegistrationHealthStatusNoRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleRegistrationHealthStatusNoRadioBtnActionPerformed(evt);
            }
        });

        jLabel12.setText("Have you read the Terms & Conditions?");

        peopleRegistrationTermsYesRadioBtn.setText("Yes");
        peopleRegistrationTermsYesRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleRegistrationTermsYesRadioBtnActionPerformed(evt);
            }
        });

        peopleRegistrationTermsNoRadioBtn.setText("No");
        peopleRegistrationTermsNoRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleRegistrationTermsNoRadioBtnActionPerformed(evt);
            }
        });

        modifyBtn.setText("Modify");
        modifyBtn.setToolTipText("");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        peopleRegistrationResidenceLocationCmbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location 1", "Location 2", "Location 3", "Location 4" }));

        peopleRegistrationPasswordTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleRegistrationPasswordTxtBoxActionPerformed(evt);
            }
        });

        poepleRegistrationCitizenRadioBtn.setSelected(true);
        poepleRegistrationCitizenRadioBtn.setText("Citizen");
        poepleRegistrationCitizenRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poepleRegistrationCitizenRadioBtnActionPerformed(evt);
            }
        });

        poepleRegistrationNonCitizenRadioBtn.setText("Non-Citizen");
        poepleRegistrationNonCitizenRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poepleRegistrationNonCitizenRadioBtnActionPerformed(evt);
            }
        });

        jLabel13.setText("Account ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(peopleRegistrationRepeatPasswordTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(peopleRegistrationHealthStatusYesRadioBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(peopleRegistrationHealthStatusNoRadioBtn))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(peopleRegistrationTermsYesRadioBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(peopleRegistrationTermsNoRadioBtn))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(peopleRegistrationResidenceLocationCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(poepleRegistrationCitizenRadioBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(poepleRegistrationNonCitizenRadioBtn))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(peopleRegistrationFullNameTxtBox))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(peopleRegistrationPhoneNumberTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(peopleRegistrationPasswordTxtBox))
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(peopleRegistrationIdentityCardTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jLabel1)))
                        .addGap(0, 146, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(peopleRegistrationCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(accountIDTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(accountIDTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(peopleRegistrationFullNameTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(peopleRegistrationIdentityCardTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poepleRegistrationCitizenRadioBtn)
                    .addComponent(poepleRegistrationNonCitizenRadioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(peopleRegistrationPhoneNumberTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peopleRegistrationCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(peopleRegistrationResidenceLocationCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(peopleRegistrationPasswordTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(peopleRegistrationRepeatPasswordTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peopleRegistrationHealthStatusYesRadioBtn)
                    .addComponent(peopleRegistrationHealthStatusNoRadioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peopleRegistrationTermsYesRadioBtn)
                    .addComponent(peopleRegistrationTermsNoRadioBtn))
                .addGap(14, 14, 14)
                .addComponent(modifyBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void peopleRegistrationHealthStatusYesRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleRegistrationHealthStatusYesRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peopleRegistrationHealthStatusYesRadioBtnActionPerformed

    private void peopleRegistrationHealthStatusNoRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleRegistrationHealthStatusNoRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peopleRegistrationHealthStatusNoRadioBtnActionPerformed

    private void peopleRegistrationTermsYesRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleRegistrationTermsYesRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peopleRegistrationTermsYesRadioBtnActionPerformed

    private void peopleRegistrationTermsNoRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleRegistrationTermsNoRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peopleRegistrationTermsNoRadioBtnActionPerformed

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void poepleRegistrationCitizenRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poepleRegistrationCitizenRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poepleRegistrationCitizenRadioBtnActionPerformed

    private void poepleRegistrationNonCitizenRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poepleRegistrationNonCitizenRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poepleRegistrationNonCitizenRadioBtnActionPerformed

    private void peopleRegistrationPasswordTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleRegistrationPasswordTxtBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peopleRegistrationPasswordTxtBoxActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddRegistrationPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddRegistrationPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddRegistrationPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddRegistrationPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddRegistrationPeople().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountIDTxtBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton modifyBtn;
    private com.toedter.calendar.JCalendar peopleRegistrationCalendar;
    private javax.swing.JTextField peopleRegistrationFullNameTxtBox;
    private javax.swing.JRadioButton peopleRegistrationHealthStatusNoRadioBtn;
    private javax.swing.JRadioButton peopleRegistrationHealthStatusYesRadioBtn;
    private javax.swing.JTextField peopleRegistrationIdentityCardTxtBox;
    private javax.swing.JTextField peopleRegistrationPasswordTxtBox;
    private javax.swing.JTextField peopleRegistrationPhoneNumberTxtBox;
    private javax.swing.JTextField peopleRegistrationRepeatPasswordTxtBox;
    private javax.swing.JComboBox<String> peopleRegistrationResidenceLocationCmbBox;
    private javax.swing.JRadioButton peopleRegistrationTermsNoRadioBtn;
    private javax.swing.JRadioButton peopleRegistrationTermsYesRadioBtn;
    private javax.swing.JRadioButton poepleRegistrationCitizenRadioBtn;
    private javax.swing.JRadioButton poepleRegistrationNonCitizenRadioBtn;
    // End of variables declaration//GEN-END:variables
}
