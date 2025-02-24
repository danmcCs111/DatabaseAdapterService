package SessionUtil;

import java.util.List;

import org.apache.commons.commons_lang3.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;

import logger.DbAdapterLogger;

public class SessionUtil 
{
	private SessionFactory sessionFactory;
	private Session session;
	
	public void createSession()
	{
		//Get Session
		this.sessionFactory = HibernateUtil.getSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	//TODO just select to log
	public void performQueryTransaction(String query)
	{
		//start transaction
		session.beginTransaction();
		//Save the Model object
		NativeQuery<?> nq = session.createSQLQuery(query);
		List<?> l = nq.getResultList();
		
		for(int i =0; i < l.size(); i++)
		{
			Object [] os = (Object[]) l.get(i);
			for(Object o : os)
			{
				Logger log = DbAdapterLogger.getProjectLogger(); 
				log.info("output - > " + o.toString());
			}
		}
		//Commit transaction
		session.getTransaction().commit();
	}
	
	public void closeSession()
	{
		sessionFactory.close();
	}
}
