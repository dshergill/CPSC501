package code;
/*DILJOT SHERGILL
10055781
*/
import java.util.Random;

//Contains attributes for the Attack class construction
public class Attack
{
	private String attack;
	private int probabilityHighAttacks;
	private int probabilityMedAttacks;
	private int probabilityLowAttacks;
	private int chance;
	static final int MIN_CHANCE = 0;
	static final int RAND_RANGE_MAX = 100;

//Uses the input of probabilities from the Manager
//Randomly generates a number from 1-100, and based on this number (chance) and the defined probability by the user (in manager), this
// will generate an attack if (chance) falls in between the appropriate values
	public void getAttack(int probabilityLowAttacks, int probabilityMedAttacks, int probabilityHighAttacks)
	{
		Random rand = new Random();
		chance = rand.nextInt(RAND_RANGE_MAX);
		
		if ((chance > MIN_CHANCE) && (chance <= probabilityLowAttacks))
		{
			attack = "Low";
		}
		else if ((chance > probabilityLowAttacks) && (chance < (probabilityLowAttacks + probabilityMedAttacks)))
		{
			attack = "Medium";
		}
		else 
		{
			attack = "High";
		}
	}
// Returns the attack generated in the method above
	public String returnedAttack()
	{
		return (attack);
	}
	
}

