package database.project.customer.management;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lno.object.model.domain.Customer;

public class CustomerManagementDB {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

	public static List<Customer> getAllCustomers() {
		return null;
	}

	public static Customer saveCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		Customer find = entityManager.find(Customer.class, customer.getId());
		entityManager.close();
		return find;
	}

}
