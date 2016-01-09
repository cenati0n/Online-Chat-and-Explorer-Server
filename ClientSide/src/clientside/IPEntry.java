/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientside;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author nirankar
 */
public class IPEntry extends JFrame implements ActionListener
{
  JButton CONNECT;
  JLabel lblIp;
  JTextField txtIP;
  public IPEntry()
    {
          this.setLayout(null);
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          CONNECT =new JButton("CONNECT");
          this.lblIp=new JLabel("Enter IP Address Of Server");
          this.txtIP=new JTextField(30);
          this.add(this.CONNECT);
          this.add(this.lblIp);
          this.add(this.txtIP);
          this.CONNECT.setBounds(200,50,100,20);
          this.lblIp.setBounds(10,10,180,20);
          this.txtIP.setBounds(200,10,150,20);
          this.CONNECT.addActionListener(this);
     }
  public void actionPerformed(ActionEvent ae)
  {
      //if(ae.getSource()==this.CONNECT)
      if(this.txtIP.getText().trim().equals(""))
      {
          JOptionPane.showMessageDialog(this, "IP Address Not Provided!!!","IP Entry",JOptionPane.ERROR_MESSAGE);
          return;
      }
      try
      {
          InetAddress inet=InetAddress.getByName(this.txtIP.getText().trim());
          ClientSide.client=new Socket(inet,2244);
          JOptionPane.showMessageDialog(this, "Successfully Connected To Server!!!","IP Entry",JOptionPane.INFORMATION_MESSAGE);
           
           LoginWin login=new LoginWin();
           Toolkit tool=Toolkit.getDefaultToolkit();
           Dimension size=tool.getScreenSize();
           final int WIDTH=350;
           final int HEIGHT=150;
           login.setVisible(true);
           login.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
           login.setTitle("Login Entry");
           login.setResizable(false);
           this.dispose();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(this, "Cannot Connect To Server!!!","IP Entry",JOptionPane.ERROR_MESSAGE);
      }
  }
}
