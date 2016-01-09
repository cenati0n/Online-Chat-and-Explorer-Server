/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientside;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author nirankar
 */
public class ExplorerTab extends JPanel implements ItemListener,ActionListener
{
    Choice loggedInUsers,selectDrive;
    JLabel lblIPAddress,lblDirectories,lblFiles;
    JButton GO,SEARCH,NEXT,PREVIOUS,DOWNLOAD;
    JTextField txtAddressbar;
    JScrollPane jspDirectory,jspFile;
    
    JTable tblDir,tblFile;
    Object DIRHEAD[]=new Object[]{"DIRECTORY LISTING"};
    Object FILEHEAD[]=new Object[]{"FILE LISTING"};
    Object DIRDATA[][]=new Object[500][1];
    Object FILEDATA[][]=new Object[500][1];
    
    public ExplorerTab()
    {
        this.setLayout(null);
        for(int i=0;i<500;i++) {
           this.DIRDATA[i][0]="";
           this.FILEDATA[i][0]="";
       }
        
        this.tblDir=new JTable(this.DIRDATA,this.DIRHEAD);
        this.tblFile=new JTable(this.FILEDATA,this.FILEHEAD);
        loggedInUsers=new Choice();
        selectDrive=new Choice();
        txtAddressbar=new JTextField();
        jspFile=new JScrollPane(this.tblFile,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspDirectory=new JScrollPane(this.tblDir,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        lblIPAddress=new JLabel("");
        lblDirectories=new JLabel("Directories");
        lblFiles=new JLabel ("Files");
        GO=new JButton ("GO");
        SEARCH=new JButton ("SEARCH");
        NEXT=new JButton ("NEXT");
        PREVIOUS=new JButton ("PREV");
        DOWNLOAD=new JButton ("DOWNLOAD");
       
        
        this.design();
        this.loggedInUsers.add("Select...");
        this.loggedInUsers.addItemListener(this);
        this.GO.addActionListener(this);
        this.NEXT.addActionListener(this);
        this.SEARCH.addActionListener(this);
        this.PREVIOUS.addActionListener(this);
        this.DOWNLOAD.addActionListener(this);
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
    
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==this.GO)
         {
            if(!this.loggedInUsers.getSelectedItem().equals("Select..."))
            {
                //JOptionPane.showMessageDialog(this,this.loggedInUsers.getSelectedItem());
                try
                {
                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DiscInfo");
                    out.writeObject(this.loggedInUsers.getSelectedItem());
                    out.writeObject(this.selectDrive.getSelectedItem());
                    this.txtAddressbar.setText(this.selectDrive.getSelectedItem());
                }
                catch(Exception ex)
                {

                }
            }
            else
                JOptionPane.showMessageDialog(this, "No Client Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
         }
         if(ae.getSource()==this.NEXT)
         {
             if(!this.loggedInUsers.getSelectedItem().equals("Select..."))
            {
                //JOptionPane.showMessageDialog(this,this.loggedInUsers.getSelectedItem());
                try
                {
                    if(this.tblDir.getSelectedRow()==-1){
                        JOptionPane.showMessageDialog(this, "No Directory Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String path=this.tblDir.getValueAt(this.tblDir.getSelectedRow(), 0).toString();
                    if(path.equals("")){
                        JOptionPane.showMessageDialog(this, "No Directory Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    path=this.txtAddressbar.getText()+ "\\" + path;
                    
                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DiscInfo");
                    out.writeObject(this.loggedInUsers.getSelectedItem());
                    out.writeObject(path);
                    this.txtAddressbar.setText(path);
                }
                catch(Exception ex)
                {

                }
            }
            else
                JOptionPane.showMessageDialog(this, "No Client Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
         }
         if(ae.getSource()==this.SEARCH)
         {
             if(!this.loggedInUsers.getSelectedItem().equals("Select..."))
            {
                //JOptionPane.showMessageDialog(this,this.loggedInUsers.getSelectedItem());
                try
                {
                    
                    String path=this.txtAddressbar.getText();
                    if(path.equals("")){
                        JOptionPane.showMessageDialog(this, "No Search Path Entered!!!","Explorer",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    
                    
                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DiscInfo");
                    out.writeObject(this.loggedInUsers.getSelectedItem());
                    out.writeObject(path);
                    this.txtAddressbar.setText(path);
                }
                catch(Exception ex)
                {

                }
            }
            else
                JOptionPane.showMessageDialog(this, "No Client Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
         }
         if(ae.getSource()==this.PREVIOUS)
         {
             if(!this.loggedInUsers.getSelectedItem().equals("Select..."))
            {
                //JOptionPane.showMessageDialog(this,this.loggedInUsers.getSelectedItem());
                try
                {
                    
                    String path=this.txtAddressbar.getText();
                    int index=path.lastIndexOf('\\');
                    path=path.substring(0, index);
                    if(path.equals("")){
                        JOptionPane.showMessageDialog(this, "No Valid Path Available!!!","Explorer",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    
                    
                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DiscInfo");
                    out.writeObject(this.loggedInUsers.getSelectedItem());
                    out.writeObject(path);
                    this.txtAddressbar.setText(path);
                }
                catch(Exception ex)
                {

                }
            }
            else
                JOptionPane.showMessageDialog(this, "No Client Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
         }
         if(ae.getSource()==this.DOWNLOAD)
         {
             if(!this.loggedInUsers.getSelectedItem().equals("Select..."))
            {
                //JOptionPane.showMessageDialog(this,this.loggedInUsers.getSelectedItem());
                try
                {
                    if(this.tblFile.getSelectedRow()==-1){
                        JOptionPane.showMessageDialog(this, "No File Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String path=this.tblFile.getValueAt(this.tblFile.getSelectedRow(), 0).toString();
                    path=this.txtAddressbar.getText()+ "\\" + path;
                    if(path.equals("")){
                        JOptionPane.showMessageDialog(this, "No File Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DownloadReq");
                    out.writeObject(this.loggedInUsers.getSelectedItem());
                    out.writeObject(path);

                }
                catch(Exception ex)
                {

                }
            }
            else
                JOptionPane.showMessageDialog(this, "No Client Selected!!!","Explorer",JOptionPane.ERROR_MESSAGE);
         }

     }
     
      public void itemStateChanged(ItemEvent e)
      {
          //clear explorer window
          this.lblIPAddress.setText("");
          this.selectDrive.removeAll();
          this.txtAddressbar.setText("");
          for(int i=0;i<500;i++) {
           this.DIRDATA[i][0]="";
           this.FILEDATA[i][0]="";
       }
          this.tblDir.repaint();
          this.tblFile.repaint();
          
          if(!this.loggedInUsers.getSelectedItem().equals("Select..."))
          {
              //JOptionPane.showMessageDialog(this,this.loggedInUsers.getSelectedItem());
              try
              {
                  ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                  out.writeObject("DriveInfo");
                  out.writeObject(this.loggedInUsers.getSelectedItem());
              }
              catch(Exception ex)
              {
                  
              }
          }
          
      }
}
