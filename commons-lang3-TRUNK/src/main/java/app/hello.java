package app;

import java.sql.Date;
import java.util.Calendar;

import org.apache.commons.commons_lang3.HibernateUtil;
import org.apache.commons.commons_lang3.Video;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(video);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID=" + video.getVideoId());
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}
}
