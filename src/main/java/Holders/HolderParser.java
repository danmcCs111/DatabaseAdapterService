package Holders;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;

import DriverAdapter.DriverAdapter;

public class HolderParser 
{
	public static Class<?> [] holders = new Class<?>[] {
			Timestamp.class,
			Date.class,
			Integer.class,
			Float.class,
			Double.class,
			Object.class,//Default as string...
			String.class
	};
	
	public static HashMap<String, Class<?>> databaseClassTypeAndHolder =  new HashMap<String, Class<?>>();
	static {
		databaseClassTypeAndHolder.put(Timestamp.class.getName(), TimestampHolder.class);
		databaseClassTypeAndHolder.put(Date.class.getName(), DateHolder.class);
		databaseClassTypeAndHolder.put(Integer.class.getName(), IntegerHolder.class);
		databaseClassTypeAndHolder.put(Float.class.getName(), FloatHolder.class);
		databaseClassTypeAndHolder.put(Double.class.getName(), DoubleHolder.class);
		databaseClassTypeAndHolder.put(Object.class.getName(), StringHolder.class);//Default as string...
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
				} catch (Exception e) {
					e.printStackTrace();
					DriverAdapter.databaseDriverConsole.setError(e.getMessage());
				}
			}
		}
		return retHolder;
	}
}
