package VaccinationProgram;


public class FrmPersonnelMainMenu extends javax.swing.JFrame {
    String accID, name, user = "Personnel";

    public FrmPersonnelMainMenu(String aID, String n) {
        this.accID = aID;
        this.name = n;
        initComponents();
        
        lblWelcome.setText("Welcome back, "+name+"!");
    }
    
    public FrmPersonnelMainMenu() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        btnCenterNSupply = new javax.swing.JButton();
        btnRegistration = new javax.swing.JButton();
        btnAppointment = new javax.swing.JButton();
        btnVaccine = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblWelcome.setText("Welcome back, Personnel Name!");

        btnCenterNSupply.setText("Vaccination Center & Supplies");
        btnCenterNSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCenterNSupplyActionPerformed(evt);
            }
        });

        btnRegistration.setText("Vaccine Registration");
        btnRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrationActionPerformed(evt);
            }
        });

        btnAppointment.setText("Vaccine Appointment");
        btnAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentActionPerformed(evt);
            }
        });

        btnVaccine.setText("Vaccine Information");
        btnVaccine.setMaximumSize(new java.awt.Dimension(183, 25));
        btnVaccine.setMinimumSize(new java.awt.Dimension(183, 25));
        btnVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineActionPerformed(evt);
            }
        });

        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(lblWelcome)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCenterNSupply, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(btnAppointment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblWelcome)
                .addGap(26, 26, 26)
                .addComponent(btnRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCenterNSupply, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentActionPerformed
        this.dispose();
        new FrmAppointmentRecordsPersonnel(accID, name).setVisible(true);
    }//GEN-LAST:event_btnAppointmentActionPerformed

    private void btnCenterNSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCenterNSupplyActionPerformed
        this.dispose();
        new FrmCenterNSupplyPersonnel(accID, name).setVisible(true);
    }//GEN-LAST:event_btnCenterNSupplyActionPerformed

    private void btnRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrationActionPerformed
        this.dispose();
        new FrmRegistrationRecordsPersonnel(accID, name).setVisible(true);
    }//GEN-LAST:event_btnRegistrationActionPerformed

    private void btnVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineActionPerformed
        this.dispose();
        new FrmVaccineInformationPersonnel(accID, name).setVisible(true);
    }//GEN-LAST:event_btnVaccineActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        new FrmMainLogin().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        new FrmMainLogin().setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmPersonnelMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersonnelMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersonnelMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersonnelMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPersonnelMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAppointment;
    private javax.swing.JButton btnCenterNSupply;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegistration;
    private javax.swing.JButton btnVaccine;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
