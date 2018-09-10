package edu.nd.se2018.homework.homework3;

public class EarlySprint implements Jockey
{
	public EarlySprint()
	{
	}
	
	@Override
	public double run(double position, double maxSpeed)
	{
		//run every minute, thus divide by 60
		if(position < 2)
		{
			position += maxSpeed / 60.0;
		}
		else
		{
			position += (maxSpeed * 0.75 / 60.0);
		}
		return position;
	}
	
}