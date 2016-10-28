import java.util.*;
import java.lang.reflect.*;

public class Inspector {
	
	public Inspector() {}
	
	public void inspect (Object obj, boolean recursive) 
	{
		
		Class classObject = obj.getClass();
		if (classObject.getSuperclass() != null) {
			inspectClassName(obj, classObject, recursive);
			inspectSuperclassName(obj, classObject, recursive);
			inspectClassInterfaces(obj, classObject, recursive);
			inspectClassMethods(obj, classObject, recursive);
		}
		

		
	}
	
	private void inspectClassName(Object obj, Class classObject, boolean recursive) 
	{
		//Gets the class name
		String className = classObject.getName();
		System.out.println(className);
	}
	
	private void inspectSuperclassName(Object obj, Class classObject, boolean recursive)
	{
		String superClassName = classObject.getSuperclass().getName();
		System.out.println(superClassName);
	}
	
	private void inspectClassInterfaces(Object obj, Class classObject, boolean recursive)
	{
		Class[] classInterfaces = classObject.getInterfaces();
		for (int i=0;i<classInterfaces.length; i++){
			System.out.println(classInterfaces[i]);
		}
	}
	
	private void inspectClassMethods(Object obj, Class classObject, boolean recursive)
	{
		Method[] classMethods = classObject.getDeclaredMethods();
		
		for(int i = 0; i<classMethods.length; i++){
			
		}
	}
}
