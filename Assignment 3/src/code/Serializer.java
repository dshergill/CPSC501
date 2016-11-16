package code;

import java.lang.reflect.*;

import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;

public class Serializer {
	public static Document serializeObject(Object source) throws Exception {
		return serializeHelper(source, new Document(new Element("serialized")), new IdentityHashMap());
	}

	private static Document serializeHelper(Object source, Document document, IdentityHashMap identityHashMap) {
		String id = Integer.toString(identityHashMap.size());
		identityHashMap.put(source, id);
		return null;
	}
}
