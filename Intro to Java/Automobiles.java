
import java.util.Scanner;
public class Automobiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size,mg, i;
		String name;
		double mperg;
		System.out.println("Please enter the number of cars ");
		size = input.nextInt();
		Car [] cars = new Car[size];
		for (i = 0; i < size ; i++)
		{
			cars[i] = new Car();
			System.out.println("Please enter the model type for car " + (i+1));
			name = input.next();
			cars[i].setModel(name);
			
			
			System.out.println("Please enter the mileage type for car " + (i+1));
			mg = input.nextInt();
			cars[i].setMileage(mg);
			
			System.out.println("Please enter the mpg type for car " + (i+1));
			mperg = input.nextDouble();
			cars[i].setMpg(mperg);
		}
		
		System.out.println("\n\n\n");
		for(i=0; i < size ; i++)
		{
			System.out.println("Model:      "+cars[i].getModel());
			System.out.println("Mileage:    "+cars[i].getMileage());
			System.out.println("MPG:        "+cars[i].getMpg());
			System.out.println("--------------------------------\n");
		}}}