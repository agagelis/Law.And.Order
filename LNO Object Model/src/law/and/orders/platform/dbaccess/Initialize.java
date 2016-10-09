package law.and.orders.platform.dbaccess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.HibernateException;

public class Initialize {
	
	private static void eraseData() {
	   	//Session session = JPAUtil.getSessionFactory().getCurrentSession();
		try{
			JPAUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			JPAUtil.getSessionFactory().getCurrentSession().createQuery("delete from User").executeUpdate();
//			JPAUtil.getSessionFactory().getCurrentSession().createQuery("delete from Customer").executeUpdate();
//			JPAUtil.getSessionFactory().getCurrentSession().createQuery("delete from Case").executeUpdate();
		} 
        catch (Exception ex) {
        	System.out.println(ex);
        }
    }

	public static void prepareData() {
		try { 
			//Delete all previous data
//			eraseData();
			
			//Insert Docs
		} 
		catch (HibernateException e) { 
			e.printStackTrace();
		}

	}
}
