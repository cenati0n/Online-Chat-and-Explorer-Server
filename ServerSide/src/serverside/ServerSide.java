/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverside;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author define
 */
public class ServerSide {

    /**
     * @param args the command line arguments
     */
    
    public static ServerWin swin;
    public static Vector<ClientDetail> loggedClient;
    public static void main(String[] args) {
        try
        {
           ServerSocket server=new ServerSocket(2244);
           //open Server Window
           loggedClient=new Vector<ClientDetail>();
           swin=new ServerWin();
           Toolkit tool=Toolkit.getDefaultToolkit();
           Dimension size=tool.getScreenSize();
           final int WIDTH=570;
           final int HEIGHT=500;
           swin.setVisible(true);
           swin.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
           swin.setTitle("Server Window");
           swin.setResizable(false);
           while(true)
           {
               Socket client=server.accept();
               //invoke Thread for client
               new ClientHandler(client);
           }
        }
       catch(Exception ex)
       {
           
       }
    }
    
}
