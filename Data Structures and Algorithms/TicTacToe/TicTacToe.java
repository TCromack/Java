/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#4 Tic Tac Toe Game Board
 * This program will display a Tic Tac Toe board for users to click and play on
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

//**********************************************************************
public class TicTacToe extends JFrame

{
	// Keeps Track of X's and O's Turn
	private char getTurn = 'X';
	private boolean gameOver = false;
	private int getTurns;
	
	//Create 2D Array for Board
	private boardArr[][] board = new boardArr[3][3];
	
	JLabel gameStatus = new JLabel("X pick where you'd like to play."+"\t TURN #"+ (getTurns+1));

//**********************************************************************	
	//Set the Layout for the Game Board
	public TicTacToe()
	{
		JPanel panel = new JPanel (new GridLayout(3,3,0,0));
		
		for (int r=0;r<3;r++)
			for (int c=0;c<3;c++)
				panel.add(board[r][c] = new boardArr());
		
		panel.setBorder(new LineBorder(Color.blue,1));
		gameStatus.setBorder(new LineBorder(Color.blue,1));	
		add(panel, BorderLayout.CENTER);
		add(gameStatus, BorderLayout.SOUTH);			
	}

//**********************************************************************
	//Check to see if the Board is Full otherwise continue the game
	public boolean isFull()
	{
		 for (int r = 0; r < 3; r++)
	           for (int c = 0; c < 3; c++)
	               if (board[r][c].getPlayerAt() == ' ')
	                   return false;
	     return true;
	}

//**********************************************************************
	//Check to see if a Player has Won otherwise continue the game
	public boolean isWinner(char p)
	   {
	       // Check rows for 3 X's or O's
	       for (int r = 0; r < 3; r++)
	           if ((board[r][0].getPlayerAt() == p)
	                && (board[r][1].getPlayerAt() == p)
	                && (board[r][2].getPlayerAt() == p))
	           		{
	               	return true;
	           		}
	 
	    // Check columns for 3 X's or O's
	       for (int c = 0; c < 3; c++)
	           if ((board[0][c].getPlayerAt() == p)
	                && (board[1][c].getPlayerAt() == p)
	                && (board[2][c].getPlayerAt() == p))
	           		{
	        	   	return true;
	           		}
	    
	    // Check both diagonals for 3 X's or O's
	       if ((board[0][0].getPlayerAt() == p)
	            && (board[1][1].getPlayerAt() == p)
	            && (board[2][2].getPlayerAt() == p))
	           {
	               return true;
	           }
	 
	       if ((board[0][2].getPlayerAt() == p)
	            && (board[1][1].getPlayerAt() == p)
	            && (board[2][0].getPlayerAt() == p))
	           {
	               return true;
	           }
	 
	      return false;
	   }

//**********************************************************************	
	public class boardArr extends JPanel
	{
		private char space = ' ';

//**********************************************************************		
		public boardArr()
		{
			setBorder(new LineBorder(Color.black,1));
			addMouseListener(new mouseClick());
		}

//**********************************************************************		
		public char getPlayerAt()
		{
			return space;
		}

//**********************************************************************		
		public void playMove(char p)
		{
			space = p;
			repaint();
			getTurns++;
		}

//**********************************************************************
		public String toString() {
		    String displayCurrentGame = "";
		    
		    for(int r = 0; r < board.length; r++) 
		    {
		      for(int c = 0; c < board.length; c++) 
		      {
		        displayCurrentGame += board[r][c] + "|";
		      }
		      displayCurrentGame = displayCurrentGame.substring(displayCurrentGame.length() - 1);
		      displayCurrentGame += "\n";
		      
		      for(int i = 0; r != board.length-1 && i < board.length; i++)
		      {
		        displayCurrentGame += "- ";
		      }
		      displayCurrentGame += "\n";
		    }
		    
		    return displayCurrentGame + " : It is Turn #" + getTurns + " and is " + getTurn + " move.";
		  } 

//**********************************************************************		
		//Draw X's and O's
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
	
			if (space == 'X')
			{
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			}	
			
			else if (space == 'O')
			{
				g.drawOval(10,10, getWidth() - 20 , getHeight() - 20);
			}		
		}

//**********************************************************************
		private class mouseClick extends MouseAdapter
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (gameOver)
	                return;
				
				//if space is empty while game in progress
				if (space == ' ' && getTurn != ' ')
				playMove(getTurn);
				
				//Check game status
				if (isWinner(getTurn))
				{
					gameStatus.setText(getTurn + " has Won! The Game ended on TURN #"+ (getTurns) +".");
					gameOver = true;
				}
				// Check if Game is a Tie
				else if (isFull())
				{
					gameStatus.setText("Game is a Draw! The Game ended on TURN #"+ (getTurns) +".");
					gameOver = true;
				}
				//Show X or O's Turn
				else
				{
					getTurn = (getTurn == 'X') ? 'O' : 'X';
					gameStatus.setText(getTurn + "'s Turn." + "\t\t TURN #"+ (getTurns+1) +".");
				}
			}
		}

//**********************************************************************		
	}

}
