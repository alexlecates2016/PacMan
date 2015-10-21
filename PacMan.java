# PacMan


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PacMan implements KeyListener, ActionListener{
	//8 rows 
	//16 columns

	ImageIcon eblock = new ImageIcon("icon.png");
	//0 is Blank
	//1 is Pacman
	//2 is Wall
	//5 is Ghost
	//7 is Pellet
	ImageIcon blocks[] = {new ImageIcon("black.png"),
						  new ImageIcon("pacman.png"),
						  new ImageIcon("icon.png"),
						  new ImageIcon("icon2.png"),
						  new ImageIcon("icon3.png"),
						  new ImageIcon("ghost.png"),
						  new ImageIcon("pellet.png"),
						  new ImageIcon("share.png"),
						  new ImageIcon("powerup.png")
						 };
	JFrame window;
	JLabel block;
	int score = 0;
	int lives = 3;
	final int PACMAN = 1;
	final int EMPTY = 0;
	final int WALL = 2;
	final int PELLET = 7;
	final int GHOST = 5;
	final int SUPERPELLET = 8; 
	
	int grid[][]={
					{2,2,2,0,0,2,2,2},
					{2,8,7,7,7,7,8,2},
					{2,7,4,4,4,4,7,2},
					{2,7,7,4,4,7,7,2},
					{2,7,7,7,5,7,7,2},
					{2,7,4,4,4,4,7,2},
					{2,8,7,7,7,7,8,2},
					{0,7,7,4,4,7,7,0},
					{0,7,7,4,4,7,7,0},
					{2,8,7,7,7,7,8,2},
					{2,7,4,4,4,4,7,2},
					{2,7,7,7,7,7,7,2},
					{2,7,7,4,4,7,7,2},
					{2,1,4,4,4,4,5,2},
					{2,7,7,7,7,7,8,2},
					{2,2,2,0,0,2,2,2}
				

	};
	
	JLabel pGrid[][];
	int uglyMoves[]={2,2,2,0,0,0,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2};
	int stupidMoves[]={0,0,0,0,2,2,2,2};
	Ghost stinky;
	Ghost ugly = new Ghost(4,4,2,grid,uglyMoves);
	Ghost stupid = new Ghost(13,6,0,grid,stupidMoves);
	Ghost dumb;
    Timer time;

	public void actionPerformed(ActionEvent e){
		ugly.move();
		stupid.move();
		ugly.chase();
		stupid.chase();
		paintGrid();
		System.out.println("moving");
	}

	public void keyTyped(KeyEvent e){

	}
	public void keyPressed(KeyEvent e){
		
		int value = e.getKeyCode();
		
		if(value==38){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(pacman_r==0) pacman_r=16;
			if(grid[pacman_r-1][pacman_c]==0||grid[pacman_r-1][pacman_c]==7||grid[pacman_r-1][pacman_c]==8){
				if(grid[pacman_r-1][pacman_c]==PELLET){
					score++;
					SoundEffect.GONG.play();
				}
				else if(grid[pacman_r-1][pacman_c]==SUPERPELLET){
					score+=10;
					SoundEffect.EXPLODE.play();
				}
			grid[pacman_r-1][pacman_c]=1;
			if(pacman_r==16){
				pacman_r=getPacManRow();
			}
			grid[pacman_r][pacman_c]=0;
			}else if(grid[pacman_r-1][pacman_c]==GHOST){
				lives--;
				
				if(lives==2)lives1.setIcon(new ImageIcon("black.png"));
				if(lives==1)lives2.setIcon(new ImageIcon("black.png"));
				if(lives==0) {
					JOptionPane.showMessageDialog(null, "wow u suck");
					System.exit(0);
				}
				grid[pacman_r][pacman_c]=0;
				grid[13][1]=1;
			}
		}
		else if(value==40){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(pacman_r==15) pacman_r=-1;
			if(grid[pacman_r+1][pacman_c]==0||grid[pacman_r+1][pacman_c]==7||grid[pacman_r+1][pacman_c]==8){
				if(grid[pacman_r+1][pacman_c]==PELLET){
					score++;
					SoundEffect.GONG.play();
				}
				else if(grid[pacman_r+1][pacman_c]==SUPERPELLET){
					score+=10;
					SoundEffect.EXPLODE.play();
				}
			grid[pacman_r+1][pacman_c]=1;
			if(pacman_r==-1){
				pacman_r=15;
			}
			grid[pacman_r][pacman_c]=0;
			}
			else if(grid[pacman_r+1][pacman_c]==GHOST){
				lives--;
				if(lives==2)lives1.setIcon(new ImageIcon("black.png"));
				if(lives==1)lives2.setIcon(new ImageIcon("black.png"));
				if(lives==0) {
					JOptionPane.showMessageDialog(null, "wow u suck");
					System.exit(0);
				}
				grid[pacman_r][pacman_c]=0;
				grid[13][1]=1;
			}
		}
		else if(value==37){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(pacman_c==0) pacman_c=8;
			if(grid[pacman_r][pacman_c-1]==0||grid[pacman_r][pacman_c-1]==7||grid[pacman_r][pacman_c-1]==8){
				if(grid[pacman_r][pacman_c-1]==PELLET){
					score++;
					SoundEffect.GONG.play();
				}
				else if(grid[pacman_r][pacman_c-1]==SUPERPELLET){
					score+=10;
					SoundEffect.EXPLODE.play();
				}
			grid[pacman_r][pacman_c-1]=1;
			if(pacman_c==8){
				pacman_c=getPacManCol();
			}
			grid[pacman_r][pacman_c]=0;
			}
			else if(grid[pacman_r][pacman_c-1]==GHOST){
				lives--;
				if(lives==2)lives1.setIcon(new ImageIcon("black.png"));
				if(lives==1)lives2.setIcon(new ImageIcon("black.png"));
				if(lives==0) {
					JOptionPane.showMessageDialog(null, "wow u suck");
					System.exit(0);
				}
				grid[pacman_r][pacman_c]=0;
				grid[13][1]=1;
			}
		}
		else if(value==39){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(pacman_c==7) pacman_c=-1;
			if(grid[pacman_r][pacman_c+1]==0||grid[pacman_r][pacman_c+1]==7||grid[pacman_r][pacman_c+1]==8){
				if(grid[pacman_r][pacman_c+1]==PELLET){
					score++;
					SoundEffect.GONG.play();
				}
				else if(grid[pacman_r][pacman_c+1]==SUPERPELLET){
					score+=10;
					SoundEffect.EXPLODE.play();
				}
			grid[pacman_r][pacman_c+1]=1;
			if(pacman_c==-1){
				pacman_c=7;
			}
			grid[pacman_r][pacman_c]=0;
			}
			else if(grid[pacman_r][pacman_c+1]==GHOST){
				lives--;
				if(lives==2)lives1.setIcon(new ImageIcon("black.png"));
				if(lives==1)lives2.setIcon(new ImageIcon("black.png"));
				if(lives==0) {
					JOptionPane.showMessageDialog(null, "wow u suck");
					System.exit(0);
				}
				grid[pacman_r][pacman_c]=0;
				grid[13][1]=1;
			}
		}
		paintGrid();

		System.out.println("Score: "+score);
		//if(score==121)System.exit(0);
	}
	public void keyReleased(KeyEvent e){

	}
	public void paintGrid(){
		score_txt.setText(""+score);
		if(score==120){
			//JOptionPane win = new JOptionPane("WINNER");
			//win.ShowMessageDialog("WINNER");
			JOptionPane.showMessageDialog(null,"WINNER!!!");
			System.exit(0);
		}
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 8; j++){
				pGrid[i][j].setIcon(blocks[grid[i][j]]);
				window.repaint();
			}
		}
	}
	public int getPacManRow(){
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 8; j++){
				if(grid[i][j]==1) return i;
			}
		}
		return 0;
	}
	public int getPacManCol(){
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 8; j++){
				if(grid[i][j]==1)return j;
			}
		}
		return 0;
	}
	JPanel top;
	JPanel body;
	JLabel score_lbl = new JLabel("Score: ");
	JLabel score_txt = new JLabel("0");
	JLabel lives1 = new JLabel();
	JLabel lives2 = new JLabel();
	JLabel lives3 = new JLabel();
	public PacMan(){
		SoundEffect.init();
      	SoundEffect.volume = SoundEffect.Volume.HIGH;
		//ImageIcon eblock = new ImageIcon("icon.png");
		window = new JFrame("PacMan");
		body = new JPanel();
		top = new JPanel();
		window.addKeyListener(this);
		window.setLayout(new BorderLayout());
		body.setLayout(new GridLayout(16,8));
		top.setLayout(new GridLayout(1,8));
		top.add(score_lbl);
		top.add(score_txt);
		score_lbl.setForeground(Color.white);
		score_lbl.setBackground(Color.black);
		score_lbl.setOpaque(true);
		score_txt.setForeground(Color.white);
		score_txt.setBackground(Color.black);
		score_txt.setOpaque(true);
		lives1.setIcon(new ImageIcon("pacman.png"));
		lives1.setBackground(Color.black);
		lives1.setOpaque(true);
		lives2.setIcon(new ImageIcon("pacman.png"));
		lives2.setBackground(Color.black);
		lives2.setOpaque(true);
		lives3.setIcon(new ImageIcon("pacman.png"));
		lives3.setBackground(Color.black);
		lives3.setOpaque(true);
		top.add(lives1);
		top.add(lives2);
		top.add(lives3);
		
		block = new JLabel(eblock);
		pGrid = new JLabel[16][8];
		
		for(int i = 0; i < 16; i++){
			
			for(int j = 0; j < 8; j++){
				pGrid[i][j] = new JLabel(blocks[grid[i][j]]);
				body.add(pGrid[i][j]);
			}
		}
		//window.add(block);
		//window.setSize(300,300);
		window.add(body,BorderLayout.CENTER);
		window.add(top, BorderLayout.NORTH);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		time = new Timer(1000, this);
		time.start();
		time.setRepeats(true);

	}

	public static void main(String args[]){
		new PacMan();

	}
}
