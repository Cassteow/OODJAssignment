package VaccinationProgram;

import java.io.*;
import javax.swing.*;


public class FrmMainLogin extends javax.swing.JFrame {
    protected String frmAccID, name, password;
    Boolean verifyExistence,verifyExistence1;

    
    public FrmMainLogin() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        welcomeText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAccountID = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBoxUser = new javax.swing.JComboBox<>();
        btnClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        welcomeText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        welcomeText.setText("Welcome to COVID-19 Vaccination Programme ");

        jLabel1.setText("Select User Type:");

        jLabel2.setText("Account ID:");

        jLabel3.setText("Password:");

        txtAccountID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccountIDKeyTyped(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel4.setText("New Here?");

        jLabel6.setText("to register a new account");

        cmbBoxUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Citizen/Non-Citizen", "Personnel" }));

        btnClick.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnClick.setText("Click Me");
        btnClick.setBorder(null);
        btnClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(welcomeText)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClick, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(cmbBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeText)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(btnClick))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        frmAccID = txtAccountID.getText();
        password = txtPassword.getText();        
        boolean loginVerified = false;
        
        //Verify login information from the user
        if(cmbBoxUser.getItemAt(cmbBoxUser.getSelectedIndex()).equals("Citizen/Non-Citizen")){
            People ppl = new People();
            loginVerified = ppl.LoginAccount(frmAccID, password);            
        }
        else if (cmbBoxUser.getItemAt(cmbBoxUser.getSelectedIndex()).equals("Personnel")){
            Personnel psn = new Personnel();
            loginVerified = psn.LoginAccount(frmAccID, password);
        }
        
        //Get Name of user and Direct user to Main Menu Page
        if(loginVerified == true && "Citizen/Non-Citizen".equals(cmbBoxUser.getItemAt(cmbBoxUser.getSelectedIndex())))
        {
            //Get Name of User
            try{
                File file = new File("People.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String checkLine = null;
                while((checkLine = br.readLine()) != null)
                {
                    String [] temp = checkLine.split(";");
                    if(temp[0].equals(frmAccID) && temp[1].equals(password))
                    {
                        name = temp[2];
                        break;
                    }
                }   
                br.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "There is an error in the system.\n"
                    + "Please try again later.", "Error",JOptionPane.WARNING_MESSAGE);
            }
            //Call People Main Menu Form
            this.setVisible(false);
            new FrmPeopleMainMenu(frmAccID,name).setVisible(true);        
            
        }
       else if(loginVerified == true && "Personnel".equals(cmbBoxUser.getItemAt(cmbBoxUser.getSelectedIndex()))) 
       {
           try{
                File file = new File("Personnel.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String checkLine = null;
                while((checkLine = br.readLine()) != null)
                {
                    String [] temp = checkLine.split(";");
                    if(temp[0].equals(frmAccID) && temp[1].equals(password))
                    {
                        name = temp[2];
                        break;
                    }
                }   
                br.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "There is an error in the system.\n"
                    + "Please try again later.", "Error",JOptionPane.WARNING_MESSAGE);
            }
           //Call Personnel Main Menu Form
           this.dispose();
           new FrmPersonnelMainMenu(frmAccID,name).setVisible(true);               
       }
       else 
        {
            JOptionPane.showMessageDialog(null, "Invalid Login Information!\nPlease try Again!", "Error",JOptionPane.WARNING_MESSAGE); 
            txtPassword.setText("");
            txtPassword.requestFocusInWindow();
        }
        
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClickActionPerformed
        String u = "People";
        FrmAddRegistration rp = new FrmAddRegistration(u);
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClickActionPerformed

    private void txtAccountIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountIDKeyTyped

    }//GEN-LAST:event_txtAccountIDKeyTyped

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
            java.util.logging.Logger.getLogger(FrmMainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClick;
    private javax.swing.JButton btnLogin;
    public static javax.swing.JComboBox<String> cmbBoxUser;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JTextField txtAccountID;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
