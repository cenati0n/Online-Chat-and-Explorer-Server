/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swingapp;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author define
 */
public class SwingWin extends JFrame
{
/*    Button btn;
    JButton jbtn;
    
    public  SwingWin()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        btn=new Button("Hello");
        jbtn=new JButton("Hello");
        
        this.add(btn);
        this.add(jbtn);
    }*/
    JLabel lblname,lblloginid,lblpassword,lblconfirmpass,lblcontactno,lblemail;
     JTextField txtname,txtloginid,txtpassword,txtconfirmpass,txtcontactno,txtemail;
     JButton REGISTER;
     public SwingWin()
     {
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setBounds(400,100,500,400);
        this.setLayout(null);         
          lblname = new JLabel("Enter your name : ");
          this.add(lblname);
          lblname.setBounds(100,45,200,15);
          txtname = new JTextField(20);
          this.add(txtname);
          txtname.setBounds(300,45,100,20);
          lblloginid = new JLabel("Enter a new id : ");
          this.add(lblloginid );
          lblloginid.setBounds(100,65,200,15);
          txtloginid = new JTextField(20);
          this.add(txtloginid);
          txtloginid.setBounds(300,65,100,20);
          lblpassword = new JLabel("Enter your password : ");
          this.add(lblpassword);
          lblpassword.setBounds(100,85,200,15);
          txtpassword = new JTextField(20);
          this.add(txtpassword);
          txtpassword.setBounds(300,85,100,20);
          lblconfirmpass = new JLabel("Confirm password : ");
          this.add(lblconfirmpass);
          lblconfirmpass.setBounds(100,105,200,15);
          txtconfirmpass = new JTextField(20);
          this.add(txtconfirmpass);
          txtconfirmpass.setBounds(300,105,100,20);
          lblcontactno = new JLabel("Enter your phone number :");
          this.add(lblcontactno);
          lblcontactno.setBounds(100,125,200,15);
          txtcontactno = new JTextField(20);
          this.add(txtcontactno);
          txtcontactno.setBounds(300,125,100,20);
          lblemail = new JLabel("Enter your Email :");
          this.add(lblemail);
          lblemail.setBounds(100,145,200,15);
          txtemail = new JTextField(20);
          this.add(txtemail);
          txtemail.setBounds(300,145,100,20);
          REGISTER = new JButton("Register");
          this.add(REGISTER);
          REGISTER.setBounds(200,170,100,20);
}
}