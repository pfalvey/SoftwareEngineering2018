package edu.nd.se2018.homework.homework3;
import org.junit.Test;

public class MainTest 
{
	@Test
	public void test() {
		Race race1 = new Race();
		Race race2 = new Race();
		Race race3 = new Race();
		Race race4 = new Race();
		Race race5 = new Race();
		
		//checking speed
		race1.enrollHorse(15, "scooter", new EarlySprint(), 1);
		race1.enrollHorse(25, "patrick", new EarlySprint(), 2);
		assert(race1.runRace() == "patrick");
		//checking strategy combo 1
		race2.enrollHorse(25, "scooter", new EarlySprint(), 1);
		race2.enrollHorse(25, "patrick", new SlowStart(), 2);
		assert(race2.runRace() == "patrick");
		//checking strategy combo 2
		race3.enrollHorse(25, "scooter", new EarlySprint(), 1);
		race3.enrollHorse(25, "patrick", new SteadyRun(), 2);
		assert(race3.runRace() == "patrick");
		//checking strategy combo 3
		race4.enrollHorse(25, "scooter", new SlowStart(), 1);
		race4.enrollHorse(25, "patrick", new SteadyRun(), 2);
		assert(race4.runRace() == "patrick");
		//checking run method with tie
		race5.enrollHorse(25, "scooter", new SteadyRun(), 1);
		race5.enrollHorse(25, "patrick", new SteadyRun(), 2);
		assert(race5.runRace() == "patrick");
		
		
	}
}