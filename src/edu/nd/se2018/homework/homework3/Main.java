package edu.nd.se2018.homework.homework3;

public class Main
{
	public static void main(String args[])
	{
		Race race = new Race();
		race.enrollHorse(25, "Scooter", new EarlySprint(), 8);
		race.enrollHorse(24, "Patrick", new SteadyRun(), 10);
		race.enrollHorse(26, "Bob", new SlowStart(), 18);
		race.runRace();
	}
}