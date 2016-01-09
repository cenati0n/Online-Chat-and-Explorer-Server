/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author nirankar
 */
public class entry extends JFrame
{
  JButton connect;
  JLabel EIP;
  JTextField Ipadd;
  public entry()
    {
          this.setLayout(null);
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          connect =new JButton("connect");
          EIP=new JLabel("enter ip address");
          Ipadd=new JTextField(30);
          this.add(connect);
          this.add(Ipadd);
          this.add(EIP);
          connect.setBounds(80,70,80,30);
          EIP.setBounds(10,10,100,30);
          Ipadd.setBounds(110,10,100,30);
     }
}
