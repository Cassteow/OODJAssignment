
package VaccinationProgram;

import java.util.Date;
import javax.swing.JOptionPane;

public class FrmAddRegistration extends javax.swing.JFrame {
    String FullName, IC_Passport, Citizen_NonCitizen, Residence, Password, RePassword,HealthStat, TnC, DOB,PhoneNumber;
    Date date;
    String frmAccID, name;
    String userType;
    
    public FrmAddRegistration(String id,String n, String u)
    {
        this.frmAccID = id;
        this.name = n;
        this.userType = u;
        initComponents();
    }
    
    public FrmAddRegistration(String u)
    {
        this.userType = u;
        initComponents();
    }
    

    public FrmAddRegistration() {
        
        initComponents();
        
    }

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
        jLabel12 = new javax.swing.JLabel();
        peopleAddRegisterBtn = new javax.swing.JButton();
        peopleRegistrationFullNameTxtBox = new javax.swing.JTextField();
        peopleRegistrationPhoneNumberTxtBox = new javax.swing.JTextField();
        peopleRegistrationIdentityCardTxtBox = new javax.swing.JTextField();
        peopleRegistrationResidenceLocationCmbBox = new javax.swing.JComboBox<>();
        cmbBoxCitizen = new javax.swing.JComboBox<>();
        CmbBoxTnC = new javax.swing.JComboBox<>();
        cmbBoxHealthStat = new javax.swing.JComboBox<>();
        dateChooserDOB = new com.toedter.calendar.JDateChooser();
        btnBack = new javax.swing.JButton();
        peopleRegistrationPasswordTxtBox = new javax.swing.JPasswordField();
        peopleRegistrationRepeatPasswordTxtBox = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("COVID-19 Vaccination Programme Registration");

        jLabel2.setText("Full Name :");

        jLabel3.setText("IC/Passport No:");

        jLabel4.setText("Citizenship:");

        jLabel5.setText("Phone Number:");

        jLabel6.setText("Date Of Birth:");

        jLabel7.setText("Residence Location:");

        jLabel8.setText("Password:");

        jLabel9.setText("Repeat Password:");

        jLabel10.setText("Health Status:");

        jLabel11.setText("Do you have any history of severe allergic reactions?");

        jLabel12.setText("Do you agree to the Terms & Conditions?");

        peopleAddRegisterBtn.setText("Register");
        peopleAddRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleAddRegisterBtnActionPerformed(evt);
            }
        });

        peopleRegistrationFullNameTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleRegistrationFullNameTxtBoxActionPerformed(evt);
            }
        });
        peopleRegistrationFullNameTxtBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                peopleRegistrationFullNameTxtBoxKeyTyped(evt);
            }
        });

        peopleRegistrationPhoneNumberTxtBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                peopleRegistrationPhoneNumberTxtBoxKeyTyped(evt);
            }
        });

        peopleRegistrationResidenceLocationCmbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selangor", "Johor", "Kedah", "Kelantan", "Melaka", "Negeri Sembilan", "Pahang", "Penang", "Sabah", "Sarawak", "Terengganu", "W.P. Kuala Lumpur", "W.P. Labuan", "W.P. Putrajaya" }));

        cmbBoxCitizen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Citizen", "Non-Citizen" }));

        CmbBoxTnC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        cmbBoxHealthStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        cmbBoxHealthStat.setSelectedIndex(1);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel13.setText("TnC:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCitizen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(peopleRegistrationIdentityCardTxtBox)
                            .addComponent(peopleRegistrationFullNameTxtBox)
                            .addComponent(peopleRegistrationPhoneNumberTxtBox)
                            .addComponent(dateChooserDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbBoxHealthStat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(CmbBoxTnC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(peopleAddRegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(peopleRegistrationResidenceLocationCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(peopleRegistrationPasswordTxtBox, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(peopleRegistrationRepeatPasswordTxtBox))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(peopleRegistrationFullNameTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(peopleRegistrationIdentityCardTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbBoxCitizen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(peopleRegistrationPhoneNumberTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateChooserDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(peopleRegistrationResidenceLocationCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(peopleRegistrationPasswordTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(peopleRegistrationRepeatPasswordTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbBoxHealthStat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbBoxTnC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(peopleAddRegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void peopleAddRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleAddRegisterBtnActionPerformed
        
        //Ask for user confirmation to add new registration
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to confirm the new registration?",
                "Registration Details Confirmation", dialogButton);
        //If user selects YES:
        if(confirm == 0){
            User u = new User();
            boolean registered = u.RegisterNewAccount();
        
            if(registered == true){ 
                //Show Account Registration as successful
                //if user type is personnel, pass personnel info
                if(userType == "Personnel"){
                    JOptionPane.showMessageDialog(null, "Registration is successful!\n"
                            + "\nAccount ID: "+peopleRegistrationPhoneNumberTxtBox.getText()+"\nFull Name: "+peopleRegistrationFullNameTxtBox.getText()
                            +"\nIC or Passport No: "+peopleRegistrationIdentityCardTxtBox.getText(), 
                            "Registration Successful",JOptionPane.INFORMATION_MESSAGE);
                    new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Registration is successful!\n"
                            + "\nAccount ID: "+peopleRegistrationPhoneNumberTxtBox.getText()+"\nFull Name: "+peopleRegistrationFullNameTxtBox.getText()
                            +"\nIC or Passport No: "+peopleRegistrationIdentityCardTxtBox.getText()
                            +"\nPlease proceed to log in from the main menu.", 
                            "Registration Successful",JOptionPane.INFORMATION_MESSAGE);
                    FrmMainLogin ml = new FrmMainLogin();
                    ml.setVisible(true);
                    this.dispose();
                }        
            }
            else{
                peopleRegistrationPasswordTxtBox.setText("");
                peopleRegistrationRepeatPasswordTxtBox.setText("");
                peopleRegistrationFullNameTxtBox.requestFocusInWindow();
            }
        }
        //User selects NO and aborts adding new regsitration operation
        else{
            JOptionPane.showMessageDialog(null, "Operation cancelled!", "New Registration",JOptionPane.INFORMATION_MESSAGE);
            peopleRegistrationPasswordTxtBox.setText("");
            peopleRegistrationRepeatPasswordTxtBox.setText("");
            peopleRegistrationFullNameTxtBox.requestFocusInWindow();
        }       
    }//GEN-LAST:event_peopleAddRegisterBtnActionPerformed

    private void peopleRegistrationPhoneNumberTxtBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_peopleRegistrationPhoneNumberTxtBoxKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_peopleRegistrationPhoneNumberTxtBoxKeyTyped

    private void peopleRegistrationFullNameTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleRegistrationFullNameTxtBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peopleRegistrationFullNameTxtBoxActionPerformed

    private void peopleRegistrationFullNameTxtBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_peopleRegistrationFullNameTxtBoxKeyTyped
       //Only allow text field to accept alphabet, delete keys, and whitespace
        char enter = evt.getKeyChar();
        if(Character.isLetter(enter) || Character.isWhitespace(enter) || Character.isISOControl(enter))
        {
            peopleRegistrationFullNameTxtBox.setEditable(true);
        }else{
            peopleRegistrationFullNameTxtBox.setEditable(false);
        }
    }//GEN-LAST:event_peopleRegistrationFullNameTxtBoxKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Move to main login form if user type is people
        if(userType == "People"){
            FrmMainLogin ml = new FrmMainLogin();
            ml.setVisible(true);
            this.dispose();
        }
        //Move to main menu of personnel if use type is personnel
        else if(userType == "Personnel"){
            new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //Move to main login form if user type is people
        if(userType == "People"){
            FrmMainLogin ml = new FrmMainLogin();
            ml.setVisible(true);
            this.dispose();
        }
        //Move to main menu of personnel if use type is personnel
        else if(userType == "Personnel"){
            new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> CmbBoxTnC;
    private javax.swing.JButton btnBack;
    public static javax.swing.JComboBox<String> cmbBoxCitizen;
    public static javax.swing.JComboBox<String> cmbBoxHealthStat;
    public static com.toedter.calendar.JDateChooser dateChooserDOB;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private static javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private static javax.swing.JLabel jLabel8;
    private static javax.swing.JLabel jLabel9;
    public static javax.swing.JButton peopleAddRegisterBtn;
    public static javax.swing.JTextField peopleRegistrationFullNameTxtBox;
    public static javax.swing.JTextField peopleRegistrationIdentityCardTxtBox;
    public static javax.swing.JPasswordField peopleRegistrationPasswordTxtBox;
    public static javax.swing.JTextField peopleRegistrationPhoneNumberTxtBox;
    public static javax.swing.JPasswordField peopleRegistrationRepeatPasswordTxtBox;
    public static javax.swing.JComboBox<String> peopleRegistrationResidenceLocationCmbBox;
    // End of variables declaration//GEN-END:variables
}
