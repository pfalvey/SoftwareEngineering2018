package edu.nd.se2018.homework.homework3;

public class Horse {
	
	double maxSpeed;
	String name;
	Jockey jockey;
	double position;
	int horseNum;
	
	public Horse(double maxSpeed, String name, Jockey j, int horseNum)
	{
		this.maxSpeed = maxSpeed;
		this.name = name;
		this.jockey = j;
		this.horseNum = horseNum;
		this.position = 0; //how many miles traveled
	}
	
	public Horse()
	{
		this(25.0, "Secretariat", new EarlySprint(), 8);
	}
	
	public double run()
	{
		return jockey.run(position, maxSpeed);
	}
	
	public double getPosition()
	{
		return this.position;
	}
	
	public void setPosition(double position)
	{
		this.position = position;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public int getHorseNum()
	{
		return this.horseNum;
	}

	
	
	
	
	
	
}