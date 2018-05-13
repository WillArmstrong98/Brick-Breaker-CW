import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cw
{ 
    public static void main(String[] args)
    { 
       /**Brick Arrays for each line of bricks**/
       Rectangle[] R1 = new Rectangle[5];
       Rectangle[] R2 = new Rectangle[4];
       double Xlocation; 

       GameArena Game = new GameArena(900,900);
       Ball b = new Ball(450, 710, 10, "WHITE");
       Rectangle BounceBoard = new Rectangle(450,750,150,10,"BLUE");
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
       
       Game.addBall(b);
       Game.addRectangle(BounceBoard);   

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
       Game.update();
    		  yeet
      for (int c = 0; c <4; c++)
       { 
           for (int xl1 = 150; xl1<850; xl1 = xl1 + 200)
           {
              R1[c] = new Rectangle(xl1,400,100,50,"#d15c29");
              Game.addRectangle(R1[c]);

               for (int c1 = 0; c1 <3; c1++) 
               {
                  for (int xl2 = 250; xl2<750; xl2 = xl2 + 200)
                  {
                     R2[c] = new Rectangle(xl2,250,100,50,"#d15c29");
                     Game.addRectangle(R2[c]);
                     Game.update();
                  }
               }   
           }    
       }
       
       while(true)
       {
          if(Game.leftPressed()==true)
            {
             Xlocation = BounceBoard.getXPosition();
             Xlocation = Xlocation + 50;
             BounceBoard.setXPosition(Xlocation);
             System.out.println("test/n");
             Game.update();
            }
          
        }    
           
          
    }
   
}

