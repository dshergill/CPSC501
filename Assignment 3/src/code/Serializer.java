package code;

import java.lang.reflect.*;

import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;

public class Serializer {
	public static Document serializeObject(Object source) throws Exception {
		return serializeHelper(source, new Document(new Element("serialized")),
				new IdentityHashMap<Object, Object>());
	}

	private static Document serializeHelper(Object source, Document doc, 
			IdentityHashMap<Object, Object> map) {
		String id = Integer.toString(map.size());
		map.put(source, id);
		return null;
	}
}
