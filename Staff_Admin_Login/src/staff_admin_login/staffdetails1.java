/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff_admin_login;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
public class staffdetails1 extends javax.swing.JFrame {
private  DefaultTableModel model;
private LocalTime logintime;

    /**
     * Creates new form staffdetails1
     */
    public staffdetails1() {
        setUndecorated(true);
        initComponents();
        ResultSet rs;
        comobox();
        tbload();
        computerpc();
        reporttable1();
        combox1();
        reporttable.getColumnModel().getColumn(1).setPreferredWidth(140);
        
        
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
    
    public void reporttable1(){
        /*try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
           
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select Roll_Number,Name,Subject,Batch,Year,sdate,Attendance from student_attendance_records where subject='MMT'");
       
                  
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
     */
    }
     public void computerpc(){
        try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select Roll_Number,Pc,sdate,login,logout from student_attendance_records where Subject='MMT'");
          
           while (rs.next()) {
        Object[] row = new Object[5];
        row[0] = rs.getString("Roll_Number");
        row[1] = rs.getString("Pc");
         row[2] = rs.getDate("sdate");
       row[3] = rs.getTime("login");
        row[4] = rs.getTime("logout");
       
        
        DefaultTableModel model = (DefaultTableModel)comtable.getModel();
        model.addRow(row);
    }
         
        } catch (Exception e) {
        }
     
    }
    
        public void tbload(){
        try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select Roll_Number,sdate,login,logout,OTP,Attendance from student_attendance_records where Subject='MMT' ORDER BY sdate ASC");
          
           while (rs.next()) {
        Object[] row = new Object[6];
        row[0] = rs.getString("Roll_Number");
        row[1] = rs.getDate("sdate");
       row[2] = rs.getTime("login");
        row[3] = rs.getTime("logout");
        row[4] = rs.getString("OTP");
        row[5] =rs.getString("Attendance");
        DefaultTableModel model = (DefaultTableModel)attendancetable.getModel();
        model.addRow(row);
    }
        
                    
        } catch (Exception e) {
        }
     
    }
    
    
    private void comobox()
    {
        try {
            Connection con = databaseconnection.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from master_Student_details  ORDER BY Name ASC ");
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
        jButton1 = new javax.swing.JButton();
        btnpresent = new javax.swing.JButton();
        btnabsent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        attendancetable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        comtable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnreport = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btnclear = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        reporttable = new javax.swing.JTable();
        txtrollnumber1 = new javax.swing.JTextField();
        txtnoofdays1 = new javax.swing.JTextField();
        btnbyrollno1 = new javax.swing.JButton();
        btnbyrolldays1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        classtable = new javax.swing.JTable();
        classdate1 = new com.toedter.calendar.JDateChooser();
        classdate2 = new com.toedter.calendar.JDateChooser();
        combosubclass = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        printreport = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnpresent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnpresent.setText("PRESENT");
        btnpresent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnpresent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpresentActionPerformed(evt);
            }
        });

        btnabsent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnabsent.setText("ABSENT");
        btnabsent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnabsent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnabsentActionPerformed(evt);
            }
        });

        attendancetable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attendancetable.setModel(new javax.swing.table.DefaultTableModel(
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
        attendancetable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(attendancetable);

        jScrollPane1.setViewportView(jScrollPane2);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                            .addComponent(btnpresent, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboroll, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnabsent, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
                        .addComponent(jButton1)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnpresent)
                            .addComponent(btnabsent))
                        .addGap(37, 37, 37)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ATTENDANCE", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        comtable.setModel(new javax.swing.table.DefaultTableModel(
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
        comtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(comtable);

        jScrollPane4.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("COMPUTER USED", jPanel4);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        btnreport.setText("Generate report");
        btnreport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportActionPerformed(evt);
            }
        });

        jButton2.setText("Show Report");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        reporttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll_Number", "Name", "Subject", "Batch", "Year", "sdate", "Attendance", "Percentage", "Days"
            }
        ));
        reporttable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane5.setViewportView(reporttable);

        jScrollPane6.setViewportView(jScrollPane5);

        txtrollnumber1.setText("Enter roll number");
        txtrollnumber1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtrollnumber1FocusGained(evt);
            }
        });

        txtnoofdays1.setText("Enter No.of Days to Calculate %");
        txtnoofdays1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnoofdays1FocusGained(evt);
            }
        });

        btnbyrollno1.setText("Get Record By Roll Number");
        btnbyrollno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbyrollno1ActionPerformed(evt);
            }
        });

        btnbyrolldays1.setText("Calculate Percentage");
        btnbyrolldays1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbyrolldays1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnbyrollno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtrollnumber1)
                    .addComponent(txtnoofdays1)
                    .addComponent(btnbyrolldays1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnreport, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtrollnumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbyrollno1)
                        .addGap(18, 18, 18)
                        .addComponent(txtnoofdays1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbyrolldays1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnclear)
                        .addGap(18, 18, 18)
                        .addComponent(btnreport))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("LAB REPORTS", jPanel5);

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);

        classtable.setModel(new javax.swing.table.DefaultTableModel(
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
        classtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        classtable.setAutoscrolls(false);
        classtable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane7.setViewportView(classtable);

        jScrollPane8.setViewportView(jScrollPane7);

        combosubclass.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jButton4.setText("Show Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        printreport.setText("Generate Report");
        printreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printreportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classdate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combosubclass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printreport, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(classdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(classdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combosubclass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(printreport)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLASS REPORTS", jPanel2);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel1.setText("Astute Student Governance System");

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

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClose)
                            .addComponent(btnMinimize))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void comborollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comborollActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comborollActionPerformed

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

    private void btnpresentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpresentActionPerformed
        // TODO add your handling code here:
        try {
        
        DefaultTableModel model = (DefaultTableModel)attendancetable.getModel();
        for(int i=0;i<model.getRowCount();i++){
            
        
        
        int selectedRow = attendancetable.getSelectedRow();
        model.setValueAt("Present", selectedRow, 5);
        Object value = attendancetable.getValueAt(selectedRow,5);
        
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
        
      
    }//GEN-LAST:event_btnpresentActionPerformed

    private void btnabsentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabsentActionPerformed
        // TODO add your handling code here:
        
      try {
        
        DefaultTableModel model = (DefaultTableModel)attendancetable.getModel();
        for(int i=0;i<model.getRowCount();i++){
            
        
        
        int selectedRow = attendancetable.getSelectedRow();
        model.setValueAt("Absent", selectedRow, 5);
        Object value = attendancetable.getValueAt(selectedRow,5);
        
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
    }//GEN-LAST:event_btnabsentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
               
                
                
                pst1.setString(3,"MMT");
                
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
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportActionPerformed
        // TODO add your handling code here:
        try{
          MessageFormat header= new MessageFormat("Report");
          MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        reporttable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        
                }
      catch(Exception ex){
      }
        
    }//GEN-LAST:event_btnreportActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
        PreparedStatement stmt = conn.prepareStatement("SELECT Roll_Number, Name, Subject, Batch, Year, sdate, Attendance FROM student_attendance_records WHERE sdate BETWEEN ? AND ? AND Subject='MMT' ORDER BY Name ASC");
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


    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        
        reporttable.setModel(new DefaultTableModel(null,new String[]{"Roll_Number", "Name", "Subject", "Batch", "Year", "sdate", "Attendance","Percentage","Days"}));
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtrollnumber1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrollnumber1FocusGained
        // TODO add your handling code here:
        txtrollnumber1.setText("");
    }//GEN-LAST:event_txtrollnumber1FocusGained

    private void txtnoofdays1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnoofdays1FocusGained
        // TODO add your handling code here:
        txtnoofdays1.setText("");
    }//GEN-LAST:event_txtnoofdays1FocusGained

    private void btnbyrollno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbyrollno1ActionPerformed
        // TODO add your handling code here:

        // Clear table data
        // model.setRowCount(0);

        try {
            
               if (txtrollnumber1.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the Roll Number.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
            
            // Connect to MySQL database
          Connection conn = databaseconnection.getConnection();

            // Prepare SQL statement
            PreparedStatement stmt = conn.prepareStatement("SELECT Roll_Number, Name, Subject, Batch, Year, sdate, Attendance FROM student_attendance_records WHERE Roll_Number=? AND Subject='MMT'");
            stmt.setString(1, txtrollnumber1.getText());

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

    }//GEN-LAST:event_btnbyrollno1ActionPerformed

  
    private void btnbyrolldays1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbyrolldays1ActionPerformed

     /*   DefaultTableModel model = (DefaultTableModel) reporttable.getModel();

try {
    // Connect to MySQL database
    Connection conn = databaseconnection.getConnection();

    // Prepare SQL statement
    PreparedStatement stmt = conn.prepareStatement("SELECT Roll_Number,Name, COUNT(*) AS count, (COUNT(*)/?)*100 AS percentage FROM student_attendance_records WHERE Roll_Number=? AND Subject='MMT' GROUP BY Roll_Number");

    // Set the parameters for the SQL statement
    stmt.setString(2, txtrollnumber1.getText());
    stmt.setString(1, txtnoofdays1.getText());

    // Execute SQL query
    ResultSet rs = stmt.executeQuery();

    // Loop through existing rows in the table
    for (int i = 0; i < model.getRowCount(); i++) {
        String rollNumber = model.getValueAt(i, 0).toString();
        boolean rowExists = false;

        // Loop through result set to find matching row
        while (rs.next()) {
            String rsRollNumber = rs.getString("Roll_Number");
            if (rsRollNumber.equals(rollNumber)) {
                // Update existing row with new data
                int count = rs.getInt("count");
                double percentage = ((double)count / Integer.parseInt(txtnoofdays1.getText())) * 100;

                model.setValueAt(rs.getString("Name"), i, 1);
                model.setValueAt(percentage, i, 2);
                model.setValueAt(count, i, 3);

                rowExists = true;
                break;
            }
        }

        // If no matching row was found, remove row from table
        if (!rowExists) {
            model.removeRow(i);
            i--;
        }

        // Reset result set cursor to beginning
        rs.beforeFirst();
    }

    // Add new rows to table
    while (rs.next()) {
        int count = rs.getInt("count");
        double percentage = ((double)count / Integer.parseInt(txtnoofdays1.getText())) * 100;

        Object[] row = new Object[4];
        row[0] = rs.getInt("Roll_Number");
        row[1] = rs.getString("Name");
        row[2] = percentage;
        row[3] = count;

        model.addRow(row);
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}*/

        
        
        
        
     /*   // Create a new default table model
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        model.addColumn("Roll Number");
        model.addColumn("Name");
        model.addColumn("Percentage");
        model.addColumn("No Of Days Present");
        // Set the model for the report table
        reporttable.setModel(model);
    */
  // Create a new default table model
  //  DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model = (DefaultTableModel) reporttable.getModel();
    // Add columns to the model
    //model.addColumn("Roll Number");
  //  model.addColumn("Name");
  //  model.addColumn("Percentage");
  //  model.addColumn("No Of Days Present");
    // Set the model for the report table
   // reporttable.setModel(model);
    
    try {
        
         if (txtnoofdays1.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the number of days.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        // Connect to MySQL database
        Connection conn = databaseconnection.getConnection();
        
        // Prepare SQL statement
        PreparedStatement stmt = conn.prepareStatement("SELECT Roll_Number, Name,Subject,Batch,Year,sdate,Attendance ,COUNT(*) AS count, (COUNT(*)/?)*100 AS percentage FROM student_attendance_records WHERE Subject='MMT' AND Attendance <> 'Absent' GROUP BY Roll_Number, Name ,Subject,Batch,Year,sdate,Attendance ORDER BY Name ASC");
        
        
        // Set the parameters for the SQL statement
    //    stmt.setString(2, txtrollnumber.getText());
        stmt.setString(1, txtnoofdays1.getText());
        
        // Execute SQL query
        ResultSet rs = stmt.executeQuery();
        
        // Populate table with query results
        while (rs.next()) {
            int count = rs.getInt("count");
            double percentage = ((double)count / Integer.parseInt(txtnoofdays1.getText())) * 100;
            
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
        
    }//GEN-LAST:event_btnbyrolldays1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel)attendancetable.getModel();
        model.setRowCount(0);
        tbload();
    DefaultTableModel m = (DefaultTableModel)comtable.getModel();
    m.setRowCount(0);
    computerpc();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
        PreparedStatement stmt = conn.prepareStatement("SELECT  PRN,Name,Roll_Number, Subject, Date ,Time FROM class_attendance WHERE Date BETWEEN ? AND ? AND Subject= ? ORDER BY Name ASC");
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
            
            DefaultTableModel model = (DefaultTableModel) classtable.getModel();
            model.addRow(row);
        }
        
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        classtable.setModel(new DefaultTableModel(null,new String[]{"PRN","Name", "Roll Number", "Subject","Date","Time" }));
    }//GEN-LAST:event_clearbtnActionPerformed

    private void printreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printreportActionPerformed
        // TODO add your handling code here:
          try{
          MessageFormat header= new MessageFormat("Report");
          MessageFormat footer = new MessageFormat("Page{0,number,integer}");
       classtable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        
                }
      catch(Exception ex){
      }
    }//GEN-LAST:event_printreportActionPerformed

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
            java.util.logging.Logger.getLogger(staffdetails1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffdetails1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffdetails1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffdetails1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffdetails1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendancetable;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnabsent;
    private javax.swing.JButton btnbyrolldays1;
    private javax.swing.JButton btnbyrollno1;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnpresent;
    private javax.swing.JButton btnreport;
    private com.toedter.calendar.JDateChooser classdate1;
    private com.toedter.calendar.JDateChooser classdate2;
    private javax.swing.JTable classtable;
    private javax.swing.JButton clearbtn;
    private javax.swing.JComboBox<String> comboroll;
    private javax.swing.JComboBox<String> combosubclass;
    private javax.swing.JTable comtable;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JTable reporttable;
    private javax.swing.JTextField txtnoofdays1;
    private javax.swing.JTextField txtrollnumber1;
    // End of variables declaration//GEN-END:variables
}
