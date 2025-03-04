package DriverAdapter;

import java.util.ArrayList;

import Holders.DateHolder;
import Holders.Holder;
import Holders.IntegerHolder;
import Holders.StringHolder;

public class VideoSelect 
{
	public static final String SELECT_SQL = "select * from videodatabase.video";
	public static ArrayList<Holder> videoMap = new ArrayList<Holder>();
	static {
		videoMap.add(new IntegerHolder("VideoIdVideoVideoDatabase"));
	    videoMap.add(new StringHolder("VideoNameVideoVideoDatabase"));
	    videoMap.add(new StringHolder("VideoPathVideoVideoDatabase"));
	    videoMap.add(new StringHolder("VideoExtensionVideoVideoDatabase"));
	    videoMap.add(new DateHolder("InsertDateVideoVideoDatabase"));
	}
	
	public static ArrayList<Holder> getHolders()
	{
		return videoMap;
	}
	
	public static String getSelectQuery()
	{
		return SELECT_SQL;
	}
}
