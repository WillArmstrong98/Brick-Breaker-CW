import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;
public class cw
{ 
    public static void main(String[] args)
    { 
       /**Brick Arrays for bricks**/
       Rectangle[] R1 = new Rectangle[18];

       /**Brick lives arrays**/
       Text[] BN = new Text[18];
       String BL;
       int[] livesB = new int[18];
  
       for(int c13 = 0; c13 < 18; c13++)
       {
         livesB[c13] = 2;
       }

       GameArena Game = new GameArena(900,900);
       Ball [] b = new Ball[8];
       Arrow a = new Arrow(450,800,450,700,6,"RED", Game);
       
       /**Title Board**/
       Rectangle TitleLabelYellow = new Rectangle(0,0,1800,180,"YELLOW");
       Rectangle Redbar1 = new Rectangle(0,0,1800,200,"RED");
       Rectangle TitleLabelRed = new Rectangle(449,45,800,65,"RED");
       Rectangle TitleLabelBorder = new Rectangle(449,45,803,68,"BLACK");
       Text Title = new Text("BRICK BREAKER DELUXE", 200,54,40,"BLACK");

       /**Side Bars**/
       Rectangle LeftRed = new Rectangle(0,450,20,900,"RED");
       Rectangle RightRed = new Rectangle(900,450,20,900,"RED");
       
       /**Adding objects into the window**/
       Game.addRectangle(Redbar1);
       Game.addRectangle(TitleLabelYellow);
       Game.addRectangle(TitleLabelBorder);
       Game.addRectangle(TitleLabelRed);
       Game.addText(Title);
       Game.addRectangle(LeftRed);
       Game.addRectangle(RightRed);

       /**Displaying the bricks**/
       int spacing1 = 0;
       int spacing2 = 0;
       int total = 0;
       
       for (int c = 0; c < 3; c++)
       {
     	  for (int c2 = 0; c2 < 6; c2++)
     	  {
            R1[total] = new Rectangle(170 + spacing1,300 + spacing2,100,50,"ORANGE");
     	    Game.addRectangle(R1[total]);
     	    spacing1 = spacing1 + 110;
            total ++;
     	  }
     	  /**Pushing Y down 60 for each row**/
     	  spacing2 = spacing2 + 60;
     	  spacing1 = 0;
       }
         
         /**Adding 8 balls in a line**/
         int spacing3 = 0;
         for(int c4 = 0; c4 < 8; c4++)
	       {
    		  {
    		      b[c4] = new Ball(450,770 + spacing3,10,"WHITE");
                      Game.addBall(b[c4]);        
    		  }
               
                spacing3 = spacing3 + 30;
               }

       int total3 = 0;
       int spacing5 = 0;
       int spacing6 = 0;

       /**Puts brick lives onto the bricks, and converts the lives int into a string**/
       for (int c11 = 0; c11 < 3; c11++)
       {
     	  for (int c12 = 0; c12 < 6; c12++)
     	  {
                  BL = String.valueOf(livesB[c12]);
     		  BN[total3] = new Text(BL, 160 + spacing5, 310 + spacing6,30,"WHITE");
     		  Game.addText(BN[total3]);
     		  spacing5 = spacing5 + 110;
     		  total3 ++;
     	  }
     	  /**Pushing Y down 60 for each row**/
     	  spacing6 = spacing6 + 60;
     	  spacing5 = 0;
       }

      /**Array of X and Y direction/speed for each ball**/
      double[] XD = new double[8];
      double[] YD = new double[8];
      double neg = -1;
      double xnext = 0;
      double ynext = 0;
      double aEX = 0;
      double aSX = 0;
      double aEY = 0; 
      double lX = 0;
      double lY = 0;
      double lX1 = 0;
      double spacing4 = 0;
      int drop = 1;
      int spacing15 = 0;
      

      int[] beenHit = new int[18];
      for(int c2 = 0; c2 <18; c2++)
      {
         beenHit[c2] = 0;
      } 
      Game.update();
      /**While loop which constantly keeps the ball moving and responds to user input for the arrow**/
      while(true)
      {   
    	  ynext = 0;
          total = 0;
        
    	  for(int c = 0; c < 3; c++)
          {
    	    for(int c1 = 0; c1 < 6; c1++)
            {
               for(int c6 = 0; c6 <8; c6++)
               {
                 /**bottom edge of brick**/
                 if((beenHit[total] == 0 && b[c6].getXPosition() >= 120 + xnext && b[c6].getXPosition() <= 225 + xnext) && (b[c6].getYPosition() >= 320 + ynext && b[c6].getYPosition() <= 330 + ynext))
    	         { 
                   livesB[total]  = livesB[total] - 1;
                   BL = String.valueOf(livesB[total]);
                   BN[total].setText(BL);
                   YD[c6] = YD[c6] * neg;
                   Game.update();
                   
                     if(livesB[total] < 1)
                     {
                       beenHit[total] = 1;
                       Game.removeRectangle(R1[total]);
                       Game.removeText(BN[total]);
                     }
                 }
         	 /**Top edge**/
    	         if((beenHit[total] == 0 && b[c6].getXPosition() >= 120 + xnext && b[c6].getXPosition() <= 220 + xnext) && (b[c6].getYPosition() >= 270 + ynext && b[c6].getYPosition() <= 275 + ynext))
    	         {
                   livesB[total] = livesB[total] - 1;
                   BL = String.valueOf(livesB[total]);
                   BN[total].setText(BL);
    		   YD[c6] = YD[c6] * neg;
                  
                    if(livesB[total] < 1)
                    {
                      beenHit[total] = 1;
                      Game.removeRectangle(R1[total]);
                      Game.removeText(BN[total]);
                    }
                 }
    	         /**left side**/
    		 if((beenHit[total] == 0 && b[c6].getXPosition() >= 115 + xnext && b[c6].getXPosition() <= 125 + xnext) && (b[c6].getYPosition() >= 275 + ynext && b[c6].getYPosition() <= 325 + ynext))
    		 {
                   livesB[total] = livesB[total] - 1;
                   BL = String.valueOf(livesB[total]);
                   BN[total].setText(BL);
    		   XD[c6] = XD[c6] * neg;
                    if(livesB[total] < 1)
                    {
                      beenHit[total] = 1;
                      Game.removeRectangle(R1[total]);
                      Game.removeText(BN[total]);
                    }
                 }
    		 /**right side**/
    		 if((beenHit[total] == 0 && b[c6].getXPosition() >= 215 + xnext && b[c6].getXPosition() <= 225 + xnext) && (b[c6].getYPosition() >= 275 + ynext && b[c6].getYPosition() <= 325 + ynext))
    		 {
                   livesB[total] = livesB[total] - 1;
                   BL = String.valueOf(livesB[total]);
                   BN[total].setText(BL);
    		   XD[c6] = XD[c6] * neg;
                   if(livesB[total] < 1)
                   {
                      beenHit[total] = 1;
                      Game.removeRectangle(R1[total]);
                      Game.removeText(BN[total]);
                   }
                 }
               }
               xnext = xnext + 110;
    	       total = total + 1;
            }
             xnext = 0;
	     ynext = ynext + 60;		  
            }
    	  /**Allows the player to move the arrow**/                
    	  if(a.getEndX() == 450 )
     	  {
     	    if(Game.leftPressed() )
     	    {
     	    	a.setEnd(a.getEndX() -1 ,a.getEndY());
     	    }
     	    if(Game.rightPressed() )
    	    {
    		a.setEnd(a.getEndX() +1 ,a.getEndY());
            }
     	  } 
    	  if(a.getEndX()> 450 )
     	  {
     	    if(Game.leftPressed() )
     	    {
     	    	a.setEnd(a.getEndX() -3 ,a.getEndY() -3) ;
     	    }
     	    if(Game.rightPressed() )
    		{
    		    a.setEnd(a.getEndX() +3 ,a.getEndY() +3 );
    		}
     	  }    
     	  if(a.getEndX() <450 )
     	  {
            if(Game.leftPressed() )
     	    {
    	      a.setEnd(a.getEndX() -3 ,a.getEndY() +3 );
     	    }
            if(Game.rightPressed() )
     	    {
              a.setEnd(a.getEndX() +3 ,a.getEndY() -3 );
            }
     	  }
     	  if(a.getEndY() >750 )
     	  {
     	    if(Game.rightPressed() )
     	    {
              a.setEnd(a.getEndX() -3, 749);
     	    }
     	    if(Game.leftPressed() )
            {
     	      a.setEnd(a.getEndX() +3, 749);
            }
     	  }
         aEX = a.getEndX();
         aSX = a.getStartX();
         aEY = a.getEndY();
         Game.update();
         for(int c5 = 0; c5 < 8; c5++)
         {
            b[c5].setXPosition(b[c5].getXPosition()+XD[c5]);
            b[c5].setYPosition(b[c5].getYPosition()+YD[c5]);
           
         }
         /**Ball bounces of the edges of the screen**/
         for(int c8 = 0; c8 < 8; c8++)
          {
              if(b[c8].getXPosition() < 20)
              {
         	  XD[c8] = XD[c8] * neg;
              }         
              if(b[c8].getXPosition() > 875)
              {
         	 XD[c8] = XD[c8] * neg;
              }
              if(b[c8].getYPosition() < 110)
              {
         	 YD[c8] = YD[c8] * neg;
              }   
          }
         /**Launches the ball in the direction of the arrow**/
         if(Game.spacePressed())
          {
              lY = (aEY - 700);
              lX = (aSX - aEX);
              if(lX < 0)
                {
                   lX1 = 1;
                }
              if(lX > 0)
                {
                   lX1 = -1;
                }  
              if(lX == 0)
                {
                   lX1 = 0;
                }
              for(int c7 = 0; c7 < 8; c7++)
              {
                 if(lX < 0)
                 {
                    b[c7].setXPosition(450 - lX - spacing4);
                    b[c7].setYPosition(700 + lY + spacing4);
                 }
                 if(lX > 0)
                 {
                    b[c7].setXPosition(450 - lX + spacing4);
                    b[c7].setYPosition(700 + lY + spacing4);
                 }
                 if(lX == 0)
                 {
                    b[c7].setXPosition(450 - lX);
                    b[c7].setYPosition(700 + lY + spacing4);
                 }
                 spacing4 = spacing4 + 30;
               for(int c9 = 0; c9 < 8; c9++)
               {
                 XD[c9] = 3 * lX1;
                 YD[c9] = -3;             
               }               
             }
          }

              for(int c10 = 0; c10 < 8; c10++)
              {
              if(drop == 1 && b[0].getYPosition() > 1100 && b[1].getYPosition() > 1100 && b[2].getYPosition() > 1100 && b[3].getYPosition() > 1100 && b[4].getYPosition() > 1100 && b[5].getYPosition() > 1100 && b[6].getYPosition() > 1100 && b[7].getYPosition() > 1100)
              {
                for(int c11 = 0; c11 < 18; c11++)
                {
                  R1[c11].setYPosition(R1[c11].getYPosition() + 40);
                  BN[c11].setYPosition(BN[c11].getYPosition() + 40);    
                  drop = 0;    
                  Game.update();    
                }
              }
              /**Player gets another go**/
              if(drop == 0)
              {  
                for(int c9 = 0; c9 < 8; c9++)
                {
                   XD[c9] = 0;
                   YD[c9] = 0;
                   Game.removeBall(b[c9]);             
                } 
                int spacing9 = 0;
               
                for(int c4 = 0; c4 < 8; c4++)
	        {
    		  {
    		    b[c4] = new Ball(450,770 + spacing9,10,"WHITE");
                    Game.addBall(b[c4]);        
    		  }
                  spacing9 = spacing9 + 30;       
               }
               drop = 1;
             }          
          }
       }
    }
 }
