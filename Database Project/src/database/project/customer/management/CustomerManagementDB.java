package database.project.customer.management;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import law.and.orders.platform.dbaccess.JPAUtil;
import lno.object.model.domain.Customer;

public class CustomerManagementDB<T> {

	//private T t;
	private Class<T> entityClass;
	private static Transaction tx;
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

	//CRUD Generic Functions for Customers
	public T saveGeneric(T t) {
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		if(em.getTransaction().isActive()){
			tx = em.getTransaction();
		}
		else {
			tx = em.beginTransaction();
		}
		
        try{
        		em.save(t);
        		tx.commit();
        		em.close();
        		return em.find(entityClass, t);
        } 
        catch (Exception ex) {
        	tx.rollback();
        	ex.printStackTrace();
        	em.close();
        	return null;
        }
		
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		entityManager.persist(customer);
//		entityManager.getTransaction().commit();
//		Customer find = entityManager.find(Customer.class, customer.getId());
//		entityManager.close();
//		return find;
	}
	
	public T updadteGeneric(T t){
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		if(em.getTransaction().isActive()){
			tx = em.getTransaction();
		}
		else {
			tx = em.beginTransaction();
		}
		
        try{
        		em.update(t);
        		tx.commit();
        		em.close();
        		return em.find(entityClass, t);
        } 
        catch (Exception ex) {
        	tx.rollback();
        	ex.printStackTrace();
        	em.close();
        	return null;
        }
	}
	
	public void deleteGeneric(T t)
	{
		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		if(s.getTransaction().isActive()){
			tx = s.getTransaction();
		}
		else {
			tx = s.beginTransaction();
		}
		
		try{
        	s.delete(t);
        	tx.commit();
        	s.close();
        } 
        catch (Exception ex) {
        	tx.rollback();
        	ex.printStackTrace();
        	s.close();
        }
	}
}
