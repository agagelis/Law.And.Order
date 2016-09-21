package database.project.customer.management;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;

import law.and.orders.platform.dbaccess.JPAUtil;


public class CustomerManagementDB {

	private static Transaction tx;
	private static Session em;
	
//	private static CustomerManagementDB<?> instance = null;
//	public static CustomerManagementDB<?> getInstance(){
//		if(instance == null){
//			instance = new CustomerManagementDB();
//		}
//		return (CustomerManagementDB<?>) instance;
//	}
//	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

	//CRUD Generic Functions for Customers
	public static <T> T saveGeneric(T t) {
		startOperation();
        try{
        		em.save(t);
        		tx.commit();
        		return (T) em.find(t.getClass(), t);
        } 
        catch (Exception ex) {
        	tx.rollback();
        	ex.printStackTrace();
        	return null;
        }finally{        	
        	em.close();
        }
		
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		entityManager.persist(customer);
//		entityManager.getTransaction().commit();
//		Customer find = entityManager.find(Customer.class, customer.getId());
//		entityManager.close();
//		return find;
	}
	
	public static <T> T updateGeneric(T t){
		startOperation();
        try{
        		em.update(t);
        		tx.commit();
        		return (T) em.find(t.getClass(), t);
        } 
        catch (Exception ex) {
        	tx.rollback();
        	ex.printStackTrace();
        	return null;
        }finally{        	
        	em.close();
        }
	}
	
	public static <T> void deleteGeneric(T t)
	{
		startOperation();
		try{
        	em.delete(t);
        	tx.commit();
        } 
        catch (Exception ex) {
        	tx.rollback();
        	ex.printStackTrace();
        }finally{        	
        	em.close();
        }
	}

	public static <T> List<T> selectAllGeneric(Class<T> entityClass)
	{
		startOperation();
		try{
			Query query = em.createQuery("from " + entityClass.getName());
			List<T> genericList =query.getResultList();   
			tx.commit();
		    return genericList;
		} 
        catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }finally{        	
        	em.close();
        }
	}
	
	private static void startOperation() {
		em = JPAUtil.getSessionFactory().getCurrentSession();
		if(em.getTransaction().isActive()){
			tx = em.getTransaction();
		}
		else {
			tx = em.beginTransaction();
		}
    }
}
