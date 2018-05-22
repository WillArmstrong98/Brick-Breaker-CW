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
       
       GameArena Game = new GameArena(900,900);
       Ball [] b = new Ball[8];

       Arrow a = new Arrow(450,800,450,700,6,"RED", Game);
       /**Points Board**/  
       Rectangle PointsBoard = new Rectangle(0,900,1800,200,"YELLOW");
       Rectangle PointsLabelBlock = new Rectangle(100,830,100,40,"RED");
       Rectangle PointsLabelBorder = new Rectangle(100,830,103,43,"BLACK");
       Text PointsLabelText = new Text("POINTS:",60,835,20,"BLACK");
       Rectangle PointsCounterBlock = new Rectangle(180,830,50,40,"RED");
       Rectangle PointsCounterBlockBorder = new Rectangle(180,830,53,43,"BLACK");
       Rectangle RedBar = new Rectangle(0,890,1800,200,"RED");
       Text PointsCounter = new Text("0",173,837,25,"BLACK");
       /**Title Board**/
       Rectangle TitleLabelYellow = new Rectangle(0,0,1800,180,"YELLOW");
       Rectangle Redbar1 = new Rectangle(0,0,1800,200,"RED");
       Rectangle TitleLabelRed = new Rectangle(449,45,800,65,"RED");
       Rectangle TitleLabelBorder = new Rectangle(449,45,803,68,"BLACK");
       Text Title = new Text("BRICK BREAKER DELUXE", 200,54,40,"BLACK");
       /**Side Bars**/
       Rectangle LeftRed = new Rectangle(0,450,20,700,"RED");
       Rectangle RightRed = new Rectangle(900,450,20,700,"RED");
       
       Text TEST = new Text("TEST", 400,600,40,"WHITE");
       
       /**Adding objects into the window**/
       Game.addRectangle(RedBar);
       Game.addRectangle(PointsBoard);
       Game.addRectangle(PointsLabelBorder);
       Game.addRectangle(PointsLabelBlock);
       Game.addText(PointsLabelText);
       Game.addRectangle(PointsCounterBlockBorder);
       Game.addRectangle(PointsCounterBlock);
       Game.addText(PointsCounter);
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
         
         int spacing3 = 0;
         for(int c4 = 0; c4 < 8; c4++)
	       {
    		  
    		  {
    		      b[c4] = new Ball(450,770 + spacing3,10,"WHITE");
                      Game.addBall(b[c4]);
                             
    		  }
               
                spacing3 = spacing3 + 30;
               }

      /**X and Y co-ordinate direction variables, as well as negative number used to control whether XD and YD are positive/negative**/
      double XD = 0;
      double YD = 0;
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
      
      Boolean[] beenHit = new Boolean[18];
      for(int c2 = 0; c2 <18; c2++)
      {
         beenHit[c2] = false;
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
    		    	  if((b[c6].getXPosition() >= 120 + xnext && b[c6].getXPosition() <= 225 + xnext) && (b[c6].getYPosition() >= 320 + ynext && b[c6].getYPosition() <= 330 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              YD = YD * neg;
                             
    		          }
    		    	  /**Top edge**/
    		    	  if((b[c6].getXPosition() >= 120 + xnext && b[c6].getXPosition() <= 220 + xnext) && (b[c6].getYPosition() >= 270 + ynext && b[c6].getYPosition() <= 275 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              YD = YD * neg;
                           
    		          }
    		    	  /**left side**/
    		    	  if((b[c6].getXPosition() >= 115 + xnext && b[c6].getXPosition() <= 125 + xnext) && (b[c6].getYPosition() >= 275 + ynext && b[c6].getYPosition() <= 325 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              XD = XD * neg;
                             
    		          }
    		    	  /**right side**/
    		    	  if((b[c6].getXPosition() >= 215 + xnext && b[c6].getXPosition() <= 225 + xnext) && (b[c6].getYPosition() >= 275 + ynext && b[c6].getYPosition() <= 325 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              XD = XD * neg;
                           
    		          }
    		    	  }
    		    	  xnext = xnext + 110;
    		    	  total = total + 1;
               }
           xnext = 0;
	   ynext = ynext + 60;		  
           }
    	                  
    	       
              
      	  
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
  
         for(int c5 = 0; c5 < 8; c5++)
         {
            b[c5].setXPosition(b[c5].getXPosition()+XD);
            b[c5].setYPosition(b[c5].getYPosition()+YD);
            Game.update();
         }
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
                 XD = 3 * lX1;
                 YD = -3;
                 spacing4 = spacing4 + 30; 
                 Game.update();
                          
              }
          for(int c8 = 0; c8 < 8; c8++)
          {
              if(b[c8].getXPosition() < 20)
              {
         	  XD = XD * neg;
              }         
              if(b[c8].getXPosition() > 875)
              {
         	 XD = XD * neg;
              }
              if(b[c8].getYPosition() < 110)
              {
         	 YD = YD * neg;
              }
              
              Game.update();
          }
          Game.update();
       }
   }
} 
}