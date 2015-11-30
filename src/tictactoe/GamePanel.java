package tictactoe;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class GamePanel extends JPanel implements MouseInputListener {
	//dimensions
	public static final int HEIGHT = 600;
	public static final int WIDTH = 600;
	
	Random rand = new Random(System.currentTimeMillis());
	
	//Holds all the images for the board
	ImagePanel[] spaces = new ImagePanel[9];
	
	int[] moves = new int[9];
	
	//Keeps track of which player is currently going
	public int currPlayer = rand.nextInt(2) + 1;
	public int winner = 0;
	

	//Constructor
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		addMouseListener(this);
		
		this.setLayout(new GridLayout(3,3));
		//Adds all the images to the board
		for(int i = 0; i < spaces.length; i++){
			Image newImage;
			
			if(i % 2 == 0){
				newImage = new ImageIcon("Resources/lightBackground.gif").getImage();
			}
			else {
				newImage = new ImageIcon("Resources/darkBackground.gif").getImage();
			}
			
			spaces[i] = new ImagePanel(newImage);
			this.add(spaces[i]);
		}
	}
	
	//Returns board to default images
	public void resetBoard() {
		for(int i = 0; i < spaces.length; i++){
			if(i % 2 == 0)
				spaces[i].setImage(new ImageIcon("Resources/lightBackground.gif").getImage());
			else
				spaces[i].setImage(new ImageIcon("Resources/darkBackground.gif").getImage());
			moves[i] = 0;
		}
		currPlayer = rand.nextInt(2) + 1;
		winner = 0;
	}
	
	//Updates the image based on the current player
	public void playerMove(int position){
		if(winner == 0){ //prevents continuing if the game is over
			if(moves[position] == 0){
				moves[position] = currPlayer;
				
				if(currPlayer == 1){
					if(position % 2 == 0)
						spaces[position].setImage(new ImageIcon("Resources/lightBackgroundX.gif").getImage());
					else
						spaces[position].setImage(new ImageIcon("Resources/darkBackgroundX.gif").getImage());
				} else {
					if(position % 2 == 0)
						spaces[position].setImage(new ImageIcon("Resources/lightBackgroundO.gif").getImage());
					else
						spaces[position].setImage(new ImageIcon("Resources/darkBackgroundO.gif").getImage());
				}
				
				
				checkWinner();
				if(winner != 0)
					if(JOptionPane.showConfirmDialog(null, "Player " + winner + " won! Replay?", null, JOptionPane.YES_NO_OPTION) == 0){
						resetBoard();
						return;
					}
						
				currPlayer = currPlayer == 1 ? 2 : 1;
			} else {
				JOptionPane.showMessageDialog(null, "ERR: That position has already been taken");
			}
		}
	}
	
	//Determines if there is either a winner
	//or a tie
	public void checkWinner() {
		//Checks for horizontal 3 in a rows
		if(moves[0] == moves[1] && moves[1] == moves[2] && moves[0] != 0){
			winner = currPlayer;
			return;
		} else if(moves[3] == moves[4] && moves[4] == moves[5] && moves[3] != 0){
			winner = currPlayer;
			return;
		} else if(moves[6] == moves[7] && moves[7] == moves[8] && moves[6] != 0){
			winner = currPlayer;
			return;
		//Checks for vertical 3 in a rows
		} else if(moves[0] == moves[3] && moves[3] == moves[6] && moves[0] != 0){
			winner = currPlayer;
			return;
		} else if(moves[1] == moves[4] && moves[4] == moves[7] && moves[1] != 0){
			winner = currPlayer;
			return;
		} else if(moves[2] == moves[5] && moves[5] == moves[8] && moves[2] != 0){
			winner = currPlayer;
			return;
		//Checks for diagonal 3 in a rows
		} else if(moves[0] == moves[4] && moves[4] == moves[8] && moves[0] != 0){
			winner = currPlayer;
			return;
		} else if(moves[2] == moves[4] && moves[4] == moves[6] && moves[2] != 0){
			winner = currPlayer;
			return;
		//Checks if the entire board is full
		} else {
			boolean isFull = true;
			for(int i = 0; i < moves.length; i++){
				if(moves[i] == 0){
					isFull = false;
					break;
				}
			}
			
			if(isFull){
				JOptionPane.showMessageDialog(null, "Nobody won!");
				resetBoard();
			}
		}
	}

	//Listens for mouse events
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int xCoord = arg0.getX();
		int yCoord = arg0.getY();
		
		//Checks which box the user selected
		if(yCoord < (HEIGHT)/3){
			if(xCoord < WIDTH / 3) {
				playerMove(0);
			} else if(xCoord < 2 * WIDTH / 3){
				playerMove(1);
			} else if(xCoord < WIDTH){
				playerMove(2);
			}
		} else if(yCoord < 2*(HEIGHT)/3){
			if(xCoord < WIDTH / 3) {
				playerMove(3);
			} else if(xCoord < 2 * WIDTH / 3){
				playerMove(4);
			} else if(xCoord < WIDTH ){
				playerMove(5);
			}
		} else if(yCoord < (HEIGHT)){
			if(xCoord < WIDTH / 3) {
				playerMove(6);
			} else if(xCoord < 2 * WIDTH / 3){
				playerMove(7);
			} else if(xCoord < WIDTH){
				playerMove(8);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
