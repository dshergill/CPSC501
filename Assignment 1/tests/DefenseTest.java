package tests;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import code.Defense;	
public class DefenseTest
{
	private Defense defender;
	String defense;

	@Before 
	public void setUp()
	{
		defender = new Defense();		
	}
	
	@After
	public void tearDown()
	{
		defender = null;
	}
	
	@Test
	public void testDef()
	{	
		defender.getDefense();
		defense = defender.returnedDefense();
		//Test a passable string
		assertEquals("High", defense);
		//Test an acceptable string that does not pass
		assertEquals("Low", defense);
		//Test an integer	
		assertEquals(10, defense);
		//Test a zero
		assertEquals(0, defense);
		
	}
	@Test
	public void testDefChoice() {
		//Test passable input
		defense = defender.defenseChoice(100, 0, 0);
		assertEquals("Low", defense);
		//Test improper input
		defense = defender.defenseChoice(0, 0, 0);
		String errorMessage = "Error, not enough attacks";
		assertEquals("Error, not enough attacks", errorMessage);
	}
}
