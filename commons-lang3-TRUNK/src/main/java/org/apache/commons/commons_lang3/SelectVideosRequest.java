package org.apache.commons.commons_lang3;

import java.sql.Date;

public class SelectVideosRequest 
{
	private int videoId;
	private String 
		videoName,
		videoPath,
		videoExtension;
	private Date insertDate;
	
	public int getVideoDatabaseVideoVideoId() 
	{
		return videoId;
	}
	public void setVideoDatabaseVideoVideoId(int videoId) 
	{
		this.videoId = videoId;
	}
	
	public String getVideoDatabaseVideoVideoName() 
	{
		return videoName;
	}
	public void setVideoDatabaseVideoVideoName(String videoName) 
	{
		this.videoName = videoName;
	}
	
	public String getVideoDatabaseVideoVideoPath() 
	{
		return videoPath;
	}
	public void setVideoDatabaseVideoVideoPath(String videoPath) 
	{
		this.videoPath = videoPath;
	}
	
	public String getVideoDatabaseVideoVideoExtension() 
	{
		return videoExtension;
	}
	public void setVideoDatabaseVideoVideoExtension(String videoExtension) 
	{
		this.videoExtension = videoExtension;
	}
	
	public Date getVideoDatabaseVideoInsertDate() 
	{
		return insertDate;
	}
	public void setInsertDate(Date insertDate) 
	{
		this.insertDate = insertDate;
	}
		
}
