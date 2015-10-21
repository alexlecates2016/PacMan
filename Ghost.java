# PacMan

public class Ghost{
	int ghostrow;
	int ghostcolumn;
	int direction;
	int grid[][];
	int lastSpot;
	int pacman_r;
	int pacman_c;
	final int LEFT=2;
	final int RIGHT=3;
	final int UP=0;
	final int DOWN=1;
	final int PACMAN = 1;
	final int EMPTY = 0;
	final int WALL = 2;
	final int PELLET = 7;
	final int GHOST = 5;
	final int SUPERPELLET = 8; 
	int moves[];
	int movesLength;

	public void flip(){
		if(direction==0)direction=1;
		else if(direction==1)direction=0;
		else if(direction==2)direction=3;
		else if(direction==3)direction=2;
	}

	public Ghost(int r, int c, int d, int g[][], int m[]){
		ghostrow=r;
		ghostcolumn=c;
		grid=g;
		direction=d;
		lastSpot=EMPTY;
		moves=m;
		movesLength=0;
	}
	
	public void move(){
		System.out.println(pacman_r);
		System.out.println(pacman_c);
		if(movesLength!=moves.length){
			direction=moves[movesLength];
			movesLength++;
		}
		if(direction==UP){
			pacman_r=getPacManRow();
			pacman_c=getPacManCol();
			
			if(grid[ghostrow-1][ghostcolumn] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow-1][ghostcolumn] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostrow-1][ghostcolumn]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow-1][ghostcolumn] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow-1][ghostcolumn]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow-1][ghostcolumn] = GHOST;
				lastSpot=SUPERPELLET;

			}
			if(grid[ghostrow-1][ghostcolumn]==WALL){
				flip();
			} 
			ghostrow--;
		}

		
		if(direction==DOWN){
			pacman_r=getPacManRow();
			pacman_c=getPacManCol();
			
			if(grid[ghostrow+1][ghostcolumn] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow+1][ghostcolumn] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostrow+1][ghostcolumn]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow+1][ghostcolumn] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow+1][ghostcolumn]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow+1][ghostcolumn] = GHOST;
				lastSpot=SUPERPELLET;
			}
			if(grid[ghostrow+1][ghostcolumn]==WALL){
				flip();
			} 
			ghostrow++; 
		}
		if(direction==LEFT){
			pacman_r=getPacManRow();
			pacman_c=getPacManCol();
			
			if(grid[ghostrow][ghostcolumn-1] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow][ghostcolumn-1] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostrow][ghostcolumn-1]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow][ghostcolumn-1] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow][ghostcolumn-1]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow][ghostcolumn-1] = GHOST;
				lastSpot=SUPERPELLET;
			}
			if(grid[ghostrow][ghostcolumn-1]==WALL){
				flip();
			}  
			ghostcolumn--;
		}
		if(direction==RIGHT){
			pacman_r=getPacManRow();
			pacman_c=getPacManCol();
			
			if(grid[ghostrow][ghostcolumn+1] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow][ghostcolumn+1] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostrow][ghostcolumn+1]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow][ghostcolumn+1] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow][ghostcolumn+1]==SUPERPELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==SUPERPELLET){
					grid[ghostrow][ghostcolumn]=SUPERPELLET;
				}
				grid[ghostrow][ghostcolumn+1] = GHOST;
				lastSpot=SUPERPELLET;
			}
			if(grid[ghostrow][ghostcolumn+1]==WALL){
				flip();
			}  
			ghostcolumn++;
		}
	}
	public void chase(){
	System.out.println("CHASE");
	if(ghostrow==pacman_r){
		if(ghostcolumn<=pacman_c){
			for(int i=ghostcolumn+1;i<pacman_c;i++){
				if(grid[ghostrow][i]==WALL)return;
				else{
					direction=RIGHT;
					}
			}
		}else if(pacman_c<=ghostcolumn){
			for(int i=ghostcolumn-1;i<pacman_c;i++){
				if(grid[ghostrow][i]==WALL)return;
				else{
					direction=LEFT;
					}
			}
		}

	}
	if(ghostcolumn==pacman_c){
		if(ghostrow<=pacman_r){
			for(int i=ghostrow+1;i<pacman_r;i++){
				if(grid[i][ghostcolumn]==WALL){
					return;
				}else{
				direction=DOWN;
			}
		}
	}
			else if(pacman_r<=ghostrow){
			for(int i=ghostrow-1;i<pacman_r;i++){
				if(grid[ghostrow][i]==WALL)return;
				else{
					direction=LEFT;
					}
			}
		}
			
		
	}
}
	public int getPacManRow(){
	for(int i=0;i<16;i++){
		for(int j=0;j<8;j++){
			if(grid[i][j]==1)
				return i;
		}
	}return 0;
}

public int getPacManCol(){
	for(int i=0;i<16;i++){
		for(int j=0;j<8;j++){
			if(grid[i][j]==1)
				return j;
		}
	}return 0;
}
}
