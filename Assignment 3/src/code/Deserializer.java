package code;

import java.lang.reflect.*;
import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;

public class Deserializer {
	public static Object deserialize(Document source) throws Exception
	{
		List objList = source.getRootElement().getChildren();
		Map map = new HashMap();
		createInstances( map, objList );
		assignFieldValues( map, objList );
		return map.get("0");
	}

	private static void assignFieldValues(Map map, List objList) throws Exception {
		for (int i = 0; i < objList.size(); i++) {
			Element objectElement = (Element) objList.get(i);
			Object instance = map.get( objectElement.getAttributeValue("id") );
			List fieldElements = objectElement.getChildren();
			if (!instance.getClass().isArray()) {
				for (int j=0; j<fieldElements.size(); j++) {
					Element fieldElement = (Element) fieldElements.get(j);
					String className = fieldElement.getAttributeValue("declaringclass");
					Class fieldDC = Class.forName(className);
					String fieldName = fieldElement.getAttributeValue("name");
					Field f = fieldDC.getDeclaredField(fieldName);
					if (!Modifier.isPublic(f.getModifiers())) {
						f.setAccessible(true);
					}
					Element vElt = (Element) fieldElement.getChildren().get(0);
					f.set( instance, deserializeValue( vElt, f.getType(), map ) );
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

	private static void createInstances(Map map, List objList) throws Exception {
		for (int i = 0; i < objList.size(); i++) {
			Element objectElement = (Element) objList.get(i);
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
	private static Object deserializeValue( Element vElt, Class fieldType, Map map ) throws ClassNotFoundException
	{
		String valtype = vElt.getName();
		if (valtype.equals("null")) {
			return null;
		} else if (valtype.equals("reference")) {
			return map.get(vElt.getText());
		} else {
			if (fieldType.equals(boolean.class)) {
				if (vElt.getText().equals("true")) {
					return Boolean.TRUE;
				} else {
				return Boolean.FALSE;
				}
			} else if (fieldType.equals(byte.class)) {
				return Byte.valueOf(vElt.getText());
			} else if (fieldType.equals(short.class)) {
				return Short.valueOf(vElt.getText());
			} else if (fieldType.equals(int.class)) {
				return Integer.valueOf(vElt.getText());
			} else if (fieldType.equals(long.class)) {
				return Long.valueOf(vElt.getText());
			} else if (fieldType.equals(float.class)) {
				return Float.valueOf(vElt.getText());
			} else if (fieldType.equals(double.class)) {
				return Double.valueOf(vElt.getText());
			} else if (fieldType.equals(char.class)) {
				return new Character(vElt.getText().charAt(0));
			} else {
				return vElt.getText();
			}
		}
	}
	
}
