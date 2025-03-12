package Holders;

import java.util.ArrayList;

public class HolderToXml 
{
	public static String holdersToXml(ArrayList<Holder> holders)
	{
		StringBuilder sb = new StringBuilder();
		for(Holder h : holders)
		{
			String tagName = h.getColumnName();
			String value = h.getReturnValueString();
			String classType = h.getClassType().getName();
			sb.append("<" + tagName + " classType=" + classType + ">");
			sb.append(value);
			sb.append("</" + tagName + ">");
			sb.append("\n\n");
		}
		return sb.toString();
	}
}
