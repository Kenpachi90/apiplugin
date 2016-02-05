package hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTemplate {
	
	private static HibernateTemplate instance;
	private SessionFactory sessionFactory;
	
	public static HibernateTemplate getInstance(){
		if(instance == null){
			instance = new HibernateTemplate();
		}
		return instance;
	}
	
	private HibernateTemplate(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
	}
	public Collection query(String hql){
		Session session = sessionFactory.openSession();
		//session.beginTransaction();
		List list = session.createQuery(hql).list();
		session.close();
		return list;
	}
	
	/*
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	TestClass test = new TestClass(2);
	
	session.saveOrUpdate(testResultSet);
	session.getTransaction().commit();
	session.close();
	
	System.out.println("hm...");*/

}
