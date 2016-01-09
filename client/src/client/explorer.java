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
public class explorer extends JFrame
{
    Choice loggedInUsers,selectDrive;
    JLabel lblIPAddress,lblDirectories,lblFiles;
    JButton GO,SEARCH,NEXT,PREVIOUS,DOWNLOAD;
    JTextField txtAddressbar;
    JScrollPane jspDirectory,jspFile;
    explorer()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loggedInUsers=new Choice();
        selectDrive=new Choice();
        txtAddressbar=new JTextField();
        jspFile=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspDirectory=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        lblIPAddress=new JLabel("ip address of machine");
        lblDirectories=new JLabel("directories");
        lblFiles=new JLabel ("files");
        GO=new JButton ("GO");
        SEARCH=new JButton ("SEARCH");
        NEXT=new JButton ("NEXT");
        PREVIOUS=new JButton ("PREV");
        DOWNLOAD=new JButton ("DOWNLOAD");
        this.design();
    }
    private void design()
    {
          setPosition(loggedInUsers,10,10,100,30);
          setPosition(PREVIOUS,30,220,90,20);
          setPosition(NEXT,380,220,80,20);
          setPosition(SEARCH,350,45,100,20);
          setPosition(GO,420,10,60,20);
          setPosition(lblFiles,220,230,30,60);
          setPosition(lblDirectories,200,70,200,40);
          setPosition(lblIPAddress,140,10,150,20);
          setPosition(jspFile,10,270,470,60);
          setPosition(jspDirectory,10,100,470,100);
          setPosition(txtAddressbar,10,40,300,30);
          setPosition(selectDrive,300,10,100,20);
          setPosition(DOWNLOAD,360,335,110,20);
    }
     private void setPosition(Component c,int x,int y,int w,int h)
    {
        this.add(c);
        c.setBounds(x,y,w,h);
    }
     
}
