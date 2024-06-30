/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.java_project;
/**
 *
 * @author Abdul Malik
 */
import javax.imageio.ImageIO;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {
        JFrame jfrm = new JFrame();
        
        PlayGame gameplay = new PlayGame();
        jfrm.setBounds(10, 10, 700, 600);
        jfrm.setTitle("Brick Breaker Game_Java");
        jfrm.setResizable(false);
        
        jfrm.setVisible(true);
        
      
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Inserting gameplay Method in JFRAME
        jfrm.add(gameplay); 
               
        //Game Logo
        ImageIcon image =  new ImageIcon("brick2.png");
        jfrm.setIconImage(image.getImage());
        
    }
}
