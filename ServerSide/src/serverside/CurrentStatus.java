/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverside;
import javax.swing.*;
/**
 *
 * @author define
 */
public class CurrentStatus  extends JPanel{
    JTextArea txtStatus;
    JLabel lblStatus;
    JScrollPane jspStatus;
    
    public CurrentStatus()
    {
        this.setLayout(null);
        
        this.lblStatus=new JLabel("Current Status of Network...");
        this.txtStatus=new JTextArea();
        this.jspStatus=new JScrollPane(this.txtStatus,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        this.add(this.lblStatus);
        this.add(this.jspStatus);
        
        this.lblStatus.setBounds(10,10,250,20);
        this.jspStatus.setBounds(10,40,540,470);
        
        this.txtStatus.setEditable(false);
    }
}
