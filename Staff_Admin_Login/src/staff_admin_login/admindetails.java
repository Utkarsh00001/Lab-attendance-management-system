/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff_admin_login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class admindetails extends javax.swing.JFrame {
  //  Connection con=null;
  //  PreparedStatement pst=null;
  //  ResultSet rs=null;
    
    

    public admindetails() {
        setUndecorated(true);
        initComponents();
        tbload();
        tbload1();
        tbload2();
        satable1();
    
        
        
    }
    
    
    
    public void tbload(){
        try {
            DefaultTableModel dt = (DefaultTableModel)jstafftable.getModel(); 
            dt.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select * From staff");
           
            while (rs.next()) {
                Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                
                
                
                dt.addRow(v);
            }
                    
        } catch (Exception e) {
        }
     
    }
    
      public void tbload1(){
        try {
            DefaultTableModel dt12 = (DefaultTableModel)jcomputertable.getModel(); 
            dt12.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs1 = pst.executeQuery("Select *From computer_details");
           
            while (rs1.next()) {
                Vector v = new Vector();
                
                 v.add(rs1.getString(1));
                 v.add(rs1.getString(2));
                v.add(rs1.getString(3));
                v.add(rs1.getString(4));
                
                
                
                dt12.addRow(v);
            }
                    
        } catch (Exception e) {
        }
        
        
        
    }
      
      public void tbload2(){
      /*  try {
            DefaultTableModel dt13 = (DefaultTableModel)msdtable.getModel(); 
            dt13.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs1 = pst.executeQuery("Select *From master_student_details");
           
            while (rs1.next()) {
                Vector v = new Vector();
                
                 v.add(rs1.getString(1));
                 v.add(rs1.getString(2));
                v.add(rs1.getString(3));
                v.add(rs1.getString(4));
                v.add(rs1.getString(5));
                v.add(rs1.getString(6));
                v.add(rs1.getString(7));
                dt13.addRow(v);
            }
                    
        } catch (Exception e) {
        }*/
        try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select PRN,Roll_Number,Name,Batch,Year,Pc,Year_of_Admission,Password,hint from master_student_details ORDER BY Name ASC");
          
         while (rs.next()) {
        Object[] row = new Object[9];
        row[0] = rs.getString("PRN");
        row[1] = rs.getString("Roll_Number");
        row[2] = rs.getString("Name");
        row[3] = rs.getString("Batch");
        
        row[4] = rs.getString("Year");
        row[5] = rs.getString("Pc");
        
        row[6] = rs.getString("Year_of_Admission");
        
        
        row[7] = rs.getString("Password");
        row[8] = rs.getString("hint");
        
        
        DefaultTableModel model = (DefaultTableModel)msdtable.getModel();
        model.addRow(row);
   
    }
         
        } catch (Exception e) {
        }
        
        
    }
   
/*    try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select PRN,Roll_Number,Name,Batch,Year,Pc,Year_of_Admission,Password from master_student_details");
          
       SecretKeySpec secretKey = new SecretKeySpec("abcdefghijklmnop".getBytes(), "AES");
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);

while (rs.next()) {
    Object[] row = new Object[8];
    row[0] = rs.getString("PRN");
    row[1] = rs.getString("Roll_Number");
    row[2] = rs.getString("Name");
    row[3] = rs.getString("Batch");
    row[4] = rs.getString("Year");
    row[5] = rs.getString("Pc");
    row[6] = rs.getString("Year_of_Admission");

      String encryptedPassword = rs.getString("Password");
    byte[] decryptedPassword = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
    row[7] = new String(decryptedPassword);

    DefaultTableModel model = (DefaultTableModel) msdtable.getModel();
    model.addRow(row);
}

    
         
        } catch (Exception e) {
        }
        
        
    }*/
   
   
   
   
   
   
      public void clearfields(){
          //msd record
          txtprnmsd.setText(null);
          txtrollnumbermsd.setText(null);
          txtnamemsd.setText(null);
          Combomsd.setSelectedItem(null);
          Combomsdyear.setSelectedItem(null);
          combomsdpcno.setSelectedItem(null);
          txtyoamsd.setText(null);
          txtstudentpass.setText(null);
          txthint.setText(null);
         //staff record
          txtstaffid.setText(null);
        txtstaffname.setText(null);
          txtstaffpass1.setText(null);
          txtstaffsubject.setText(null);
          
          // Computer details
          txtpcno.setText(null);
          txtprocessor.setText(null);
          txtmemory.setText(null);
          txtgraphics.setText(null);
      }
      
       public void satable1(){
        try {
             //DefaultTableModel dt = (DefaultTableModel)attendancetable.getModel(); 
           // dt.setRowCount(0);
            Connection con = databaseconnection.getConnection();
                PreparedStatement pst =con.prepareStatement("");
            ResultSet rs = pst.executeQuery("Select Roll_Number,Name,Subject,Batch,Year,Pc,sdate,login,logout,Total_time,OTP,Attendance,Year_of_Admission from student_attendance_records ");
          
           while (rs.next()) {
        Object[] row = new Object[13];
        row[0] = rs.getString("Roll_Number");
        row[1] = rs.getString("Name");
        row[2] = rs.getString("Subject");
        row[3] = rs.getString("Batch");
        row[4] = rs.getString("Year");
        row[5] = rs.getString("Pc");
        row[6] = rs.getDate("sdate");
        row[7] = rs.getTime("login");
        row[8] = rs.getTime("logout");
        row[9] = rs.getTime("Total_time");
        row[10] = rs.getString("OTP");
        row[11] = rs.getString("Attendance");
        row[12] = rs.getString("Year_of_Admission");
        
        
        
        DefaultTableModel model = (DefaultTableModel)satable.getModel();
        model.addRow(row);
    }
         
        } catch (Exception e) {
        }
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * rgenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtstaffid = new javax.swing.JTextField();
        txtstaffname = new javax.swing.JTextField();
        txtstaffsubject = new javax.swing.JTextField();
        btnadd1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jstafftable = new javax.swing.JTable();
        txtstaffpass1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtpcno = new javax.swing.JTextField();
        txtmemory = new javax.swing.JTextField();
        txtgraphics = new javax.swing.JTextField();
        txtprocessor = new javax.swing.JTextField();
        btnadd6 = new javax.swing.JButton();
        btndeletepc = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jcomputertable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        satable = new javax.swing.JTable();
        btnrefresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnamemsd = new javax.swing.JTextField();
        txtyoamsd = new javax.swing.JTextField();
        Combomsd = new javax.swing.JComboBox<>();
        Combomsdyear = new javax.swing.JComboBox<>();
        combomsdpcno = new javax.swing.JComboBox<>();
        txtrollnumbermsd = new javax.swing.JTextField();
        btnupdatemsd = new javax.swing.JButton();
        btnaddmsd = new javax.swing.JButton();
        btndeletemsd = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtprnmsd = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        msdtable = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtstudentpass = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txthint = new javax.swing.JTextField();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_refresh_64px.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel1.setText("Astute Student Governance System");

        jLabel16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel16MouseDragged(evt);
            }
        });
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)))
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMinimize)
                            .addComponent(btnClose))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 204));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("STAFF ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("NAME");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("PASSWORD");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("SUBJECT");

        txtstaffname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstaffnameActionPerformed(evt);
            }
        });

        btnadd1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnadd1.setText("ADD");
        btnadd1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnadd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd1ActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jstafftable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff_id", "Name", "Password", "Subject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jstafftable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jstafftableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jstafftable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jstafftableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jstafftable);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnadd1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtstaffsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtstaffpass1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstaffname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstaffid))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(721, 721, 721))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstaffid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstaffname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstaffpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstaffsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnadd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("STAFF RECORDS", jPanel2);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("PC_NO.");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("MEMORY");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("PROCESSOR");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("GRAPHICS");

        txtpcno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpcnoActionPerformed(evt);
            }
        });

        txtmemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmemoryActionPerformed(evt);
            }
        });

        txtgraphics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgraphicsActionPerformed(evt);
            }
        });

        txtprocessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprocessorActionPerformed(evt);
            }
        });

        btnadd6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnadd6.setText("ADD");
        btnadd6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnadd6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd6ActionPerformed(evt);
            }
        });

        btndeletepc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btndeletepc.setText("DELETE");
        btndeletepc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndeletepc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndeletepc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletepcActionPerformed(evt);
            }
        });

        jcomputertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pc_no", "Processor", "Ram", "Graphics"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jcomputertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcomputertableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jcomputertable);

        jScrollPane6.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtprocessor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmemory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnadd6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btndeletepc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgraphics, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpcno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpcno, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtprocessor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmemory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtgraphics, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeletepc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("COMPUTER DETAILS", jPanel4);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);

        satable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        satable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll_Number", "Name ", "Subject", "Batch", "Year", "Pc", "sdate", "login", "logout", "Total_time", "OTP", "Attendance", "Year_of_Admission"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        satable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane7.setViewportView(satable);

        jScrollPane9.setViewportView(jScrollPane7);

        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_refresh_64px.png"))); // NOI18N
        btnrefresh.setContentAreaFilled(false);
        btnrefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("STUDENT ATTENDANCE RECORDS", jPanel6);

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("ROLL NUMBER");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("NAME");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("BATCH");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("YEAR");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("PC_NO");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("YEAR OF ADMISSION");

        Combomsd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Combomsd.setForeground(new java.awt.Color(0, 153, 153));
        Combomsd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        Combomsdyear.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Combomsdyear.setForeground(new java.awt.Color(0, 153, 153));
        Combomsdyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        combomsdpcno.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        combomsdpcno.setForeground(new java.awt.Color(0, 153, 153));
        combomsdpcno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));
        combomsdpcno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomsdpcnoActionPerformed(evt);
            }
        });

        btnupdatemsd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnupdatemsd.setText("UPDATE");
        btnupdatemsd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnupdatemsd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnupdatemsd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatemsdActionPerformed(evt);
            }
        });

        btnaddmsd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnaddmsd.setText("ADD");
        btnaddmsd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnaddmsd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnaddmsd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddmsdActionPerformed(evt);
            }
        });

        btndeletemsd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btndeletemsd.setText("DELETE");
        btndeletemsd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndeletemsd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndeletemsd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletemsdActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel17.setText("PRN");

        txtprnmsd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprnmsdActionPerformed(evt);
            }
        });

        msdtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRN", "Roll Number", "Name", "Batch", "Year", "Pc", "Year Of Admission", "Password", "hint "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        msdtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        msdtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msdtableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(msdtable);

        jScrollPane4.setViewportView(jScrollPane3);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("PASSWORD");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("SET HINT DEFAULT ANSWER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnupdatemsd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnaddmsd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(btndeletemsd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txthint))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtrollnumbermsd)
                                    .addComponent(txtnamemsd)
                                    .addComponent(txtprnmsd)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Combomsdyear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Combomsd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(combomsdpcno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtyoamsd)
                                    .addComponent(txtstudentpass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 378, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprnmsd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtrollnumbermsd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtnamemsd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Combomsd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Combomsdyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combomsdpcno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtyoamsd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtstudentpass, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txthint, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndeletemsd)
                            .addComponent(btnaddmsd)
                            .addComponent(btnupdatemsd))
                        .addGap(656, 656, 656))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("MASTER STUDENT DETAILS", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try 
            {
                   if (txtstaffid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields");
            return;
        } 
                String id=txtstaffid.getText();
                String name=txtstaffname.getText();
                String pass=txtstaffpass1.getText();
                String subject=txtstaffsubject.getText();
                
              //  Class.forName("com.mysql.jdbc.driver");
                Connection con = databaseconnection.getConnection();
                PreparedStatement pst=con.prepareStatement("Delete from staff where Staff_id=?");
                pst.setString(1, id);
               
                
                pst.executeUpdate();
                
                DefaultTableModel dt1 = (DefaultTableModel) jstafftable.getModel();
                dt1.setRowCount(0);
                tbload();
                
                JOptionPane.showMessageDialog(this,"Delete Successfully!");
                
            } catch (Exception ex) {
                Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtstaffnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstaffnameActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txtstaffnameActionPerformed

    private void btndeletemsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletemsdActionPerformed
        // TODO add your handling code here:
        try 
            {
                   if (txtrollnumbermsd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields");
            return;
        }
                String rollnumber=txtrollnumbermsd.getText();
                
              //  Class.forName("com.mysql.jdbc.driver");
                Connection con = databaseconnection.getConnection();
                PreparedStatement pst1=con.prepareStatement("Delete from master_student_details where Roll_Number=?");
                
                pst1.setString(1, rollnumber);
                
                
                pst1.executeUpdate();
                
                DefaultTableModel dt13 = (DefaultTableModel)msdtable.getModel(); 
                dt13.setRowCount(0);
                tbload2();
                
                JOptionPane.showMessageDialog(this,"Delete Successfully!");
                clearfields();
            } catch (Exception ex) {
                Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btndeletemsdActionPerformed

    private void txtpcnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpcnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpcnoActionPerformed

    private void txtmemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmemoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmemoryActionPerformed

    private void txtgraphicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgraphicsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgraphicsActionPerformed

    private void txtprocessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprocessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprocessorActionPerformed

    private void btndeletepcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletepcActionPerformed
        // TODO add your handling code here:
         try 
            {
                    if (txtpcno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields");
            return;
        }
                String pc=txtpcno.getText();
                String Pro=txtprocessor.getText();
                String Memo=txtmemory.getText();
                String Graph=txtgraphics.getText();
                
              //  Class.forName("com.mysql.jdbc.driver");
                Connection con = databaseconnection.getConnection();
                PreparedStatement pst=con.prepareStatement("Delete from computer_details where pc_no=?");
                pst.setString(1, pc);
               
                
                pst.executeUpdate();
                
                DefaultTableModel dt12 = (DefaultTableModel) jcomputertable.getModel();
                dt12.setRowCount(0);
                tbload1();
                
                JOptionPane.showMessageDialog(this,"Delete Successfully!");
                
            } catch (Exception ex) {
                Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btndeletepcActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd1ActionPerformed
  // TODO add your handling code here:
     
            try 
            {
                String id=txtstaffid.getText();
                String name=txtstaffname.getText();
                String pass=txtstaffpass1.getText();
                String subject=txtstaffsubject.getText();
                
                if (id.isEmpty() || name.isEmpty() || pass.isEmpty() || subject.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter all fields");
                return;
            }
             
                
              //  Class.forName("com.mysql.jdbc.driver");
                Connection con = databaseconnection.getConnection();
                PreparedStatement pst=con.prepareStatement("insert into staff(Staff_id,Name,Password,Subject)values(?,?,?,?)");
                pst.setString(1, id);
                pst.setString(2,name);
                pst.setString(3,pass);
                pst.setString(4,subject);
                
                pst.executeUpdate();
                DefaultTableModel dt1 = (DefaultTableModel) jstafftable.getModel();
                dt1.setRowCount(0);
                tbload();
                
                JOptionPane.showMessageDialog(this,"Insert Successfully!");
                clearfields();
            } catch (Exception ex) {
                Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
  
    }//GEN-LAST:event_btnadd1ActionPerformed

    private void jstafftableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jstafftableAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jstafftableAncestorAdded

    private void btnadd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd6ActionPerformed
        // TODO add your handling code here:
         try 
            {
       
                
                String pc=txtpcno.getText();
                String Pro=txtprocessor.getText();
                String Memo=txtmemory.getText();
                String Graph=txtgraphics.getText();
                
                // Validate fields
            if (pc.isEmpty() || Pro.isEmpty() || Memo.isEmpty() || Graph.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter all fields");
                return;
            }
            
              //  Class.forName("com.mysql.jdbc.driver");
                Connection con = databaseconnection.getConnection();
                PreparedStatement pst = con.prepareStatement("Insert into computer_details(pc_no,Processor,Ram,Graphics)values(?,?,?,?)");
                
                pst.setString(1, pc);
                pst.setString(2,Pro);
                pst.setString(3,Memo);
                pst.setString(4,Graph);
                
                pst.executeUpdate();
                
               DefaultTableModel dt12 = (DefaultTableModel) jcomputertable.getModel();
               dt12.setRowCount(0);
              tbload1();
                
                JOptionPane.showMessageDialog(this,"Insert Successfully!");
                clearfields();
            } catch (Exception ex) {
                Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnadd6ActionPerformed

    private void jstafftableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jstafftableMouseClicked
        // TODO add your handling code here:
        int i = jstafftable.getSelectedRow();
        TableModel mod = jstafftable.getModel();
        txtstaffid.setText(mod.getValueAt(i,0).toString());
        txtstaffname.setText(mod.getValueAt(i,1).toString());
        txtstaffpass1.setText(mod.getValueAt(i,2).toString());
        txtstaffsubject.setText(mod.getValueAt(i,3).toString());
        
    }//GEN-LAST:event_jstafftableMouseClicked

    private void jcomputertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcomputertableMouseClicked
        // TODO add your handling code here:
         int i = jcomputertable.getSelectedRow();
        TableModel mod = jcomputertable.getModel();
        txtpcno.setText(mod.getValueAt(i,0).toString());
        txtprocessor.setText(mod.getValueAt(i,1).toString());
        txtmemory.setText(mod.getValueAt(i,2).toString());
        txtgraphics.setText(mod.getValueAt(i,3).toString());
        
        
        
    }//GEN-LAST:event_jcomputertableMouseClicked
private static final String KEY = "abcdefghijklmnop"; // should be stored securely
    private void btnaddmsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddmsdActionPerformed
   
         try {
        if (txtprnmsd.getText().isEmpty() ||  txtrollnumbermsd.getText().isEmpty() || txtnamemsd.getText().isEmpty() || Combomsd.getSelectedItem().toString().isEmpty() || Combomsdyear.getSelectedItem().toString().isEmpty() || combomsdpcno.getSelectedItem().toString().isEmpty()|| txtyoamsd.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please enter all fields");
            return;
        }
        
        Connection con = databaseconnection.getConnection();
        PreparedStatement pst1=con.prepareStatement("insert into master_student_details(PRN,Roll_Number,Name,Batch,Year,Pc,Year_of_Admission,Password,hint)values(?,?,?,?,?,?,?,?,?)");
        pst1.setString(1, txtprnmsd.getText());
        pst1.setString(2, txtrollnumbermsd.getText());
        pst1.setString(3, txtnamemsd.getText());
        
        String Batch;
        Batch = Combomsd.getSelectedItem().toString();
        pst1.setString(4, Batch);
        
        String Year;
        Year = Combomsdyear.getSelectedItem().toString();
        pst1.setString(5, Year);
        
        String Pc_no;
        Pc_no = combomsdpcno.getSelectedItem().toString();
        pst1.setString(6, Pc_no);
        
        pst1.setString(7, txtyoamsd.getText());
        
        
        // Encrypt the password using AES-128 ECB encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey key = new SecretKeySpec(KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedPassword = cipher.doFinal(txtstudentpass.getText().getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(encryptedPassword);
        pst1.setString(8, encodedPassword);
        pst1.setString(9, txthint.getText());
        pst1.executeUpdate();
        
        DefaultTableModel dt13 = (DefaultTableModel)msdtable.getModel(); 
        dt13.setRowCount(0);
        tbload2();
        
        JOptionPane.showMessageDialog(this,"Insert Successfully!");
        clearfields();
    } catch (Exception ex) {
        Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        /*    // TODO add your handling code here:
        try 
            {
                
                if (txtprnmsd.getText().isEmpty() ||  txtrollnumbermsd.getText().isEmpty() || txtnamemsd.getText().isEmpty() || Combomsd.getSelectedItem().toString().isEmpty() || Combomsdyear.getSelectedItem().toString().isEmpty() || combomsdpcno.getSelectedItem().toString().isEmpty()|| txtyoamsd.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Please enter all fields");
                return;
            }
              //  Class.forName("com.mysql.jdbc.driver");
                Connection con = databaseconnection.getConnection();
                PreparedStatement pst1=con.prepareStatement("insert into master_student_details(PRN,Roll_Number,Name,Batch,Year,Pc,Year_of_Admission,Password)values(?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtprnmsd.getText());
                pst1.setString(2, txtrollnumbermsd.getText());
                pst1.setString(3, txtnamemsd.getText());
                
                
                String Batch;
                Batch = Combomsd.getSelectedItem().toString();
                pst1.setString(4, Batch);
                
                String Year;
                Year = Combomsdyear.getSelectedItem().toString();
                pst1.setString(5, Year);
                
                String Pc_no;
                Pc_no = combomsdpcno.getSelectedItem().toString();
                pst1.setString(6, Pc_no);
                
                pst1.setString(7, txtyoamsd.getText());
                
                pst1.setString(8, txtstudentpass.getText());
                pst1.executeUpdate();
                
                DefaultTableModel dt13 = (DefaultTableModel)msdtable.getModel(); 
                dt13.setRowCount(0);
                tbload2();
                
                JOptionPane.showMessageDialog(this,"Insert Successfully!");
                clearfields();
            } catch (Exception ex) {
                Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        
    }//GEN-LAST:event_btnaddmsdActionPerformed

    private void msdtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msdtableMouseClicked
        // TODO add your handling code here:
         int i = msdtable.getSelectedRow();
        TableModel mod1 = msdtable.getModel();
        txtprnmsd.setText(mod1.getValueAt(i,0).toString());
        txtrollnumbermsd.setText(mod1.getValueAt(i,1).toString());
        txtnamemsd.setText(mod1.getValueAt(i,2).toString());
        Combomsd.setSelectedItem(mod1.getValueAt(i,3).toString());
        Combomsdyear.setSelectedItem(mod1.getValueAt(i,4).toString());
        combomsdpcno.setSelectedItem(mod1.getValueAt(i,5).toString());
        txtyoamsd.setText(mod1.getValueAt(i,6).toString());
        txtstaffpass1.setText(mod1.getValueAt(i,7).toString());
        txthint.setText(mod1.getValueAt(i,8).toString());
    }//GEN-LAST:event_msdtableMouseClicked

    private void btnupdatemsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatemsdActionPerformed
        // TODO add your handling code here:
        try 
            {
                
                
              //  Class.forName("com.mysql.jdbc.driver");
                Connection con = databaseconnection.getConnection();
                PreparedStatement pst1=con.prepareStatement("UPDATE master_student_details set PRN=?, Name=?,Batch=?,Year=?,Pc=?,Year_of_Admission=?,hint=? where Roll_Number=? ");
                pst1.setString(1, txtprnmsd.getText());
                
                pst1.setString(2, txtnamemsd.getText());
                
                
                String Batch;
                Batch = Combomsd.getSelectedItem().toString();
                pst1.setString(3, Batch);
                
                String Year;
                Year = Combomsdyear.getSelectedItem().toString();
                pst1.setString(4, Year);
                
                String Pc_no;
                Pc_no = combomsdpcno.getSelectedItem().toString();
                pst1.setString(5, Pc_no);
                
                pst1.setString(6, txtyoamsd.getText());
                pst1.setString(7, txthint.getText());
                pst1.setString(8, txtrollnumbermsd.getText());
                
                
                pst1.executeUpdate();
                
                DefaultTableModel dt13 = (DefaultTableModel)msdtable.getModel(); 
                dt13.setRowCount(0);
                tbload2();
                
                JOptionPane.showMessageDialog(this,"Update Successfully!");
                clearfields();
            } catch (Exception ex) {
                Logger.getLogger(admindetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btnupdatemsdActionPerformed
public int mousepX,mousepY;
    private void jLabel16MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseDragged
        // TODO add your handling code here:
        int kordinatX = evt.getXOnScreen();
       int kordinatY = evt.getYOnScreen();
       
       this.setLocation(kordinatX-mousepX, kordinatY-mousepY);
    }//GEN-LAST:event_jLabel16MouseDragged

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        // TODO add your handling code here:
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jLabel16MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void combomsdpcnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomsdpcnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combomsdpcnoActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        // TODO add your handling code here:
        DefaultTableModel m = (DefaultTableModel)satable.getModel();
        m.setRowCount(0);
        satable1();
    
      
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void txtprnmsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprnmsdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprnmsdActionPerformed
        
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
            java.util.logging.Logger.getLogger(admindetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admindetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admindetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admindetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combomsd;
    private javax.swing.JComboBox<String> Combomsdyear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnadd1;
    private javax.swing.JButton btnadd6;
    private javax.swing.JButton btnaddmsd;
    private javax.swing.JButton btndeletemsd;
    private javax.swing.JButton btndeletepc;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnupdatemsd;
    private javax.swing.JComboBox<String> combomsdpcno;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jcomputertable;
    private javax.swing.JTable jstafftable;
    private javax.swing.JTable msdtable;
    private javax.swing.JTable satable;
    private javax.swing.JTextField txtgraphics;
    private javax.swing.JTextField txthint;
    private javax.swing.JTextField txtmemory;
    private javax.swing.JTextField txtnamemsd;
    private javax.swing.JTextField txtpcno;
    private javax.swing.JTextField txtprnmsd;
    private javax.swing.JTextField txtprocessor;
    private javax.swing.JTextField txtrollnumbermsd;
    private javax.swing.JTextField txtstaffid;
    private javax.swing.JTextField txtstaffname;
    private javax.swing.JTextField txtstaffpass1;
    private javax.swing.JTextField txtstaffsubject;
    private javax.swing.JTextField txtstudentpass;
    private javax.swing.JTextField txtyoamsd;
    // End of variables declaration//GEN-END:variables
}
