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
public class ServerWin extends JFrame{
    JTabbedPane jtb;
    CurrentStatus current;
    RegistrationForm register;
    public ServerWin()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.jtb=new JTabbedPane();
        this.current=new CurrentStatus();
        this.register=new RegistrationForm();
        
        this.jtb.addTab("Current Status", this.current);
        this.jtb.addTab("Registration", this.register);
        
        this.add(this.jtb);
        
        this.jtb.setBounds(1,1,550,480);
    }
}
