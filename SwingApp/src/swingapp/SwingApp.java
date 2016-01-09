/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swingapp;

//import java.awt.Dimension;
//import java.awt.Toolkit;

/**
 *
 * @author define
 */
public class SwingApp  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingWin win=new SwingWin();
        
        /*Toolkit tool=Toolkit.getDefaultToolkit();
        Dimension size=tool.getScreenSize();
        final int WIDTH=500;
        final int HEIGHT=400;*/
        win.setVisible(true);
        /*win.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
        win.setTitle("My window");
        win.setResizable(false);*/
        
    }
    
}
