/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverside;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author define
 */
public class ClientHandler extends Thread{
    private Socket client;
    private String logid;
    private String loginTime;
    
    public ClientHandler(Socket client)
    {
        this.client=client;
        this.start();
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                ObjectInputStream in=new ObjectInputStream(this.client.getInputStream());
                String request=in.readObject().toString();
                if(request.equals("LoginDetails"))
                {
                    String logid=in.readObject().toString();
                    String pass=in.readObject().toString();
                    //Check from database
                    /*Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/netdb","root","");
                    Statement stmt=con.createStatement();
                    String query="select * from usermaster where LoginId='" + logid + "' and Password='" + pass + "'";
                    ResultSet rs=stmt.executeQuery(query);
                    if(rs.next()) */
                    if(true)
                    {
                        ObjectOutputStream out=new ObjectOutputStream(this.client.getOutputStream());
                        out.writeObject("Success");
                        
                        this.logid=logid;
                        this.loginTime=new java.util.Date().toString();
                        
                        String txt=ServerSide.swin.current.txtStatus.getText();
                        txt=txt + "\n" + this.logid + " : Logged in at " + this.loginTime + "[" + this.client.getInetAddress().getHostAddress() + "]";
                        ServerSide.swin.current.txtStatus.setText(txt);
                        //Update Database for Log History
                        
                        for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("NewLog");
                            tmp.writeObject(this.logid);
                        }
                        
                        for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                            ObjectOutputStream tmp=new ObjectOutputStream(this.client.getOutputStream());
                            tmp.writeObject("NewLog");
                            tmp.writeObject(ServerSide.loggedClient.elementAt(i).logid);
                        }
                        
                        ClientDetail detail=new ClientDetail();
                        detail.logid=this.logid;
                        detail.client=this.client;
                        ServerSide.loggedClient.add(detail);
                }
                    else
                    {
                        ObjectOutputStream out=new ObjectOutputStream(this.client.getOutputStream());
                        out.writeObject("Failed");
                    }
                }
                if(request.equals("Logout"))
                {
                    String logoutTime=new java.util.Date().toString();
                        
                    String txt=ServerSide.swin.current.txtStatus.getText();
                    txt=txt + "\n" + this.logid + " : Logged Out at " + logoutTime + "[" + this.client.getInetAddress().getHostAddress() + "]";
                    ServerSide.swin.current.txtStatus.setText(txt);
                    //Update Database for Log History
                   
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                    {
                        if(ServerSide.loggedClient.elementAt(i).logid.equals(this.logid))
                        {
                            ServerSide.loggedClient.remove(i);
                            break;
                        }
                    }
                    //Info to All Other Clients...
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("Logout");
                            tmp.writeObject(this.logid);
                        }
                    break;
                }
                if(request.equals("ChatMesg"))
                {
                    String other=in.readObject().toString();
                    String msg=in.readObject().toString();
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                          if(ServerSide.loggedClient.elementAt(i).logid.equals(other))  {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("ChatMesg");
                            tmp.writeObject(this.logid);
                            tmp.writeObject(msg);
                            break;
                          }
                        }
                }
                if(request.equals("DriveInfo"))
                {
                    String other=in.readObject().toString();
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                          if(ServerSide.loggedClient.elementAt(i).logid.equals(other))  {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("DriveInfo");
                            tmp.writeObject(this.logid);
                            break;
                          }
                        }
                }
                if(request.equals("DriveResp"))
                {
                    String other=in.readObject().toString();
                    File farr[]=(File[])in.readObject();
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                          if(ServerSide.loggedClient.elementAt(i).logid.equals(other))  {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("DriveResp");
                            tmp.writeObject(this.client.getInetAddress().getHostAddress());
                            tmp.writeObject(farr);
                            break;
                          }
                        }
                }
                if(request.equals("DiscInfo"))
                {
                    String other=in.readObject().toString();
                    String path=in.readObject().toString();
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                          if(ServerSide.loggedClient.elementAt(i).logid.equals(other))  {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("DiscInfo");
                            tmp.writeObject(this.logid);
                            tmp.writeObject(path);
                            break;
                          }
                        }
                }
                if(request.equals("DiscResp"))
                {
                    String other=in.readObject().toString();
                    Vector main=(Vector)in.readObject();
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                          if(ServerSide.loggedClient.elementAt(i).logid.equals(other))  {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("DiscResp");
                            tmp.writeObject(main);
                            break;
                          }
                        }
                }
                if(request.equals("DownloadReq"))
                {
                    String other=in.readObject().toString();
                    String path=in.readObject().toString();
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                          if(ServerSide.loggedClient.elementAt(i).logid.equals(other))  {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("DownloadReq");
                            tmp.writeObject(this.logid);
                            tmp.writeObject(path);
                            break;
                          }
                        }
                }
                if(request.equals("DownloadResp"))
                {
                    String other=in.readObject().toString();
                    byte barr[]=(byte[])in.readObject();
                    for(int i=0;i<ServerSide.loggedClient.size();i++)
                        {
                          if(ServerSide.loggedClient.elementAt(i).logid.equals(other))  {
                            ObjectOutputStream tmp=new ObjectOutputStream(ServerSide.loggedClient.elementAt(i).client.getOutputStream());
                            tmp.writeObject("DownloadResp");
                            tmp.writeObject(barr);
                            break;
                          }
                        }
                }


                
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error On Server : " + ex.getMessage(),"Server Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
