package edu.nd.se2018.homework.homework3;

public class SlowStart implements Jockey
{
	public SlowStart()
	{
	}
	
	@Override
	public double run(double position, double maxSpeed)
	{
		//run every minute, thus divide by 60
		if(position < 6)
		{
			position += (maxSpeed * 0.75 / 60.0);
		}
		else if (position < 9)
		{
			position += (maxSpeed * 0.9 / 60.0);
		}
		else
		{
			position += maxSpeed / 60.0;
		}
		return position;
	}
	
}