package DriverAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtility 
{
	public static ArrayList<String> getMatches(String textToMatch, String regexMatch)
	{
		ArrayList<String> values = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile(regexMatch);
		Matcher matcher = pattern.matcher(textToMatch);
		while (matcher.find()) 
		{
			String value = matcher.group();
			values.add(value);
		}
		return values;
	}
	
}
