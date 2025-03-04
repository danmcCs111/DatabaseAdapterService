package Holders;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateHolder implements Holder
{
	private String columnName;
	private Date ret;
	
	public DateHolder(String columnName)
	{
		this.columnName = columnName;
	}
	
	@Override
	public Object callConversion(ResultSet rs) 
	{
		try {
			this.ret = rs.getDate(columnName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.ret;
	}
	
	public Date getReturnValue()
	{
		return this.ret;
	}

	@Override
	public String getColumnName() 
	{
		return this.columnName;
	}
}
