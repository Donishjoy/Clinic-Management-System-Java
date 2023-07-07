/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinic;
import java.awt.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author donis
 */
public class pcreate extends javax.swing.JFrame {

    /**
     * Creates new form pcreate
     */
    public pcreate() {
        initComponents();
        presdropdown.setVisible(false);
    }
Connection con=conn.mycon();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        profile = new javax.swing.JButton();
        home = new javax.swing.JButton();
        prescription = new javax.swing.JButton();
        patient = new javax.swing.JButton();
        presdropdown = new javax.swing.JPanel();
        presoption1 = new javax.swing.JButton();
        presoption2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pattable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1567, 115, -1, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setBackground(new java.awt.Color(102, 102, 102));
        profile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\profile (1).png")); // NOI18N
        profile.setText("PROFILE");
        profile.setIconTextGap(37);
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileMouseEntered(evt);
            }
        });
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        jPanel3.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 230, 50));

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
        jPanel3.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 230, 50));

        prescription.setBackground(new java.awt.Color(102, 102, 102));
        prescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prescription.setForeground(new java.awt.Color(255, 255, 255));
        prescription.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\drug.png")); // NOI18N
        prescription.setText("PRESCRIPTION");
        prescription.setIconTextGap(20);
        prescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prescriptionMouseEntered(evt);
            }
        });
        prescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescriptionActionPerformed(evt);
            }
        });
        jPanel3.add(prescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 230, 50));

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
        jPanel3.add(patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 230, 50));

        presdropdown.setBackground(new java.awt.Color(102, 102, 102));
        presdropdown.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                presdropdownMouseMoved(evt);
            }
        });
        presdropdown.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                presdropdownFocusGained(evt);
            }
        });
        presdropdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                presdropdownMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                presdropdownMouseExited(evt);
            }
        });
        presdropdown.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        presoption1.setBackground(new java.awt.Color(102, 102, 102));
        presoption1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        presoption1.setForeground(new java.awt.Color(255, 255, 255));
        presoption1.setText("CREATE PRESCRIPTION");
        presoption1.setIconTextGap(40);
        presoption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                presoption1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                presoption1MouseExited(evt);
            }
        });
        presoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presoption1ActionPerformed(evt);
            }
        });
        presdropdown.add(presoption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 32, 240, 50));

        presoption2.setBackground(new java.awt.Color(102, 102, 102));
        presoption2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        presoption2.setForeground(new java.awt.Color(255, 255, 255));
        presoption2.setText("MODIFY PRESCRIPTION");
        presoption2.setIconTextGap(40);
        presoption2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                presoption2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                presoption2MouseExited(evt);
            }
        });
        presoption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presoption2ActionPerformed(evt);
            }
        });
        presdropdown.add(presoption2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 122, 239, 50));

        jPanel3.add(presdropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 280, 195));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\logo-no-background (1).png")); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 220));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 282, 976));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, -1, 64));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("HealthFirst Clinic");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 424, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Your trusted partner in health.");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 360, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DOCTOR DASHBOARD");
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel3FocusLost(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, 210, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 0, 1279, 172));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Name");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 189, 26));
        jPanel5.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 203, -1));
        jPanel5.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 203, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("PID");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 189, 26));

        search.setBackground(new java.awt.Color(0, 153, 153));
        search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search.setText("SEARCH");
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel5.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 126, 34));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("OR");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 37, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pattable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        pattable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pattable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PATIENT ID", "NAME", "AGE", "PHONE", "ADDRESS"
            }
        ));
        pattable.setAlignmentX(1.0F);
        pattable.setAlignmentY(1.0F);
        pattable.setRowHeight(60);
        pattable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pattableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pattable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1050, 320));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 1100, 380));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 244, 1172, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseEntered
        presdropdown.setVisible(false);
        prescription.setForeground(Color.white);
        profile.setForeground(Color.orange);   // TODO add your handling code here:
    }//GEN-LAST:event_profileMouseEntered

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileActionPerformed

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        profile.setVisible(true);
        prescription.setVisible(false);
        prescription.setVisible(true);
        home.setForeground(Color.orange);     //TODO add your handling code here:
    }//GEN-LAST:event_homeMouseEntered

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        home h = new home();
        h.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_homeActionPerformed

    private void prescriptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prescriptionMouseEntered
        presdropdown.setVisible(true);
        profile.setVisible(false);
        prescription.setForeground(Color.orange);// TODO add your handling code here:
    }//GEN-LAST:event_prescriptionMouseEntered

    private void prescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescriptionActionPerformed
        presdropdown.setVisible(true);
        profile.setVisible(false);
        prescription.setForeground(Color.orange);        // TODO add your handling code here:
    }//GEN-LAST:event_prescriptionActionPerformed

    private void patientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientMouseEntered
        patient.setForeground(Color.orange);
        presdropdown.setVisible(false);
        profile.setVisible(true);
        prescription.setForeground(Color.white);// TODO add your handling code here:
    }//GEN-LAST:event_patientMouseEntered

    private void patientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientMouseExited
        patient.setForeground(Color.white);      // TODO add your handling code here:
    }//GEN-LAST:event_patientMouseExited

    private void patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientActionPerformed

    private void presoption1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presoption1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_presoption1MouseEntered

    private void presoption1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presoption1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_presoption1MouseExited

    private void presoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presoption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presoption1ActionPerformed

    private void presoption2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presoption2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_presoption2MouseEntered

    private void presoption2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presoption2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_presoption2MouseExited

    private void presoption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presoption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presoption2ActionPerformed

    private void presdropdownMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presdropdownMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_presdropdownMouseMoved

    private void presdropdownFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_presdropdownFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_presdropdownFocusGained

    private void presdropdownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presdropdownMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_presdropdownMouseEntered

    private void presdropdownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presdropdownMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_presdropdownMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3FocusGained

    private void jLabel3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3FocusLost

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setForeground(Color.orange);       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void pattableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pattableMouseClicked
        int id = Integer.parseInt(pattable.getValueAt(pattable.getSelectedRow(), 0).toString());
        int presid=0,patientid = 0;
try{
    PreparedStatement d=con.prepareStatement("insert into prescription (`patid`,`d_id`) values(?,2)");
    PreparedStatement p=con.prepareStatement("select * from prescription order by pid desc limit 1");
    d.setString(1, String.valueOf(id));
    int suc=d.executeUpdate();
    if(suc>0)
    { 
    
    ResultSet r=p.executeQuery();
    while(r.next())
    {
        presid=r.getInt("pid");
        patientid=r.getInt("patid");
    }
    prescription pr=new prescription();
    pr.load(presid,patientid);
    pr.setVisible(true);
    this.setVisible(false);
    }
}catch(SQLException e){
    JOptionPane.showMessageDialog(null,e); 
}
    }//GEN-LAST:event_pattableMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
try{
        PreparedStatement s=con.prepareStatement("select * from patient where name like '"+name.getText()+"' or patid='"+pid.getText()+"'"); 
        ResultSet r=s.executeQuery();
        while(r.next())
        {
                String na = String.valueOf(r.getString("name"));
                String ph = r.getString("phone");
                String id = r.getString("patid");
                String age= r.getString("age");
                String address = r.getString("address");
                String tbData[] = {id, na, age,ph,address};
                DefaultTableModel tblModel = (DefaultTableModel) pattable.getModel();//jTable2 is the  dragged tablename
                tblModel.addRow(tbData);
        }
}catch(SQLException e){
}
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(pcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pcreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pcreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JButton patient;
    private javax.swing.JTable pattable;
    private javax.swing.JTextField pid;
    private javax.swing.JButton prescription;
    private javax.swing.JPanel presdropdown;
    private javax.swing.JButton presoption1;
    private javax.swing.JButton presoption2;
    private javax.swing.JButton profile;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
