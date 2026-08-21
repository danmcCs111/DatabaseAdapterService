package Holders;

import java.sql.ResultSet;
import java.sql.SQLException;

import DriverAdapter.DriverAdapter;

public class StringHolder implements Holder
{
	private String columnName;
	private String ret;
	
	public StringHolder(String columnName)
	{
		this.columnName = columnName;
	}
	
	@Override
	public Object callConversion(ResultSet rs) 
	{
		try {
			this.ret = rs.getString(columnName);
		} catch (SQLException e) {
			e.printStackTrace();
			DriverAdapter.databaseDriverConsole.setError(e.getMessage());
		}
		return (this.ret == null)
				? null
				: this.ret;
	}
	
	public String getReturnValue()
	{
		return this.ret;
	}

	@Override
	public String getColumnName() 
	{
		return this.columnName;
	}

	@Override
	public String getReturnValueString() 
	{
		return this.ret;
	}

	@Override
	public Class<?> getClassType() 
	{
		return String.class;
	}

}
