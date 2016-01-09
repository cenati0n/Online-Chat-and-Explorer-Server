/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener 
{
    JLabel lblUsername,lblPassword;
    JTextField  txtUsername;
    JPasswordField txtPassword;
    JButton GO;
    public login()
     {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lblUsername =new JLabel("enter your username");
        lblPassword=new JLabel("enter your password");
        txtUsername=new JTextField(15);
        txtPassword=new JPasswordField(15);
        GO=new JButton("GO");
        this.design();
        this.GO.addActionListener(this);
     }
    private void design()
    {
        
        setPosition(lblUsername,20,10,140,20);
        setPosition(lblPassword,20,50,140,20);
        setPosition(txtUsername,150,12,130,20);
        setPosition(txtPassword,150,50,130,20);
        setPosition(GO,100,100,60,20);
    }
    private void setPosition(Component c,int x,int y,int w,int h)
    {
        this.add(c);
        c.setBounds(x,y,w,h);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(this.txtUsername.getText().trim().equals(""))
             {
               JOptionPane.showMessageDialog(this,"username  is not provided!!!","Login",JOptionPane.ERROR_MESSAGE);
               return;     
             }
           else if(this.txtPassword.getText().trim().equals(""))
           {
              JOptionPane.showMessageDialog(this,"password is not provided!!!","Login",JOptionPane.ERROR_MESSAGE);
               return; 
           }

    }
}