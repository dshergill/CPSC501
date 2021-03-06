
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
			inspectClassConstructors(obj, classObject, recursive);
			inspectClassFields(obj, classObject, recursive);
			inspectClassHierarchy(obj, classObject, recursive);
		}
	}
	
	public void inspectClassName(Object obj, Class classObject, boolean recursive) 
	{
		//Retrieves and prints the class name
		String className = classObject.getName();
		System.out.println("Class name: " + className);
	}
	
	public void inspectSuperclassName(Object obj, Class classObject, boolean recursive)
	{
		//Retrieves and prints the superclass name if it exists
		String superClassName = classObject.getSuperclass().getName();
		System.out.println("Super class name: " + superClassName);
	}
	
	public void inspectClassInterfaces(Object obj, Class classObject, boolean recursive)
	{
		//Retrieves and prints all interfaces implemented by a class
		Class[] classInterfaces = classObject.getInterfaces();
		for (int i=0;i<classInterfaces.length; i++){
			System.out.println("Implements Interface: " + classInterfaces[i].getName());
		}
	}
	
	public void inspectClassMethods(Object obj, Class classObject, boolean recursive)
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
	public void inspectClassConstructors(Object obj, Class classObject, boolean recursive)
	{
		Constructor[] theConstructors = classObject.getConstructors(); //get all public
		//constructors
		System.out.print("Constructors: \n" );
		if (theConstructors.length > 0)
		{
			for (int i = 0; i < theConstructors.length; i++) {
				System.out.print("   (");
				Class[] parameterTypes = theConstructors[i].getParameterTypes(); //get the constructor
				//parameters types
				for (int k = 0; k < parameterTypes.length; k ++) {
					//get the name of each parameter
					String parameterString = parameterTypes[k].getName(); 
					System.out.print(parameterString + " ");
				}
			System.out.println(")");
			}
		}
		
		
	}	
    
	public void inspectClassFields(Object obj, Class classObject, boolean recursive)
	{

		Field[] allFields = classObject.getDeclaredFields(); //returns all the accessible 	
		
		if (allFields.length >0)
		{
		    //public fields of c
			for (int i=0; i < allFields.length; i++) {
				String fieldName = allFields[i].getName(); //gets the field�s name
				Class typeClass = allFields[i].getType(); //gets the field�s type
				String fieldType = allFields[i].getName(); //gets the type�s name
				
				System.out.println("Field Name: " + fieldName);
				System.out.println("      Type: " + typeClass);
				
			try{
				allFields[i].setAccessible(true);	
				System.out.println("      Value: " + allFields[i].get(obj));
			} catch (IllegalAccessException e) {
				System.out.println(e);
			}
			}
		}
		
			
	}
	
	public void inspectClassHierarchy(Object obj, Class classObject, boolean recursive)
	{		
		//Feeds superclass into the methods recursively until the
		//superclass is non-existent
		Class supClass = classObject.getSuperclass();
		
		if (supClass != (Object.class))
		{
			inspectClassName(obj, supClass, recursive);
			inspectSuperclassName(obj, supClass, recursive);
			inspectClassInterfaces(obj, supClass, recursive);
			inspectClassMethods(obj, supClass, recursive);
			inspectClassConstructors(obj, supClass, recursive);
			inspectClassFields(obj, supClass, recursive);
			inspectClassHierarchy(obj, supClass, recursive);
		}
			
	}
}
