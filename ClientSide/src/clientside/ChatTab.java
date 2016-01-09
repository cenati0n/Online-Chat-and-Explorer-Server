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


public class ChatTab extends JPanel implements ActionListener
   {
    JButton SEND;
    Choice loggedInUsers;
    JTextArea txtChat,txtResp;
    JScrollPane jspResp,jspChat;
    JLabel lblHistory;
    public ChatTab()
    {
        this.setLayout(null);
    
        SEND=new JButton("SEND");
        loggedInUsers=new Choice();
        JLabel lblHistory=new JLabel("MESSAGE HISTORY");
        txtChat=new JTextArea();
        txtResp=new JTextArea();
        jspResp=new JScrollPane(txtResp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspChat=new JScrollPane(txtChat,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        jspResp.setBounds(10,35,470,250);
        jspChat.setBounds(10,300,470,100);
        loggedInUsers.setBounds(10,420,200,20);
        SEND.setBounds(230,420,150,20);
        lblHistory.setBounds(170,10,150,20);
        this.add(SEND);
        this.add(loggedInUsers);
        this.add(jspResp);
        this.add(jspChat);
        this.add(lblHistory);
        this.txtResp.setEditable(false);
        
        this.SEND.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if(this.loggedInUsers.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(this, "No User Selected!!!","Chat Services",JOptionPane.ERROR_MESSAGE);
                return;
            }
            ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
            out.writeObject("ChatMesg");
            out.writeObject(this.loggedInUsers.getSelectedItem());
            out.writeObject(this.txtChat.getText());
            String txt=this.txtResp.getText();
            txt=txt + "\n" + "ME -> " + this.loggedInUsers.getSelectedItem() + " : " + this.txtChat.getText();
            this.txtResp.setText(txt);
            this.txtChat.setText("");
        }
        catch(Exception ex)
        {
            
        }
    }
}
