/**
 * Keeps track of a Car object's information including the model, year and current speed of the car
 * @author Vince Ou
 * @version November 2014
 *
 */
public class Car
{
	private String model;
	private int year;
	private int currentSpeed;


	/**
	 * Constructs a new Car object with the given model and year. Current speed is
	 * set to zero.
	 * @param model model of the car (eg Corvette)
	 * @param year the year of this car (eg 2012)
	 */
	public Car (String model, int year)
	{
		this.model = model;
		this.year = year;
		this.currentSpeed = 0;
	}
	
	/** Returns a String representation of this Car
	* @return the Car's year, model and current speed (if moving)
	*/
	public String toString()
	{
	if (currentSpeed == 0)
	return String.format("%d %s stopped", year, model);
	else
	return String.format("%d %s travelling at %d kph",
	year, model, currentSpeed);
	}
	
	/** Accelerate the Car (increase its speed by 5 kph)
	*/
	public void accelerate()
	{
	currentSpeed += 5;
	}
	
	/** Brake the Car (decrease its speed by 10 kph)
	* Makes sure the speed doesn’t fall below 0 kph
	*/
	public void brake()
	{
	if (currentSpeed >= 10)
	currentSpeed -= 10;
	else
	currentSpeed = 0;
	}
} 