package test;
import org.junit.*;

import static org.junit.Assert.*;

import java.lang.reflect.*;
import java.util.*;
import code.ObjectCreator;

public class ObjectCreatorTest {
	
	private ObjectCreator objectCreation;
	
	@Before 
	public void setUp()
	{
		objectCreation  = new ObjectCreator();	
	}
	
	@After
	public void tearDown()	
	{
		objectCreation = null;
	}	
	
	@Test
	public Object testMakeIntObject() {
		try {
			Field field = objectCreation.getClass().getDeclaredField("integer1");
			field.setAccessible(true);
			field.set(objectCreation, 2);
			Method method = objectCreation.getClass().getDeclaredMethod("makeInt", null);
			method.setAccessible(true);
			return method.invoke(objectCreation, null);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectCreation;
	}
}
