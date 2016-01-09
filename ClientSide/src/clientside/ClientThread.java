/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientside;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author define
 */
public class ClientThread extends Thread {
    
    private ClientWin win;
    public ClientThread(ClientWin win)
    {
        this.win=win;
        this.start();
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                ObjectInputStream in=new ObjectInputStream(ClientSide.client.getInputStream());
                String resp=in.readObject().toString();
                if(resp.equals("NewLog"))
                {
                    String logid=in.readObject().toString();
                    this.win.chat.loggedInUsers.add(logid);
                    this.win.explorer.loggedInUsers.add(logid);
                }
                if(resp.equals("Logout"))
                {
                    String logid=in.readObject().toString();
                    this.win.chat.loggedInUsers.remove(logid);
                    this.win.explorer.loggedInUsers.remove(logid);
                }
                if(resp.equals("ChatMesg"))
                {
                    String sender=in.readObject().toString();
                    String msg=in.readObject().toString();
                    String txt=this.win.chat.txtResp.getText();
                    txt=txt + "\n" + sender + " : " + msg;
                    this.win.chat.txtResp.setText(txt);
                }
                if(resp.equals("DriveInfo"))
                {
                    String requestee=in.readObject().toString();
                    File farr[]=File.listRoots();
                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DriveResp");
                    out.writeObject(requestee);
                    out.writeObject(farr);
                }
                if(resp.equals("DriveResp"))
                {
                    String ipaddress=in.readObject().toString();
                    File farr[]=(File[])in.readObject();
                    this.win.explorer.lblIPAddress.setText(ipaddress);
                    this.win.explorer.selectDrive.removeAll();
                    for(int i=0;i<farr.length;i++)
                    {
                        this.win.explorer.selectDrive.add(farr[i].getPath());
                    }
                }
                if(resp.equals("DiscInfo"))
                {
                    String requestee=in.readObject().toString();
                    String path=in.readObject().toString();
                    Vector main=new Vector();
                    Vector file=new Vector();
                    Vector dir=new Vector();
                    File fle=new File(path);
                    if(fle!=null) {
                        String sarr[]=fle.list();
                        for(int i=0;i<sarr.length;i++){
                            File tmp=new File(path + "\\" + sarr[i]);
                            if(tmp.isDirectory())
                                dir.add(sarr[i]);
                            else
                                file.add(sarr[i]);
                        }
                    }
                    else
                    {
                        file.add("Invalid Path!!!");
                        dir.add("Invalid Path!!!");
                    }
                    main.add(dir);
                    main.add(file);
                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DiscResp");
                    out.writeObject(requestee);
                    out.writeObject(main);
                }
                if(resp.equals("DiscResp"))
                {
                    Vector main=(Vector)in.readObject();
                    for(int i=0;i<500;i++) {
                        this.win.explorer.DIRDATA[i][0]="";
                        this.win.explorer.FILEDATA[i][0]="";
                    }
                    Vector dir=(Vector)main.elementAt(0);
                    Vector file=(Vector)main.elementAt(1);
                    for(int i=0;i<dir.size();i++)
                        this.win.explorer.DIRDATA[i][0]=dir.elementAt(i).toString();
                    for(int i=0;i<file.size();i++)
                        this.win.explorer.FILEDATA[i][0]=file.elementAt(i).toString();
                    this.win.explorer.tblDir.repaint();
                    this.win.explorer.tblFile.repaint();
                }
                
                /*File file=new File("");
                byte barr[]=new byte[(int)file.length()];
                FileInputStream inp=new FileInputStream(file);
                inp.read(barr);*/
                
                //show file chooser save as dialog
                //select file
                /*String path="";
                File file=new File(path);
                FileOutputStream fout=new FileOutputStream(file);
                fout.write(barr);*/
                if(resp.equals("DownloadReq"))
                {
                    String requestee=in.readObject().toString();
                    String path=in.readObject().toString();
                    File file=new File(path);
                    byte barr[]=new byte[(int)file.length()];
                    FileInputStream inp=new FileInputStream(file);
                    inp.read(barr);
                    ObjectOutputStream out=new ObjectOutputStream(ClientSide.client.getOutputStream());
                    out.writeObject("DownloadResp");
                    out.writeObject(requestee);
                    out.writeObject(barr);
                }
                if(resp.equals("DownloadResp"))
                {
                    byte barr[]=(byte[])in.readObject();
                    JFileChooser fileChooser=new JFileChooser();
                    fileChooser.setDialogTitle("Download Location");
                    // fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int returnVal=fileChooser.showSaveDialog(this.win);
                  
                    
                    if(returnVal==JFileChooser.APPROVE_OPTION)
                    {
                        File selectedDir=fileChooser.getSelectedFile();
                        String path=selectedDir.getAbsolutePath();
                        File file= new File(path);
                        FileOutputStream fout=new FileOutputStream(file);
                        fout.write(barr);
                        JOptionPane.showMessageDialog(this.win, "File downloaded successfully..!!","Download Result",JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                   // fileChooser.setVisible(false);
                }
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this.win, "Error On Client : " + ex.getMessage(),"Client Side",JOptionPane.ERROR_MESSAGE);
        }
    }
}
