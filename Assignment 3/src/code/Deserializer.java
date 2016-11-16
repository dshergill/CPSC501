package code;

import java.lang.reflect.*;
import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;

public class Deserializer {
	public static Object deserialize( Document source ) throws Exception
	{
		List objectList = source.getRootElement().getChildren();
		Map map = new HashMap();
		createInstances( map, objectList );
		assignFieldValues( map, objectList );
		return map.get("0");
	}

	private static void createInstances( Map map, List objectList ) throws Exception
	{
		for (int i = 0; i < objectList.size(); i++) {
			Element objectElement = (Element) objectList.get(i);
			Class cls = Class.forName(objectElement.getAttributeValue("class"));
			Object instance = null;
			if (!cls.isArray()) {
				Constructor c = cls.getDeclaredConstructor(null);
				
				if (!Modifier.isPublic(c.getModifiers())) {
					c.setAccessible(true);
				}
				instance = c.newInstance(null);
			} else {
				instance = Array.newInstance(cls.getComponentType(), Integer.parseInt(objectElement.getAttributeValue("length")));
			}
			map.put(objectElement.getAttributeValue("id"), instance);
		}
	}
	
	private static void assignFieldValues( Map map, List objectList ) throws Exception
	{
		for (int i = 0; i < objectList.size(); i++) {
			Element objectElement = (Element) objectList.get(i);
			Object instance = map.get( objectElement.getAttributeValue("id") );
			List fieldElements = objectElement.getChildren();
			if (!instance.getClass().isArray()) {
				for (int j=0; j<fieldElements.size(); j++) {
					Element fieldElement = (Element) fieldElements.get(j);
					String className = fieldElement.getAttributeValue("declaringclass");
					Class fieldDC = Class.forName(className);
					String fieldName = fieldElement.getAttributeValue("name");
					Field field = fieldDC.getDeclaredField(fieldName);
					if (!Modifier.isPublic(field.getModifiers())) {
						field.setAccessible(true);
					}
					Element virtualElement = (Element) fieldElement.getChildren().get(0);
					field.set( instance, deserializeValue( virtualElement, field.getType(), map ) );
				}
			} else {
				Class comptype = instance.getClass().getComponentType();
				for ( int j = 0; j < fieldElements.size(); j++) {
					Array.set( instance, j,
						deserializeValue( (Element)fieldElements.get(j), comptype, map ));
				}
			}
		}
	}
	
	private static Object deserializeValue( Element virtualElement, Class fieldType, Map map ) throws ClassNotFoundException
	{
		String valtype = virtualElement.getName();
		if (valtype.equals("null")) {
			return null;
		} else if (valtype.equals("reference")) {
			return map.get(virtualElement.getText());
		} else {
			if (fieldType.equals(boolean.class)) {
				if (virtualElement.getText().equals("true")) {
					return Boolean.TRUE;
				} else {
				return Boolean.FALSE;
				}
			} else if (fieldType.equals(byte.class)) {
				return Byte.valueOf(virtualElement.getText());
			} else if (fieldType.equals(short.class)) {
				return Short.valueOf(virtualElement.getText());
			} else if (fieldType.equals(int.class)) {
				return Integer.valueOf(virtualElement.getText());
			} else if (fieldType.equals(long.class)) {
				return Long.valueOf(virtualElement.getText());
			} else if (fieldType.equals(float.class)) {
				return Float.valueOf(virtualElement.getText());
			} else if (fieldType.equals(double.class)) {
				return Double.valueOf(virtualElement.getText());
			} else if (fieldType.equals(char.class)) {
				return new Character(virtualElement.getText().charAt(0));
			} else {
				return virtualElement.getText();
			}
		}
	}
	
}
