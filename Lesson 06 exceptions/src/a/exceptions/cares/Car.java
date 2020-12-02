package a.exceptions.cares;

public class Car {

	public static final int MAX_SPEED = 110;
	private int speed;

	public void drive(int speed) throws CarException {
		if (speed > MAX_SPEED) {
			throw new CarException("drive failed - " + speed + " is above max spedd allowed");
		}
		this.speed = speed;
		System.out.println("car is moving at " + speed + " km/h");
	}

}
