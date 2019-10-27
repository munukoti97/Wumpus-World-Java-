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
	int wumpus = 0, pa = 0, pb = 0, minvalue = 100, t = 1, minscore = 100, k1;

	/**
	 * Creates a new instance of your solver agent.
	 * 
	 * @param world Current world statea
	 */
	public MyAgent(World world) {
		w = world;
	}

	public void pathDestination(int[][] map, int[] a, int x, int y, int c1, int move, int score, int fx, int fd) {

		int k;

		if (x == fx && y == fd) {
			if (minscore >= score) {
				minscore = score;
				k1 = a[0];
			}
		}

		else {
			if (map[x][y] % 2 == 0 && map[x][y] > 0) {
				k = map[x][y] / 2;
				score = score + k;

			}
			if (map[x][y] != 3 && map[x][y] != 7 && map[x][y] != -3 && map[x][y] != -2) {
				if (move != 1 && (y + 1) <= 3) {

					// movie right

					if (map[x][y + 1] == -3) {

						c1++;
						a[c1] = 5;
						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						c1--;
					} else {
						c1++;
						a[c1] = 1;
						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 2 && (y - 1) >= 0) {
					if (map[x][y - 1] == -3) {

						c1++;
						a[c1] = 6;
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 2;
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 3 && x - 1 >= 0) {
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
				if (move != 4 && x + 1 <= 3) {
					if (map[x + 1][y] == -3) {

						c1++;
						a[c1] = 8;
						path(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;
					} else {

						c1++;
						a[c1] = 4;
						path(map, a, x + 1, y, c1, 3);
						c1--;
					}
				}

			}

		}
	}

	public void pathbreeze(int[][] map, int[] a, int x, int y, int c1, int move) {
		int l = 0;

		if (map[x][y] % 2 == 0 && map[x][y] > 0) {

			if (minvalue >= a[c1] || t == 1) {
				t++;
				minvalue = a[c1];

			}
			if (minvalue == 2) {
				pb = 1;
				l = 1;
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
			}
			if (t == 3 && l != 1 && minvalue < 6) {
				pb = 1;
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

			}
		}

		else {
			if (map[x][y] != 3 && map[x][y] != 7 && map[x][y] != -3 && pb != 1 && map[x][y] != -4) {
				if (move != 1 && (y + 1) <= 3) {

					// movie right

					if (map[x][y + 1] == -3) {
						c1++;
						a[c1] = 5;

						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;

						c1--;
					} else {
						c1++;
						a[c1] = 1;
						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 2 && (y - 1) >= 0) {
					if (map[x][y - 1] == -3) {
						c1++;
						a[c1] = 6;
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 2;
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 3 && x - 1 >= 0) {
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
				if (move != 4 && x + 1 <= 3) {
					if (map[x + 1][y] == -3) {
						c1++;
						a[c1] = 8;
						path(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 4;
						path(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;
					}
				}

			}

		}

	}

	public void path(int[][] map, int[] a, int x, int y, int c1, int move) {

		if (map[x][y] == 0) {

			pa = 1;
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
		}

		else {
			if (map[x][y] % 2 == 0 && map[x][y] != 3 && map[x][y] != 7 && map[x][y] != -3 && pa == 0) {
				if (move != 1 && (y + 1) <= 3) {

					// movie right

					if (map[x][y + 1] == -3) {
						c1++;
						a[c1] = 5;
						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						c1--;

					} else {
						c1++;
						a[c1] = 1;
						path(map, a, x, y + 1, c1, 2);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 2 && (y - 1) >= 0) {
					if (map[x][y - 1] == -3) {

						c1++;
						a[c1] = 6;
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;
					} else {

						c1++;
						a[c1] = 2;
						path(map, a, x, y - 1, c1, 1);
						a[c1] = 0;
						c1--;
					}
				}
				if (move != 3 && x - 1 >= 0) {
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
				if (move != 4 && x + 1 <= 3) {
					if (map[x + 1][y] == -3) {
						c1++;
						a[c1] = 8;
						path(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;

					} else {

						c1++;
						a[c1] = 4;
						path(map, a, x + 1, y, c1, 3);
						a[c1] = 0;
						c1--;
					}
				}
			}

		}

	}

	public void breezeAndStrenchMethod(int[][] map, int cX, int cY, int transformX, int transformY) {

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
											if (map[i][j] == 0)
												count++;
								if (count <= 2) {
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (map[i][j] == 0) {
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

	public void breezeMethod(int[][] map, int cX, int cY, int transformX, int transformY) {

		int count = 0, x = 0, y = 0, t1 = 0, d = 0;
		int a[] = new int[16];

		map[transformX][transformY] = -4;

		if (transformX - 1 >= 0) {
			if (!w.isVisited(cX, cY + 1)) {

				if (map[transformX - 1][transformY] != 1 && map[transformX - 1][transformY] != -7
						&& map[transformX - 1][transformY] != -5 && map[transformX - 1][transformY] != -4) {

					if (map[transformX - 1][transformY] == 3 || map[transformX - 1][transformY] == 7)
						map[transformX - 1][transformY] = 4;
					else
						map[transformX - 1][transformY] = map[transformX - 1][transformY] + 2;

					count++;
					x = transformX - 1;
					y = transformY;
				}
			}
		}
		if (transformY + 1 <= 3) {
			if (!w.isVisited(cX + 1, cY)) {
				if (map[transformX][transformY + 1] != 1 && map[transformX][transformY + 1] != -7
						&& map[transformX][transformY + 1] != -5 && map[transformX][transformY + 1] != -4) {

					if (map[transformX][transformY + 1] == 3 || map[transformX][transformY + 1] == 7)
						map[transformX][transformY + 1] = 4;
					else
						map[transformX][transformY + 1] = map[transformX][transformY + 1] + 2;
					count++;
					x = transformX;
					y = transformY + 1;

				}

			}
		}
		if (transformX + 1 <= 3) {
			if (!w.isVisited(cX, cY - 1)) {
				if (map[transformX + 1][transformY] != 1 && map[transformX + 1][transformY] != -7
						&& map[transformX + 1][transformY] != -5 && map[transformX + 1][transformY] != -4) {

					if (map[transformX + 1][transformY] == 3 || map[transformX + 1][transformY] == 7)
						map[transformX + 1][transformY] = 4;
					else
						map[transformX + 1][transformY] = map[transformX + 1][transformY] + 2;
					count++;
					x = transformX + 1;
					y = transformY;
				}
			}
		}
		if (transformY - 1 >= 0) {
			if (!w.isVisited(cX - 1, cY)) {
				if (map[transformX][transformY - 1] != 1 && map[transformX][transformY - 1] != -7
						&& map[transformX][transformY - 1] != -5 && map[transformX][transformY - 1] != -4) {
					if (map[transformX][transformY - 1] == 3 || map[transformX][transformY - 1] == 7)
						map[transformX][transformY - 1] = 4;
					else
						map[transformX][transformY - 1] = map[transformX][transformY - 1] + 2;
					count++;
					x = transformX;
					y = transformY - 1;
				}
			}
		}

		if (count == 1) {
			map[x][y] = -2;
		}

		if (w.isVisited(cX, cY + 1)) {
			if ((transformX + 1) <= 3 && (transformX - 1) >= 0)
				if ((!w.isVisited(cX + 1, cY + 1) && map[transformX + 1][transformY + 1] == 0)
						|| (!w.isVisited(cX - 1, cY + 1) && map[transformX - 1][transformY + 1] == 0)) {

					t1 = 1;
					// move up

					d = 3;
				}

		}
		if (w.isVisited(cX + 1, cY)) {
			if ((transformY + 1) <= 3 && (transformY - 1) >= 0)
				if ((!w.isVisited(cX, cY + 1) && map[transformX][transformY + 1] == 0)
						|| (!w.isVisited(cX, cY - 1) && map[transformX][transformY - 1] == 0)) {
					// move right
					t1 = 1;
					d = 1;
				}
		}
		if (w.isVisited(cX, cY - 1)) {
			if ((transformX + 1) <= 3 && (transformX - 1) >= 0)
				if ((!w.isVisited(cX + 1, cY - 1) && map[transformX + 1][transformY - 1] == 0)
						|| (!w.isVisited(cX - 1, cY - 1) && map[transformX - 1][transformY - 1] == 0)) {
					// move down

					d = 4;
					t1 = 1;
				}

		}
		if (w.isVisited(cX - 1, cY)) {
			if ((transformY + 1) <= 3 && (transformY - 1) >= 0)
				if ((!w.isVisited(cX - 1, cY + 1) && map[transformX - 1][transformY + 1] == 0)
						|| (!w.isVisited(cX - 1, cY - 1) && map[transformX - 1][transformY - 1] == 0)) {
					// move left
					t1 = 1;
					d = 2;
				}

		}

		int cur_direction3 = w.getDirection();
		if (t == 1) {
			switch (d) {
			case 1: // right
				directionIntoRequired(cur_direction3, 1);
				w.doAction(World.A_MOVE);
				break;
			case 2: // left
				directionIntoRequired(cur_direction3, 3);
				w.doAction(World.A_MOVE);
				break;
			case 3: // up
				directionIntoRequired(cur_direction3, 0);
				w.doAction(World.A_MOVE);
				break;
			case 4: // down
				directionIntoRequired(cur_direction3, 2);
				w.doAction(World.A_MOVE);
				break;
			}
		}
		if (t1 != 1) {
			pa = 0;
			count = 0;
			path(map, a, transformX, transformY, 0, 0);
			if (pa != 1)
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (map[i][j] == 0)
							count++;
			if (count <= 2) {
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (map[i][j] == 0) {
							minscore = 100;
							pathDestination(map, a, transformX, transformY, 0, 0, 0, i, j);
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
				pb = 0;
				t = 1;
				pathbreeze(map, a, transformX, transformY, 0, 0);
			}
		}

	}

	public void strenchMethod(int[][] map, int cX, int cY, int transformX, int transformY) {

		int count = 0, x = 0, y = 0, t1 = 0, d = 0;

		int[] a = new int[16];
		map[transformX][transformY] = -5;

		if (transformX - 1 >= 0) {

			if (!w.isVisited(cX, cY + 1)) {
				if (map[transformX - 1][transformY] != 1 && map[transformX - 1][transformY] != -7
						&& map[transformX - 1][transformY] != -4) {
					if (!(map[transformX - 1][transformY] % 2 == 0 && map[transformX - 1][transformY] > 0)) {
						if (map[transformX - 1][transformY] == 3 || map[transformX - 1][transformY] == 7) {

							count++;
							x = transformX - 1;
							y = transformY;
							int cur_dir = w.getDirection();
							directionIntoRequired(cur_dir, 0);
							d = 0;
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
								map[transformX - 1][transformY] = 3;
								d = 0;
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
								directionIntoRequired(cur_dir, 1);
								d = 1;
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
									map[transformX][transformY + 1] = 3;
									count++;
								}
							}
						}
					}

				}
				if (transformX + 1 <= 3) {
					if (!w.isVisited(cX, cY - 1)) {
						if (map[transformX + 1][transformY] != 1 && map[transformX + 1][transformY] != -7
								&& map[transformX + 1][transformY] != -4) {
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
										map[transformX + 1][transformY] = 3;
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
										directionIntoRequired(cur_dir, 3);
										d = 3;
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
											map[transformX][transformY - 1] = 3;
											d = 3;
											count++;
										}
									}
								}
							}
						}

						if (count == 1) {

							wumpus = 1;
							map[transformX][transformY] = 1;
							int cur_dir = w.getDirection();
							directionIntoRequired(cur_dir, d);

							for (int i = 0; i < 4; i++)
								for (int j = 0; j < 4; j++) {
									if (map[i][j] == 3)
										map[i][j] = 1;
									if (map[i][j] == 7)
										map[i][j] = 2;
								}
							if (w.hasArrow()) {
								w.doAction(World.A_SHOOT);
							}
							// shoot arrow
						} else {
							if (w.isVisited(cX, cY + 1)) {
								if ((transformX + 1) <= 3 && (transformX - 1) >= 0)
									if ((!w.isVisited(cX + 1, cY + 1) && map[transformX + 1][transformY + 1] == 0)
											|| (!w.isVisited(cX - 1, cY + 1)
													&& map[transformX - 1][transformY + 1] == 0)) {

										t1 = 1;
										// move up
										d = 3;
									}

							}
							if (w.isVisited(cX + 1, cY)) {
								if ((transformY + 1) <= 3 && (transformY - 1) >= 0)
									if ((!w.isVisited(cX, cY + 1) && map[transformX][transformY + 1] == 0)
											|| (!w.isVisited(cX, cY - 1) && map[transformX][transformY - 1] == 0)) {
										// move right
										t1 = 1;
										d = 1;
									}
							}
							if (w.isVisited(cX, cY - 1)) {
								if ((transformX + 1) <= 3 && (transformX - 1) >= 0)
									if ((!w.isVisited(cX + 1, cY - 1) && map[transformX + 1][transformY - 1] == 0)
											|| (!w.isVisited(cX - 1, cY - 1)
													&& map[transformX - 1][transformY - 1] == 0)) {
										// move down
										d = 4;
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
										d = 2;
									}

							}

							int cur_direction = w.getDirection();

							switch (d) {
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
							}

							if (t1 != 1) {
								pa = 0;
								count = 0;
								path(map, a, transformX, transformY, 0, 0);
								if (pa != 1)
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (map[i][j] == 0)
												count++;
								if (count <= 2) {
									for (int i = 0; i < 4; i++)
										for (int j = 0; j < 4; j++)
											if (map[i][j] == 0) {
												minscore = 100;
												int cur_direction2 = w.getDirection();
												pathDestination(map, a, transformX, transformY, 0, 0, 0, i, j);

												switch (k1) {
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
									pathbreeze(map, a, transformX, transformY, 0, 0);
								}
							}

						}
					}
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

		int transformX = 4 - cX;
		int transformY = cY - 1;

		int[][] map = new int[4][4];

		if (w.hasBreeze(cX, cY) && w.hasStench(cX, cY)) {
			if (wumpus == 0)
				breezeAndStrenchMethod(map, cX, cY, transformX, transformY);
			else
				breezeMethod(map, cX, cY, transformX, transformY);
		} else if (w.hasBreeze(cX, cY)) {
			breezeMethod(map, cX, cY, transformX, transformY);
		} else if (w.hasStench(cX, cY)) {
			strenchMethod(map, cX, cY, transformX, transformY);
		} else if (w.hasGlitter(cX, cY)) {
			w.doAction(World.A_GRAB);
			return;
		} else if (w.isInPit()) {
			w.doAction(World.A_CLIMB);
			return;
		} else {
			int count = 0, x1 = 0, y1 = 0;

			int[] a = new int[16];

			if (map[transformX][transformY] != -4 && map[transformX][transformY] != -5
					&& map[transformX][transformY] != -7)
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

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (map[i][j] == -4) {
						if (map[i - 1][j] != 1 && (i - 1 <= 3 && i - 1 >= 0) && map[i - 1][j] != 3
								&& map[i - 1][j] != -4 && map[i - 1][j] != -3 && map[i - 1][j] != -5) {
							count++;

							x1 = i - 1;
							y1 = j;
						}
						if (map[i + 1][j] != 1 && (i + 1 <= 3 && i + 1 >= 0) && map[i + 1][j] != 3
								&& map[i + 1][j] != -3 && map[i + 1][j] != -4 && map[i + 1][j] != -5) {
							count++;

							x1 = i + 1;
							y1 = j;
						} else if (map[i][j + 1] != 1 && (j + 1 <= 3 && j + 1 >= 0) && map[i][j + 1] != 3
								&& map[i][j + 1] != -4 && map[i][j + 1] != -3 && map[i][j + 1] != -5) {
							count++;

							x1 = i;
							y1 = j + 1;
						}
						if (map[i][j - 1] != 1 && (j - 1 >= 0 && j - 1 >= 0) && map[i][j - 1] != 3
								&& map[i][j - 1] != -4 && map[i][j - 1] != -3 && map[i][j - 1] != -5) {
							count++;

							x1 = i;
							y1 = j - 1;
						}
						if (count == 1) {
							map[x1][y1] = -2;
						}
					}
					count = 0;
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (map[i][j] == -5) {
						if (map[i - 1][j] != 1 && (i - 1 <= 3 && i - 1 >= 0) && map[i - 1][j] % 2 != 0
								&& map[i - 1][j] != -4) {
							count++;

							x1 = i - 1;
							y1 = j;
						}
						if (map[i + 1][j] != 1 && (i + 1 <= 3 && i + 1 >= 0) && map[i + 1][j] % 2 != 0
								&& map[i + 1][j] != -4) {
							count++;

							x1 = i + 1;
							y1 = j;
						} else if (map[i][j + 1] != 1 && (j + 1 <= 3 && j + 1 >= 0) && map[i][j + 1] % 2 != 0
								&& map[i][j + 1] != -4) {
							count++;

							x1 = i;
							y1 = j + 1;
						}
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
			path(map, a, transformX, transformY, 0, 0);
			if (pa != 1)
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (map[i][j] == 0)
							count++;
			if (count <= 2) {
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						if (map[i][j] == 0) {
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
