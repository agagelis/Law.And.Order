package law.and.orders.platform.dbaccess;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.osgi.framework.Bundle;

public class JPAUtil {

	private static final SessionFactory sessionFactory ;
	
    static {
        try {
        	String property = System.getProperty("file.separator");
        	System.out.println("##"+property+"##");
        	Bundle bundle = Platform.getBundle("LNO.Object.Model");
        	URL fileURL = bundle.getEntry("hibernate.cfg.xml");
        	File file = null;
        	try {
        		String path = FileLocator.resolve(fileURL).getPath();
//        		path = path.replace(" ", "%20");
        	    file = new File(path);
        	    System.out.println("File opened");
        	} catch (IOException e1) {
        	    e1.printStackTrace();
        	}
        	//Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
//        	sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        	sessionFactory = new Configuration().configure(file).buildSessionFactory();
            //StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            //sb.applySettings(cfg.getProperties());
            //StandardServiceRegistry standardServiceRegistry = sb.build();                   
            //sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    } 
}
