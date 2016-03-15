
public class CarTest
{

	public static void main(String[] args)
	{
		Car firstCar = new Car("Honda Civic", 2008);
		System.out.println(firstCar);
		
		Car secondCar = new Car("Ford Focus", 2010);
		System.out.println(secondCar);
		
		// Accelerate both cars
		for (int repeat = 1; repeat <= 7;repeat++)
		firstCar.accelerate();
		secondCar.accelerate();
		
		// Print out their status
		System.out.println(firstCar);
		System.out.println(secondCar);
		
		// Brake both cars
		firstCar.brake();
		firstCar.brake();
		secondCar.brake();
		secondCar.brake();
		
		// Print out their new status
		System.out.println(firstCar);
		System.out.println(secondCar);
	}

}
