package code;
/*DILJOT SHERGILL
T03
10055781
*/
import java.util.Random;
//Contains the attributes for the Defense class construction
public class Defense
{
	private String defense;
	private String defenseTypes[] = {"Low", "Medium", "High"};
	float lowBlocks;
	float medBlocks;
	float highBlocks;
	
//Randomly generates a Low, Medium or High attacks from an array using the random method
	public void getDefense()
	{		
		defense = defenseTypes[new Random().nextInt(defenseTypes.length)];
	}
	
	public String returnedDefense()
	{
		return defense;
	}

}
