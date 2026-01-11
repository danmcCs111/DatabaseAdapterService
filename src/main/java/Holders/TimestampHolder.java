package Holders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TimestampHolder implements Holder
{
	private String columnName;
	private Timestamp ret;
	
	public TimestampHolder(String columnName)
	{
		this.columnName = columnName;
	}
	
	@Override
	public Object callConversion(ResultSet rs) 
	{
		try {
			this.ret = rs.getTimestamp(columnName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (this.ret == null)
				? null
				: this.ret.getTime();
	}
	
	public Timestamp getReturnValue()
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
		return this.ret == null
				? ""
				: this.ret.getTime() + "";
	}

	@Override
	public Class<?> getClassType() 
	{
		return Timestamp.class;
	}
}
