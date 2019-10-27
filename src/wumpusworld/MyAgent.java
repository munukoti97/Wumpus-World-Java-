package wumpusworld;

/**
 * Contains starting code for creating your own Wumpus World agent. Currently
 * the agent only make a random decision each turn.
 * 
 * @author Johan Hagelbäck
 */
public class MyAgent implements Agent {
	private World w;
	int rnd;
	int c1,c2,c3,minscore=100,fl

	/**
	 * Creates a new instance of your solver agent.
	 * 
	 * @param world Current world state
	 */
	public MyAgent(World world) {
		w = world;
	}

	/**
	 * Asks your solver agent to execute an action.
	 */
	
	public void path(int x,int y,int a[],int c1,int move,int score,int fx,int fd)
	{  
		int k;
	
		if(x==fx && y==fd)
		{
		 if(minscore>=score)
		 {
		  minscore=score;
		  for(i=0;i<=c1;i++)
		     b[i]=a[i];
		  fl=c1;
		  
		 }
		}
		
		else
		{  
			if(map[x][y]%2==0 && map[x][y]>0)
			{
				k=map[x][y]/2;
				score=score+k;
				
			}
			 
			
		   if(map[x][y]!=3 && map[x][y]!=7 && map[x][y]!=-3 && map[x][y]!=-4) 
		   {
			if(move!=1 &&  )
			{
			
			
				
				// movie right
				if(a[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=1
				c1=c1+2;
				path(x,y+1,a[],c1,2,fx,fd);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
				c1++;
				a[]=1;
				
				path(x,y+1,a[],c1,2,fx,fd);
				c1--;
				}
				
			}
			if(move!=2)
			{
				
				if(a[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=1
				c1=c1+2;
				path(x,y-1,a[],c1,1,fx,fd);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=1;
				path(x,y-1,a[],c1,1,fx,fd);
				c1--;
				}
			
			}
			if(move!=3)
			{
				if(a[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=1
				c1=c1+2;
				path(x-1,y,a[],c1,4,fx,fd);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=1;
				path(x-1,y,a[],c1,4,fx,fd);
				c1--;
				}
			}
			if(move!=left)
			{
				if(a[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=1
				c1=c1+2;
				path(x+1,y,a[],c1,3,fx,fd);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=1;
				path(x+1,y,a[],c1,3,fx,fd);
				c1--;
				}
			}
		   }
			
		}
		
		
		
	}
	
	
	
	
	
	public void pathbreeze(int x,int y,int a[],int c1,int move)
	{
	
		if(map[][]%2==0 && map[][]>0)
		{
	
		if(minvalue>=a[][] || t==1)
		{
		t++;
		minvalue=a[][];
		for(i=0;i<=c1;i++)
			b[]=a[];
		fl=c1;
		}
		if(minvalue==2)
		{
			pb=1;
		}
		}
		
		else
		{  
		   if(map[x][y]!=3 && map[x][y]!=7 && map[x][y]!=-3 && pb=-1 && map[x][y]!=-4) 
		   {
			if(move!=1)
			{
				if(map[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=1
				c1=c1+2;
				pathbreeze(x,y+1,a[],c1,2);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
				c1++;
				a[]=1;
				
				path(x,y+1,a[],c1,2);
				c1--;
				}
			}
			if(move!=2)
			{

				if(map[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=2
				c1=c1+2;
				path(x,y-1,a[],c1,1);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=2;
				path(x,y-1,a[],c1,1);
				c1--;
				}
			}
			if(move!=3)
			{

				if(map[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=3
				c1=c1+2;
				path(x-1,y,a[],c1,4);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=3;
				path(x-1,y,a[],c1,4);
				c1--;
				}
			}
			if(move!=4)
			{
				if(map[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=4
				c1=c1+2;
				path(x+1,y,a[],c1,3);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=4;
				path(x+1,y,a[],c1,3);
				c1--;
			}
		   }
			
		}
		
		
		
	}
	
	public void path()
	{
	
		if(map[x][y]==0)
		{
		for(i=0;i<c1;i++)
			b[i]=a[i];
		  pa=1;
	     fl=c1;
		}
		
		else
		{  
		   if(map[x][y]%2==0 && map[x][y]!=3 && map[x][y]!=7 && map[x][y]!=-3 && pa==0) 
		   {
			if(move!=1)
			{
			
			movie right
			
			if(a[][]==-3)
			{
				
			a[c1+1]=shootarrow;
			a[c1+2]=1;
			c1=c1+2;
			path(x,y+1,a[],count,2);
			a[c1-1]=shoot arrow;
			a[c1-2]=
		    c1=c1-2;
			}
			else {
			a[]=
			path(x,y+1)
			a[]=
			count--;
			}
			}
			if(move!=2)
			{
				if(map[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=2
				c1=c1+2;
				path(x,y-1,a[],c1,1);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=2;
				path(x,y-1,a[],c1,1);
				c1--;
				}
			}
			if(move!=3)
			{
				if(map[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=3
				c1=c1+2;
				path(x-1,y,a[],c1,4);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=3;
				path(x-1,y,a[],c1,4,fx,fd);
				c1--;
				}
			}
			if(move!=4)
			{
				if(map[][]==-3)
				{
					
				a[c1+1]=shootarrow;
				a[c1+2]=4
				c1=c1+2;
				path(x+1,y,a[],c1,3);
				a[]=null
				a[]=
			    c1=c1-2;
				}
				else {
					
	             c1++;
				a[]=4;
				path(x+1,y,a[],c1,3);
				c1--;
			}
			}
		   }
			
		}
		
		
		
	}

	public void doAction() {

		// Location of the player
		int cX = w.getPlayerX();
		int cY = w.getPlayerY();

		int transformX = 4 - cX;
		int transformY = cY - 1;

		int[][] pitArray = new int[4][4];
		int[][] mapArray = new int[4][4];
		int[][] wumpusArray = new int[4][4];

		if (w.hasBreeze(cX, cY) && w.hasStench(cX, cY) && w!=0) {
			int count = 0, x = 0, y = 0;

			mapArray[transformX][transformY] = -7;

			if (transformX - 1 >= 0) 
			{
		
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX - 1 ][transformY]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4)
					{
						if(!(map[transformX - 1 ][transformY]%2==0 && map[transformX - 1 ][transformY]>0))
						{
							if(wumpusArray[transformX-1 ][transformY] ==3 || wumpusArray[transformX-1 ][transformY] ==7 )
							{
							
								count++;
								x=transformX - 1 ;
								y=transformY;
							}
							else
							{  
								x=transformX - 1 ;
							    y=transformY;
								map[transformX-1 ][transformY] =7;
								count++;
							}
						}
					}
				}
			}
			if (transformY + 1 <= 3)
			{
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX][transformY+1]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4)
					{
						if(!(map[transformX][transformY+1]%2==0 && map[transformX][transformY+1]>0))
						{
							if(wumpusArray[transformX][transformY+1] ==3 || wumpusArray[transformX ][transformY+1] ==7 )
							{
							
								count++;
								x=transformX;
								y=transformY+1;
							}
							else
							{  
								x=transformX;
							    y=transformY+1;
								map[transformX ][transformY+1] =7;
								count++;
							}
						}
					}
				}
			
				
			}
			if (transformX + 1 <= 3)
			{
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX + 1][transformY]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4)
					{
						if(!(map[transformX + 1][transformY]%2==0 && map[transformX + 1][transformY]>0))
						{
							if(wumpusArray[transformX+1 ][transformY] ==3 || wumpusArray[transformX+1 ][transformY] ==7 )
							{
							
								count++;
								x=transformX + 1;
								
								y=transformY;
							}
							else
							{  
								x=transformX + 1;
							    y=transformY;
								wumpusArray[transformX+1][transformY] =7;
								count++;
								
							}
						}
					}
				}
			}
			if (transformY - 1 >= 0) 
			{
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX][transformY - 1]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4)
					{
						if(!(map[transformX][transformY - 1]%2==0 && map[transformX][transformY - 1]>0))
						{
							if(wumpusArray[transformX][transformY-1] ==3 || wumpusArray[transformX ][transformY-1] ==7 )
							{
							
								count++;
								x=transformX;
								y=transformY - 1;
							}
							else
							{  
								x=transformX;
							    y=transformY-1;
								wumpusArray[transformX ][transformY-1] =7;
								count++;
							}
						}
					}
				}
			}

			if (count == 1)
			{
				w=1;
				map[transformX][transformY]=1;
				shoot arrow
				for(i=0;i<4;i++)
					for(j=0;j<4;j++)
					{
						if(map[i][j]==3)
							map[i][j]=1;
				         if(map[i][j]==7)
				        	 map[i][j]=2;
					}
				path(transformX,transformY,a[],c1,0);
				if(pa!=1 )
				  pathbreeze();
				for(i=0;i<4;i++)
					for(j=0;j<4;j++)
						if(map[][]==0)
							count++;
				if(count<=2)
					for(i=0;i<4;i++)
						for(j=0;j<4;j++)
							if(map[][]==0)
							{  direction()
								break;
							}
				if(pa!=1 )
					  pathbreeze();
				// shoot arrow
			} 
			else 
			{

				if (w.isVisited(cX, cY + 1)) {

					if (!w.isVisited(cX + 1, cY + 1) && map[][]==0 ) {
						a[]=
								t1=1;
						
					}
					if (!w.isVisited(cX - 1, cY + 1) &&  map[][]==0) {
						// move left
						a[]=
								t1=1;
					}
				}
				if (w.isVisited(cX + 1, cY)) {

					if (!w.isVisited(cX, cY + 1) && map[][]==0 ) {
						// move up
						t1=1;
						a[]=
					}
					if (!w.isVisited(cX, cY - 1) && map[][]==0 ) {
						// move down
						t1=1;
						a[]=
						
					}
				}
				if (w.isVisited(cX, cY - 1)) {
					if (!w.isVisited(cX + 1, cY - 1) && map[][]==0) {
						// move right
						a[]=
								t1=1
					}
					if (!w.isVisited(cX - 1, cY - 1) && map[][]==0) {
						// mov
						a[]=
								t1=1;
					}

				}
				if (w.isVisited(cX - 1, cY)) {
					if (!w.isVisited(cX - 1, cY + 1) && map[][]==0) {
						// move up
						a[]=
								t1=
					}
					if (!w.isVisited(cX - 1, cY - 1) && map[][]==0) {
						// move down
						a[]=
								t1=1;
					}
				}
                if(t1!=1) 
                {
				shortpath();
				 path();
                }
				
				
				
				
		}

		} else if (w.hasBreeze(cX, cY)) {
			int count = 0, x = 0, y = 0;

			map[transformX][transformY] = -4;

			if (transformX - 1 >= 0) 
			{
				if(map[transformX][transformY]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4)
				{
				if (!w.isVisited(cX, cY + 1))
				{
		              
					   if(map[transformX - 1][transformY]==3 || map[transformX - 1][transformY]==7)
						map[transformX - 1][transformY] = 4;
					   else
						  map[transformX - 1][transformY]=map[transformX - 1][transformY]+2;
		              
		            	  
		            	   
					   count++;
					   x=transformX - 1;
					   y=transformY;
				} 
				}
			}
			if (transformY + 1 <= 3) {
				if (!w.isVisited(cX + 1, cY)) {
					if(map[][]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4) 
					{
					
						
					if(wumpusArray[transformX ][transformY+1] ==3 || wumpusArray[transformX ][transformY+1] ==7)
					wumpusArray[transformX][transformY + 1] = 4;
					else
					map[transformX][transformY + 1]=map[transformX][transformY + 1]+2;
					count++;
					x=transformX;
					y=transformY+1;
				
					}

				}
			}
			if (transformX + 1 <= 3) 
			{
				if (!w.isVisited(cX, cY - 1))
				{
					if(map[][]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4) 
					{
						
					if(map[transformX + 1][transformY]==3 || map[transformX + 1][transformY]==7)
					wumpusArray[transformX + 1][transformY] = 4;
					else
					map[transformX+1][transformY]=map[transformX + 1][transformY]+2;
					count++;
					x = transformX+1;
					y = transformY ;
					}
				}
			}
			if (transformY - 1 >= 0)
			{
				if (!w.isVisited(cX - 1, cY))
				{
					if(map[][]!=1 && map[][]!=-7 && map[][]!=-5 && map[][]!=-4) 
					{
	                 if(map[transformX][transformY-1]==3 || map[transformX ][transformY-1]==7 )
					wumpusArray[transformX][transformY - 1] = 4;
	                 else
	                	 map[transformX ][transformY-1]=map[transformX ][transformY-1]+2;
					count++;
					x = transformX ;
					y = transformY-1;
						}
				}
			}

	
              if(count==1)
              {
            	map[x][y]=-2;
            	path(transformX,transformY,a[],c1,0);
            	if(pa!=1 )
  				  pathbreeze();
  				for(i=0;i<4;i++)
  					for(j=0;j<4;j++)
  						if(map[][]==0)
  							count++;
  				if(count<=2)
  					for(i=0;i<4;i++)
  						for(j=0;j<4;j++)
  							if(map[][]==0)
  							{  direction()
  								break;
  							}
  				if(pa!=1 )
  					  pathbreeze();
            	
              }
              else
              {
				if (w.isVisited(cX, cY + 1)) {

					if (!w.isVisited(cX + 1, cY + 1) && ) {
						// move right
					}
					if (!w.isVisited(cX - 1, cY + 1) &&  pit[][]==0) {
						// move left
					}
				}
				if (w.isVisited(cX + 1, cY)) {

					if (!w.isVisited(cX, cY + 1) && pit[][]==0 ) {
						// move up
					}
					if (!w.isVisited(cX, cY - 1) && pit[][==0] ) {
						// move down
					}
				}
				if (w.isVisited(cX, cY - 1)) {
					if (!w.isVisited(cX + 1, cY - 1) && pit[][]==0) {
						// move right
					}
					if (!w.isVisited(cX - 1, cY - 1) && pit[][]==0) {
						// move left
					}

				}
				if (w.isVisited(cX - 1, cY)) {
					if (!w.isVisited(cX - 1, cY + 1) && pit[][]==0) {
						// move up
					}
					if (!w.isVisited(cX - 1, cY - 1) && pit[][]==0) {
						// move down
					}
				
                 
				shortpath(trx,tny,0);
				path();
				
				
					
				

		} else if (w.hasStench(cX, cY)) {

			int count = 0, x = 0, y = 0;

			mapArray[transformX][transformY] = -5;
			
			if (transformX - 1 >= 0) 
			{
		
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX - 1 ][transformY]!=1 && map[][]!=-4 && map[][]!=-7)
					{
						if(!(map[transformX - 1 ][transformY]%2==0 && map[transformX - 1 ][transformY]>0))
						{
							if(wumpusArray[transformX-1 ][transformY] ==3 || wumpusArray[transformX-1 ][transformY] ==7 )
							{
							
								count++;
								x=transformX - 1 ;
								y=transformY;
							}
							else
							{  
								x=transformX - 1 ;
							    y=transformY;
								map[transformX-1 ][transformY] =3;
								count++;
							}
						}
					}
				}
			}

			if (transformY + 1 <= 3)
			{
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX][transformY+1]!=1 && map[][]!=-4 && map[][]!=-7)
					{
						if(!(map[transformX][transformY+1]%2==0 && map[transformX][transformY+1]>0))
						{
							if(wumpusArray[transformX][transformY+1] ==3 || wumpusArray[transformX ][transformY+1] ==7 )
							{
							
								count++;
								x=transformX;
								y=transformY+1;
							}
							else
							{  
								x=transformX;
							    y=transformY+1;
								map[transformX ][transformY+1] =3;
								count++;
							}
						}
					}
				}
			
				
			}
			if (transformX + 1 <= 3)
			{
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX + 1][transformY]!=1 && map[][]!=-4 && map[][]!=-7)
					{
						if(!(map[transformX + 1][transformY]%2==0 && map[transformX + 1][transformY]>0))
						{
							if(wumpusArray[transformX+1 ][transformY] ==3 || wumpusArray[transformX+1 ][transformY] ==7 )
							{
							
								count++;
								x=transformX + 1;
								
								y=transformY;
							}
							else
							{  
								x=transformX + 1;
							    y=transformY;
								wumpusArray[transformX+1][transformY] =3;
								count++;
								
							}
						}
					}
				}
			}
			if (transformY - 1 >= 0) 
			{
				if (!w.isVisited(cX, cY + 1)) 
				{
					if(map[transformX][transformY - 1]!=1 && map[][]!=-4 && map[][]!=-7)
					{
						if(!(map[transformX][transformY - 1]%2==0 && map[transformX][transformY - 1]>0))
						{
							if(wumpusArray[transformX][transformY-1] ==3 || wumpusArray[transformX ][transformY-1] ==7 )
							{
							
								count++;
								x=transformX;
								y=transformY - 1;
							}
							else
							{  
								x=transformX;
							    y=transformY-1;
								wumpusArray[transformX ][transformY-1] =3;
								count++;
							}
						}
					}
				}
			}
	
		
			if (count == 1) {
			
				w=1;
				map[transformX][transformY]=1;
				shoot arrow
				for(i=0;i<4;i++)
					for(j=0;j<4;j++)
					{
						if(map[][]==3)
							map[][]=1;
				         if(map[][]==7)
				        	 map[][]=2;
					}
				path();
				pathbreeze();
				for(i=0;i<4;i++)
					for(j=0;j<4;j++)
						if(map[][]==0)
							count++;
				if(count<=2)
					for(i=0;i<4;i++)
						for(j=0;j<4;j++)
							if(map[][]==0)
							{  direction()
								break;
							}
				
				// shoot arrow
			} else {

				if (w.isVisited(cX, cY + 1)) {

					if (!w.isVisited(cX + 1, cY + 1) && ) {
						// move right
						t1=1;
					}
					if (!w.isVisited(cX - 1, cY + 1) &&  pit[][]==0) {
						// move left
						t1=1;
					}
				}
				if (w.isVisited(cX + 1, cY)) {

					if (!w.isVisited(cX, cY + 1) && pit[][]==0 ) {
						// move up
						t1=1;
					}
					if (!w.isVisited(cX, cY - 1) && pit[][==0] ) {
						// move down
						t1=1;
					}
				}
				if (w.isVisited(cX, cY - 1)) {
					if (!w.isVisited(cX + 1, cY - 1) && pit[][]==0) {
						// move right
						t1=1;
					}
					if (!w.isVisited(cX - 1, cY - 1) && pit[][]==0) {
						// move left
						t1=1;
					}

				}
				if (w.isVisited(cX - 1, cY)) {
					if (!w.isVisited(cX - 1, cY + 1) && pit[][]==1) {
						// move up
						b[][]=3;
						count=0;
						t1=1;
					}
					if (!w.isVisited(cX - 1, cY - 1) && pit[][]==0) {
						// move down
						t1=1
					}
				}
                 if(t1!=1)
                 {
				   shortpath(transformX,transformY,0);
                 }
                 if()
                 {
				path();
                 }
                 if()
                 {
                	 
                 }
				
				
				
				
				
			}
//rahul demo 123
		} else {
			map[transformX][transformY] = 1;
			
            
			
			if (transformX - 1 >= 0 && a[i]==0)
				mapArray[transformX - 1][transformY] = 1;
			if (transformY + 1 <= 3 && a[i]==0)
				mapArray[transformX][transformY + 1] = 1;
			if (transformX + 1 <= 3 && a[][]==0)
				mapArray[transformX + 1][transformY] = 1;
			if (transformY - 1 >= 0 && a[][]==0)
				mapArray[transformX][transformY - 1] = 1;
			
			
            for(i=0;i<4;i++)
            {
            	for(j=0;j<4;j++)
            	{
            	   if(map[i][j]==-4)
            	   {
            		   if(a[i][j]!=1 && movie valid && a[][]!=3 && a[][]!=7 )
            				   {   count++;
            	
            			   x1=x;
            			   y1=y;
            		   }
            		   if(a[i][j]!=1 && movie valid && a[][]!=3 && a[][]!=5)
            		   {   count++;
            		   
            			   x1=x;
            			   y1=y;
            		   }
            		   else
            		   if(a[][]!=1 && movie valid && a[][]!=3 && a[][]!=5)
            		   {  count++;
            		   
            		   
            			   x1=x;
            			   y1=y;
            		   }
            		   if(a[][]!=1 && movie valid && a[][]!=3 && a[][]!=5)
            		   {  count++;
            		   
            		
            			   x1=x;
            			   y1=y;
            		   }
            		   if(count==1)
            		   {
            			   
            		   }
            			   
            		   
            			   
            	   }
            	   count=0;
            	}
            }
            for(i=0;i<4;i++)
            {
            	for(j=0;j<4;j++)
            	{
            	   if(map[][]==50)
            	   {
            		   if(a[][]!=1 && movie valid  && a[][]%2!=0)
            				   {   count++;
            	
            			   x1=x;
            			   y1=y;
            		   }
            		   if(a[][]!=1 && movie valid && a[][]%2!=0)
            		   {   count++;
            		   
            			   x1=x;
            			   y1=y;
            		   }
            		   else
            		   if(a[][]!=1 && movie valid && a[][]%2!=0)
            		   {  count++;
            		   
            		   
            			   x1=x;
            			   y1=y;
            		   }
            		   if(a[][]!=1 && movie valid && a[][]%2!=0)
            		   {  count++;
            		   
            		
            			   x1=x;
            			   y1=y;
            		   }
            		   if(count==1)
            		   {
            			   w=1;
            			   a[][]=-3;
            			   
            		   }
            			   
            		   
            			   
            	   }
            	   count=0;
            	}
            }
            for(i=0;i<4;i++)
            	for(j=0;j<4;j++)
            		if(map[][]==0)
            			count3++;
            if(count3)
            t=0;
            path();
            if(t==1)
            	
			if(t!=1)
				pathbreeze(transformX,transformY,0)
			
			w.doAction(World.A_TURN_RIGHT);

			if (w.getDirection() == World.DIR_RIGHT) {
				w.doAction(World.A_MOVE);
			}
		}

		// Basic action:
		// Grab Gold if we can.
		if (w.hasGlitter(cX, cY)) {
			w.doAction(World.A_GRAB);
			return;
		}

		// Basic action:
		// We are in a pit. Climb up.
		if (w.isInPit()) {
			w.doAction(World.A_CLIMB);
			return;
		}

		// Test the environment
		if (w.hasBreeze(cX, cY)) {
			System.out.println("I am in a Breeze");
		}
		if (w.hasStench(cX, cY)) {
			System.out.println("I am in a Stench");
		}
		if (w.hasPit(cX, cY)) {
			System.out.println("I am in a Pit");
		}
		if (w.getDirection() == World.DIR_RIGHT) {
			System.out.println("I am facing Right");
		}
		if (w.getDirection() == World.DIR_LEFT) {
			System.out.println("I am facing Left");
		}
		if (w.getDirection() == World.DIR_UP) {
			System.out.println("I am facing Up");
		}
		if (w.getDirection() == World.DIR_DOWN) {
			System.out.println("I am facing Down");
		}

		// decide next move
		rnd = decideRandomMove();
		if (rnd == 0) {
			w.doAction(World.A_TURN_LEFT);
			w.doAction(World.A_MOVE);
		}

		if (rnd == 1) {
			w.doAction(World.A_MOVE);
		}

		if (rnd == 2) {
			w.doAction(World.A_TURN_LEFT);
			w.doAction(World.A_TURN_LEFT);
			w.doAction(World.A_MOVE);
		}

		if (rnd == 3) {
			w.doAction(World.A_TURN_RIGHT);
			w.doAction(World.A_MOVE);
		}

	}

	/**
	 * Genertes a random instruction for the Agent.
	 */
	public int decideRandomMove() {
		return (int) (Math.random() * 4);
	}

}
