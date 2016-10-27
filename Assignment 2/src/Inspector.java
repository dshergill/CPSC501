import java.util.*;
import java.lang.reflect.*;

public class Inspector {
	
	public Inspector() {}
	
	public void inspect (Object obj, boolean recursive) {
		
		Class classObject = obj.getClass();
		
		//Gets the class name
		String className = classObject.getName();
		System.out.println(className);
		//Gets the superclass name
		if (classObject.getSuperclass() != null) {
			String superClassName = classObject.getSuperclass().getName();
			System.out.println(superClassName);
		}
		
		//Gets the names of the interfaces
		Class[] classInterfaces = classObject.getInterfaces();
		for (int i=0;i<classInterfaces.length; i++){
			System.out.println(classInterfaces[i]);
		}
		
		//Sets up an array of methods declared by the class object
		//Method[] classMethods = classObject.getDeclaredMethods();
		
		//for(int i = 0; i<classMethods.length; i++){
			
		//}
		
	}
	
}
