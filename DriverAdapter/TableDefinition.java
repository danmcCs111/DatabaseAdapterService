package DriverAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import Holders.Holder;
import Holders.HolderParser;

public class TableDefinition 
{
	private HashMap<String, Holder> tableColumnAndType = new HashMap<String, Holder>();
	private ArrayList<String> tableColumnKeySet = new ArrayList<String>();//orderedKeyset
	
	public void addColumnMetadata(String columnLabel, String columnValue)
	{
		if(!tableColumnKeySet.contains(columnLabel))
		{
			tableColumnKeySet.add(columnLabel);
			System.out.println("**Metadata** " + columnLabel + " --- "  + columnValue);
			tableColumnAndType.put(columnLabel, HolderParser.getHolderFromDbType(columnValue, columnLabel));
		}
		
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
