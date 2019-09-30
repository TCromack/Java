
public class PrimeNum {

	public static void main(String[] args)
	{
		System.out.println("The first 25 Prime Numbers are: \n");
		PrintPrime(25);
		System.out.println("\n\nThe first 50 Prime Numbers are: \n");
		PrintPrime(50);
	}
	
	public static boolean isPrime(int number)
	{
		int c;
		for(c=2; c<= number/2; c++)
		{
			if(number%c==0)
			return false;
		}
		return true;
		
	}
	public static void PrintPrime(int NumberOfPrimes)
	{
		int count = 0;
		int number = 2;
		
		while(count < NumberOfPrimes)
			{
		if(isPrime(number)==true)
		{
			count = count+1;
			if((count % 10)==0)
			System.out.printf("%-5d\n",number);
			else
				System.out.printf("%-5d", number);
		}
		number++;
			}
	}
}
