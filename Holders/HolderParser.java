package Holders;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;

public class HolderParser 
{
	public static Class<?> [] holders = new Class<?>[] {
			Date.class,
			int.class,
			String.class
	};
	
	public static HashMap<Class<?>, Class<?>> classAndHolder =  new HashMap<Class<?>, Class<?>>();
	static {
		classAndHolder.put(Date.class, DateHolder.class);
		classAndHolder.put(int.class, IntegerHolder.class);
		classAndHolder.put(String.class, StringHolder.class);
	}
	
	public static Holder getHolder(String classType, String columnName)
	{
		Holder retHolder = null;
		for(Class<?> clazz : holders)
		{
			if(clazz.getName().equals(classType))
			{
				Class<?> holdClass = classAndHolder.get(clazz);
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
