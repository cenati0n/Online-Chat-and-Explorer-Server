/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author nirankar
 */
public class loginhistory extends JFrame
{
    JTable selectedUser;
    Choice loggedInUsers;
    JButton GO;
    JScrollPane jsp;
    Object Head[]={"Login","password","Machineno"};
    Object Data[][]={ };
   
    loginhistory()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loggedInUsers=new Choice();
        loggedInUsers.setBounds(100,20,150,105);
        this.add(loggedInUsers);
        GO=new JButton("GO");
        GO.setBounds(275,20,60,20);
        this.add(GO);
        selectedUser=new JTable(Data,Head);
        jsp=new JScrollPane(selectedUser,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(jsp);
        jsp.setBounds(20,70,450,270);
    }
}