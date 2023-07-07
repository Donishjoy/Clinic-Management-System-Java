/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinic;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author donis
 */
public class presdetails extends javax.swing.JFrame {

    /**
     * Creates new form presdetails
     */
    public presdetails() {
        initComponents();
        presdropdown.setVisible(false);
    }
 Connection con=conn.mycon();
    DefaultTableModel tblModel;
    int presid;
    void load(int presid,int patientid)
    {
        presdropdown.setVisible(false);
        this.presid=presid;
        try{
            PreparedStatement q=con.prepareStatement("select * from patient where patid='"+patientid+"'");
            PreparedStatement p=con.prepareStatement("select * from prescription where pid='"+presid+"'");
            ResultSet s=q.executeQuery();
            ResultSet r=p.executeQuery();
            table();
            while(s.next())
            {
               pid.setText("PID:-"+s.getString("patid")); 
               pname.setText("Name:-"+s.getString("name"));
            }
            while(r.next())
            {
                disease.setText(r.getString("disease"));
                symptoms.setText(r.getString("symptoms"));
                findings.setText(r.getString("findings"));
                remarks.setText(r.getString("remarks"));
            }
        }catch(SQLException e)
        {
            
        }
       
        date.setText("Date:-"+LocalDate.now());
       presdropdown.setVisible(false);
    }
void add()
{
      
    String drug=mname.getText();
    String dose=mdose.getText();
    String stre=mstrength.getText();
    String duration=mduration.getText();
    String advice=madvice.getText();
    System.out.print(drug+" "+dose+" "+stre+" "+duration+" "+advice+" "+presid);
    
    PreparedStatement p;
    try{
        p=con.prepareStatement("insert into medicine (`medicines`,`advice`,`dose`,`strength`,`duration`,`pid`) values(?,?,?,?,?,?)");
        p.setString(1,drug);
        p.setString(2,advice);
        p.setString(3,dose);
        p.setString(4,stre);
        p.setString(5,duration);
        p.setInt(6,presid);
        int c=p.executeUpdate();
       
        System.out.println(c);
        if(c>0)
        {
            mname.setText(null);
             mdose.setText(null);
              mstrength.setText(null);
               mduration.setText(null);
                madvice.setText(null);
             
                   //     for (int row = 0; row < drugtable.getRowCount(); row++) {
           // tblModel.removeRow(row);
           
       // }
       DefaultTableModel tblModel;
            tblModel = (DefaultTableModel)drugtable.getModel();
        tblModel.setRowCount(0);
       table();
      drugtable.revalidate();
      tblModel.fireTableDataChanged();
       
          
        }else
            JOptionPane.showMessageDialog(null, "Failed"); 
    }catch(SQLException e){
     JOptionPane.showMessageDialog(null,e); 
    }
}
    void table()
    {
        try{
            
        PreparedStatement s=con.prepareStatement("select * from medicine where pid='"+presid+"'");
        ResultSet rs=s.executeQuery();
        while(rs.next())
                {
                    String medid=String.valueOf(rs.getString("medid"));
                    String dname=rs.getString("medicines");
                    String ddose=rs.getString("dose");
                    String dstrength=rs.getString("strength");
                    String dduration=rs.getString("duration");
                    String dadvice=rs.getString("advice");
                
                   String tbData[]={medid,dname,ddose,dstrength,dduration,dadvice};
            
      tblModel=(DefaultTableModel)drugtable.getModel();
            tblModel.addRow(tbData);
                }
    }catch(SQLException e)
    {
        
    }
    }
    void pres()
    {
        try
        {
        PreparedStatement r=con.prepareStatement("update prescription set findings='"+disease.getText()+"',symptoms='"+symptoms.getText()+"',remarks='"+remarks.getText()+"',disease='"+disease.getText()+"'");
        int suc=r.executeUpdate();
        if(suc>0)
        {
          JOptionPane.showMessageDialog(null, "Updated successfully");
        }else
            JOptionPane.showMessageDialog(null, "Failed"); 
    }catch(SQLException e)
    {
      JOptionPane.showMessageDialog(null, "Failed");  
    }
    }
    void del()
    {
           int medid=Integer.parseInt(drugtable.getValueAt(drugtable.getSelectedRow(),0).toString());   
           try
           {
               PreparedStatement d=con.prepareStatement("delete from medicine where medid='"+medid+"'");
               int del=d.executeUpdate();
               if(del>0)
               {
                   if(drugtable.getSelectedRowCount()==1)
                   {
                 tblModel.removeRow(drugtable.getSelectedRow());
                   }else 
                     JOptionPane.showMessageDialog(null, "Table is empty");    
                   
               }
           }catch(SQLException e)
           {
               
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
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pid = new javax.swing.JLabel();
        pname = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        disease = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        symptoms = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        findings = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        mdose = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        mduration = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mstrength = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        madvice = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        drugtable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        remarks = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1599, 115, -1, -1));

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

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\logo-no-background (1).png")); // NOI18N
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 230, 220));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 290, 950));

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 0, 1350, 172));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pid.setText("PID:-");
        jPanel5.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 29, 119, -1));

        pname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pname.setText("Name:-");
        jPanel5.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 72, 119, -1));

        age.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        age.setText("Age:-");
        jPanel5.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 119, -1));

        disease.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        disease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseaseActionPerformed(evt);
            }
        });
        jPanel5.add(disease, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 185, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Disease");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 119, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Symptoms");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 244, 170, -1));

        symptoms.setColumns(20);
        symptoms.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        symptoms.setRows(5);
        jScrollPane1.setViewportView(symptoms);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 275, 240, 99));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Initial Findings");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 392, 150, -1));

        findings.setColumns(20);
        findings.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        findings.setRows(5);
        jScrollPane2.setViewportView(findings);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 423, 250, 114));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Drug");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        mdose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdoseActionPerformed(evt);
            }
        });
        jPanel6.add(mdose, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 90, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Dose");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
        jPanel6.add(mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 90, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Advice");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));
        jPanel6.add(mduration, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 90, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Duration");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));
        jPanel6.add(mstrength, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 90, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Strength");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        delete.setBackground(new java.awt.Color(204, 0, 51));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete.setText("DELETE");
        delete.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel6.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 90, 30));

        add.setBackground(new java.awt.Color(51, 255, 51));
        add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        add.setText("ADD");
        add.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel6.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 90, 30));

        madvice.setColumns(20);
        madvice.setRows(5);
        jScrollPane3.setViewportView(madvice);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, 60));

        drugtable.setBackground(new java.awt.Color(204, 204, 204));
        drugtable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        drugtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.NO", "DRUG", "DOSE", "STRENGTH", "DURATION", "ADVICE"
            }
        ));
        drugtable.setRowHeight(40);
        drugtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drugtableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(drugtable);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 780, 170));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 800, 360));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Medicine");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 130, -1));

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 490, 140, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Remarks");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        remarks.setColumns(20);
        remarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        remarks.setRows(5);
        jScrollPane5.setViewportView(remarks);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 550, 90));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setText("Date:-");
        jPanel5.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 1190, 580));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("PRESCRIPTION DETAILS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE))
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
        this.dispose();
        pcreate h=new pcreate();
        h.setVisible(true);// TODO add your handling code here:
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

    private void diseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diseaseActionPerformed

    private void mdoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdoseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mdoseActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        del();        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        add();  // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void drugtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drugtableMouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_drugtableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pres();
        this.dispose();
        home h=new home();
        h.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(presdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(presdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(presdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(presdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new presdetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel age;
    private javax.swing.JLabel date;
    private javax.swing.JButton delete;
    private javax.swing.JTextField disease;
    private javax.swing.JTable drugtable;
    private javax.swing.JTextArea findings;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea madvice;
    private javax.swing.JTextField mdose;
    private javax.swing.JTextField mduration;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField mstrength;
    private javax.swing.JButton patient;
    private javax.swing.JLabel pid;
    private javax.swing.JLabel pname;
    private javax.swing.JButton prescription;
    private javax.swing.JPanel presdropdown;
    private javax.swing.JButton presoption1;
    private javax.swing.JButton presoption2;
    private javax.swing.JButton profile;
    private javax.swing.JTextArea remarks;
    private javax.swing.JTextArea symptoms;
    // End of variables declaration//GEN-END:variables
}
