package Holders;

import java.util.ArrayList;

public class HolderToXml 
{
	public static String holdersToXml(ArrayList<ArrayList<Holder>> holders)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<ResultSet>" + "\n");
		for(ArrayList<Holder> hlds : holders)
		{
			sb.append("<Result>");
			sb.append("\n");
			for(Holder h : hlds)
			{
				String tagName = h.getColumnName();
				String value = h.getReturnValueString();
				String classType = h.getClassType().getName();
				sb.append("<" + tagName + " classType=" + '"' + classType + '"' + ">");
				sb.append(value);
				sb.append("</" + tagName + ">");
				sb.append("\n");
			}
			sb.append("</Result>");
			sb.append("\n");
		}
		sb.append("</ResultSet>");
		return sb.toString();
	}
}
