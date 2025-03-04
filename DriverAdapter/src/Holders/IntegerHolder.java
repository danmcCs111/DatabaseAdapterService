package Holders;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerHolder implements Holder
{
	private String columnName;
	private int ret;
	
	public IntegerHolder(String columnName)
	{
		this.columnName = columnName;
	}
	
	@Override
	public Object callConversion(ResultSet rs) 
	{
		try {
			this.ret = rs.getInt(columnName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.ret;
	}
	
	public int getReturnValue()
	{
		return ret;
	}

	@Override
	public String getColumnName() 
	{
		return this.columnName;
	}

}
