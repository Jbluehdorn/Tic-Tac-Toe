package tictactoe;

import java.awt.GridLayout;

import javax.swing.*;

public class TicTacToe {
	public static void main(String[] args){
		//Creates the Frame and displays it
		JFrame frame = new JFrame("Vikings and Dragons!");
		frame.setContentPane(new GamePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
