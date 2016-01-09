

package client;
//import java.swing.*;
import java.util.*;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Client {

   
    public static void main(String[] args) {
        
        explorer chat=new explorer();
         Toolkit tool=Toolkit.getDefaultToolkit();
        Dimension size=tool.getScreenSize();
        final int WIDTH=500;
        final int HEIGHT=400;
        chat.setVisible(true);
        chat.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
        chat.setTitle("chat");
        //chat.setResizable(false);
    }
    
}
