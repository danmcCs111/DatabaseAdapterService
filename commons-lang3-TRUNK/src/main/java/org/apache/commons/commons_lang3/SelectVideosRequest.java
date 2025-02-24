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
	
	public int getVideoDatabase_Video_VideoId() 
	{
		return videoId;
	}
	public void setVideoDatabase_Video_VideoId(int videoId) 
	{
		this.videoId = videoId;
	}
	
	public String getVideoDatabase_Video_VideoName() 
	{
		return videoName;
	}
	public void setVideoDatabase_Video_VideoName(String videoName) 
	{
		this.videoName = videoName;
	}
	
	public String getVideoDatabase_Video_VideoPath() 
	{
		return videoPath;
	}
	public void setVideoDatabase_Video_VideoPath(String videoPath) 
	{
		this.videoPath = videoPath;
	}
	
	public String getVideoDatabase_Video_VideoExtension() 
	{
		return videoExtension;
	}
	public void setVideoDatabase_Video_VideoExtension(String videoExtension) 
	{
		this.videoExtension = videoExtension;
	}
	
	public Date getVideoDatabase_Video_InsertDate() 
	{
		return insertDate;
	}
	public void setVideoDatabase_Video_InsertDate(Date insertDate) 
	{
		this.insertDate = insertDate;
	}
		
}
