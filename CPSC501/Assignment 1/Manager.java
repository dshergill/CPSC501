/*DILJOT SHERGILL
10055781
 
-Obtains attack based on proportions set by the user
-Obtains defense randomly until 20 rounds have occurred
-After 20 rounds the defender will block an attack that has occured more than 50% of the time in the first 20 rounds
-If there is a even spread of attacks, the defender will continue to block randomly
-Displays if each round resulted in a block or hit
-Tallies total blocks and hits as well as the %values of each type of attack and block

Program limitations:
-If defender "accidentally" assumes that attacker has chosen a specific attack out of chance, the defender will continue to block that attack
even if the attacker switches attacks
*/
import java.util.Scanner;
import java.util.Random;

//Initializes the main program
public class Manager
{
	private int numRounds;
	private int count;
	private int numBlocks = 0;
	private int numHits = 0;
	private float lowBlocks = 0;
	private float medBlocks = 0;
	private float highBlocks = 0;
	private float lowAttacks = 0;
	private float medAttacks = 0;
	private float highAttacks= 0;
	private String attack;
	private String defense;
	private Scanner in = new Scanner (System.in);
		
	public void start()
	{
//Attributes of manager
//Obtains input from the user for the number of round. If a number outside the range is chosen, 10 will be set as default		
		System.out.print("Enter the number of rounds: ");
		numRounds = in.nextInt ();
		if (numRounds > 100 || numRounds < 1)
			{
				numRounds = 10;
				System.out.println("Invalid number entered, default set to 10 rounds");
			}
		in.nextLine(); 
//Obtains information from the user for the percentage of each attack and passes them back into the attack class later. If the total does not
//equal 100, then a roughly equal probability will be chosen 		
		System.out.println("Enter the percentage of attacks that will be aimed low:");
		int lowAttack = in.nextInt();
		in.nextLine(); 
		System.out.println("Enter the percentage of attacks that will be aimed medium:");
		int medAttack = in.nextInt();
		in.nextLine();
		System.out.println("Enter the percentage of attacks that will be aimed high:");
		int highAttack = in.nextInt();
		
		if (lowAttack + medAttack + highAttack != 100)
			{
				lowAttack = 33;
				medAttack = 34;
				highAttack = 33;
				System.out.println("Numbers entered did not equal 100. Default values set");
			}
		System.out.println("COMBAT INITIALIZED!");
		System.out.println("-------------------");
		
		calculate(lowAttack, medAttack, highAttack);
	}
		
	public void calculate(int lowAttack, int medAttack, int highAttack)
	{
		//Instantiates Attack and Defense classes for use throughout this class		
		Attack attacker  = new Attack();
		Defense defender = new Defense();
		
	
//Main loop that obtains the random attack and defense from the classes
//Also counts the number and types of attacks and blocks for display as a statistic		
		for (count = 0; count < numRounds; count++)
		{
			attacker.getAttack(lowAttack, medAttack, highAttack);
			attack = attacker.returnedAttack();
			defender.getDefense();
			defense = defender.returnedDefense();
			if (attack == "Low")
				{
					lowAttacks++;
				}
			else if (attack == "Medium")
				{
					medAttacks++;
				}
			else if (attack == "High")
				{
					highAttacks++;
				}
// Blocker AI which kicks in after a minimum of 20 rounds which then takes in whichever attack has occurred > 50% of the time
// And all future defense actions will block only that type of attack 
			if ((count > 20))
				{
					if (lowAttacks > 10)
						{
							defense = "Low";
						}
					else if ((medAttacks > 10))
						{
							defense = "Medium";
						}
					else if ((highAttacks > 10))
						{
							defense = "High";
						}
				}
			if (defense == "Low")
				{
					lowBlocks++;
				}
			else if (defense == "Medium")
				{
					medBlocks++;
				}
			else if (defense == "High")
				{
					highBlocks++;
				}
	//Prints updated information each round as well as keeps a running total of blocks and hits
			System.out.println("Round " + (count + 1) + "...   " + "Attacker: " + attack + "  Defender: " + defense);
			
			if (defense.equals(attack))
				{
					System.out.println("\tBlocked!\n");
					numBlocks++;
					System.out.println("\tTotal Hits: " + numHits);
					System.out.println("\tTotal Blocks: " + numBlocks);
				}
			else
				{
					System.out.println("\tHit!\n");
					numHits++;
					System.out.println("\tTotal Hits: " + numHits);
					System.out.println("\tTotal Blocks: " + numBlocks);
				}
		}
		
		displayStats(lowAttack, medAttack, highAttack);
		
	}
	

	public void displayStats(int lowAttack, int medAttack, int highAttack)
	{
// Display of all statistics
		System.out.println ("Summary of Combat");
		System.out.println ("Total Hits Overall: " + numHits + "   Total Blocks Overall: " + numBlocks);
		System.out.println ("Attacker Proportions:  " + "Low  " + lowAttack + "% " + "Medium  " + medAttack + "% " + "High  " + highAttack + "% ");
		System.out.print ("Defender Proportions:  " + "Low  ");
		System.out.printf("%.2f", (lowBlocks*100)/(count+1));
		System.out.print("% " + "Medium  "); 
		System.out.printf("%.2f", ((medBlocks*100)/(count+1)));
		System.out.print("% " + "High  ");
		System.out.printf("%.2f", ((highBlocks*100)/(count+1)));
		System.out.println("% ");		
	
	}
}


