package DriverAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Holders.Holder;
import Holders.HolderParser;

public class TableDefinition 
{
	private LinkedHashMap<String, Holder> tableColumnAndType = new LinkedHashMap<String, Holder>();
	private ArrayList<String> tableColumnKeySet = new ArrayList<String>();//orderedKeyset
	
	public TableDefinition cloneTableDefinition()
	{
		return addAllColumnMetadata(this);
	}
	
	public void addColumnMetadata(String columnLabel, String columnValue)
	{
		if(!tableColumnKeySet.contains(columnLabel))
		{
			tableColumnKeySet.add(columnLabel);
			System.out.println("**Metadata** " + columnLabel + " --- "  + columnValue);
			tableColumnAndType.put(columnLabel, HolderParser.getHolderFromDbType(columnValue, columnLabel));
		}
		
	}
	
	protected TableDefinition addAllColumnMetadata(TableDefinition td)
	{
		TableDefinition tdNew = new TableDefinition();
		for(String key : tableColumnAndType.keySet())
		{
			String val = tableColumnAndType.get(key).getClassType().getName();
			System.out.println("value type: " + val);
			tdNew.addColumnMetadata(key, val);
		}
		return tdNew;
	}
	
	public ArrayList<String> getTableColumnsKeySet()
	{
		return tableColumnKeySet;
	}
	
	public Holder getHolder(String columnFieldName)
	{
		return tableColumnAndType.get(columnFieldName);
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(String tc : tableColumnKeySet)
		{
			sb.append(tc + " ");
		}
		return sb.toString();
	}
}
