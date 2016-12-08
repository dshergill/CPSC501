package code;

import java.lang.reflect.*;
import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;

public class Serializer {
	public static Document serializeObject(Object source) throws Exception {
		return serializeHelper(source, new Document(new Element("serialized")), new IdentityHashMap());
	}

	private static Document serializeHelper(Object source, Document document, Map map) throws Exception {
		String id = Integer.toString(map.size());
		map.put(source, id);
		Class sourceclass = source.getClass();
		
		Element objectElement = new Element("object");
		objectElement.setAttribute("class", sourceclass.getName() );
		objectElement.setAttribute("id", id );
		document.getRootElement().addContent(objectElement);
		
		Class arrayListClass = Class.forName("java.util.ArrayList");
		if (arrayListClass.isInstance(source)) {
			ArrayList<Object> sourceArrayList = (ArrayList)source;
			source = sourceArrayList.toArray();
			sourceclass = source.getClass();
		}
		
		if (!sourceclass.isArray()) {
			Field[] fields = sourceclass.getDeclaredFields();
			for (int i=0; i<fields.length; i++) {
				if (!Modifier.isPublic(fields[i].getModifiers()))
					fields[i].setAccessible(true);
				
				Element fieldElement = new Element("field");
				fieldElement.setAttribute("name", fields[i].getName());
				Class declaringClass = fields[i].getDeclaringClass();
				fieldElement.setAttribute("declaringclass", declaringClass.getName());
				
				Class fieldtype = fields[i].getType();
				Object child = fields[i].get(source);
				if (Modifier.isTransient(fields[i].getModifiers())) {
					child = null;
				}
				fieldElement.addContent(serializeVariable(fieldtype, child, document, map));
				objectElement.addContent(fieldElement);
			}
		} else {
			Class componentType = sourceclass.getComponentType();
			int length = Array.getLength(source);
			objectElement.setAttribute( "length", Integer.toString(length) );
			for (int i=0; i<length; i++) {
				objectElement.addContent(serializeVariable(componentType, Array.get(source,i), document, map));
			}
		}
		return document;
	}
	
	
	private static Element serializeVariable(Class fieldtype, Object child, Document document, Map map) throws Exception {
		if (child == null) {
			return new Element("null");
		}
		else if (!fieldtype.isPrimitive()) {
			Element reference = new Element("reference");
			if (map.containsKey(child)) {
				reference.setText(map.get(child).toString());
			}
			else {
				reference.setText( Integer.toString(map.size()) );
				serializeHelper(child, document, map);
			}
			return reference;
		}
		else {
			Element value = new Element("value");
			value.setText(child.toString());
			return value;
		}
	}
}
