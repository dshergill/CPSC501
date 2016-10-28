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
		String className = classObject.getName();
		System.out.println("Class name: " + className);
	}
	
	private void inspectSuperclassName(Object obj, Class classObject, boolean recursive)
	{
		String superClassName = classObject.getSuperclass().getName();
		System.out.println("Super class name: " + superClassName);
	}
	
	private void inspectClassInterfaces(Object obj, Class classObject, boolean recursive)
	{
		Class[] classInterfaces = classObject.getInterfaces();
		for (int i=0;i<classInterfaces.length; i++){
			System.out.println("Implements Interface: " + classInterfaces[i].getName());
		}
	}
	
	private void inspectClassMethods(Object obj, Class classObject, boolean recursive)
	{
		Method[] classMethods = classObject.getDeclaredMethods();
		
		for(int i = 0; i<classMethods.length; i++){
			String methodString = classMethods[i].getName(); //get the method name
			System.out.println("Method Name: " + methodString);
			//get the method return type 
			String returnString = classMethods[i].getReturnType().getName(); 
			System.out.println("   Return Type: " + returnString);
			//get the method parameters types
			Class<?>[] parameterTypes = classMethods[i].getParameterTypes();
			Class<?>[] exceptionTypes = classMethods[i].getExceptionTypes();
			
			for (int k = 0; k < parameterTypes.length; k ++) {
				System.out.print("   Parameter Types:");
				//get the name of each parameter
				String parameterString = parameterTypes[k].getCanonicalName(); 
				System.out.print(" " + parameterString + "\n");
			}
			
			if (exceptionTypes.length > 0)
			{	
				System.out.print("   Exceptions Thrown:");
				for (int l = 0; l < exceptionTypes.length; l ++) {
					//get the name of each parameter
					String exceptionString = exceptionTypes[l].getCanonicalName(); 
					System.out.print(" " + exceptionString + "\n");
				}
			}
			
			System.out.println("   Method modifiers: " + 
			Modifier.toString(classObject.getModifiers()));
		}
	}
}
