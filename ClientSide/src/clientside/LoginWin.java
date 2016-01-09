/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientside;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class LoginWin extends JFrame implements ActionListener 
{
    JLabel lblUsername,lblPassword;
    JTextField  txtUsername;
    JPasswordField txtPassword;
    JButton GO;
    public LoginWin()
     {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lblUsername =new JLabel("Enter Login Id");
        lblPassword=new JLabel("Enter Password");
        txtUsername=new JTextField(15);
        txtPassword=new JPasswordField(15);
        GO=new JButton("LOGIN");
        this.design();
        this.GO.addActionListener(this);
     }
    private void design()
    {
        
        setPosition(lblUsername,20,10,140,20);
        setPosition(lblPassword,20,50,140,20);
        setPosition(txtUsername,150,12,130,20);
        setPosition(txtPassword,150,50,130,20);
        setPosition(GO,150,90,100,20);
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
               JOptionPane.showMessageDialog(this,"Login Id not provided!!!","Login",JOptionPane.ERROR_MESSAGE);
               return;     
             }
           else if(new String(this.txtPassword.getPassword()).trim().equals(""))
           {
              JOptionPane.showMessageDialog(this,"Password not provided!!!","Login",JOptionPane.ERROR_MESSAGE);
               return; 
           }
        try
        {
           ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
           out.writeObject("LoginDetails");
           out.writeObject(this.txtUsername.getText().trim());
           out.writeObject(new String(this.txtPassword.getPassword()).trim());
           
           ObjectInputStream in=new ObjectInputStream(ClientSide.client.getInputStream());
           String resp=in.readObject().toString();
           if(resp.equals("Success"))
           {
               JOptionPane.showMessageDialog(this, "Successfully Logged In","Login",JOptionPane.INFORMATION_MESSAGE);
               
                ClientWin win=new ClientWin();
                Toolkit tool=Toolkit.getDefaultToolkit();
                Dimension size=tool.getScreenSize();
                final int WIDTH=530;
                final int HEIGHT=530;
                win.setVisible(true);
                win.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
                win.setTitle("Welcome " + this.txtUsername.getText());
                win.setResizable(false);
                new ClientThread(win);
                this.dispose();
           }
           else
           {
               JOptionPane.showMessageDialog(this, "LoginId/Password Invalid!!!","Login",JOptionPane.ERROR_MESSAGE);
           }
           
        }
        catch(Exception ex)
        {
            
            
        }
    }
}