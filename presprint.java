/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
/**
 *
 * @author donis
 */
public class presprint extends javax.swing.JFrame {

    /**
     * Creates new form presprint
     */
    public presprint() {
        initComponents();
           docdropdown2.setVisible(false);
           patdropdown.setVisible(false);
        
    }
    Connection con=conn.mycon();
    DefaultTableModel tblModel;
    int presid;
    int patientid;
    void load(int presid,int patientid)
    {

        this.presid=presid;
        try{
            PreparedStatement q=con.prepareStatement("select * from patient where patid='"+patientid+"'");
            PreparedStatement p=con.prepareStatement("select * from prescription where pid='"+presid+"'");
            ResultSet s=q.executeQuery();
            ResultSet r=p.executeQuery();
            table(presid);
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
   
    }

    void table(int presid)
    {
        this.presid=presid;
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

void printPrescription() {
    try (PDDocument document = new PDDocument()) {
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            float y = PDRectangle.A4.getHeight() - 50;
            float columnWidth = PDRectangle.A4.getWidth() / 4; // Divide the page width into four columns

            // Add hospital details
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            float textWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("HEALTH FIRST") / 1000 * 16;
            float textX = PDRectangle.A4.getWidth() - 50 - textWidth; // Align to the right side
            contentStream.newLineAtOffset(textX, y);
            contentStream.newLineAtOffset(0, -12);
            contentStream.newLineAtOffset(0, -12);
            contentStream.newLineAtOffset(0, -12);
            contentStream.newLineAtOffset(0, -12);
            contentStream.newLineAtOffset(0, -12);
            contentStream.newLineAtOffset(0, -12);
            contentStream.showText("HEALTH FIRST");
            contentStream.setFont(PDType1Font.HELVETICA, 14);
            contentStream.newLine();
            y -= 12;
          contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Address");
            contentStream.newLine();
            y -= 12;
                                contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Abc, NewYork, 1434");
            contentStream.newLine();
            y -= 12;
                                contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Phone: 183-040-2266");
            contentStream.newLine();
            y -= 12;
                                contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Website: www.hfirst.com");
            contentStream.endText();

            // Add hospital icon
            PDImageXObject hospitalIcon = PDImageXObject.createFromFile("C:/Users/donis/OneDrive/Documents/NetBeansProjects/Clinic/src/clinic/icons/logo-no-background (2).png", document);
            float iconX = PDRectangle.A4.getWidth() - 100;
            float iconY = PDRectangle.A4.getHeight() - 100;
            float iconWidth = 80;
            float iconHeight = 80;
            contentStream.drawImage(hospitalIcon, iconX, iconY, iconWidth, iconHeight); // Divide the page width into four columns

            try {
                PreparedStatement statement = con.prepareStatement("SELECT *,name,date(date)'d1' FROM prescription join patient using (patid) WHERE pid = '"+presid+"'");
                ResultSet resultSet = statement.executeQuery();

                // Retrieve patient information
                if (resultSet.next()) {
                    String patientId = resultSet.getString("patid");
                    String disease = resultSet.getString("disease");
                    String symptoms = resultSet.getString("symptoms");
                    String findings = resultSet.getString("findings");
                    String remarks = resultSet.getString("remarks");

                    // Add prescription text
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA, 12); // Set font
                    contentStream.newLineAtOffset(50, y);
                    for(int i=0;i<8;i++)
                    {
                         contentStream.newLineAtOffset(0, -12);
                    }
                    contentStream.showText("Patient ID :  " + patientId);
                    contentStream.newLine();
                    y -= 12;
                    contentStream.newLineAtOffset(0, -12);
                    contentStream.showText("Patient Name :  "+resultSet.getString("name")); // Provide patient name here
                    contentStream.newLine();
                    y -= 12;
                    contentStream.newLineAtOffset(0, -12);
                    contentStream.showText("Prescription ID :  " + resultSet.getString("pid"));
                    contentStream.newLine();
                    y -= 12;
                    contentStream.newLineAtOffset(0, -12);
                    contentStream.showText("Date :  "+resultSet.getString("d1")); // Provide date here
                    contentStream.newLine();
                    y -= 12;
                    contentStream.newLineAtOffset(0, -12);
                    contentStream.showText("Disease:  " + disease);
                    contentStream.newLine();
                    y -= 12;
                    contentStream.newLineAtOffset(0, -12);


                    // Retrieve medicine details
                    PreparedStatement medicineStatement = con.prepareStatement("SELECT * FROM medicine WHERE pid = 45");
                    ResultSet medicineResultSet = medicineStatement.executeQuery();
contentStream.newLine();
contentStream.newLine();
                    // Add medicine details
                    contentStream.newLine();
                    contentStream.newLineAtOffset(0, -12);contentStream.newLineAtOffset(0, -12);
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                    contentStream.showText("MEDICINE DETAILS");
                    contentStream.newLine();
                    y -= 12;
                    contentStream.newLineAtOffset(0, -12);
contentStream.newLine();
contentStream.newLine();
                    // Print column headers
                      contentStream.newLineAtOffset(0, -12);  contentStream.newLineAtOffset(0, -12);
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                    contentStream.showText("Medicine Name");
                    contentStream.newLineAtOffset(columnWidth, 0);
                    contentStream.showText("Dose");
                    contentStream.newLineAtOffset(columnWidth, 0);
                    contentStream.showText("Strength");
                    contentStream.newLineAtOffset(columnWidth, 0);
                    contentStream.showText("Duration");
                    contentStream.newLineAtOffset(columnWidth, 0);
                    contentStream.showText("Advice");
                    contentStream.newLineAtOffset(-4 * columnWidth, -12);

                    while (medicineResultSet.next()) {
                        String medicineName = medicineResultSet.getString("medicines");
                        String dose = medicineResultSet.getString("dose");
                        String strength = medicineResultSet.getString("strength");
                        String duration = medicineResultSet.getString("duration");
                        String advice = medicineResultSet.getString("advice");

                        // Print medicine details in columns
                         contentStream.setFont(PDType1Font.HELVETICA, 12);
                         contentStream.newLineAtOffset(0, -12);
                        contentStream.showText(medicineName);
                        contentStream.newLineAtOffset(columnWidth, 0);
                        contentStream.showText(dose);
                        contentStream.newLineAtOffset(columnWidth, 0);
                        contentStream.showText(strength);
                        contentStream.newLineAtOffset(columnWidth, 0);
                        contentStream.showText(duration);
                        contentStream.newLineAtOffset(columnWidth, 0);
                        contentStream.showText(advice);
                        contentStream.newLineAtOffset(-4 * columnWidth, -12);
                    }

                    contentStream.endText(); // End the text block
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Save the PDF file
        document.save("prescription7.pdf");
 JOptionPane.showMessageDialog(null, "PDF created");
    } catch (IOException e) {
        e.printStackTrace();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        drugtable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        remarks = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        profile1 = new javax.swing.JButton();
        home1 = new javax.swing.JButton();
        prescription1 = new javax.swing.JButton();
        report = new javax.swing.JButton();
        patient1 = new javax.swing.JButton();
        doctor = new javax.swing.JButton();
        patdropdown = new javax.swing.JPanel();
        patoption1 = new javax.swing.JButton();
        patient2 = new javax.swing.JButton();
        docdropdown2 = new javax.swing.JPanel();
        docoption1 = new javax.swing.JButton();
        docoption2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 423, 240, 114));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 780, 310));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 800, 360));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Medicine");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 130, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Remarks");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        remarks.setColumns(20);
        remarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        remarks.setRows(5);
        jScrollPane5.setViewportView(remarks);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 550, 90));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setText("Date:-");
        jPanel5.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinic/icons/icons8-print-30.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 480, 120, 60));

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
        jLabel3.setText("ADMIN DASHBOARD");
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

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile1.setBackground(new java.awt.Color(102, 102, 102));
        profile1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profile1.setForeground(new java.awt.Color(255, 255, 255));
        profile1.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\profile (1).png")); // NOI18N
        profile1.setText("PROFILE");
        profile1.setIconTextGap(40);
        profile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile1ActionPerformed(evt);
            }
        });
        jPanel7.add(profile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 230, 50));

        home1.setBackground(new java.awt.Color(102, 102, 102));
        home1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        home1.setForeground(new java.awt.Color(255, 255, 255));
        home1.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\homeRed.png")); // NOI18N
        home1.setText("HOME");
        home1.setIconTextGap(40);
        home1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home1MouseEntered(evt);
            }
        });
        home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home1ActionPerformed(evt);
            }
        });
        jPanel7.add(home1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 230, 50));

        prescription1.setBackground(new java.awt.Color(102, 102, 102));
        prescription1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prescription1.setForeground(new java.awt.Color(255, 255, 255));
        prescription1.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\drug.png")); // NOI18N
        prescription1.setText("PRESCRIPTION");
        prescription1.setIconTextGap(40);
        prescription1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescription1ActionPerformed(evt);
            }
        });
        jPanel7.add(prescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 230, 50));

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
        jPanel7.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, 230, 50));

        patient1.setBackground(new java.awt.Color(102, 102, 102));
        patient1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        patient1.setForeground(new java.awt.Color(255, 255, 255));
        patient1.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\patient.png")); // NOI18N
        patient1.setText("PATIENT");
        patient1.setIconTextGap(40);
        patient1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patient1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patient1MouseExited(evt);
            }
        });
        patient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient1ActionPerformed(evt);
            }
        });
        jPanel7.add(patient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 230, 50));

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
        jPanel7.add(doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 230, 50));

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

        jPanel7.add(patdropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 280, -1));

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

        jPanel7.add(docdropdown2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 280, 195));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\donis\\Downloads\\logo-no-background (1).png")); // NOI18N
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 210, 220));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        printPrescription();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void drugtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drugtableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_drugtableMouseClicked

    private void diseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diseaseActionPerformed

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

    private void profile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile1ActionPerformed
        this.dispose();
        adminprofile s=new adminprofile();
        s.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_profile1ActionPerformed

    private void home1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home1MouseEntered
        report.setForeground(Color.white);
        doctor.setVisible(true);
        prescription1.setVisible(true);
        profile1.setVisible(true);
        patdropdown.setVisible(false);
        docdropdown2.setVisible(false);
        doctor.setForeground(Color.white);
        patient1.setForeground(Color.white);// TODO add your handling code here:
    }//GEN-LAST:event_home1MouseEntered

    private void home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home1ActionPerformed
        admin h = new admin();
        h.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_home1ActionPerformed

    private void prescription1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescription1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prescription1ActionPerformed

    private void reportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseEntered
        report.setForeground(Color.orange);
        doctor.setVisible(true);
        prescription1.setVisible(true);
        profile1.setVisible(true);
        patdropdown.setVisible(false);
        docdropdown2.setVisible(false);
        patient1.setForeground(Color.white);// TODO add your handling code here:
    }//GEN-LAST:event_reportMouseEntered

    private void reportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseExited
        report.setForeground(Color.white);
        // TODO add your handling code here:
    }//GEN-LAST:event_reportMouseExited

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        datewise d=new datewise();
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reportActionPerformed

    private void patient1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient1MouseEntered
        patient1.setForeground(Color.orange);
        doctor.setVisible(false);
        prescription1.setVisible(false);
        profile1.setVisible(false);
        patdropdown.setVisible(true);
        docdropdown2.setVisible(false);
        doctor.setForeground(Color.white); // TODO add your handling code here:
    }//GEN-LAST:event_patient1MouseEntered

    private void patient1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_patient1MouseExited

    private void patient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient1ActionPerformed
        doctor.setVisible(false);
        prescription1.setVisible(false);
        profile1.setVisible(false);
        patdropdown.setVisible(true);
        docdropdown2.setVisible(false);
        patient1.setForeground(Color.orange);// TODO add your handling code here:
    }//GEN-LAST:event_patient1ActionPerformed

    private void doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorMouseEntered
        doctor.setVisible(true);
        prescription1.setVisible(false);
        profile1.setVisible(false);
        docdropdown2.setVisible(true);
        patdropdown.setVisible(false);
        doctor.setForeground(Color.orange);
        patient1.setForeground(Color.white);// TODO add your handling code here:
    }//GEN-LAST:event_doctorMouseEntered

    private void doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorMouseExited
        doctor.setForeground(Color.white); // TODO add your handling code here:
    }//GEN-LAST:event_doctorMouseExited

    private void doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActionPerformed
        doctor.setVisible(true);
        prescription1.setVisible(false);
        profile1.setVisible(false);
        docdropdown2.setVisible(true);
        patdropdown.setVisible(false);
        doctor.setForeground(Color.orange);
        patient1.setForeground(Color.white);   // TODO add your handling code here:
    }//GEN-LAST:event_doctorActionPerformed

    private void patoption1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patoption1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_patoption1MouseEntered

    private void patoption1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patoption1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_patoption1MouseExited

    private void patoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patoption1ActionPerformed
        this.dispose();
        patient_reg a=new patient_reg();
        a.setVisible(true);
    }//GEN-LAST:event_patoption1ActionPerformed

    private void patient2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_patient2MouseEntered

    private void patient2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_patient2MouseExited

    private void patient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient2ActionPerformed
        patsearch p=new patsearch();
        p.setVisible(true);
        this.dispose();// TODO add your handling code here:
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
        Registration r=new Registration();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_docoption1ActionPerformed

    private void docoption2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docoption2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption2MouseEntered

    private void docoption2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docoption2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_docoption2MouseExited

    private void docoption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docoption2ActionPerformed
        doctordetails d=new doctordetails();
        d.setVisible(true);
        this.dispose();// TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(presprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(presprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(presprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(presprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new presprint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JLabel date;
    private javax.swing.JTextField disease;
    private javax.swing.JPanel docdropdown2;
    private javax.swing.JButton docoption1;
    private javax.swing.JButton docoption2;
    private javax.swing.JButton doctor;
    private javax.swing.JTable drugtable;
    private javax.swing.JTextArea findings;
    private javax.swing.JButton home1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel patdropdown;
    private javax.swing.JButton patient1;
    private javax.swing.JButton patient2;
    private javax.swing.JButton patoption1;
    private javax.swing.JLabel pid;
    private javax.swing.JLabel pname;
    private javax.swing.JButton prescription1;
    private javax.swing.JButton profile1;
    private javax.swing.JTextArea remarks;
    private javax.swing.JButton report;
    private javax.swing.JTextArea symptoms;
    // End of variables declaration//GEN-END:variables
}
