package Holders;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;

public class HolderParser 
{
	public static Class<?> [] holders = new Class<?>[] {
			Timestamp.class,
			Date.class,
			Integer.class,
			String.class
	};
	
	public static HashMap<String, Class<?>> databaseClassTypeAndHolder =  new HashMap<String, Class<?>>();
	static {
		databaseClassTypeAndHolder.put(Timestamp.class.getName(), DateHolder.class);
		databaseClassTypeAndHolder.put(Date.class.getName(), DateHolder.class);
		databaseClassTypeAndHolder.put(Integer.class.getName(), IntegerHolder.class);
		databaseClassTypeAndHolder.put(String.class.getName(), StringHolder.class);
	}
	
	public static Holder getHolderFromDbType(String databaseClassType, String columnName)
	{
		Holder retHolder = null;
		for(Class<?> dbClassType : holders)
		{
			if(databaseClassType.startsWith(dbClassType.getName()))
			{
				Class<?> holdClass = databaseClassTypeAndHolder.get(dbClassType.getName());
				try {
					retHolder = (Holder) holdClass.getDeclaredConstructor(String.class).newInstance(columnName);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return retHolder;
	}
}
