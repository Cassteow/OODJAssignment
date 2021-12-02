package VaccinationProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Frm2ndAppt extends javax.swing.JFrame {
    String frmAccID, name, accID, apptID;

    Frm2ndAppt(String aID, String n, String fID){
        this.accID=aID;
        this.name = n;
        this.frmAccID = fID;
        
        initComponents();
        //Get Appointment ID of the Account
        try{
                File file = new File("Appointment.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String checkLine = null;
                while((checkLine = br.readLine()) != null)
                {
                    String[] temp = checkLine.split(";");
                    if(temp[5].equals(accID))
                    {
                        apptID = temp[0];
                        break;
                    }
                }   
                br.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "There is an error in the system.\n"
                    + "Please try again later.", "Error",JOptionPane.WARNING_MESSAGE);
            }
        User u = new User();
        //Call view appointment method from appointment class to view 1st Dose Appointment
        String[] details = u.viewAppointmentDetails(apptID);
        lblAccountID.setText(details[0]);
        lblApptID.setText(details[1]);
        lblLocation.setText(details[2]);
        lblDate.setText(details[3]);
        lblTime.setText(details[4]);
        lblVaccine.setText(details[5]); 
    }
    
    public Frm2ndAppt() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbLocation = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("COVID-19 Vaccination Appointment");

        jLabel3.setText("Select Location:");

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stadium Bukit Jalil", "World Trade Center KL", "Stadium Shah Alam" }));

        jLabel4.setText("Select Preferred Date");

        btnAdd.setText("Add 2nd Appointment");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        jLabel11.setText("1st Dose Appointment Details");

        jLabel12.setText("Enter 2nd Dose Appointment Details:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
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
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(29, 29, 29))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnAdd)))
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
                .addGap(35, 35, 35)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String apptID, accID, vacLocation, vacDate, vacTime = null, vacName;
        apptID = lblApptID.getText();
        accID = lblAccountID.getText();
        vacLocation = cmbLocation.getItemAt(cmbLocation.getSelectedIndex());
        vacName = lblVaccine.getText(); //use the same type of vaccine
        
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
        //Check the availability of the vaccine
        boolean vaccineAvailable = appt.vaccineAvailability(vacLocation, vacName);              
        //Use Method to ensure center do not exceed appointment limit
        boolean verifyLimit = appt.checkAppointmentLimit(vacLocation, vacDate);
        //Use Method to verify date of appointment
        boolean verifyDay = appt.verifyApptDay(dcApptDate.getDate(), vacLocation);
        
        //Call FrmSelectVaccine if all conditions are validated
        if(verifyLimit == true){
            if(verifyDay == true){
                if(vaccineAvailable == true){
                    //Confirm Modified Appointment Details from user
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int confirm = JOptionPane.showConfirmDialog(this, "Please confirm your 2nd appointment details below:"
                                    + "\nAppointment ID: "+apptID+"\nDate: "+vacDate+"\nTime: "+vacTime+"\nLocation: "+vacLocation
                                    +"\nVaccine Name: "+vacName+"\nAccount ID: "+accID,
                                    "Appointment Details Confirmation", dialogButton);
                    if(confirm == 0){
                        User u = new User();
                        //Modify appointment to the 2nd appointment details
                        boolean modified = u.modifyAppointment(apptID, vacDate, vacTime, vacLocation, vacName, accID);
                        if(modified == true){
                            JOptionPane.showMessageDialog(null, "Appointment is modified succesfully.", "Appointment Details Modified",JOptionPane.INFORMATION_MESSAGE);
                            new FrmPersonnelMainMenu(frmAccID, name).setVisible(true);
                            this.dispose();               
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "There is an error in the system!\nPlease try again later.", "Error",JOptionPane.WARNING_MESSAGE);
                            cmbLocation.requestFocusInWindow();        
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Operation cancelled!\n"
                                + "Please fill in the details for the 2nd Appointment now.", 
                                "Appointment",JOptionPane.INFORMATION_MESSAGE);
                        cmbLocation.requestFocusInWindow();      
                    }
                    
                }
                //Not enough vaccines for the selected location
                else{
                    JOptionPane.showMessageDialog(null, "Running low on vaccine supply!\nPlease select another location instead!", 
                            "Error",JOptionPane.WARNING_MESSAGE);
                    cmbLocation.requestFocusInWindow();
                }
            }
            //User selected date that is not during operating hours
            else{
                JOptionPane.showMessageDialog(null, "Selected Date is not available!\n Please select another date!", 
                        "Error",JOptionPane.WARNING_MESSAGE);
                cmbLocation.requestFocusInWindow();
            }
        }
        //Selected vaccination center is fully booked for the selected date
        else{
            JOptionPane.showMessageDialog(null, "The vaccination center is fully booked for the selected date."
                    + "\nPlease select another location or date for the appointment.", "Error",JOptionPane.WARNING_MESSAGE);
            cmbLocation.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new FrmRegistrationRecordsPersonnel(frmAccID, name).setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm2ndAppt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
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
