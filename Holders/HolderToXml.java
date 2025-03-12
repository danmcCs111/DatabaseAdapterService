package Holders;

import java.util.ArrayList;

public class HolderToXml 
{
	public static String holdersToXml(ArrayList<ArrayList<Holder>> holders)
	{
		StringBuilder sb = new StringBuilder();
		for(ArrayList<Holder> hlds : holders)
		{
			for(Holder h : hlds)
			{
				String tagName = h.getColumnName();
				String value = h.getReturnValueString();
				String classType = h.getClassType().getName();
				sb.append("<" + tagName + " classType=" + classType + ">");
				sb.append(value);
				sb.append("</" + tagName + ">");
				sb.append("\n");
			}
			sb.append("\n\n");
		}
		return sb.toString();
	}
}
