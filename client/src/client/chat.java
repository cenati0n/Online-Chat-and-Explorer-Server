


package client;
import javax.swing.*;
import java.awt.*;

public class chat extends JFrame
   {
    JButton SEND;
    Choice loggedInUsers;
    JTextField txtChat;
    JScrollPane jspMessageHistory;
    JLabel lblHistory;
    public chat()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SEND=new JButton("SEND");
        loggedInUsers=new Choice();
        JLabel lblHistory=new JLabel("MESSAGE HISTORY");
        txtChat=new JTextField(15);
        jspMessageHistory=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspMessageHistory.setBounds(10,35,470,200);
        txtChat.setBounds(80,250,300,30);
        loggedInUsers.setBounds(80,300,150,50);
        SEND.setBounds(300,300,80,20);
        lblHistory.setBounds(170,10,150,20);
        this.add(SEND);
        this.add(loggedInUsers);
        this.add(jspMessageHistory);
        this.add(lblHistory);
        this.add(txtChat);
        
    }
    
    
    
}
