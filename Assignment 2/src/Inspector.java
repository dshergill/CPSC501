import java.util.*;
import java.lang.reflect.*;

public class Inspector {
	
	public Inspector() {}
	
	public void inspect (Object obj, boolean recursive) {
		
		Class classObject = obj.getClass();
		//Gets the class name
		String className = classObject.getName();
		//Gets the superclass name
		if (classObject.getSuperclass() != null) {
			String superClassName = classObject.getSuperclass().getName();
		}
		//Gets the names of the interfaces
		Class[] classInterfaces = classObject.getInterfaces();
		
		
	}
	
}
