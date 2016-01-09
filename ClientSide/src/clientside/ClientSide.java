/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientside;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.*;
/**
 *
 * @author define
 */
public class ClientSide {

    public static Socket client;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         IPEntry ipentry=new IPEntry();
         Toolkit tool=Toolkit.getDefaultToolkit();
        Dimension size=tool.getScreenSize();
        final int WIDTH=380;
        final int HEIGHT=120;
        ipentry.setVisible(true);
        ipentry.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
        ipentry.setTitle("IP Entry");
        ipentry.setResizable(false);
    }
    
}
