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
/**
 *
 * @author define
 */
public class ClientWin extends JFrame {
    JTabbedPane jtb;
    ChatTab chat;
    ExplorerTab explorer;
    
    public ClientWin()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                if(JOptionPane.showConfirmDialog(ClientWin.this, "Do You Want To Logout???","Logout",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                {
                    try
                    {
                     ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                     out.writeObject("Logout");
                     System.exit(1);
                    }
                    catch(Exception ex)
                    {
                        
                    }
                }
            }
        });
        jtb=new JTabbedPane();
        
        chat=new ChatTab();
        explorer=new ExplorerTab();
        
        jtb.addTab( "Chat Services",chat);
        jtb.addTab("Online Explorer", explorer);
        
        this.add(jtb);
        jtb.setBounds(1,1,500,500);
    }
}
