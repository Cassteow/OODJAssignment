package VaccinationProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class FrmModifyAppointmentPersonnel extends javax.swing.JFrame {
    String frmAccID, name;
    String user = "Personnel";

    FrmModifyAppointmentPersonnel(String aID, String n, String apptID){
        this.frmAccID=aID;
        this.name = n;
        
        initComponents();
        
        Appointment appt = new Appointment(apptID);
        //Call view appointment method from appointment class
        String[] details = appt.viewAppointmentDetails(appt.appointmentID);
        lblAccountID.setText(details[0]);
        lblApptID.setText(details[1]);
        lblLocation.setText(details[2]);
        lblDate.setText(details[3]);
        lblTime.setText(details[4]);
        lblVaccine.setText(details[5]); 
    }
    
    public FrmModifyAppointmentPersonnel() {
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
        lblDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblVaccine = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblAccountID = new javax.swing.JLabel();
        lblApptID = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dcApptDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("COVID-19 Vaccination Appointment");

        jLabel3.setText("Select Location:");

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stadium Bukit Jalil", "World Trade Center KL", "Stadium Shah Alam" }));

        jLabel4.setText("Select Preferred Date");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblDate.setText("3 November 2021");

        jLabel5.setText("Account ID:");

        lblTime.setText("10.00am - 6.00pm");

        jLabel6.setText("Appointment ID:");

        lblVaccine.setText("Pfizer");

        jLabel7.setText("Location:");

        jLabel8.setText("Date:");

        jLabel9.setText("Time:");

        jLabel10.setText("Vaccine:");

        lblAccountID.setText("6012345678");

        lblApptID.setText("SBJ1001");

        lblLocation.setText("Stadium Bukit Jalil");

        jLabel11.setText("Current Appointment Details");

        jLabel12.setText("Enter New Appointment Details:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcApptDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApptID)
                                            .addComponent(lblLocation)
                                            .addComponent(lblAccountID)
                                            .addComponent(lblTime)
                                            .addComponent(lblDate)
                                            .addComponent(lblVaccine)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel1)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(161, 161, 161)
                            .addComponent(jLabel11))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblAccountID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblApptID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblVaccine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dcApptDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnNext)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String apptID, accID, vacLocation, vacDate, vacTime = null;
        apptID = lblApptID.getText();
        accID = lblAccountID.getText();
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
        //Use Method to ensure center do not exceed appointment limit
        Boolean verifyLimit = appt.checkAppointmentLimit(vacLocation, vacDate);
        
        //Call FrmSelectVaccine if all conditions are validated
        if(verifyLimit == true){
            this.setVisible(false);
            new FrmModifyApptSelectVaccine(apptID, appt.accountID, appt.appointmentLocation,appt.appointmentDate, appt.appointmentTime, name, user, frmAccID, vaccineAvailable).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "The vaccination center is fully booked for the selected date."
                    + "\nPlease select another location or date for the appointment.", "Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmModifyAppointmentPersonnel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> cmbLocation;
    private com.toedter.calendar.JDateChooser dcApptDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAccountID;
    private javax.swing.JLabel lblApptID;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblVaccine;
    // End of variables declaration//GEN-END:variables
}
