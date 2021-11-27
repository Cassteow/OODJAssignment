package VaccinationProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmCenterNSupplyPersonnel extends javax.swing.JFrame {
    String frmAccID, name;

    FrmCenterNSupplyPersonnel(String aID, String n){
        this.frmAccID = aID;
        this.name = n;
        initComponents();
    }
    public FrmCenterNSupplyPersonnel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearchID = new javax.swing.JTextField();
        cmbLocation = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCenterID = new javax.swing.JLabel();
        lblCenterLocation = new javax.swing.JLabel();
        lblCenterDay = new javax.swing.JLabel();
        lblCenterTime = new javax.swing.JLabel();
        btnModifyCenter = new javax.swing.JButton();
        btnModifySupply = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineSupply = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Vaccination Center and Supply Details");

        jLabel2.setText("Enter Center ID to search:");

        jLabel3.setText("Or select the choices below:");

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stadium Bukit Jalil", "World Trade Center KL", "Stadium Shah Alam" }));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel4.setText("Vaccination Center Information");

        jLabel5.setText("Center ID:");

        jLabel6.setText("Location:");

        jLabel7.setText("Operating Days:");

        jLabel8.setText("Operating Time:");

        btnModifyCenter.setText("Modify Information");
        btnModifyCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyCenterActionPerformed(evt);
            }
        });

        btnModifySupply.setText("Modify Supply");
        btnModifySupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifySupplyActionPerformed(evt);
            }
        });

        tblVaccineSupply.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Supply (Dose)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVaccineSupply.getTableHeader().setReorderingAllowed(false);
        tblVaccineSupply.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblVaccineSupplyKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblVaccineSupply);

        btnView.setText("View Selection");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBack)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCenterTime)
                                            .addComponent(lblCenterLocation)
                                            .addComponent(lblCenterID)
                                            .addComponent(lblCenterDay)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(txtSearchID)
                                            .addComponent(cmbLocation, 0, 204, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModifySupply)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btnModifyCenter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView))
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnModifyCenter)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnModifySupply)
                .addGap(113, 113, 113))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModifyCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyCenterActionPerformed
        String centerID = lblCenterID.getText();
        if(centerID == ""){
            JOptionPane.showMessageDialog(null, "Please select a Vaccination Center to proceed!", "Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            this.dispose();
            new FrmModifyCenterPersonnel(frmAccID, name, centerID).setVisible(true);
        }
        
    }//GEN-LAST:event_btnModifyCenterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        //Get text in search textfield
        String searchID = txtSearchID.getText();
        VaccineCenter vc = new VaccineCenter(searchID);
        vc.searchVaccineCenter(searchID);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        String selection = cmbLocation.getSelectedItem().toString();
        String centerID = null;
        if(selection == "Stadium Bukit Jalil"){
            centerID = "SBJ";
        }
        else if (selection == "World Trade Center KL"){
            centerID = "WTCKL";
        }
        else if(selection == "Stadium Shah Alam"){
            centerID = "SSA";
        }
        else{
            JOptionPane.showMessageDialog(null, "No records found.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        VaccineCenter vc = new VaccineCenter(centerID);
        vc.searchVaccineCenter(centerID);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnModifySupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifySupplyActionPerformed
        String centerID = lblCenterID.getText();
        if(centerID == ""){
            JOptionPane.showMessageDialog(null, "Please select a Vaccination Center to proceed!", "Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Confirm Modified Appointment Details from user
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to modify the vaccine supplies?",
                    "Modify Vaccine Supply Confirmation", dialogButton);
            if(confirm == 0){
                VaccineCenter vc = new VaccineCenter(centerID);
                boolean modified = vc.modifyCenterSupply(centerID);
                if(modified == true){
                    JOptionPane.showMessageDialog(null, "Vaccine supply is updated!", "Modification Successful",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please ensure only numbers are entered!", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Operation cancelled!", "Appointment",JOptionPane.INFORMATION_MESSAGE);
            }       
        }
    }//GEN-LAST:event_btnModifySupplyActionPerformed

    private void tblVaccineSupplyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVaccineSupplyKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_tblVaccineSupplyKeyTyped

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmCenterNSupplyPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCenterNSupplyPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCenterNSupplyPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCenterNSupplyPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCenterNSupplyPersonnel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModifyCenter;
    private javax.swing.JButton btnModifySupply;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cmbLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JLabel lblCenterDay;
    public static javax.swing.JLabel lblCenterID;
    public static javax.swing.JLabel lblCenterLocation;
    public static javax.swing.JLabel lblCenterTime;
    public static javax.swing.JTable tblVaccineSupply;
    private javax.swing.JTextField txtSearchID;
    // End of variables declaration//GEN-END:variables
}
