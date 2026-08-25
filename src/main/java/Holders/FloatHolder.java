package Holders;

import java.sql.ResultSet;
import java.sql.SQLException;

import DriverAdapter.DriverAdapter;

public class FloatHolder implements Holder
{
	private String columnName;
	private float ret;
	
	public FloatHolder(String columnName)
	{
		this.columnName = columnName;
	}
	
	@Override
	public Object callConversion(ResultSet rs) 
	{
		try {
			this.ret = rs.getFloat(columnName);
		} catch (SQLException e) {
			e.printStackTrace();
			DriverAdapter.databaseDriverConsole.setError(e.getMessage());
		}
		return this.ret;
	}
	
	public float getReturnValue()
	{
		return ret;
	}

	@Override
	public String getColumnName() 
	{
		return this.columnName;
	}

	@Override
	public String getReturnValueString() 
	{
		return this.ret + "";
	}

	@Override
	public Class<?> getClassType() 
	{
		return Integer.class;
	}
}
