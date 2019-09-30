/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#4 Tic Tac Toe Game Board
 * This program will drive TicTacToe.Java
 */

import java.util.Scanner;
import javax.swing.JFrame;
//**********************************************************************
public class PlayTicTacToe
{
    public static void main(String[] args)
    {
    	final String TITLE = "Tic Tac Toe V4.0";
    	final String CONTINUE_PROMPT = "Play another game of Tic-Tac-Toe? [y/N] "; 
        System.out.println("Welcome to " + TITLE);
        Scanner sc = new Scanner(System.in);
        do {
        	JFrame tttGame = new TicTacToe();
        	tttGame.setTitle("TicTacToe Game V4.0");
        	tttGame.setSize(500, 500);
        	tttGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	tttGame.setLocationRelativeTo(null);
        	tttGame.setVisible(true);
        } while (doThisAgain(sc, CONTINUE_PROMPT));
        sc.close();
        System.out.println("Thank you for using " + TITLE);    
    }
 //**********************************************************************
 private static boolean doThisAgain(Scanner sc, String prompt) {
        System.out.print(prompt);
        String doOver = sc.nextLine();
        return doOver.equalsIgnoreCase("Y");
    }
}