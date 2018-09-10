package edu.nd.se2018.homework.homework3;

public class SteadyRun implements Jockey
{
	public SteadyRun()
	{
	}
	
	@Override
	public double run(double position, double maxSpeed)
	{
		//run every minute, thus divide by 60
		position += (maxSpeed * 0.8) / 60.0; 
		return position;
	}
	
}