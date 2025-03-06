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
		videoMap.add(new IntegerHolder("VideoId_Video_VideoDatabase"));
	    videoMap.add(new StringHolder("VideoName_Video_VideoDatabase"));
	    videoMap.add(new StringHolder("VideoPath_Video_VideoDatabase"));
	    videoMap.add(new StringHolder("VideoExtension_Video_VideoDatabase"));
	    videoMap.add(new DateHolder("InsertDate_Video_VideoDatabase"));
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
