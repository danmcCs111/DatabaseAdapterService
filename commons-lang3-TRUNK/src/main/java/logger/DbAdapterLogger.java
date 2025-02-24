package logger;

import org.slf4j.Logger;
import org.slf4j.impl.Log4jLoggerFactory;

public interface DbAdapterLogger//TODO
{
	public static Logger getProjectLogger()
	{
		Log4jLoggerFactory lf = new Log4jLoggerFactory();
		Logger log = lf.getLogger(Logger.ROOT_LOGGER_NAME);
		return log;
	}
	
}
