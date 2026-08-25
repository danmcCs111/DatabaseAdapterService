package Holders;

import java.sql.ResultSet;
import java.sql.SQLException;

import DriverAdapter.DriverAdapter;

public class DoubleHolder implements Holder
{
	private String columnName;
	private double ret;
	
	public DoubleHolder(String columnName)
	{
		this.columnName = columnName;
	}
	
	@Override
	public Object callConversion(ResultSet rs) 
	{
		try {
			this.ret = rs.getDouble(columnName);
		} catch (SQLException e) {
			e.printStackTrace();
			DriverAdapter.databaseDriverConsole.setError(e.getMessage());
		}
		return this.ret;
	}
	
	public double getReturnValue()
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
