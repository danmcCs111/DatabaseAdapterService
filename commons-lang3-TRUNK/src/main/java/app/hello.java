package app;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.commons_lang3.HibernateUtil;
import org.apache.commons.commons_lang3.Video;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

public class hello 
{
	public static void main(String [] args)
	{
		System.out.println("hello world");
		
		Video video = new Video();
		video.setVideoId(2);
		video.setVideoName("David");
		video.setVideoPath("Developer");
		video.setVideoExtension(".url");
		video.setInsertDate(new Date(Calendar.getInstance().getTime().getTime()));
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//start transaction
		session.beginTransaction();
//		session.create
		//Save the Model object
		NativeQuery nq = session.createSQLQuery("select * from videodatabase.Video");
		List l = nq.getResultList();
		for(int i =0; i < l.size(); i++)
		{
			Object [] os = (Object[]) l.get(i);
			for(Object o : os)
				System.out.println("output - > " + o.toString());
		}
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID=" + video.getVideoId());
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}
}
