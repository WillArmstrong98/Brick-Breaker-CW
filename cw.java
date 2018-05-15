public class cw
{ 
    public static void main(String[] args)
    { 
       /**Brick Arrays for each line of bricks**/
       Rectangle[] R1 = new Rectangle[6];
       Rectangle[] R2 = new Rectangle[6];
       Rectangle[] R3 = new Rectangle[6];

       GameArena Game = new GameArena(900,900);
       Ball b = new Ball(450, 690, 10, "WHITE");
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
      for (int c = 0; c <6; c++)
       { 
           for (int xl1 = 175; xl1<=725; xl1 = xl1 + 110)
           {
        	  /**Bottom Row**/
              R1[c] = new Rectangle(xl1,360,100,50,"GREEN");
              Game.addRectangle(R1[c]);
           }   
           for (int xl2 = 175; xl2<=725; xl2 = xl2 + 110)
           {
               /**Top Row**/
               R2[c] = new Rectangle(xl2,240,100,50,"RED");
               Game.addRectangle(R2[c]);
           }  
                     
           for (int xl3 = 175; xl3<=725; xl3 = xl3 + 110)
           {
              /**Middle Row**/
              R3[c] = new Rectangle(xl3,300,100,50,"ORANGE");
              Game.addRectangle(R3[c]);
           }
       }
      
      Game.addBall(b);
      /**X and Y co-ordinate direction variables**/
      int XD = -5;
      int YD = -1;
      int neg = -1;

      while(true)
      {
    	  if(a.getEndX()==450)
     	  {
     	    if(Game.leftPressed() )
     	    {
     	    	a.setEnd(a.getEndX()-1,a.getEndY());
     	    }
     	    if(Game.rightPressed() )
    		{
    			a.setEnd(a.getEndX()+1,a.getEndY());
    		}
     	  } 
    	  if(a.getEndX()>450)
     	  {
     	    if(Game.leftPressed() )
     	    {
     	    	a.setEnd(a.getEndX()-3,a.getEndY()-3);
     	    }
     	    if(Game.rightPressed() )
    		{
    		    a.setEnd(a.getEndX()+3,a.getEndY()+3);
    		}
     	  }    
     	  if(a.getEndX()<450)
     	  {
     		if(Game.leftPressed() )
     	    {
     		    a.setEnd(a.getEndX()-3,a.getEndY()+3);
     	    }
     		if(Game.rightPressed() )
     		{
     		    a.setEnd(a.getEndX()+3,a.getEndY()-3);
     		}
     	  }
     	  if(a.getEndY()>750)
     	  {
     		if(Game.rightPressed() )
     		{
     		    a.setEnd(a.getEndX()-3, 749);
     		}
     		if(Game.leftPressed() )
     		{
     			a.setEnd(a.getEndX()+3, 749);
     		}
     	  }
          if(b.getXPosition() < 20)
          {
         	  XD = XD * neg;
          }         
          if(b.getXPosition() > 875)
          {
         	 XD = XD * neg;
          }
          if(b.getYPosition() < 110)
          {
         	 YD = YD * neg;
          }
          if(b.getYPosition() > 780)
          {
         	 b.setXPosition(450);
         	 b.setYPosition(690);
         	 XD = 0;
         	 YD = 0;
          }
          b.setXPosition(b.getXPosition()+XD);
          b.setYPosition(b.getYPosition()+YD);
          
          Game.stop();
          Game.update();
    }
            
   }

}     
          
    
    
       
       





    
       
       




