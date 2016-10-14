package tests;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import code.Attack;

public class AttackTest
{
	private Attack attacker;
	String attack;
	
	@Before 
	public void setUp()
	{
		attacker  = new Attack();	
	}
	
	@After
	public void tearDown()	
	{
		attacker = null;
	}	
	
	@Test
	public void testAtk()
	{
		//Test a passable string
		attacker.getAttack(0, 0, 100);
		attack = attacker.returnedAttack();
		assertEquals("High", attack);
		//Test an acceptable int that does not pass
		attacker.getAttack(101, 0, 0);
		attack = attacker.returnedAttack();
		assertEquals("Low", attack);

	}
}
