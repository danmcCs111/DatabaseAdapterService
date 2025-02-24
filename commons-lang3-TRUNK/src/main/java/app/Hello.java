package app;

import org.slf4j.Logger;

import SessionUtil.SessionUtil;
import logger.DbAdapterLogger;

public class Hello 
{
	public static void main(String [] args)
	{
		Logger log = DbAdapterLogger.getProjectLogger();
		log.info("hello world");
		SessionUtil session = new SessionUtil();
		session.createSession();
		session.performQueryTransaction("select * from videodatabase.Video");
		
		//terminate session factory, otherwise program won't end
		session.closeSession();
	}
}
