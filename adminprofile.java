/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinic;
import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author donis
 */
public class adminprofile extends javax.swing.JFrame {

    /**
     * Creates new form adminprofile
     */
    public adminprofile() {
        initComponents();
        load();
                patdropdown.setVisible(false);
        docdropdown2.setVisible(false);
    }
    public static Connection mycon()
{Connection con=null;
            try
        {
        
        String url="jdbc:mysql://localhost:3306/clinic?"+"user=root&password=P@ssword1";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(url);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection Failed");
        }
            return con;
}
    public void load(){
              patdropdown.setVisible(false);
        docdropdown2.setVisible(false);
    Connection con=mycon();
        try{
  
           PreparedStatement p;
           String sql="select * from user";
           p=con.prepareStatement(sql);
           ResultSet s=p.executeQuery();
           if(s.next())
           {
              this.username.setText(s.getString(2));
              this.cpass.setText(s.getString(3));
           }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Failed");
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        profile = new javax.swing.JButton();
        home = new javax.swing.JButton();
        prescription = new javax.swing.JButton();
        report = new javax.swing.JButton();
        patient = new javax.swing.JButton();
        doctor = new javax.swing.JButton();
        patdropdown = new javax.swing.JPanel();
        patoption1 = new javax.swing.JButton();
        patient2 = new javax.swing.JButton();
        docdropdown2 = new javax.swing.JPanel();
        docoption1 = new javax.swing.JButton();
        docoption2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        npass = new javax.swing.JPasswordField();
        update = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1567, 115, -1, -1));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setBackground(new java.awt.Color(102, 102, 102));
        profile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\profile (1).png")); // NOI18N
        profile.setText("PROFILE");
        profile.setIconTextGap(40);
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        jPanel4.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 230, 50));

        home.setBackground(new java.awt.Color(102, 102, 102));
        home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\homeRed.png")); // NOI18N
        home.setText("HOME");
        home.setIconTextGap(40);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel4.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 230, 50));

        prescription.setBackground(new java.awt.Color(102, 102, 102));
        prescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prescription.setForeground(new java.awt.Color(255, 255, 255));
        prescription.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\drug.png")); // NOI18N
        prescription.setText("PRESCRIPTION");
        prescription.setIconTextGap(40);
        prescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescriptionActionPerformed(evt);
            }
        });
        jPanel4.add(prescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 230, 50));

        report.setBackground(new java.awt.Color(102, 102, 102));
        report.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        report.setForeground(new java.awt.Color(255, 255, 255));
        report.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\template.png")); // NOI18N
        report.setText("REPORT");
        report.setIconTextGap(40);
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportMouseExited(evt);
            }
        });
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        jPanel4.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, 230, 50));

        patient.setBackground(new java.awt.Color(102, 102, 102));
        patient.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        patient.setForeground(new java.awt.Color(255, 255, 255));
        patient.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\patient.png")); // NOI18N
        patient.setText("PATIENT");
        patient.setIconTextGap(40);
        patient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientMouseExited(evt);
            }
        });
        patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientActionPerformed(evt);
            }
        });
        jPanel4.add(patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 230, 50));

        doctor.setBackground(new java.awt.Color(102, 102, 102));
        doctor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doctor.setForeground(new java.awt.Color(255, 255, 255));
        doctor.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\doctor.png")); // NOI18N
        doctor.setText("DOCTOR");
        doctor.setIconTextGap(40);
        doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorMouseExited(evt);
            }
        });
        doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActionPerformed(evt);
            }
        });
        jPanel4.add(doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 230, 50));

        patdropdown.setBackground(new java.awt.Color(102, 102, 102));
        patdropdown.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                patdropdownMouseMoved(evt);
            }
        });
        patdropdown.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patdropdownFocusGained(evt);
            }
        });
        patdropdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patdropdownMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patdropdownMouseExited(evt);
            }
        });

        patoption1.setBackground(new java.awt.Color(102, 102, 102));
        patoption1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        patoption1.setForeground(new java.awt.Color(255, 255, 255));
        patoption1.setText("PATIENT REGISTRATION");
        patoption1.setIconTextGap(40);
        patoption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patoption1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patoption1MouseExited(evt);
            }
        });
        patoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patoption1ActionPerformed(evt);
            }
        });

        patient2.setBackground(new java.awt.Color(102, 102, 102));
        patient2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        patient2.setForeground(new java.awt.Color(255, 255, 255));
        patient2.setText("MODIFY DETAILS");
        patient2.setIconTextGap(40);
        patient2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patient2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patient2MouseExited(evt);
            }
        });
        patient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patdropdownLayout = new javax.swing.GroupLayout(patdropdown);
        patdropdown.setLayout(patdropdownLayout);
        patdropdownLayout.setHorizontalGroup(
            patdropdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patdropdownLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(patdropdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(patoption1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        patdropdownLayout.setVerticalGroup(
            patdropdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patdropdownLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(patoption1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(patient2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.add(patdropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 280, -1));

        docdropdown2.setBackground(new java.awt.Color(102, 102, 102));
        docdropdown2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                docdropdown2MouseMoved(evt);
            }
        });
        docdropdown2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                docdropdown2FocusGained(evt);
            }
        });
        docdropdown2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docdropdown2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docdropdown2MouseExited(evt);
            }
        });
        docdropdown2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        docoption1.setBackground(new java.awt.Color(102, 102, 102));
        docoption1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        docoption1.setForeground(new java.awt.Color(255, 255, 255));
        docoption1.setText("DOCTOR REGISTRATION");
        docoption1.setIconTextGap(40);
        docoption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docoption1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docoption1MouseExited(evt);
            }
        });
        docoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docoption1ActionPerformed(evt);
            }
        });
        docdropdown2.add(docoption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 32, -1, 50));

        docoption2.setBackground(new java.awt.Color(102, 102, 102));
        docoption2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        docoption2.setForeground(new java.awt.Color(255, 255, 255));
        docoption2.setText("MODIFY DETAILS");
        docoption2.setIconTextGap(40);
        docoption2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docoption2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docoption2MouseExited(evt);
            }
        });
        docoption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docoption2ActionPerformed(evt);
            }
        });
        docdropdown2.add(docoption2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 122, 239, 50));

        jPanel4.add(docdropdown2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 280, 195));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\logo-no-background (1).png")); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 220));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 282, 896));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\logout.png")); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, -1, 64));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("HealthFirst Clinic");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 424, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Your trusted partner in health.");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 360, -1));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ADMIN DASHBOARD");
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel6MouseMoved(evt);
            }
        });
        jLabel6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel6FocusLost(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, 210, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 0, 1279, 172));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 149, -1));

        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 304, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Current Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 149, -1));

        cpass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpassActionPerformed(evt);
            }
        });
        jPanel1.add(cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 304, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("New Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 250, 149, -1));

        npass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        npass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                npassPropertyChange(evt);
            }
        });
        jPanel1.add(npass, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 280, 304, -1));

        update.setBackground(new java.awt.Color(204, 204, 255));
        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(0, 51, 51));
        update.setText("UPDATE");
        update.setPreferredSize(new java.awt.Dimension(95, 32));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 344, 127, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 990, 500));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("ADMIN PROFILE");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, 34));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1572, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     conn c=new conn();
     Connection con=c.mycon();// TODO add your handling code here:
        try
        {
            String u=username.getText();
            String np=npass.getText();
            String t="admin";
           String sql="update user set username='"+u+"',password='"+np+"'where type='"+t+"'";
           PreparedStatement s;
           s=con.prepareStatement(sql);
           int count=s.executeUpdate();
           if(count>0){
               JOptionPane.showMessageDialog(null, "Successfully updated");
               this.dispose();
              Login l=new Login();
              l.setVisible(true);
           }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Failed");
        }

      
    }//GEN-LAST:event_updateActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void npassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_npassPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_npassPropertyChange

    private void cpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpassActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileActionPerformed

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        report.setForeground(Color.white);
        doctor.setVisible(true);
        prescription.setVisible(true);
        profile.setVisible(true);
        patdropdown.setVisible(false);
        docdropdown2.setVisible(false);
        doctor.setForeground(Color.white);
        patient.setForeground(Color.white);// TODO add your handling code here:
    }//GEN-LAST:event_homeMouseEntered

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        admin h = new admin();
        h.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_homeActionPerformed

    private void prescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prescriptionActionPerformed

    private void reportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseEntered
        report.setForeground(Color.orange);
        doctor.setVisible(true);
        prescription.setVisible(true);
        profile.setVisible(true);
        patdropdown.setVisible(false);
        docdropdown2.setVisible(false);
        patient.setForeground(Color.white);// TODO add your handling code here:
    }//GEN-LAST:event_reportMouseEntered

    private void reportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseExited
        report.setForeground(Color.white);
        // TODO add your handling code here:
    }//GEN-LAST:event_reportMouseExited

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportActionPerformed

    private void patientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientMouseEntered
        patient.setForeground(Color.orange);
        doctor.setVisible(false);
        prescription.setVisible(false);
        profile.setVisible(false);
        patdropdown.setVisible(true);
        docdropdown2.setVisible(false);
        doctor.setForeground(Color.white); // TODO add your handling code here:
    }//GEN-LAST:event_patientMouseEntered

    private void patientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_patientMouseExited

    private void patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientActionPerformed
        doctor.setVisible(false);
        prescription.setVisible(false);
        profile.setVisible(false);
        patdropdown.setVisible(true);
        docdropdown2.setVisible(false);
        patient.setForeground(Color.orange);// TODO add your handling code here:
    }//GEN-LAST:event_patientActionPerformed

    private void doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorMouseEntered
        doctor.setVisible(true);
        prescription.setVisible(false);
        profile.setVisible(false);
        docdropdown2.setVisible(true);
        patdropdown.setVisible(false);
        doctor.setForeground(Color.orange);
        patient.setForeground(Color.white);// TODO add your handling code here:
    }//GEN-LAST:event_doctorMouseEntered

    private void doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorMouseExited
        doctor.setForeground(Color.white); // TODO add your handling code here:
    }//GEN-LAST:event_doctorMouseExited

    private void doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActionPerformed
        doctor.setVisible(true);
        prescription.setVisible(false);
        profile.setVisible(false);
        docdropdown2.setVisible(true);
        patdropdown.setVisible(false);
        doctor.setForeground(Color.orange);
        patient.setForeground(Color.white);   // TODO add your handling code here:
    }//GEN-LAST:event_doctorActionPerformed

    private void patoption1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patoption1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_patoption1MouseEntered

    private void patoption1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patoption1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_patoption1MouseExited

    private void patoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patoption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patoption1ActionPerformed

    private void patient2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_patient2MouseEntered

    private void patient2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_patient2MouseExited

    private void patient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient2ActionPerformed

    private void patdropdownMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patdropdownMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_patdropdownMouseMoved

    private void patdropdownFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patdropdownFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_patdropdownFocusGained

    private void patdropdownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patdropdownMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_patdropdownMouseEntered

    private void patdropdownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patdropdownMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_patdropdownMouseExited

    private void docoption1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docoption1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption1MouseEntered

    private void docoption1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docoption1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption1MouseExited

    private void docoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docoption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption1ActionPerformed

    private void docoption2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docoption2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption2MouseEntered

    private void docoption2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docoption2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption2MouseExited

    private void docoption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docoption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption2ActionPerformed

    private void docdropdown2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docdropdown2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_docdropdown2MouseMoved

    private void docdropdown2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_docdropdown2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_docdropdown2FocusGained

    private void docdropdown2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docdropdown2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_docdropdown2MouseEntered

    private void docdropdown2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docdropdown2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_docdropdown2MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseMoved

    private void jLabel6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6FocusGained

    private void jLabel6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6FocusLost

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel3.setForeground(Color.orange);       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel3.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

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
            java.util.logging.Logger.getLogger(adminprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminprofile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpass;
    private javax.swing.JPanel docdropdown2;
    private javax.swing.JButton docoption1;
    private javax.swing.JButton docoption2;
    private javax.swing.JButton doctor;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField npass;
    private javax.swing.JPanel patdropdown;
    private javax.swing.JButton patient;
    private javax.swing.JButton patient2;
    private javax.swing.JButton patoption1;
    private javax.swing.JButton prescription;
    private javax.swing.JButton profile;
    private javax.swing.JButton report;
    private javax.swing.JButton update;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
