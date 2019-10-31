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
	int wumpus = 0, pa = 0, pb = 0, minvalue = 100, t = 1, minscore = 100, k1,op,k=1,fp=0;
	int c2=0,c3=0,path=0;
	int[][] map = new int[4][4];
	int[] b = new int[10];
    int pbb=0;
    int pd=0;
    int path1=0;
	/**
	 * Creates a new instance of your solver agent.
	 * 
	 * @param world Current world statea
	 */
	public MyAgent(World world) {
		w = world;
	}
    public void direction(int x)
    {  
    	 int i=0,dif;
    	 
    	if (w.getDirection() == World.DIR_RIGHT) {
			System.out.println("I am facing Right");
			i=1;
		}
		if (w.getDirection() == World.DIR_LEFT) {
			System.out.println("I am facing Left");
			i=2;
		}
		if (w.getDirection() == World.DIR_UP) {
			System.out.println("I am facing Up");
			i=3;
		}
		if (w.getDirection() == World.DIR_DOWN) {
			System.out.println("I am facing Down");
			i=4;
		}
		dif=i-x;
        if(dif==0)
        	w.doAction(World.A_MOVE);
        if((i==1 && x==2) ||(x==1 && i==2) || (i==3 && x==4 ) || (x==3 && i==4) )
        {
        	w.doAction(World.A_TURN_RIGHT);
			w.doAction(World.A_TURN_RIGHT);
			w.doAction(World.A_MOVE);
			
        }
        	
       if((i==4 && x==2) || ( i==2 && x==3) || (i==3 && x==1) || (i==1 && x==4))
       {
    	   w.doAction(World.A_TURN_RIGHT);
    	   w.doAction(World.A_MOVE);
       }
		
       if((x==4 && i==2) || ( x==2 && i==3) || (x==3 && i==1) || (x==1 && i==4))
       {
    	   w.doAction(World.A_TURN_LEFT);
    	   w.doAction(World.A_MOVE);
       }
		
		
    }
    
    public void arrow(int x)
    {  
    	 int i=0,dif;
    	 
    	if (w.getDirection() == World.DIR_RIGHT) {
			System.out.println("I am facing Right");
			i=1;
		}
		if (w.getDirection() == World.DIR_LEFT) {
			System.out.println("I am facing Left");
			i=2;
		}
		if (w.getDirection() == World.DIR_UP) {
			System.out.println("I am facing Up");
			i=3;
		}
		if (w.getDirection() == World.DIR_DOWN) {
			System.out.println("I am facing Down");
			i=4;
		}
		dif=i-x;
        if(dif==0)
        	w.doAction(World.A_SHOOT);
        if((i==1 && x==2) ||(x==1 && i==2) || (i==3 && x==4 ) || (x==3 && i==4) )
        {
        	w.doAction(World.A_TURN_RIGHT);
			w.doAction(World.A_TURN_RIGHT);
			w.doAction(World.A_SHOOT);
			
        }
        	
       if((i==4 && x==2) || ( i==2 && x==3) || (i==3 && x==1) || (i==1 && x==4))
       {
    	   w.doAction(World.A_TURN_RIGHT);
    	   w.doAction(World.A_SHOOT);
       }
		
       if((x==4 && i==2) || ( x==2 && i==3) || (x==3 && i==1) || (x==1 && i==4))
       {
    	   w.doAction(World.A_TURN_LEFT);
    	   w.doAction(World.A_SHOOT);
       }
		
		
    }
	public void pathDestination(int[][] map, int[] a, int x, int y, int c1, int move, int score, int fx, int fd) {

		int k;

		if (x == fx && y == fd) 
		{
			if (minscore >= score) 
			{
				minscore = score;
				k1 = a[0];
				System.out.println("98745632123654");
				
				for(int i=0;i<=c1;i++)
					b[i]=a[i];
				pd=c1;
				if(c1>0)
				{   
					k=1;
					fp=c1;
					path=1;
				}
				System.out.println(pd);
			}
		}

		else {
			if (map[x][y] % 2 == 0 && map[x][y] > 0) {
				k = map[x][y] / 2;
				score = score + k;

			}
			if (map[x][y] != 3 && map[x][y] != 7 && map[x][y] != -3 ) {
				if (move != 1 && (y + 1) <= 3 && c1<6) {

					// movie right

					if (map[x][y + 1] == -3  ) {

						c1++;
						a[c1] = 5;
						pathDestination(map, a, x, y + 1, c1, 2,score,fx,fd);
						a[c1] = 0;
						c1--;
					} else {
						c1++;
						a[c1] = 1;
						pathDestination(map, a, x, y + 1, c1, 2,score,fx,fd);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 2 && (y - 1) >= 0 && c1<6) {
					if (map[x][y - 1] == -3) {

						c1++;
						a[c1] = 6;
						pathDestination(map, a, x, y - 1, c1, 1,score,fx,fd);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 2;
						pathDestination(map, a, x, y - 1, c1, 1,score,fx,fd);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 3 && x - 1 >= 0 && c1<6) {
					if (map[x - 1][y] == -3) {
						c1++;
						a[c1] = 7;
						pathDestination(map, a, x - 1, y, c1, 4,score,fx,fd);
						a[c1] = 0;
						c1--;
					} else {

						c1++;
						a[c1] = 3;
						pathDestination(map, a, x - 1, y, c1, 4,score,fx,fd);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 4 && x + 1 <= 3 && c1<6) {
					if (map[x + 1][y] == -3) {

						c1++;
						a[c1] = 8;
						pathDestination(map, a, x + 1, y, c1, 3,score,fx,fd);
						a[c1] = 0;
						c1--;
					} else {

						c1++;
						a[c1] = 4;
						pathDestination(map, a, x + 1, y, c1, 3,score,fx,fd);
						c1--;
					}
				}

			}

		}
	}

	public void pathbreeze(int[][] map, int[] a, int x, int y, int c1, int move) {
		int l = 0;
		
		if (map[x][y] % 2 == 0 && map[x][y] > 0) {
			
			if (minvalue >= map[x][y] || t == 1) {
				t++;
				minvalue = map[x][y];

			}
			if (minvalue == 2) {
				pb = 1;
				l = 1;
				t=1;
				System.out.println("na bondhaasdfghjksdfghjk");
				for(int i=0;i<=c1;i++)
					{b[i]=a[i];
					System.out.println(a[i]);
					}
				System.out.println(c1);
				pd=c1;
				if(c1>0)
				{   
					k=1;
					fp=c1;
					path=1;
				}				
				switch (b[0]) {
				case 1:
					direction(1);
					break;
				case 2: // left
					direction(2);
					break;
				case 3: // up
					direction(3);
					break;
				case 4: // down
					direction(4);
					break;
				case 5: // shoot
				

					w.doAction(World.A_SHOOT);
					break;
				case 6:
				
					w.doAction(World.A_SHOOT);
					break;
				case 7:
					
					w.doAction(World.A_SHOOT);
					break;
				case 8:
		
					w.doAction(World.A_SHOOT);
					break;
				default: // random
					break;
				}
				
				
				
			}
			if (t == 3 && l != 1 && minvalue < 6) {
				pb = 1;
				t=1;
				System.out.println("na bondhaasdfghjksdfghjk");
				for(int i=0;i<=c1;i++)
					b[i]=a[i];
				pd=c1;
				if(c1>0)
				{   
					k=1;
					fp=c1;
					path=1;
				}	
					
				switch (a[0]) {
				case 1:
					direction(1);
					break;
				case 2: // left
					direction(2);
					break;
				case 3: // up
					direction(3);
					break;
				case 4: // down
					direction(4);
					break;
				case 5: // shoot
				

					w.doAction(World.A_SHOOT);
					break;
				case 6:
				
					w.doAction(World.A_SHOOT);
					break;
				case 7:
					
					w.doAction(World.A_SHOOT);
					break;
				case 8:
		
					w.doAction(World.A_SHOOT);
					break;
				default: // random
					break;
				}

			}
		}

		else 
		{
			if (map[x][y] != 3 && map[x][y] != 7 && map[x][y] != -3   && pb!=1 && map[x][y] != -2) {
				if (move != 1 && (y + 1) <= 3 && pb!=1 && c1<6) {

					// movie right

					if (map[x][y + 1] == -3 && pb!=1) {
						c1++;
						a[c1] = 5;

						pathbreeze(map, a, x, y + 1, c1, 2);
						a[c1] = 0;

						c1--;
					} else {
						c1++;
						a[c1] = 1;
						pathbreeze(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 2 && (y - 1) >= 0 && pb!=1 && c1<6) {
					if (map[x][y - 1] == -3) {
						c1++;
						a[c1] = 6;
						pathbreeze(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 2;
						pathbreeze(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 3 && x - 1 >= 0 && pb!=1 && c1<6) {
					if (map[x - 1][y] == -3) {
						c1++;
						a[c1] = 7;
						pathbreeze(map, a, x - 1, y, c1, 4);
						a[c1] = 0;
						c1--;

					} else {
						System.out.println("na bondha");
						c1++;
						a[c1] = 3;
						pathbreeze(map, a, x - 1, y, c1, 4);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 4 && x + 1 <= 3 && pb!=1 && c1<6) {
					if (map[x + 1][y] == -3) {
						c1++;
						a[c1] = 8;
						pathbreeze(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 4;
						pathbreeze(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;
					}
				}

			}

		}

	}

	public void path(int[][] map, int[] a, int x, int y, int c1, int move) {
        
		if(!w.isVisited(y+1 , 4-x))
		{
			System.out.println("na dengu");
			System.out.println(x);
			System.out.println(y);
			System.out.println(map[x][y]);
		}
		if(x<=3 && y<=3 && x>=0 && y>=0)
		if (map[x][y] == 0  || (!w.isVisited(y+1 , 4-x) && map[x][y]==1)) 
		{

			pa = 1;
			for(int i=0;i<c1;i++)
				b[i]=a[i];
			if(c1>0)
			{   
				k=1;
				fp=c1;
				path=1;
			}
			System.out.println("9874563212cffchgvjhkl;3654");
			System.out.println(c1);
			for(int i=0;i<=c1;i++)
				System.out.println(a[i]);
		    
			switch (a[0]) {
			case 1:
				direction(1);
				break;
			case 2: // left
				direction(2);
				break;
			case 3: // up
				direction(3);
				break;
			case 4: // down
				direction(4);
				break;
			case 5: // shoot
			

				w.doAction(World.A_SHOOT);
				break;
			case 6:
			
				w.doAction(World.A_SHOOT);
				break;
			case 7:
				
				w.doAction(World.A_SHOOT);
				break;
			case 8:
	
				w.doAction(World.A_SHOOT);
				break;
			default: // random
				break;
			}
			return;
		}

		else {
			if(c1<5)
			if(x<=3 && y<=3 && x>=0 && y>=0)
			if ((map[x][y] % 2 != 0 || map[x][y]<0) && map[x][y] != 3 && map[x][y] != 7 && map[x][y] != -3 && pa!=1 && map[x][y]!=-2 ) {
				 System.out.println("dfgh");
				if (move != 1 && (y + 1) <= 3  && pa!=1 && c1<5) {

					// movie right
                      System.out.println("dfgh");
					if (map[x][y + 1] == -3) {
						
						a[c1] = 5;
						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						c1--;
						System.out.println("stop1");

					} else {
						c1++;
						a[c1] = 1;
						System.out.println(c1);
						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						System.out.println("stop1");
						c1--;
					}
				}
				if (move != 2 && (y - 1) >= 0 && pa!=1 && c1<5) {
					if (map[x][y - 1] == -3 ) {

						c1++;
						a[c1] = 6;
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;
					} else {

						c1++;
						a[c1] = 2;
						System.out.println(c1);
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 3 && x - 1 >= 0 && pa!=1 && c1<5) {
					if (map[x - 1][y] == -3) {

						c1++;
						a[c1] = 7;
						path(map, a, x - 1, y, c1, 4);
						a[c1] = 0;
						c1--;
					} else {

						c1++;
						a[c1] = 3;
						
						path(map, a, x - 1, y, c1, 4);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 4 && x + 1 <= 3 && pa!=1 && c1<5) {
					if (map[x + 1][y] == -3) {
						c1++;
						a[c1] = 8;
						path(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 4;
						System.out.println("asdfghjkl;lsdfghjkl;dfghjkl");
						System.out.println(c1);
						System.out.println("asdfghjklsdfghjkdfghjk");
						path(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;
					}
				}
			}

		}

	}
   
	public void breezeAndStrenchMethod1(int[][] map, int cX, int cY, int transformX, int transformY) {

		int count = 0, x = 0, y = 0, t1 = 0, d = 0;

		int[] a = new int[16];

		map[transformX][transformY] = -7;

		if (transformX - 1 >= 0) {

			if (!w.isVisited(cX, cY + 1)) {
				if (map[transformX - 1][transformY] != 1 && map[transformX - 1][transformY] != -7
						&& map[transformX - 1][transformY] != -5 && map[transformX - 1][transformY] != -4) {
					if (!(map[transformX - 1][transformY] % 2 == 0 && map[transformX - 1][transformY] > 0)) {
						if (map[transformX - 1][transformY] == 3 || map[transformX - 1][transformY] == 7) {

							count++;
							x = transformX - 1;
							y = transformY;
							int cur_dir = w.getDirection();
							d = 0;
							directionIntoRequired(cur_dir, 0);
							if (w.hasArrow()) {
								w.doAction(World.A_SHOOT);
								count = 2;
								wumpus = 1;
								map[transformX][transformY] = 1;
								for (int i = 0; i < 4; i++)
									for (int j = 0; j < 4; j++) {
										if (map[i][j] == 3)
											map[i][j] = 1;
										if (map[i][j] == 7)
											map[i][j] = 2;
									}

							} else {
								x = transformX - 1;
								y = transformY;
								d = 0;
								map[transformX - 1][transformY] = 7;
								count++;
							}
						}
					}
				}
			}
			if (transformY + 1 <= 3) {
				if (!w.isVisited(cX + 1, cY)) {
					if (map[transformX][transformY + 1] != 1 && map[transformX][transformY + 1] != -7
							&& map[transformX][transformY + 1] != -5 && map[transformX][transformY + 1] != -4) {
						if (!(map[transformX][transformY + 1] % 2 == 0 && map[transformX][transformY + 1] > 0)) {
							if (map[transformX][transformY + 1] == 3 || map[transformX][transformY + 1] == 7) {

								count++;
								x = transformX;
								y = transformY + 1;
								int cur_dir = w.getDirection();
								d = 1;
								directionIntoRequired(cur_dir, 1);
								if (w.hasArrow()) {
									w.doAction(World.A_SHOOT);
									count = 2;
									wumpus = 1;
									map[transformX][transformY] = 1;
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++) {
											if (map[i][j] == 3)
												map[i][j] = 1;
											if (map[i][j] == 7)
												map[i][j] = 2;
										}

								} else {
									x = transformX;
									y = transformY + 1;
									d = 1;
									map[transformX][transformY + 1] = 7;
									count++;
								}
							}
						}
					}

				}
				if (transformX + 1 <= 3) {
					if (!w.isVisited(cX, cY - 1)) {
						if (map[transformX + 1][transformY] != 1 && map[transformX + 1][transformY] != -7
								&& map[transformX + 1][transformY] != -5 && map[transformX + 1][transformY] != -4) {
							if (!(map[transformX + 1][transformY] % 2 == 0 && map[transformX + 1][transformY] > 0)) {
								if (map[transformX + 1][transformY] == 3 || map[transformX + 1][transformY] == 7) {

									count++;
									x = transformX + 1;

									y = transformY;
									int cur_dir = w.getDirection();
									directionIntoRequired(cur_dir, 2);
									d = 2;
									if (w.hasArrow()) {
										w.doAction(World.A_SHOOT);
										count = 2;
										wumpus = 1;
										map[transformX][transformY] = 1;
										for (int i = 0; i < 4; i++)
											for (int j = 0; j < 4; j++) {
												if (map[i][j] == 3)
													map[i][j] = 1;
												if (map[i][j] == 7)
													map[i][j] = 2;
											}

									} else {
										x = transformX + 1;
										y = transformY;
										d = 2;
										map[transformX + 1][transformY] = 7;
										count++;

									}
								}
							}
						}
					}
					if (transformY - 1 >= 0) {
						if (!w.isVisited(cX - 1, cY)) {

							if (map[transformX][transformY - 1] != 1 && map[transformX][transformY - 1] != -7
									&& map[transformX][transformY - 1] != -5 && map[transformX][transformY - 1] != -4) {

								if (!(map[transformX][transformY - 1] % 2 == 0
										&& map[transformX][transformY - 1] > 0)) {
									if (map[transformX][transformY - 1] == 3 || map[transformX][transformY - 1] == 7) {

										count++;
										x = transformX;
										y = transformY - 1;
										int cur_dir = w.getDirection();
										d = 3;
										directionIntoRequired(cur_dir, 3);
										if (w.hasArrow()) {
											w.doAction(World.A_SHOOT);
											count = 2;
											wumpus = 1;
											map[transformX][transformY] = 1;
											for (int i = 0; i < 4; i++)
												for (int j = 0; j < 4; j++) {
													if (map[i][j] == 3)
														map[i][j] = 1;
													if (map[i][j] == 7)
														map[i][j] = 2;
												}

										} else {
											x = transformX;
											y = transformY - 1;
											d = 3;
											map[transformX][transformY - 1] = 7;
											count++;
										}
									}
								}
							}
						}

						if (count == 1) {
							wumpus = 1;
							map[transformX][transformY] = 1;

							for (int i = 0; i < 4; i++)
								for (int j = 0; j < 4; j++) {
									if (map[i][j] == 3)
										map[i][j] = 1;
									if (map[i][j] == 7)
										map[i][j] = 2;
									int cur_dir = w.getDirection();

									directionIntoRequired(cur_dir, d);
									if (w.hasArrow()) {
										w.doAction(World.A_SHOOT);
									}
								}

						} else {

							if (w.isVisited(cX, cY + 1)) {
								if ((transformX + 1) <= 3 && (transformX - 1) >= 0)
									if ((!w.isVisited(cX + 1, cY + 1) && map[transformX + 1][transformY + 1] == 0)
											|| (!w.isVisited(cX - 1, cY + 1)
													&& map[transformX - 1][transformY + 1] == 0)) {

										t1 = 1;
										// move up
									}

							}
							if (w.isVisited(cX + 1, cY)) {
								if ((transformY + 1) <= 3 && (transformY - 1) >= 0)
									if ((!w.isVisited(cX, cY + 1) && map[transformX][transformY + 1] == 0)
											|| (!w.isVisited(cX, cY - 1) && map[transformX][transformY - 1] == 0)) {
										// move right
										t1 = 1;
									}
							}
							if (w.isVisited(cX, cY - 1)) {
								if ((transformX + 1) <= 3 && (transformX - 1) >= 0)
									if ((!w.isVisited(cX + 1, cY - 1) && map[transformX + 1][transformY - 1] == 0)
											|| (!w.isVisited(cX - 1, cY - 1)
													&& map[transformX - 1][transformY - 1] == 0)) {
										// move down

										t1 = 1;
									}

							}
							if (w.isVisited(cX - 1, cY)) {
								if ((transformY + 1) <= 3 && (transformY - 1) >= 0)
									if ((!w.isVisited(cX - 1, cY + 1) && map[transformX - 1][transformY + 1] == 0)
											|| (!w.isVisited(cX - 1, cY - 1)
													&& map[transformX - 1][transformY - 1] == 0)) {
										// move left
										t1 = 1;
									}

							}

							if (t1 != 1) {
								pa = 0;
								count = 0;
								path(map, a, transformX, transformY, 0, 0);
								if (pa != 1)
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (!w.isVisited(i+1, j+1))
												count++;
								if (count <= 2) {
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (!w.isVisited(i+1, j+1)) {
												minscore = 100;
												pathDestination(map, a, transformX, transformY, 0, 0, 0, i, j);
												int cur_direction = w.getDirection();
												switch (k1) {
												case 1: // right
													directionIntoRequired(cur_direction, 1);
													w.doAction(World.A_MOVE);
													break;
												case 2: // left
													directionIntoRequired(cur_direction, 3);
													w.doAction(World.A_MOVE);
													break;
												case 3: // up
													directionIntoRequired(cur_direction, 0);
													w.doAction(World.A_MOVE);
													break;
												case 4: // down
													directionIntoRequired(cur_direction, 2);
													w.doAction(World.A_MOVE);
													break;
												case 5: // shoot
													directionIntoRequired(cur_direction, 1);

													w.doAction(World.A_SHOOT);
													break;
												case 6:
													directionIntoRequired(cur_direction, 3);
													w.doAction(World.A_SHOOT);
													break;
												case 7:
													directionIntoRequired(cur_direction, 0);
													w.doAction(World.A_SHOOT);
													break;
												case 8:
													directionIntoRequired(cur_direction, 2);
													w.doAction(World.A_SHOOT);
													break;
												default: // random
													break;
												}
												break;
											}

								} else if (pa != 1) {
									minvalue = 100;
									pb = 0;
									t = 1;
									pathbreeze(map, a, transformX, transformY, 0, 0);
								}
							}
						}
					}
				}
			}
		}
	}
  
	
	
	public void breezeAndStrenchMethod(int[][] map, int cX, int cY, int x, int y)
	{
		int count = 0, Y = 0, X = 0, t1 = 0, d = 0,count1=0,d1=0 ;

		int[] a = new int[16];
		map[x][y] = -7;
		System.out.println(x);
		System.out.println(y);
		System.out.println("cvbn");
		path=0;
		k=1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		
		if (x-1 >= 0) 
		{
			if (!w.isVisited(cX, cY + 1)) 
			{
				if (map[x-1][y] != 1 && map[x-1][y] != -7 && map[x-1][y] != -4) 
				{
					if (!(map[ x- 1][y] % 2 == 0 && map[x-1][y] > 0)) 
					{
						if (map[x-1][y] == 3 || map[x-1][y] == 7) 
						{

							count1++;
							X = x-1;
							Y = y;
						   
							d = 3;
							
						}    else 
							{
								X = x - 1;
								Y = y;
								map[x - 1][y] = 7;
								d1=3;
								count++;
							}
				   }		
				}
			 }
		  }			

			if (y + 1 <= 3)
			{
				if (!w.isVisited(cX + 1, cY)) 
				{
					if (map[x][y + 1] != 1 && map[x][y + 1] != -7 && map[x][y + 1] != -5 && map[x][y + 1] != -4)
					{
						if (!(map[x][y + 1] % 2 == 0 && map[x][y+1] > 0)) 
						{
							if (map[x][y + 1] == 3 || map[x][y + 1] == 7)
							{

								count1++;
								X = x;
								Y = y + 1;
								
					           d=1;
								
							}else {
									X = x;
									Y = y + 1;
									d1=1;
									map[x][y + 1] = 7;
									count++;
								}
							}
						}
					}

				}
				if (x + 1 <= 3) 
				{
					if (!w.isVisited(cX, cY - 1)) 
					{
						if (map[x+1][y] != 1 && map[x + 1][y] != -7 &&  map[x + 1][y] != -4 && map[x + 1][y] != -5 ) 
						{
							if (!(map[x + 1][y] % 2 == 0 && map[x+1][y] > 0)) 
							{
								if (map[x + 1][y] == 3 || map[x + 1][y] == 7) 
								{

									count1++;
									X = x + 1;
									 d=4;
									Y = y;
									
									} else {
										X = x + 1;
										Y = y;
										d1=4;
										map[x+ 1][y] = 7;
										count++;

									}
								}
								
							}
						}
					}
				
					
	             if (y - 1 >= 0)
					{
						if (!w.isVisited(cX - 1, cY)) 
						{
							if (map[x][y - 1] != 1 && map[x][y - 1] != -7 && map[x][y - 1] != -5 && map[x][y - 1] != -4)
							{
								if (!(map[x][y - 1] % 2 == 0 && map[x][y - 1] > 0))
								{
									if (map[x][y - 1] == 3 || map[x][y - 1] == 7)
									{

										count1++;
										X = x;
										y = y - 1;
										 d=2;
										
										} else {
											X = x;
											Y = y - 1;
											map[x][y - 1] = 7;
											d1=2;
											count++;
										}
									}
								}
							}
						}
					if(x==3 && y==0)
					{
						direction(1);
						return;
					}
	
					for(int i=0;i<4;i++)
						{
							for(int j=0;j<4;j++)
								System.out.print(map[i][j]);
							System.out.println();
						}
					System.out.println(count);
					if(count1==1)
					{
						
						
							count = 2;
							wumpus = 1;
							map[x][y] = 1;
							arrow(d);
							direction(4);
							for (int i = 0; i < 4; i++)
								for (int j = 0; j < 4; j++) {
									if (map[i][j] == 3  || map[i][j]==-5 )
										map[i][j] = 1;
									if (map[i][j] == 7)
										map[i][j] = 2;
								}
							for(int i=0;i<4;i++)
							{
								for(int j=0;j<4;j++)
									System.out.print(map[i][j]);
								System.out.println();
							}
							return ;	
				
					}
						
						if (count == 1) {
							System.out.println("dfghj");
							wumpus = 1;
							map[x][y] = 1;
							arrow(d1);
							

							for (int i = 0; i < 4; i++)
								for (int j = 0; j < 4; j++) {
									if (map[i][j] == 3 || map[i][j]==-5)
										map[i][j] = 1;
									if (map[i][j] == 7)
										map[i][j] = 2;
								}
							
							
							
						} 
						else 
						{
							if (w.isVisited(cX, cY + 1)) 
							{
								if ((x-1)>= 0)
								{   
									if((y+1)<=3)
									if ((!w.isVisited(cX + 1, cY + 1) && map[x-1][y + 1] == 1) || (map[x-1][y]==1 && !w.isVisited(cX, cY + 1)))
									{

										t1 = 1;
										
										d = 3;
									}
									else
									if(y-1>=0)
										if((!w.isVisited(cX - 1, cY + 1) && map[x - 1][y - 1] == 1) || (map[x-1][y]==1 && !w.isVisited(cX, cY + 1)))
										{
											{

												t1 = 1;
												
												d = 3;
											}
										}
								}

							}
							if (w.isVisited(cX + 1, cY)) 
							{

								if ((y+1)<=3)
								{   
									if((x-1)>=0)
									if ((!w.isVisited(cX + 1, cY + 1) && map[x-1][y + 1] == 1) || (map[x][y+1]==1 && !w.isVisited(cX+1, cY )))
									{

										t1 = 1;
										
										d = 1;
									}
									else
									if(x+1<=3)
										if((!w.isVisited(cX + 1, cY - 1) && map[x + 1][y +1] == 1) || (map[x][y+1]==1 && !w.isVisited(cX+1, cY )))
										{
											{

												t1 = 1;
												
												d = 1;
											}
										}
								}
							}
							if (w.isVisited(cX, cY - 1)) 
							{

								if ((x+1)<=3)
								{   
									if((y+1)<=3)
									if ((!w.isVisited(cX + 1, cY - 1) && map[x+1][y + 1] == 1) || (map[x+1][y]==1 && !w.isVisited(cX, cY-1 )))
									{

										t1 = 1;
										System.out.print("fghj65432");
										d = 4;
									}
									else
									if(y-1>=0)
										if((!w.isVisited(cX - 1, cY - 1) && map[x - 1][y - 1] == 1)  || (map[x+1][y]==1 && !w.isVisited(cX, cY-1 )))
										{
											{

												t1 = 1;
												System.out.print("fghj65432");
												d = 4;
											}
										}
								}

							}
							
								
								
							if (w.isVisited(cX-1, cY ))
							{  
								System.out.print("fghj65432");
								
								if ((y-1)>=0)
								{
									if((x+1)<=3 )
									{
									if ((!w.isVisited(cX - 1, cY - 1) && map[x+1][y- 1] == 1) || (map[x][y-1]==1 && !w.isVisited(cX-1, cY )))
									{
										// move left
										t1 = 1;
										d = 2;
										System.out.print("fghj");
										
									}
									}
								
								if((x-1)>=0)
										if((!w.isVisited(cX - 1, cY + 1) && map[x - 1][y - 1] == 1) || (map[x][y-1]==1 && !w.isVisited(cX-1, cY )))
										{
											// move left
											t1 = 1;
											d = 2;
											System.out.print("fghj");
											
										}
								}
							}
							else
							{
							if((y-1)>=0)
							if(map[x][y-1]==1 && !w.isVisited(cX-1, cY ))
								{
										// move left
									t1 = 1;
									d = 2;
								System.out.print("fghj");
										
								}
										
						}	
						
						
						
						
						
						
						}
						
						
						
						
						
							for(int i=0;i<4;i++)
							{
								for(int j=0;j<4;j++)
									System.out.print(map[i][j]);
								System.out.println();
							}
							System.out.println("fghj");
							System.out.println(d);
							System.out.println("fghj");
                          if(t1==1)
							switch (d) {
							           
							case 1: direction(1);
							        break;
							case 2: direction(2);
							         break;
							case 3: direction(3);
							         break;
							case 4: direction(4);
							            break;
							}

							if (t1 != 1) {
								pa = 0;
								count = 0;
								path(map, a, x, y, -1, 0);
								if (pa != 1)
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (!w.isVisited(i+1, j+1))
												count++;
								if (count <= 2) {
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (!w.isVisited(i+1, j+1)) {
												minscore = 100;
												
												pathDestination(map, a, x, y, -1, 0, 0, i, j);

											      switch (b[0]) {
												case 1:
													direction(1);
													break;
												case 2: // left
													direction(2);
													break;
												case 3: // up
													direction(3);
													break;
												case 4: // down
													direction(4);
													break;
												case 5: // shoot
												

													w.doAction(World.A_SHOOT);
													break;
												case 6:
												
													w.doAction(World.A_SHOOT);
													break;
												case 7:
													
													w.doAction(World.A_SHOOT);
													break;
												case 8:
										
													w.doAction(World.A_SHOOT);
													break;
												default: // random
													break;
												}
											
												
											}

								} else if (pa != 1) {
									minvalue = 100;
									pb = 0;
									t = 1;
									pathbreeze(map, a, x, y, -1, 0);
								}
							}
						}
		
		
		
	
	public void breezeMethod(int[][] map, int cX, int cY, int x, int y) {

		int count = 0,  t1 = 0, d = 0,X=0,Y=0;
		int a[] = new int[16];

		map[x][y] = -4;
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
        
		if (x - 1 >= 0) 
		{
			if (!w.isVisited(cX, cY + 1)) 
			{

				if (map[x - 1][y] != 1 && map[x - 1][y] != -7 && map[x - 1][y] != -5 && map[x - 1][y] != -4 && map[x- 1][y] != -2) 
				{

					if (map[x - 1][y] == 3 || map[x - 1][y] == 7)
						map[x - 1][y] = 4;
					else
						map[x - 1][y] = map[x - 1][y] + 2;

					count++;
					X = x - 1;
					Y = y;
				}
				
			}
			if(map[x-1][y]==-2)
				count++;
		}
		if (y + 1 <= 3) 
		{
			if (!w.isVisited(cX + 1, cY)) 
			{
				if (map[x][y + 1] != 1 && map[x][y + 1] != -7 && map[x][y + 1] != -5 && map[x][y + 1] != -4 && map[x][y+1] != -2) 
				{

					if (map[x][y + 1] == 3 || map[x][y + 1] == 7)
						map[x][y + 1] = 4;
					else
						map[x][y + 1] = map[x][y + 1] + 2;
					count++;
					x = x;
					Y = y + 1;

				}
			
			}
			if(map[x][y+1]==-2)
				count++;
		}
		if (x + 1 <= 3) 
		{
			if (!w.isVisited(cX, cY - 1)) {
				if (map[x + 1][y] != 1 && map[x + 1][y] != -7 && map[x+ 1][y] != -5 && map[x + 1][y] != -4 && map[x+ 1][y] != -2) 
				{

					if (map[x + 1][y] == 3 || map[x + 1][y] == 7)
						map[x + 1][y] = 4;
					else
						map[x + 1][y] = map[x+ 1][y] + 2;
					count++;
					x = x + 1;
					Y = y;
				}
				
			}
			if(map[x+1][y]==-2)
				count++;
		}
		if (y - 1 >= 0) 
		{
			if (!w.isVisited(cX - 1, cY)) 
			{
				if (map[x][y - 1] != 1 && map[x][y - 1] != -7 && map[x][y - 1] != -5 && map[x][y - 1] != -4 && map[x][y-1] != -2)
				{
					if (map[x][y - 1] == 3 || map[x][y - 1] == 7)
						map[x][y - 1] = 4;
					else
						map[x][y - 1] = map[x][y - 1] + 2;
					count++;
					X = x;
					Y = y - 1;
				}
				
			}
			if(map[x][y-1]==-2)
				count++;  
		}
		System.out.println(count);
		if (count == 1) {
			map[x][y]=1;
			map[X][Y] = -2;
		}
		System.out.println("khvjbvhjbvjhbhcrdbfhddchjfhebhvhjvmjnddbvnsdvbjhdgsjvhjdsbv");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}

		if (w.isVisited(cX, cY + 1)) 
		{
			if ((x-1)>= 0)
			{   
				if((y+1)<=3)
				if ((!w.isVisited(cX + 1, cY + 1) && map[x-1][y + 1] == 1) || (map[x-1][y]==1 && !w.isVisited(cX, cY + 1)))
				{

					t1 = 1;
					
					d = 3;
				}
				else
				if(y-1>=0)
					if((!w.isVisited(cX - 1, cY + 1) && map[x - 1][y - 1] == 1) || (map[x-1][y]==1 && !w.isVisited(cX, cY + 1)))
					{
						{

							t1 = 1;
							
							d = 3;
						}
					}
			}

		}
		if (w.isVisited(cX + 1, cY)) 
		{

			if ((y+1)<=3)
			{   
				if((x-1)>=0)
				if ((!w.isVisited(cX + 1, cY + 1) && map[x-1][y + 1] == 1) || (map[x][y+1]==1 && !w.isVisited(cX+1, cY )))
				{

					t1 = 1;
					
					d = 1;
				}
				else
				if(x+1<=3)
					if((!w.isVisited(cX + 1, cY - 1) && map[x + 1][y +1] == 1) || (map[x][y+1]==1 && !w.isVisited(cX+1, cY )))
					{
						{

							t1 = 1;
							
							d = 1;
						}
					}
			}
		}
		if (w.isVisited(cX, cY - 1)) 
		{

			if ((x+1)<=3)
			{   
				if((y+1)<=3)
				if ((!w.isVisited(cX + 1, cY - 1) && map[x+1][y + 1] == 1) || (map[x+1][y]==1 && !w.isVisited(cX, cY-1 )))
				{

					t1 = 1;
					System.out.print("fghj65432");
					d = 4;
				}
				else
				if(y-1>=0)
					if((!w.isVisited(cX - 1, cY - 1) && map[x - 1][y - 1] == 1)  || (map[x+1][y]==1 && !w.isVisited(cX, cY-1 )))
					{
						{

							t1 = 1;
							System.out.print("fghj65432");
							d = 4;
						}
					}
			}

		}
		
			
			
		if (w.isVisited(cX-1, cY ))
		{  
			System.out.print("fghj65432");
			
			if ((y-1)>=0)
			{
				if((x+1)<=3 )
				{
				if ((!w.isVisited(cX - 1, cY - 1) && map[x+1][y- 1] == 1) || (map[x][y-1]==1 && !w.isVisited(cX-1, cY )))
				{
					// move left
					t1 = 1;
					d = 2;
					System.out.print("fghj");
					
				}
				}
			
			if((x-1)>=0)
					if((!w.isVisited(cX - 1, cY + 1) && map[x - 1][y - 1] == 1) || (map[x][y-1]==1 && !w.isVisited(cX-1, cY )))
					{
						// move left
						t1 = 1;
						d = 2;
						System.out.print("fghj");
						
					}
			}
		}
		else
		{
		if((y-1)>=0)
		if(map[x][y-1]==1 && !w.isVisited(cX-1, cY ))
			{
					// move left
				t1 = 1;
				d = 2;
			System.out.print("fghj");
					
			}
					
	}
		
		System.out.println("before d");
		System.out.println(d);
		System.out.println("after d");
		System.out.println(t1);
       
		switch (d) {
		           
		case 1: direction(1);
		        break;
		case 2: direction(2);
		         break;
		case 3: direction(3);
		         break;
		case 4: direction(4);
		            break;
		}
     
		System.out.println(t1);
		System.out.println("zsdfghjkldfghj");
		if (t1 != 1) {
			pa = 0;
			count = 0;
			System.out.println("zsdfghjkldfghj");
			path(map, a, x, y, -1, 0);
			System.out.println("pa");
			System.out.println(pa);
			if (pa != 1)
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (!w.isVisited(i+1, j+1))
							count++;

			if (count <= 2 && pa!=1) {
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (!w.isVisited(i+1, j+1)) {
							minscore = 100;
							System.out.println(map[2][1]);
							System.out.println("zsdfghjkldfghj");
							pathDestination(map, a, x, y, -1, 0, 0, i, j);
							int cur_direction = w.getDirection();
							switch (a[0]) {
							case 1: // right
								directionIntoRequired(cur_direction, 1);
								w.doAction(World.A_MOVE);
								break;
							case 2: // left
								directionIntoRequired(cur_direction, 3);
								w.doAction(World.A_MOVE);
								break;
							case 3: // up
								directionIntoRequired(cur_direction, 0);
								w.doAction(World.A_MOVE);
								break;
							case 4: // down
								directionIntoRequired(cur_direction, 2);
								w.doAction(World.A_MOVE);
								break;
							case 5: // shoot
								directionIntoRequired(cur_direction, 1);

								w.doAction(World.A_SHOOT);
								break;
							case 6:
								directionIntoRequired(cur_direction, 3);
								w.doAction(World.A_SHOOT);
								break;
							case 7:
								directionIntoRequired(cur_direction, 0);
								w.doAction(World.A_SHOOT);
								break;
							case 8:
								directionIntoRequired(cur_direction, 2);
								w.doAction(World.A_SHOOT);
								break;
							default: // random
								break;
							}

							break;
						}

			} else if (pa != 1) {
				minvalue = 100;
				System.out.println(map[2][1]);
				pb = 0;
				t = 1;
				System.out.println("dfghj");
				pathbreeze(map, a, x, y, -1, 0);
			}
		}

	}
	

	public void strenchMethod(int[][] map, int cX, int cY, int x, int y) {

		int count = 0, Y = 0, X = 0, t1 = 0, d = 0,count1=0,d1=0 ;

		int[] a = new int[16];
		map[x][y] = -5;
		System.out.println(x);
		System.out.println(y);
		System.out.println("cvbn");
		path=0;
		k=1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		
		if (x-1 >= 0) 
		{
			if (!w.isVisited(cX, cY + 1)) 
			{
				if (map[x-1][y] != 1 && map[x-1][y] != -7 && map[x-1][y] != -4) 
				{
					if (!(map[ x- 1][y] % 2 == 0 && map[x-1][y] > 0)) 
					{
						if (map[x-1][y] == 3 || map[x-1][y] == 7) 
						{

							count1++;
							X = x-1;
							Y = y;
						   
							d = 3;
							
						}    else 
							{
								X = x - 1;
								Y = y;
								map[x - 1][y] = 3;
								d1=3;
								count++;
							}
				   }		
				}
			 }
		  }			

			if (y + 1 <= 3)
			{
				if (!w.isVisited(cX + 1, cY)) 
				{
					if (map[x][y + 1] != 1 && map[x][y + 1] != -7 && map[x][y + 1] != -5 && map[x][y + 1] != -4)
					{
						if (!(map[x][y + 1] % 2 == 0 && map[x][y+1] > 0)) 
						{
							if (map[x][y + 1] == 3 || map[x][y + 1] == 7)
							{

								count1++;
								X = x;
								Y = y + 1;
								
					           d=1;
								
							}else {
									X = x;
									Y = y + 1;
									d1=1;
									map[x][y + 1] = 3;
									count++;
								}
							}
						}
					}

				}
				if (x + 1 <= 3) 
				{
					if (!w.isVisited(cX, cY - 1)) 
					{
						if (map[x+1][y] != 1 && map[x + 1][y] != -7 &&  map[x + 1][y] != -4 && map[x + 1][y] != -5 ) 
						{
							if (!(map[x + 1][y] % 2 == 0 && map[x+1][y] > 0)) 
							{
								if (map[x + 1][y] == 3 || map[x + 1][y] == 7) 
								{

									count1++;
									X = x + 1;
									 d=4;
									Y = y;
									
									} else {
										X = x + 1;
										Y = y;
										d1=4;
										map[x+ 1][y] = 3;
										count++;

									}
								}
								
							}
						}
					}
				
					
	             if (y - 1 >= 0)
					{
						if (!w.isVisited(cX - 1, cY)) 
						{
							if (map[x][y - 1] != 1 && map[x][y - 1] != -7 && map[x][y - 1] != -5 && map[x][y - 1] != -4)
							{
								if (!(map[x][y - 1] % 2 == 0 && map[x][y - 1] > 0))
								{
									if (map[x][y - 1] == 3 || map[x][y - 1] == 7)
									{

										count1++;
										X = x;
										y = y - 1;
										 d=2;
										
										} else {
											X = x;
											Y = y - 1;
											map[x][y - 1] = 3;
											d1=2;
											count++;
										}
									}
								}
							}
						}
					
	
					for(int i=0;i<4;i++)
						{
							for(int j=0;j<4;j++)
								System.out.print(map[i][j]);
							System.out.println();
						}
					System.out.println(count);
					if(count1==1)
					{
						
						
							count = 2;
							wumpus = 1;
							map[x][y] = 1;
							arrow(d);
							
							for (int i = 0; i < 4; i++)
								for (int j = 0; j < 4; j++) {
									if (map[i][j] == 3  || map[i][j]==-5 )
										map[i][j] = 1;
									if (map[i][j] == 7)
										map[i][j] = 2;
								}
							return ;	
				
					}
						
					
						if (count == 1) {
							System.out.println("dfghj");
							wumpus = 1;
							map[x][y] = 1;
							arrow(d1);
							

							for (int i = 0; i < 4; i++)
								for (int j = 0; j < 4; j++) {
									if (map[i][j] == 3 || map[i][j]==-5)
										map[i][j] = 1;
									if (map[i][j] == 7)
										map[i][j] = 2;
								}
							
							
							
						} 
						else 
						{
							if (w.isVisited(cX, cY + 1)) 
							{
								if ((x-1)>= 0)
								{   
									if((y+1)<=3)
									if ((!w.isVisited(cX + 1, cY + 1) && map[x-1][y + 1] == 1) )
									{

										t1 = 1;
										
										d = 3;
									}
									else
									if(y-1>=0)
										if((!w.isVisited(cX - 1, cY + 1) && map[x - 1][y - 1] == 1))
										{
											{

												t1 = 1;
												
												d = 3;
											}
										}
								}

							}
							if (w.isVisited(cX + 1, cY)) 
							{

								if ((y+1)<=3)
								{   
									if((x-1)>=0)
									if ((!w.isVisited(cX + 1, cY + 1) && map[x-1][y + 1] == 1) )
									{

										t1 = 1;
										
										d = 1;
									}
									else
									if(x+1<=3)
										if((!w.isVisited(cX + 1, cY - 1) && map[x + 1][y +1] == 1))
										{
											{

												t1 = 1;
												
												d = 1;
											}
										}
								}
							}
							if (w.isVisited(cX, cY - 1)) 
							{

								if ((x+1)<=3)
								{   
									if((y+1)<=3)
									if ((!w.isVisited(cX + 1, cY - 1) && map[x+1][y + 1] == 1) )
									{

										t1 = 1;
										
										d = 4;
									}
									else
									if(y-1>=0)
										if((!w.isVisited(cX - 1, cY - 1) && map[x - 1][y - 1] == 1))
										{
											{

												t1 = 1;
												
												d = 4;
											}
										}
								}

							}
							if (w.isVisited(cX-1, cY ))
							{  
								System.out.print("fghj65432");
								
								if ((y-1)>=0)
								{
									if((x+1)<=3 )
									{
									if ((map[x+1][y- 1] == 1))
									{
										// move left
										t1 = 1;
										d = 2;
										System.out.print("fghj");
										
									}
									}
								
								if((x-1)>=0)
										if((map[x - 1][y - 1] == 1))
										{
											// move left
											t1 = 1;
											d = 2;
											System.out.print("fghj");
											
										}
								}
							}
						
							for(int i=0;i<4;i++)
							{
								for(int j=0;j<4;j++)
									System.out.print(map[i][j]);
								System.out.println();
							}
							System.out.println("fghj");
							System.out.println(d);
							System.out.println("fghj");

							switch (d) {
							           
							case 1: direction(1);
							        break;
							case 2: direction(2);
							         break;
							case 3: direction(3);
							         break;
							case 4: direction(4);
							            break;
							}

							if (t1 != 1) {
								pa = 0;
								count = 0;
								path(map, a, x, y, -1, 0);
								if (pa != 1)
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (!w.isVisited(i+1, j+1))
												count++;
								if (count <= 2) {
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (!w.isVisited(i+1, j+1)) {
												minscore = 100;
												int cur_direction2 = w.getDirection();
												pathDestination(map, a, x, y, -1, 0, 0, i, j);

												switch (b[0]) {
												case 1: // right
													directionIntoRequired(cur_direction2, 1);
													w.doAction(World.A_MOVE);
													break;
												case 2: // left
													directionIntoRequired(cur_direction2, 3);
													w.doAction(World.A_MOVE);
													break;
												case 3: // up
													directionIntoRequired(cur_direction2, 0);
													w.doAction(World.A_MOVE);
													break;
												case 4: // down
													directionIntoRequired(cur_direction2, 2);
													w.doAction(World.A_MOVE);
													break;
												case 5: // shoot
													directionIntoRequired(cur_direction2, 1);

													w.doAction(World.A_SHOOT);
													break;
												case 6:
													directionIntoRequired(cur_direction2, 3);
													w.doAction(World.A_SHOOT);
													break;
												case 7:
													directionIntoRequired(cur_direction2, 0);
													w.doAction(World.A_SHOOT);
													break;
												case 8:
													directionIntoRequired(cur_direction2, 2);
													w.doAction(World.A_SHOOT);
													break;
												default: // random
													break;
												}

												break;
											}

								} else if (pa != 1) {
									minvalue = 100;
									pb = 0;
									t = 1;
									pathbreeze(map, a, x, y, 0, 0);
								}
							}
						}
		
			}

	public void isMoveIsPossible() {

	}

	/**
	 * Asks your solver agent to execute an action.
	 */

	public void doAction() {

		// Location of the player
		int cX = w.getPlayerX();
		int cY = w.getPlayerY();

		int transformX = 4 - cY;
		int transformY = cX - 1;
         for(int i=0;i<=fp;i++)
        	 System.out.print(fp);
	    if(path==1) {
	    	if(k<=(fp))
				direction(b[k]);
	    	System.out.println("nsbongdsdha ");
	    	for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
			k++;
			if(k==(fp+1)) {
				path=0;
				System.out.println(k);
				System.out.println("path is zero ");
			k=1;}
	    	
	    }
	    else
	    {
	    	if(w.hasGlitter(cX, cY) && w.hasBreeze(cX, cY))
	    	{
	    		w.doAction(World.A_GRAB);
			    return;
	    	}
		if (w.hasBreeze(cX, cY) && w.hasStench(cX, cY)) {
			if (wumpus == 0)
				breezeAndStrenchMethod(map, cX, cY, transformX, transformY);
			else
				breezeMethod(map, cX, cY, transformX, transformY);
		} else if (w.hasBreeze(cX, cY) && map[transformX][transformY]!=-4 && map[transformX][transformY]!=-2) {
			breezeMethod(map, cX, cY, transformX, transformY);
		} else if (w.hasStench(cX, cY)) {
			strenchMethod(map, cX, cY, transformX, transformY);
		} else if (w.hasGlitter(cX, cY) ) {
			w.doAction(World.A_GRAB);
			return;
		} else if (w.isInPit()) {
			int dir=0;
			int[] a = new int[50];
			map[transformX][transformY]=-2;
			
			w.doAction(World.A_CLIMB);
			if(transformY + 1 <=3)
				if(!w.isVisited(cX+1 , cY) )
					{
					dir=1;
					direction(1);
					}
			if(dir!=1)
			if(transformY - 1 >= 0 )
				if((!w.isVisited(cX-1 , cY)) )
					{
					dir=1;
					direction(2);
					}
			if(dir!=1)	
			if(transformX - 1 >= 0 )
				if(!w.isVisited(cX , cY+1) )
					{
					dir=1;
					direction(3);
					System.out.println("na bongdsdha ");
					}
			
			if(dir!=1)		
			if(transformX + 1 <= 3 )
				if(!w.isVisited(cX , cY-1) )
					{
					dir=1;
					direction(4);
					}
				if(dir==1)
				{   
					pa=0;
					path(map, a, transformX, transformY, -1, 0);
				}
			return;
		} 
			
			
		          
		else
		{  
			
			System.out.println("plz");
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}

			System.out.println(transformY);
			int count = 0, x1 = 0, y1 = 0;
              int dir=0;
              
			int[] a = new int[50];
			if (map[transformX][transformY] != -4 && map[transformX][transformY] != -5
					&& map[transformX][transformY] != -7 && map[transformX][transformY] != -2 )
				map[transformX][transformY] = 1;
	
			if (transformX - 1 >= 0 && map[transformX - 1][transformY] != -4 && map[transformX - 1][transformY] != -5
					&& map[transformX - 1][transformY] != -7)
				map[transformX - 1][transformY] = 1;
			if (transformY + 1 <= 3 && map[transformX][transformY + 1] != -4 && map[transformX][transformY + 1] != -5
					&& map[transformX][transformY + 1] != -7)
				map[transformX][transformY + 1] = 1;
			if (transformX + 1 <= 3 && map[transformX + 1][transformY] != -4 && map[transformX + 1][transformY] != -5
					&& map[transformX + 1][transformY] != -7)
				map[transformX + 1][transformY] = 1;
			if (transformY - 1 >= 0 && map[transformX][transformY - 1] != -4 && map[transformX][transformY - 1] != -5
					&& map[transformX][transformY - 1] != -7)
				map[transformX][transformY - 1] = 1;
			System.out.println("transformY");
	
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (map[i][j] == -4) {
						if((i - 1 <= 3 && i - 1 >= 0))
						if (map[i - 1][j] != 1 && (i - 1 <= 3 && i - 1 >= 0) && map[i - 1][j] != 3
								&& map[i - 1][j] != -4 && map[i - 1][j] != -3 && map[i - 1][j] != -5  ) {
							count++;

							x1 = i - 1;
							y1 = j;
						}
						if((i + 1 <= 3 && i + 1 >= 0))
						if (map[i + 1][j] != 1 && (i + 1 <= 3 && i + 1 >= 0) && map[i + 1][j] != 3
								&& map[i + 1][j] != -3 && map[i + 1][j] != -4 && map[i + 1][j] != -5 ) {
							count++;

							x1 = i + 1;
							y1 = j;
						} 
						if((j + 1 <= 3 && j + 1 >= 0))
						if (map[i][j + 1] != 1 && (j + 1 <= 3 && j + 1 >= 0) && map[i][j + 1] != 3
								&& map[i][j + 1] != -4 && map[i][j + 1] != -3 && map[i][j + 1] != -5 ) {
							count++;

							x1 = i;
							y1 = j + 1;
						}
						if((j - 1 >= 0 && j - 1 >= 0))
						if (map[i][j - 1] != 1 && (j - 1 >= 0 && j - 1 >= 0) && map[i][j - 1] != 3
								&& map[i][j - 1] != -4 && map[i][j - 1] != -3 && map[i][j - 1] != -5 ) {
							count++;

							x1 = i;
							y1 = j - 1;
						}
						if (count == 1) {
							map[x1][y1] = -2;
							map[i][j]=1;
						}
					}
					count = 0;
				}
			}
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
			
			System.out.println(path);
			System.out.println(map[2][1]);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (map[i][j] == -5) {
						if((i - 1 <= 3 && i - 1 >= 0))
						if (map[i - 1][j] != 1 && (i - 1 <= 3 && i - 1 >= 0) && map[i - 1][j] % 2 != 0
								&& map[i - 1][j] != -4) {
							count++;

							x1 = i - 1;
							y1 = j;
						}
						if((i + 1 <= 3 && i + 1 >= 0))
						if (map[i + 1][j] != 1 && (i + 1 <= 3 && i + 1 >= 0) && map[i + 1][j] % 2 != 0
								&& map[i + 1][j] != -4) {
							count++;

							x1 = i + 1;
							y1 = j;
						} 
						if((j + 1 <= 3 && j + 1 >= 0))
						if (map[i][j + 1] != 1 && (j + 1 <= 3 && j + 1 >= 0) && map[i][j + 1] % 2 != 0
								&& map[i][j + 1] != -4) {
							count++;

							x1 = i;
							y1 = j + 1;
						}
						if((j - 1 <= 3 && j - 1 >= 0))
						if (map[i][j - 1] != 1 && (j - 1 <= 3 && j - 1 >= 0) && map[i][j - 1] % 2 != 0
								&& map[i][j - 1] != -4) {
							count++;

							x1 = i;
							y1 = j - 1;
						}
						if (count == 1) {
							wumpus = 1;
							map[x1][y1] = -3;

						}

					}
					count = 0;
				}
			}
			
			pa = 0;
			count = 0;
			System.out.println("na bondhadtrfgyuihojpk[lp ");
			System.out.print(transformX);
			if(!w.isVisited(cX , cY+1))
				System.out.println();
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
			if(transformY + 1 <=3)
				if(!w.isVisited(cX+1 , cY) && map[transformX][transformY+1]==1)
					{
					dir=1;
					direction(1);
					}
			if(dir!=1)
			if(transformY - 1 >= 0 )
				if((!w.isVisited(cX-1 , cY)) && map[transformX][transformY-1]==1)
					{
					dir=1;
					direction(2);
					}
			if(dir!=1)	
			if(transformX - 1 >= 0 )
				if(!w.isVisited(cX , cY+1) && map[transformX-1][transformY]==1)
					{
					dir=1;
					direction(3);
					System.out.println("na bongdsdha ");
					}
			
			if(dir!=1)		
			if(transformX + 1 <= 3 )
				if(!w.isVisited(cX , cY-1) && map[transformX+1][transformY]==1)
					{
					dir=1;
					direction(4);
					}
				
			if(dir!=1)
			{ 
				pa=0;
			   path(map, a, transformX, transformY, -1, 0);
			}
			
			System.out.println("dfghjksdfghjsdfghjdfghjdfghjkl78152552");
			System.out.println("dfghjksdfghjsdfghjdfghjdfghjkl78152552");
			System.out.println("dfghjksdfghjsdfghjdfghjdfghjkl78152552");
			System.out.println("dfghjksdfghjsdfghjdfghjdfghjkl78152552");
		    if(dir!=1)
			if (pa != 1)
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (!w.isVisited(i+1, j+1))
							count++;
		    
		    System.out.println("dfghjksdfghjsdfghjdfghjdfghjkl7815255212345678");
		    for(int i=0;i<=fp;i++)
		    	System.out.println(pa);
		    for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
					
				System.out.println();
			}
		    if(dir!=1 && pa==0)
			if (count <= 2 ) 
			{
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (!w.isVisited(i+1, j+1)) 
						{
							minscore = 100;
							System.out.println("dfghjksdfghjsdfghjdfghjdfghjkl781");
							pathDestination(map, a, transformX, transformY, -1, 0, 0, i, j);
							System.out.println(pd);
						
						      switch (b[0]) {
							case 1:
								direction(1);
								break;
							case 2: // left
								direction(2);
								break;
							case 3: // up
								direction(3);
								break;
							case 4: // down
								direction(4);
								break;
							case 5: // shoot
							

								w.doAction(World.A_SHOOT);
								break;
							case 6:
							
								w.doAction(World.A_SHOOT);
								break;
							case 7:
								
								w.doAction(World.A_SHOOT);
								break;
							case 8:
					
								w.doAction(World.A_SHOOT);
								break;
							default: // random
								break;
							}
							
							
						}

			} else if (pa != 1 ) {
				minvalue = 100;
				pb = 0;
				t = 1;
				System.out.println("dfghjksdfghjsdfghjdfghjdfghjkl781");
				pathbreeze(map, a, transformX, transformY, -1, 0);
				
			}
			
		}
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
	

	}

	/**
	 * Genertes a random instruction for the Agent.
	 */
	public int decideRandomMove() {
		return (int) (Math.random() * 4);
	}

	public void directionIntoRequired(int cur_dir, int req_dir) {
		int diff = cur_dir - req_dir;
		if (diff == 2 || diff == -2) {

			w.doAction(World.A_TURN_RIGHT);
			w.doAction(World.A_TURN_RIGHT);
		} else if (diff == 1 || diff == -3) {
			w.doAction(World.A_TURN_RIGHT);
		} else if (diff == -1 || diff == 3) {
			w.doAction(World.A_TURN_LEFT);
		}

	}

}
