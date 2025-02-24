package org.apache.commons.commons_lang3;

import java.sql.Date;

public class Video 
{
	private int videoId;
	private String 
		videoName,
		videoPath,
		videoExtension;
	private Date insertDate;
	
	public int getVideoId() 
	{
		return videoId;
	}
	public void setVideoId(int videoId) 
	{
		this.videoId = videoId;
	}
	
	public String getVideoName() 
	{
		return videoName;
	}
	public void setVideoName(String videoName) 
	{
		this.videoName = videoName;
	}
	
	public String getVideoPath() 
	{
		return videoPath;
	}
	public void setVideoPath(String videoPath) 
	{
		this.videoPath = videoPath;
	}
	
	public String getVideoExtension() 
	{
		return videoExtension;
	}
	public void setVideoExtension(String videoExtension) 
	{
		this.videoExtension = videoExtension;
	}
	
	public Date getInsertDate() 
	{
		return insertDate;
	}
	public void setInsertDate(Date insertDate) 
	{
		this.insertDate = insertDate;
	}
		
}
