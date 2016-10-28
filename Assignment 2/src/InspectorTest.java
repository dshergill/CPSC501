import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

public class InspectorTest {

	private Inspector inspector;
	String className;
	//Set up streams to read System.out.println
	private final ByteArrayOutputStream outContent = 
			new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
		inspector  = new Inspector();	
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    inspector = null;
	}
	
	@Test
	public void testInspectorClassName()
	{
		Object objA = new ClassA();	
		Class classObjectA = objA.getClass();

		//USING /r/n for WINDOWS. FOR LINUX USE just /n
		inspector.inspectClassName(objA, classObjectA, true);			
		assertEquals("Class name: ClassA\r\n", outContent.toString());

	}
	@Test
	public void testInspectorSuperclassName()
	{
		//USING /r/n for WINDOWS. FOR LINUX USE just /n
		Object objA = new ClassA();	
		Class classObjectA = objA.getClass();
		inspector.inspectSuperclassName(objA, classObjectA, true);
		assertEquals("Super class name: java.lang.Object\r\n", outContent.toString());
	}
	@Test
	public void testInspectorClassInterfaces()
	{
		//USING /r/n for WINDOWS. FOR LINUX USE just /n
		Object objA = new ClassA();	
		Class classObjectA = objA.getClass();
		inspector.inspectClassInterfaces(objA, classObjectA, true);
		assertEquals("Implements Interface: java.io.Serializable\r\nImplements Interface: java.lang.Runnable\r\n", outContent.toString());
	}
	
	
}
