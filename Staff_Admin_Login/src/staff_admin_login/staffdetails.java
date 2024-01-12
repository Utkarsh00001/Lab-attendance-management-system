/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff_admin_login;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author utkar
 */
public class staffdetails extends javax.swing.JFrame {
private LocalTime logintime;
    /**
     * Creates new form staffdetails
     */
    
    public staffdetails() {
        setUndecorated(true);
        initComponents();
        comobox();
        tbload();
        computerpc();
        combox1();
      //  reporttable1();
    }
    
          private void combox1(){
        try {
            
            Connection con = databaseconnection.getConnection();
            Statement stm1 = con.createStatement();
            
            ResultSet rs1 = stm1.executeQuery("select * from staff");
            while(rs1.next()){
                String Subject = rs1.getString("Subject");
                combosubclass.addItem(Subject);
                
            }    
             } catch(Exception e) {
                JOptionPane.showMessageDialog(null,e);
                }
        
    }
    
    public void tbload(){
        try {
       //   DefaultTableModel model = (DefaultTableModel)varattendancetable.getModel(); 
        //  model.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select Roll_Number,sdate,login,logout,OTP,Attendance from student_attendance_records where Subject='VAR' ORDER BY sdate ASC");
          
           while (rs.next()) {
        Object[] row = new Object[6];
        row[0] = rs.getString("Roll_Number");
         row[1] = rs.getDate("sdate");
       row[2] = rs.getTime("login");
        row[3] = rs.getTime("logout");
        row[4] = rs.getString("OTP");
         row[5] =rs.getString("Attendance");
       DefaultTableModel model = (DefaultTableModel)varattendancetable.getModel();
        model.addRow(row);
    }
        // varattendancetable.repaint();
        } catch (Exception e) {
        }
     
    }
    
        public void computerpc(){
        try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select Roll_Number,Pc,sdate,login,logout from student_attendance_records where Subject='VAR'");
          
           while (rs.next()) {
        Object[] row = new Object[5];
        row[0] = rs.getString("Roll_Number");
        row[1] = rs.getString("Pc");
         row[2] = rs.getDate("sdate");
       row[3] = rs.getTime("login");
        row[4] = rs.getTime("logout");
       
        
        DefaultTableModel model = (DefaultTableModel)computertable.getModel();
        model.addRow(row);
    }
         
        } catch (Exception e) {
        }
     
    }
        
 /* public void reporttable1(){
        try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
           
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select Roll_Number,Name,Subject,Batch,Year,sdate,Attendance from student_attendance_records where subject='VAR'");
       
                  
           while (rs.next()) {
        Object[] row = new Object[7];
        row[0] = rs.getString("Roll_Number");
        row[1] = rs.getString("Name");
        row[2] = rs.getString("Subject");
        row[3] = rs.getString("Batch");
        row[4] = rs.getString("Year");
         row[5] = rs.getDate("sdate");
         row[6] = rs.getString("Attendance");
       
        
        DefaultTableModel model = (DefaultTableModel) reporttable.getModel();
        model.addRow(row);
    }
         
        } catch (Exception e) {
        }
     
    }
        */
    
    
    private void comobox()
    {
        try {
            Connection con = databaseconnection.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from master_Student_details ORDER BY Name ASC ");
            while(rs.next()){
                String Roll_Number = rs.getString("Roll_Number");
                comboroll.addItem(Roll_Number);
              
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboroll = new javax.swing.JComboBox<>();
        btnaddattendance = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        varattendancetable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        computertable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        reporttable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btndateshowreport = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnbyrollno = new javax.swing.JButton();
        txtrollnumber = new javax.swing.JTextField();
        txtnoofdays = new javax.swing.JTextField();
        btnbyrolldays = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        printreport = new javax.swing.JButton();
        showrepbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        combosubclass = new javax.swing.JComboBox<>();
        classdate2 = new com.toedter.calendar.JDateChooser();
        classdate1 = new com.toedter.calendar.JDateChooser();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        reportclasstable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Astute Student Governance System");
        setBackground(new java.awt.Color(0, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 204));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("ROLL NUMBER");

        comboroll.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        comboroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comborollActionPerformed(evt);
            }
        });

        btnaddattendance.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnaddattendance.setText("ADD");
        btnaddattendance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnaddattendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddattendanceActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("PRESENT");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("ABSENT");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        varattendancetable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        varattendancetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll Number", "Sdate", "Login", "Logout", "OTP", "Attendance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(varattendancetable);

        jScrollPane1.setViewportView(jScrollPane2);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboroll, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnaddattendance))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(btnaddattendance)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ATTENDANCE", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        computertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll Number", "Pc", "SDate", "Login", "Logout"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(computertable);

        jScrollPane4.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("COMPUTER USED", jPanel4);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        reporttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll_Number", "Name", "Subject", "Batch", "Year", "sdate", "Attendance", "Percentage", "Days "
            }
        ));
        jScrollPane5.setViewportView(reporttable);

        jScrollPane6.setViewportView(jScrollPane5);

        jButton4.setText("Generate Report");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btndateshowreport.setText("Show Report By Date");
        btndateshowreport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndateshowreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndateshowreportActionPerformed(evt);
            }
        });

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnbyrollno.setText("Get Record By Roll Number");
        btnbyrollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbyrollnoActionPerformed(evt);
            }
        });

        txtrollnumber.setText("Enter roll number");
        txtrollnumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtrollnumberFocusGained(evt);
            }
        });
        txtrollnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrollnumberActionPerformed(evt);
            }
        });

        txtnoofdays.setText("Enter No.of Days to Calculate %");
        txtnoofdays.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnoofdaysFocusGained(evt);
            }
        });

        btnbyrolldays.setText("Calculate Percentage");
        btnbyrolldays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbyrolldaysActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndateshowreport, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnbyrollno, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtrollnumber))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbyrolldays, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnoofdays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndateshowreport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtrollnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbyrollno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtnoofdays, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbyrolldays, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("LAB REPORTS", jPanel5);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);

        printreport.setText("Generate Report");
        printreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printreportActionPerformed(evt);
            }
        });

        showrepbtn.setText("Show Report");
        showrepbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showrepbtnActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        combosubclass.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        combosubclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosubclassActionPerformed(evt);
            }
        });

        reportclasstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRN", "Name", "Roll Number", "Subject", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportclasstable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane8.setViewportView(reportclasstable);

        jScrollPane7.setViewportView(jScrollPane8);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classdate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combosubclass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showrepbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printreport, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(classdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(classdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combosubclass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showrepbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(printreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLASS REPORTS", jPanel6);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel1.setText("Astute Student Governance System");

        jLabel3.setBackground(new java.awt.Color(0, 153, 204));
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        btnMinimize.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMinimize.setText("-");
        btnMinimize.setBorder(null);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClose.setText("X");
        btnClose.setBorder(null);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClose)
                        .addComponent(btnMinimize)))
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
       
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
public int mousepX,mousepY;
    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        // TODO add your handling code here:
        int kordinatX = evt.getXOnScreen();
       int kordinatY = evt.getYOnScreen();
       
       this.setLocation(kordinatX-mousepX, kordinatY-mousepY);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
         mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void combosubclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosubclassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combosubclassActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        reportclasstable.setModel(new DefaultTableModel(null,new String[]{"PRN", "Name", "Roll Number", "Subject","Date","Time" }));
    }//GEN-LAST:event_clearbtnActionPerformed

    private void showrepbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showrepbtnActionPerformed
        // TODO add your handling code here:
        Date fromDate = classdate1.getDate();
        Date toDate = classdate2.getDate();

        // Clear table data
        // model.setRowCount(0);

        try {

            if (classdate1.getDate() == null || classdate2.getDate()==null) {
                JOptionPane.showMessageDialog(this, "Please enter the Date.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String selectedItem = combosubclass.getSelectedItem().toString();
            // Connect to MySQL database
            Connection conn = databaseconnection.getConnection();

            // Prepare SQL statement
            PreparedStatement stmt = conn.prepareStatement("SELECT PRN, Name,Roll_Number, Subject, Date ,Time FROM class_attendance WHERE Date BETWEEN ? AND ? AND Subject= ? ORDER BY Name ASC");
            stmt.setDate(1, new java.sql.Date(fromDate.getTime()));
            stmt.setDate(2, new java.sql.Date(toDate.getTime()));
            stmt.setString(3, selectedItem);

            // Execute SQL query
            ResultSet rs = stmt.executeQuery();

            // Populate table with query results
            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getString("PRN");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("Roll_Number");
                row[3] = rs.getString("Subject");

                row[4] = rs.getDate("Date");
                row[5] = rs.getString("Time");

                DefaultTableModel model = (DefaultTableModel) reportclasstable.getModel();
                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_showrepbtnActionPerformed

    private void printreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printreportActionPerformed
        // TODO add your handling code here:
        try{
            MessageFormat header= new MessageFormat("Anuradha Engineering College , Chikhli \n Report (CSE)");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            reportclasstable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
          

        }
        catch(Exception ex){
        }
    }//GEN-LAST:event_printreportActionPerformed

    private void btnbyrolldaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbyrolldaysActionPerformed

        // Create a new default table model
        //  DefaultTableModel model = new DefaultTableModel();
        DefaultTableModel model = (DefaultTableModel) reporttable.getModel();

        try {

            // Check if the number of days field is empty
            if (txtnoofdays.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the number of days.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Connect to MySQL database
            Connection conn = databaseconnection.getConnection();

            // Prepare SQL statement
            PreparedStatement stmt = conn.prepareStatement("SELECT Roll_Number, Name,Subject,Batch,Year,sdate,Attendance ,COUNT(*) AS count, (COUNT(*)/?)*100 AS percentage FROM student_attendance_records WHERE Subject='VAR' AND Attendance <> 'Absent' GROUP BY Roll_Number, Name ,Subject,Batch,Year,sdate,Attendance ORDER BY Name ASC");

            // Set the parameters for the SQL statement
            //    stmt.setString(2, txtrollnumber.getText());
            stmt.setString(1, txtnoofdays.getText());

            // Execute SQL query
            ResultSet rs = stmt.executeQuery();

            // Populate table with query results
            while (rs.next()) {
                int count = rs.getInt("count");
                double percentage = ((double)count / Integer.parseInt(txtnoofdays.getText())) * 100;

                Object[] row = new Object[9];
                row[0] = rs.getInt("Roll_Number");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("Subject");
                row[3] = rs.getString("Batch");
                row[4] = rs.getString("Year");
                row[5] = rs.getDate("sdate");
                row[6] = rs.getString("Attendance");
                row[7] = percentage;
                row[8] = count;

                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnbyrolldaysActionPerformed

    private void txtnoofdaysFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnoofdaysFocusGained
        // TODO add your handling code here:
        txtnoofdays.setText("");
    }//GEN-LAST:event_txtnoofdaysFocusGained

    private void txtrollnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrollnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrollnumberActionPerformed

    private void txtrollnumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrollnumberFocusGained
        // TODO add your handling code here:
        txtrollnumber.setText("");
    }//GEN-LAST:event_txtrollnumberFocusGained

    private void btnbyrollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbyrollnoActionPerformed
        // TODO add your handling code here:

        // Clear table data
        // model.setRowCount(0);

        try {

            if (txtrollnumber.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the Roll Number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Connect to MySQL database
            Connection conn = databaseconnection.getConnection();

            // Prepare SQL statement
            PreparedStatement stmt = conn.prepareStatement("SELECT Roll_Number, Name, Subject, Batch, Year, sdate, Attendance FROM student_attendance_records WHERE Roll_Number=? AND Subject='VAR'");
            stmt.setString(1, txtrollnumber.getText());

            // Execute SQL query
            ResultSet rs = stmt.executeQuery();

            // Populate table with query results
            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getString("Roll_Number");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("Subject");
                row[3] = rs.getString("Batch");
                row[4] = rs.getString("Year");
                row[5] = rs.getDate("sdate");
                row[6] = rs.getString("Attendance");
                DefaultTableModel model = (DefaultTableModel) reporttable.getModel();
                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnbyrollnoActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        reporttable.setModel(new DefaultTableModel(null,new String[]{"Roll_Number", "Name", "Subject", "Batch", "Year", "sdate", "Attendance","Percentage","Days"}));
    }//GEN-LAST:event_btnclearActionPerformed

    private void btndateshowreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndateshowreportActionPerformed
        // TODO add your handling code here:
        // Get selected date range

        Date fromDate = jDateChooser1.getDate();
        Date toDate = jDateChooser2.getDate();

        // Clear table data
        // model.setRowCount(0);

        try {
            if (jDateChooser1.getDate() == null || jDateChooser2.getDate()==null) {
                JOptionPane.showMessageDialog(this, "Please enter the Date.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Connect to MySQL database
            Connection conn = databaseconnection.getConnection();

            // Prepare SQL statement
            PreparedStatement stmt = conn.prepareStatement("SELECT Roll_Number, Name, Subject, Batch, Year, sdate, Attendance FROM student_attendance_records WHERE sdate BETWEEN ? AND ? AND Subject='VAR' ORDER BY Name ASC");
            stmt.setDate(1, new java.sql.Date(fromDate.getTime()));
            stmt.setDate(2, new java.sql.Date(toDate.getTime()));

            // Execute SQL query
            ResultSet rs = stmt.executeQuery();

            // Populate table with query results
            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getString("Roll_Number");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("Subject");
                row[3] = rs.getString("Batch");
                row[4] = rs.getString("Year");
                row[5] = rs.getDate("sdate");
                row[6] = rs.getString("Attendance");
                DefaultTableModel model = (DefaultTableModel) reporttable.getModel();
                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndateshowreportActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        try{
            MessageFormat header= new MessageFormat("Anuradha Engineering College,Chikhli");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            reporttable.print(JTable.PrintMode.FIT_WIDTH,header,footer);

        }
        catch(Exception ex){
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //for attendance table
        DefaultTableModel model = (DefaultTableModel) varattendancetable.getModel();
        model.setRowCount(0);
        tbload();

        //for computer details table
        DefaultTableModel m = (DefaultTableModel)computertable.getModel();
        m.setRowCount(0);
        computerpc();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {

            DefaultTableModel model = (DefaultTableModel)varattendancetable.getModel();
            for(int i=0;i<model.getRowCount();i++){

                int selectedRow = varattendancetable.getSelectedRow();
                model.setValueAt("Absent", selectedRow, 5);
                Object value = varattendancetable.getValueAt(selectedRow,5);

                String otp = model.getValueAt(selectedRow,4).toString();

                Connection con = databaseconnection.getConnection();
                PreparedStatement stat  = con.prepareStatement("update student_attendance_records set Attendance=? where OTP=?");

                stat.setObject(1, value);
                stat.setString(2,otp);
                stat.executeUpdate();

            }
        } catch (Exception e) {
            Logger.getLogger(staffdetails1.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {

            DefaultTableModel model = (DefaultTableModel)varattendancetable.getModel();
            for(int i=0;i<model.getRowCount();i++){

                int selectedRow = varattendancetable.getSelectedRow();
                model.setValueAt("Present", selectedRow, 5);
                Object value = varattendancetable.getValueAt(selectedRow,5);

                String otp = model.getValueAt(selectedRow,4).toString();

                Connection con = databaseconnection.getConnection();
                PreparedStatement stat  = con.prepareStatement("update student_attendance_records set Attendance=? where OTP=?");

                stat.setObject(1, value);
                stat.setString(2,otp);
                stat.executeUpdate();

            }
        } catch (Exception e) {
            Logger.getLogger(staffdetails1.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnaddattendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddattendanceActionPerformed
        // TODO add your handling code here:

        try
        {

            String selectedItem = comboroll.getSelectedItem().toString();

            // Class.forName("com.mysql.jdbc.driver");
            Connection con = databaseconnection.getConnection();

            String query = "SELECT Name,Batch,Year,Pc,Year_of_Admission FROM master_student_details WHERE Roll_Number=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,selectedItem);

            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                String name=rs.getString("Name");
                String batch=rs.getString("Batch");
                String year=rs.getString("Year");
                String pc=rs.getString("Pc");
                LocalDate todaydate = LocalDate.now();
                logintime = LocalTime.now();

                String yoa=rs.getString("Year_of_Admission");

                //    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                //  DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");

                PreparedStatement pst1=con.prepareStatement("insert into student_attendance_records (Roll_Number,Name,Subject,Batch,Year,Pc,sdate,Attendance,Year_of_Admission)values(?,?,?,?,?,?,?,?,?)");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
                String time = logintime.format(formatter);

                pst1.setString(1,selectedItem);
                pst1.setString(2, name);

                pst1.setString(3,"VAR");

                pst1.setString(4,batch);
                pst1.setString(5,year);
                pst1.setString(6,pc);
                pst1.setDate(7,java.sql.Date.valueOf(todaydate));
                pst1.setString(8,"Present");
                pst1.setString(9,yoa);
                pst1.executeUpdate();

                JOptionPane.showMessageDialog(this,"Insert Successfully!");

            }
        } catch (Exception ex) {
            Logger.getLogger(staffdetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try {
            LocalDate todaydate = LocalDate.now();
            logintime = LocalTime.now();
            Connection con = databaseconnection.getConnection();
            PreparedStatement pst1 = con.prepareStatement("INSERT INTO student_attendance_records(Roll_Number, sdate, Attendance) VALUES (?, ?, ?)");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            String time = logintime.format(formatter);
            String Roll_Number = comboroll.getSelectedItem().toString();
            pst1.setString(1, Roll_Number);
            pst1.setString(2, todaydate.toString());
            pst1.setString(3, "Present");
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insert Successfully!");
        } catch (Exception ex) {
            Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        /*  DefaultTableModel model = (DefaultTableModel)varattendancetable.getModel();
        for(int i=0;i<model.getRowCount();i++){

            String roll;
            roll = comboroll.getSelectedItem().toString();

            int selectedRow = varattendancetable.getSelectedRow();
            model.setValueAt(roll, i, 0);
            model.setValueAt("A", i, 5);
            Object value = varattendancetable.getValueAt(selectedRow,1);
            Object value1 = varattendancetable.getValueAt(selectedRow,5);
        }*/
    }//GEN-LAST:event_btnaddattendanceActionPerformed

    private void comborollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comborollActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comborollActionPerformed

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
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffdetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnaddattendance;
    private javax.swing.JButton btnbyrolldays;
    private javax.swing.JButton btnbyrollno;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndateshowreport;
    private com.toedter.calendar.JDateChooser classdate1;
    private com.toedter.calendar.JDateChooser classdate2;
    private javax.swing.JButton clearbtn;
    private javax.swing.JComboBox<String> comboroll;
    private javax.swing.JComboBox<String> combosubclass;
    private javax.swing.JTable computertable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton printreport;
    private javax.swing.JTable reportclasstable;
    private javax.swing.JTable reporttable;
    private javax.swing.JButton showrepbtn;
    private javax.swing.JTextField txtnoofdays;
    private javax.swing.JTextField txtrollnumber;
    private javax.swing.JTable varattendancetable;
    // End of variables declaration//GEN-END:variables
}
