package database.project.customer.management;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import law.and.orders.platform.dbaccess.JPAUtil;


public class CustomerManagementDB {

	private static Transaction tx;
	private static Session em;
	
//	private T t;
//
//  public void set(T t) { this.t = t; }
//  public T get() { return t; }

	private static void startOperation() {
		em = JPAUtil.getSessionFactory().getCurrentSession();
		if(em.getTransaction().isActive()){
			tx = em.getTransaction();
		}
		else {
			tx = em.beginTransaction();
		}
    }
	//CRUD Generic Functions
	public static <T> T saveOrUpdateGeneric(T t) {
		startOperation();
        try{
        		em.saveOrUpdate(t);
        		tx.commit();
        		return t;
        } 
        catch (Exception ex) {
        	ex.printStackTrace();
        	tx.rollback();
        	return null;
        }finally{        	
        	em.close();
        }
	}
	
	public static <T> T updateGeneric(T t){
		startOperation();
        try{
        		em.update(t);
        		tx.commit();
        		return t;
        } 
        catch (Exception ex) {
        	ex.printStackTrace();
        	tx.rollback();
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
        	ex.printStackTrace();
        	tx.rollback();
        }finally{        	
        	em.close();
        }
	}

	@SuppressWarnings("unchecked")
	public static <T> T findByIdGeneric(int id, Class<T> t) {
		startOperation();
		T find = (T) em.find(t.getClass() , id);
        return find;
    }
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> findAllGeneric(Class<T> entityClass)
	{
		startOperation();
		try{
			Query<T> query = em.createQuery("from " + entityClass.getName());
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
}
