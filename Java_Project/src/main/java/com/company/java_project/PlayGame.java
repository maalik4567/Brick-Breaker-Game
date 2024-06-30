package com.company.java_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class PlayGame extends JPanel implements KeyListener,ActionListener{
   
    private boolean play = false;
    private int score = 0;
    private String level = "01";
    private String levelType = "Easy";
    private int totalBricks = 10; //2x5 =10 
    
    private Timer time;
    private int delay = 8;
    
    private int playX = 310;
    
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    
    
    private MapGenerator map;
    
    public PlayGame(){
      map = new MapGenerator(2,5);//4x7 Bricks will be draw  
      addKeyListener(this); 
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
      time = new Timer(delay,this);
      time.start();
           
    }
    
    @Override
    public void paint(Graphics g){
        //Backgrounds
        g.setColor(new Color(33, 47, 60));
        g.fillRect(1, 1, 692, 592);
        //map
        map.draw((Graphics2D)g);
                
        //Score+Level
        
        g.setColor(new Color(3, 255, 70));
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("Level: "+level,30,30);
        
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString(" "+levelType,320,30);
        
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("Score: "+score,560,30);
        
        //Paddle Colors
        g.setColor(new Color(173,255,47));
        g.fillRect(playX, 550, 100, 8);
        
        //the Ball
        g.setColor(new Color(252,251,13));
        g.fillOval(ballposX , ballposY, 20, 20);
        
        //Move to Next_LEVEL
        if(score==50 && totalBricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(new Color(88, 214, 141));
            
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("*** CONGRATULATION YOU WON!! ***",75,300);
            
            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press N Button to Move On Next Level", 160, 330);    
        }
        if(score==105 && totalBricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(new Color(88, 214, 141));
            
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("*** CONGRATULATION YOU WON 2ND LEVEL!! ***",55,300);
            
            g.setFont(new Font("Arial",Font.BOLD,20));
            g.drawString("Press TAB Button to Move On Next Level", 160, 330);
        }
        if(score==140 && totalBricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(new Color(88, 214, 141));
            
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("Congratulations you Complete all Level",75,300);
            
            g.setFont(new Font("Arial",Font.BOLD,20));
            g.drawString("Now Press Enter Button to Start Again From Level_01!!", 160, 330);
        }
        if(ballposY > 570){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(new Color(88, 214, 141));
            
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("Game Over, Score: "+score,190,300);
            
            g.setFont(new Font("Arial",Font.BOLD,20));
            g.drawString("Press Enter to Restart", 230, 350);
        }
        
        g.dispose();
        
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playX >= 600){
               playX = 600;
            }else{
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playX < 10){
               playX = 10;
            }else{
                moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
               play = true;
               ballposX  = 120;
               ballposY  = 350;
               ballXdir = -1;
               ballYdir = -2;
               playX  = 310;
               score = 0;
               level = "01";
               levelType="Easy";
               totalBricks = 10;
               map = new MapGenerator(2,5);
               
               repaint();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_N){
                  
            if(!play){
               play = true;
               ballposX  = 120;
               ballposY  = 350;
               ballXdir = -1;
               ballYdir = -2;
               playX  = 310;
               score = 0;
               level = "02";
               levelType="Medium";
               totalBricks = 21;
               map = new MapGenerator(3,7);
               if(e.getKeyCode() == KeyEvent.VK_ENTER){
                   if(!play){
                    play = true;
                    ballposX  = 120;
                    ballposY  = 350;
                    ballXdir = -1;
                    ballYdir = -2;
                    playX  = 310;
                    score = 0;
                    level = "01";  
                    levelType="Easy";
                    totalBricks = 10;
                    map = new MapGenerator(2,5);
                    repaint();
               }       
            }
        }
    }
        if(score==105){
            if(e.getKeyCode() == KeyEvent.VK_TAB){
              if(!play){
                    play = true;
                    ballposX  = 120;
                    ballposY  = 350;
                    ballXdir = -1;
                    ballYdir = -2;
                    playX  = 310;
                    score = 0;
                    level = "03";
                    levelType="Hard";
                    totalBricks = 28;
                    map = new MapGenerator(4,7);
                    repaint();
            }  
          }
            if(score==140){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
              if(!play){
                    play = true;
                    ballposX  = 120;
                    ballposY  = 350;
                    ballXdir = -1;
                    ballYdir = -2;
                    playX  = 310;
                    score = 0;
                    level = "01";
                    levelType="Easy";
                    totalBricks = 10;
                    map = new MapGenerator(2,5);
                    repaint();
            }  
          }
        }
        }

    }
    
    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(play){
           if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playX,550,100,8))){
               ballYdir = -ballYdir;
           } 
           //Remove Bricks
           A:for(int i=0;i<map.map.length;i++){
               for(int j=0;j<map.map[0].length;j++){
                   if(map.map[i][j]>0){
                       int brickX = j*map.brickWidth+80;
                       int brickY = i*map.brickHeight+50;
                       
                       int brickWidth = map.brickWidth;
                       int brickHeight = map.brickHeight;
                       
                       Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                       Rectangle ballrec = new Rectangle(ballposX,ballposY,20,20);
                       Rectangle brickRect = rect;
                       
                       if(ballrec.intersects(brickRect)){
                           map.setBrickValue(0, i, j);
                           totalBricks--;
                           score += 5;
                           if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
                              ballXdir = -ballXdir; 
                          }
                          else{
                             ballYdir = -ballYdir;  
                          }
                           break A;
                       }
                       
                    
                   }
                }
           }
           
           ballposX += ballXdir;
           ballposY += ballYdir;
          
           if(ballposX < 0){
             ballXdir = -ballXdir;
           }
           if(ballposY < 0){
             ballYdir = -ballYdir;
           }
           if(ballposX > 670){
             ballXdir = -ballXdir;
           }
        }
        
        repaint();
    }
    private void setFocusTraversalKeyEnabled(boolean b) {
         //To change body of generated methods, choose Tools | Templates.
    }
    public void moveRight(){
        play = true;
        playX += 20;
    }
    public void moveLeft(){
        play = true;
        playX -= 20;
    }
}
