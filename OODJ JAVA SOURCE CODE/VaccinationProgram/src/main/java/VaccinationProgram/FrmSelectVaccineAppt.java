
package VaccinationProgram;

import java.io.*;
import javax.swing.JOptionPane;



public class FrmSelectVaccineAppt extends javax.swing.JFrame {
    String apptID;
    String vacDate;
    String vacLocation;
    String vacName;
    String accID;

    
    public FrmSelectVaccineAppt() {
        initComponents();      
    }
    
    FrmSelectVaccineAppt(String ID, String L, String d){
        this.accID = ID;
        this.vacLocation = L;
        this.vacDate = d;
        initComponents(); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbVaccineName = new javax.swing.JComboBox<>();
        btnSubmitAppt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("COVID-19 Vaccination Appointment");

        jLabel2.setText("Please select a vaccine type available:");

        cmbVaccineName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pfizer ", "Sinovac", "AstraZeneca" }));

        btnSubmitAppt.setText("Submit Appointment");
        btnSubmitAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitApptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmitAppt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnSubmitAppt)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitApptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitApptActionPerformed
        // TODO add your handling code here:
        //Get all appointment details from user input
        vacName = cmbVaccineName.getSelectedItem().toString();
        int apptCount = 1;
        Boolean verifyAppointment = false;

        //Get appointment number
        try{
            File file = new File("Appointment.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (br.readLine()!= null){
                apptCount ++;
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "An error has occurred!", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //Verify Appointment Number
        apptID = "APT"+String.valueOf(apptCount);
        try{
            File file = new File("Appointment.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String checkLine = null;
            while((checkLine = br.readLine())!=null){
                String[] temp = checkLine.split(";");
            
                    if(temp[0].equals(apptID)){
                        verifyAppointment = true;
                        break;
                    }
            }
            br.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "An error has occured!", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        if(verifyAppointment == false){
            try{
                File file = new File("Appointment.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                bw.append(apptID+";");
                bw.append(vacDate+";");
                bw.append(vacLocation+";");
                bw.append(vacName+";");
                bw.append(accID+";\n");
                bw.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "An error has occured!\nPlease try again later!", "Error",JOptionPane.WARNING_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "An error has occured!\nPlease try again later...", "Error",JOptionPane.WARNING_MESSAGE);           
        }
               
    }//GEN-LAST:event_btnSubmitApptActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSelectVaccineAppt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmitAppt;
    private javax.swing.JComboBox<String> cmbVaccineName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
