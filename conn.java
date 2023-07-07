/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package clinic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author donis
 */

public class conn {
    public static Connection mycon()
{Connection con=null;
            try
        {
        
        String url="jdbc:mysql://localhost:3306/clinic?"+"user=root&password=P@ssword1";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(url);
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Connection Failed"+e);
        }
            return con;
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        conn c=new conn();
        c.mycon();
    }
}
