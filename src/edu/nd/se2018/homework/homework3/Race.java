package edu.nd.se2018.homework.homework3;

import java.util.ArrayList;
import java.util.List;

public class Race
{
	List<Horse> horses = new ArrayList<>();
	public Race()
	{
	}
	
	public void enrollHorse(double maxSpeed, String name, Jockey j, int horseNum)
	{
		this.horses.add(new Horse(maxSpeed, name, j, horseNum));
	}
	
	public void printRace()
	{
		for (Horse h : horses)
		{
			System.out.println(h.getName() + " has run " + h.getPosition() + " miles.");
		}
	}
	
	public String runRace()
	{
		boolean done = false;
		String winner = "";
		//each loop iteration represents one minute of race time
		while(!done)
		{
			for (Horse h : horses)
			{
				double pos = h.run();
				h.setPosition(pos);
				if (pos >= 10)
				{
					done = true;
					winner = h.getName();
				}
			}
			printRace();
		}
		
		System.out.println(winner + " has won the race!");
		return winner;
	}
}