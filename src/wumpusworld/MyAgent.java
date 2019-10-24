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

	public void doAction() {

		// Location of the player
		int cX = w.getPlayerX();
		int cY = w.getPlayerY();

		int transformX = 4 - cX;
		int transformY = cY - 1;

		int[][] pitArray = new int[4][4];
		int[][] mapArray = new int[4][4];
		int[][] wumpusArray = new int[4][4];

		if (w.hasBreeze(cX, cY) && w.hasStench(cX, cY)) {

		} else if (w.hasBreeze(cX, cY)) {

		} else if (w.hasStench(cX, cY)) {

			int count = 0, x = 0, y = 0;

			mapArray[transformX][transformY] = 1;

			if (transformX - 1 >= 0) {
				if (!w.isVisited(cX, cY + 1)) {
					wumpusArray[transformX - 1][transformY] = 3;
					count++;
					x = transformX;
					y = transformY + 1;
				}
			}
			if (transformY + 1 <= 3) {
				if (!w.isVisited(cX + 1, cY)) {
					wumpusArray[transformX][transformY + 1] = 3;
					count++;
					x = transformX + 1;
					y = transformY;

				}
			}
			if (transformX + 1 <= 3) {
				if (!w.isVisited(cX, cY - 1)) {
					wumpusArray[transformX + 1][transformY] = 3;
					count++;
					x = transformX;
					y = transformY - 1;
				}
			}
			if (transformY - 1 >= 0) {
				if (!w.isVisited(cX - 1, cY)) {
					wumpusArray[transformX][transformY - 1] = 3;
					count++;
					x = transformX - 1;
					y = transformY;
				}
			}

			if (count == 1) {
				wumpusArray[x][y] = 3;
				// shoot arrow
			} else {

				if (w.isVisited(cX, cY + 1)) {

					if (!w.isVisited(cX + 1, cY + 1)) {
						// move right
					}
					if (!w.isVisited(cX - 1, cY + 1)) {
						// move left
					}
				}
				if (w.isVisited(cX + 1, cY)) {

					if (!w.isVisited(cX, cY + 1)) {
						// move up
					}
					if (!w.isVisited(cX, cY - 1)) {
						// move down
					}
				}
				if (w.isVisited(cX, cY - 1)) {
					if (!w.isVisited(cX + 1, cY - 1)) {
						// move right
					}
					if (!w.isVisited(cX - 1, cY - 1)) {
						// move left
					}

				}
				if (w.isVisited(cX - 1, cY)) {
					if (!w.isVisited(cX - 1, cY + 1)) {
						// move up
					}
					if (!w.isVisited(cX - 1, cY - 1)) {
						// move down
					}
				}

			}
//rahul demo
		} else {
			mapArray[transformX][transformY] = 1;

			if (transformX - 1 >= 0)
				mapArray[transformX - 1][transformY] = 1;
			if (transformY + 1 <= 3)
				mapArray[transformX][transformY + 1] = 1;
			if (transformX + 1 <= 3)
				mapArray[transformX + 1][transformY] = 1;
			if (transformY - 1 >= 0)
				mapArray[transformX][transformY - 1] = 1;

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
