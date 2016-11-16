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
			IdentityHashMap<Object, Object> map) throws Exception {
		String id = Integer.toString(map.size());
		map.put(source, id);
		Class sourceClass = source.getClass();
		Element objectElement = new Element("object");

		Class arrayListClass = Class.forName("java.util.ArrayList");
		
		if(arrayListClass.isInstance(source)) 
		{
			ArrayList<Object> sourceArrayList = (ArrayList<Object>) source;
			source = sourceArrayList.toArray();
			sourceClass.getClass();
		}
		if(!sourceClass.isArray())
		{
			Field[] fields = sourceClass.getDeclaredFields();
			for (int i=0; i<fields.length; i++) {
				if (Modifier.isPublic(fields[i].getModifiers()))
				{
					fields[i].setAccessible(true);
				}
				Element fieldElement = new Element("field");
				fieldElement.setAttribute("name", fields[i].getName());
				Class<?> declClass = fields[i].getDeclaringClass();
				fieldElement.setAttribute("declaringclass", declClass.getName());
				
				Class fieldtype = fields[i].getType();
				Object child = fields[i].get(source);
				if (Modifier.isTransient(fields[i].getModifiers())) {
					child = null;
				}
				fieldElement.addContent(serializeVariable(fieldtype, child, doc, map));
				objectElement.addContent(fieldElement);
			}
				
		} else {
			Class componentType = sourceClass.getComponentType();
			int length = Array.getLength(source);
			objectElement.setAttribute( "length", Integer.toString(length) );
			for (int i=0; i<length; i++) {
				objectElement.addContent(serializeVariable(componentType, Array.get(source,i), doc, map));
			}
		}

		return doc;
	}

	private static Element serializeVariable(Class fieldtype, Object child, Document doc,
			IdentityHashMap<Object, Object> map) throws Exception {
		if (child == null)
		{ 
			return new Element("null");
		}
		else if (!fieldtype.isPrimitive()) {
			Element reference = new Element("reference");
			if(map.containsKey(child))
			{
				reference.setText(map.get(child).toString());
			} else {
				reference.setText(Integer.toString(map.size()));
				serializeHelper(child, doc, map);
			}
			return reference;
		} else {
			Element value = new Element("value");
			value.setText(child.toString());
			return value;
		}
	}
}
