package code;

import java.lang.reflect.*;
import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;

public class Deserializer {
	public static Object deserialize( Document source ) throws Exception
	{
		List objList = source.getRootElement().getChildren();
		Map table = new HashMap();
		createInstances( table, objList );
		assignFieldValues( table, objList );
		return table.get("0");
	}

	private static void assignFieldValues(Map table, List objList) {
		// TODO Auto-generated method stub
		
	}

	private static void createInstances(Map table, List objList) {
		// TODO Auto-generated method stub
		
	}
	
}
