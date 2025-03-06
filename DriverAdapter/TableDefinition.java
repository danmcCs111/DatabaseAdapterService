package DriverAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import Holders.Holder;
import Holders.HolderParser;

public class TableDefinition 
{
	private HashMap<String, Holder> tableColumnAndType = new HashMap<String, Holder>();
	private ArrayList<String> tableColumnKeySet = new ArrayList<String>();//orderedKeyset
	
	public void addColumnAndType(String columnLabel, String columnType)
	{
		tableColumnKeySet.add(columnLabel);
		tableColumnAndType.put(columnLabel, HolderParser.getHolder(columnType, columnLabel));
	}
	
	public ArrayList<String> getTableColumnsKeySet()
	{
		return tableColumnKeySet;
	}
	
	public Holder getHolder(String columnNameKey)
	{
		return tableColumnAndType.get(columnNameKey);
	}
}
