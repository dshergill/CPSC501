import java.util.*;
import java.lang.reflect.*;

public class Inspector {
	
	public Inspector() {}
	
	public void inspect (Object obj, boolean recursive) {
		
		Class classObject = obj.getClass();
		String className = classObject.getName();
		if (classObject.getSuperclass() != null) {
			String superClassName = classObject.getSuperclass().getName();
		}
		
		
	}
	
}
