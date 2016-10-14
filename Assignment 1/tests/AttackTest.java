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
		attacker.getAttack(10, 10, 10);
		attack = attacker.returnedAttack();
		assertEquals("High", attack);
		//Test an acceptable string that does not pass
		attacker.getAttack(20, 20, 20);
		attack = attacker.returnedAttack();
		assertEquals("Low", attack);
		//Test an integer	
		attacker.getAttack(10, 10, 10);
		attack = attacker.returnedAttack();
		assertEquals(10, attack);
		//Test a zero
		attacker.getAttack(20, 20, 20);
		attack = attacker.returnedAttack();
		assertEquals(0, attack);
	}
}
