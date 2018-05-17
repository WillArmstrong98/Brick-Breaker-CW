public class cw
{ 
    public static void main(String[] args)
    { 
       /**Brick Arrays for bricks**/
       Rectangle[] R1 = new Rectangle[18];
       
       GameArena Game = new GameArena(900,900);
       Ball b = new Ball(500, 200, 10, "WHITE");
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
      
      Game.addBall(b);
      /**X and Y co-ordinate direction variables, as well as negative number used to control whether XD and YD are positive/negative**/
      double XD = -2.5;
      double YD = -5;
      int neg = -1;
      int xnext = 0;
      int ynext = 0;
      Boolean[] beenHit = new Boolean[18];
      
      /**While loop which constantly keeps the ball moving and responds to user input for the arrow**/
      while(true)
      {   
    	  ynext = 0;
          total = 0;
          
    	  for(int c = 0; c < 3; c++)
		  {
			  for(int c1 = 0; c1 < 6; c1++)
			  {
    				  /**bottom edge of brick**/
    		    	  if((b.getXPosition() >= 115 + xnext && b.getXPosition() <= 215 + xnext) && (b.getYPosition() >= 340 + ynext && b.getYPosition() <= 350 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              Game.addText(TEST);
    		              YD = YD * neg;
    		          }
    		    	  /**Top edge**/
    		    	  if((b.getXPosition() >= 115 + xnext && b.getXPosition() <= 215 + xnext) && (b.getYPosition() >= 265 + ynext && b.getYPosition() <= 270 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              Game.addText(TEST);
    		              YD = YD * neg;
    		          }
    		    	  /**left side**/
    		    	  if((b.getXPosition() >= 115 + xnext && b.getXPosition() <= 125 + xnext) && (b.getYPosition() >= 265 + ynext && b.getYPosition() <= 315 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              Game.addText(TEST);
    		              XD = XD * neg;
    		          }
    		    	  /**right side**/
    		    	  if((b.getXPosition() >= 205 + xnext && b.getXPosition() <= 215 + xnext) && (b.getYPosition() >= 265 + ynext && b.getYPosition() <= 315 + ynext))
    		          {
    		              Game.removeRectangle(R1[total]);
    		              Game.addText(TEST);
    		              XD = XD * neg;
    		          }
    		    	  
    		    	  xnext = xnext + 110;
    		    	  total = total + 1;
			  }
			  xnext = 0;
			  ynext = ynext + 54;		  
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
         	 
         	 YD = YD * neg;
          }
          b.setXPosition(b.getXPosition()+XD);
          b.setYPosition(b.getYPosition()+YD);

          Game.stop(); 
          Game.update();
    }
            
   }
    }

     
          
    
    
       
       





    
       
       




