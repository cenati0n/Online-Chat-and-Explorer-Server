/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serverside;

/**
 *
 * @author hp
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class RegistrationForm extends JPanel implements ActionListener
{
    JLabel lblRegForm;
    JLabel lblName;
    JTextField txtName;
    JLabel lblLoginID;
    JTextField txtLoginID;
    JLabel lblPassword;
    JTextField txtPassword;
    JLabel lblConPassword;
    JTextField txtConPassword;
    JLabel lblEmailId;
    JTextField txtEmailId;
    JLabel lblContact;
    JTextField txtContact;
    JButton btnSubmit;
    public RegistrationForm()
    {
        
        this.setLayout(null);
        lblRegForm=new JLabel("Registration Form");
        lblName=new JLabel("Name");
        txtName=new JTextField(15);
        lblLoginID=new JLabel("LoginID");
        txtLoginID=new JTextField(15);
        lblPassword=new JLabel("Password");
        txtPassword=new JTextField(15);
        //txtPassword.setEchoChar('*');
        lblConPassword=new JLabel("Confirm Password");
        txtConPassword=new JTextField(15);
        lblEmailId=new JLabel("EmailID");
        txtEmailId=new JTextField(15);
        lblContact=new JLabel("Contact");
        txtContact=new JTextField(15);
        btnSubmit=new JButton("Submit");
        this.design();
        this.btnSubmit.addActionListener(this);
    }
    private void design()
    {
        setPos(lblRegForm,190,20,120,20);
        setPos(lblName,80,60,100,20);
        setPos(txtName,200,60,200,20);
        setPos(lblLoginID,80,100,100,20);
        setPos(txtLoginID,200,100,200,20);
        setPos(lblPassword,80,140,100,20);
        setPos(txtPassword,200,140,200,20);
        setPos(lblConPassword,80,180,120,20);
        setPos(txtConPassword,200,180,200,20);
        setPos(lblContact,80,220,100,20);
        setPos(txtContact,200,220,200,20);
        setPos(btnSubmit, 310, 260,90, 30);


    }
    private void setPos(Component c,int x,int y,int w,int h )
    {
        this.add(c);
        c.setBounds(x, y, w, h);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //validate data Entry
        String query="insert into usermaster set " +
                     "LoginId='" + this.txtLoginID.getText() + "'," +
                     "LoginId='" + this.txtLoginID.getText() + "'," +
                     "LoginId='" + this.txtLoginID.getText() + "'," +
                     "LoginId='" + this.txtLoginID.getText() + "'," +
                     "LoginId='" + this.txtLoginID.getText() + "'";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/netdb","root","");
            Statement stmt=con.createStatement();
            int n=stmt.executeUpdate(query);
            if(n>0)
                JOptionPane.showMessageDialog(this, "User Registered Successfully...");
            else
                JOptionPane.showMessageDialog(this, "Cannot Register User!!!");
            
        }
        
        catch(Exception ex)
        {
            
        }
                
    }
}
