package Holders;

import java.sql.ResultSet;

public interface Holder 
{
	public Object callConversion(ResultSet rs);
	public String getColumnName();
	public String getReturnValueString();
	public Class<?> getClassType();
}
