/*
 * By:Tyler Cromack
 * This program will print the result of User input Stock Price changes in a Table
 */

import javax.swing.JOptionPane;

public class Stock 
{
	 String symbol;
	 String stockName;
	 double pC;
	 double cP;
	 
	
public Stock(String sym, String name)
{
	
	symbol = sym;
	stockName = name;
}

	public static void main(String[] args) 
	{
	UserStocks();

	}
//---------------------------------------------------------	
	public static void UserStocks()
	{
		//Ask user for Number of Stocks
			String stockNum = JOptionPane.showInputDialog("Please enter the number of stocks  ");
			int size = Integer.parseInt(stockNum);
				
		//Stock Array
			Stock[] arrStocks = new Stock[size];
			int x;
				
		//Variables
			double pC,cP;
			String sym, comName, numP;
				
				
		//Get the Stocks
			for(x = 0; x < size ; x++)
			{
			sym = JOptionPane.showInputDialog("Enter the company stock symbol ");
			comName = JOptionPane.showInputDialog("Enter the company name ");
			arrStocks[x] = new Stock(sym, comName);
				
		//Get Stock Prices
			numP = JOptionPane.showInputDialog("Enter the previous closing price ");
			pC = Double.parseDouble(numP);
			arrStocks[x].pC = pC;
			numP = JOptionPane.showInputDialog("Enter the current price ");
			cP = Double.parseDouble(numP);
			arrStocks[x].cP = cP;
				
			}
			
		//Print Table for Results
			System.out.println("Symbol\tName\t\t      Percent Change\n----------------------------------------");
		//Print User Result
			for (x = 0; x < size ; x++)
			System.out.printf("%-7s %-20s %7.3f \n", arrStocks[x].symbol,arrStocks[x].stockName, (arrStocks[x].cP-arrStocks[x].pC)/arrStocks[x].pC*100);
			
	}
}
//--------------------------------------------------------------------------------------------------------	

/*
 * By:Tyler Cromack
 * This Program will print out result of preset Stock data in Table Format
 */
	class Stocked
{
	private static String symbol;
	private static String name;
	private static String symbol2 = "ORCL";
	private static String name2 = "Oracle Corporation";
	private double previousClosingPrice;
	private double currentPrice;
	
	public static void main (String[] args)
	{
	//Set Prices and Names for calculations	
	Stocked stock = new Stocked("ORCL","Oracle Corporation",34.5,34.35);
	Stocked stock1 = new Stocked("FB","FaceBook INC",80.07,81.35);
	
	//Print Results	
	System.out.println("Symbol\tName\t\t      Percent Change\n----------------------------------------");	
	System.out.printf("%-7s %-20s %7.3f \n",symbol2, name2,stock.changePercent());
	System.out.printf("%-7s %-20s %7.3f \n",symbol, name, stock1.changePercent());
	}
	
	//Get Stock Symbols, names, Prices
	public Stocked(String symbol, String name, double previousClosingPrice, double currentPrice)
	{
	this.symbol = symbol;
	this.name = name;
	
	this.previousClosingPrice = previousClosingPrice;
	this.currentPrice = currentPrice;
	}
	
	//Get Percentage change in Stock Price
	public double changePercent()
	{
	return ((currentPrice - previousClosingPrice) / previousClosingPrice)*100;
	}
	
}
	
	
