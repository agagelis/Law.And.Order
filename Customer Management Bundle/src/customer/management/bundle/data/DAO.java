package customer.management.bundle.data;

import java.util.List;

import lno.object.model.domain.Case;
import lno.object.model.domain.Customer;
import database.project.customer.management.*;

public class DAO {

	public static void saveCustomer(Customer customer) {
		CustomerManagementDB.<Customer> saveOrUpdateGeneric(customer);
	}

	// public static void updateCustomer(Customer customer)
	// {
	// CustomerManagementDB.<Customer>updateGeneric(customer);
	// }

	public static void deleteCustomer(Customer customer) {
		CustomerManagementDB.<Customer> deleteGeneric(customer);
	}

	public static void saveCase(Case currentCase) {
		CustomerManagementDB.<Case> saveOrUpdateGeneric(currentCase);

	}

	public static List<Customer> getAllCustomers() {
		return CustomerManagementDB.<Customer> findAllGeneric(Customer.class);
		
	}

	public static List<Case> getAllCases() {
		return CustomerManagementDB.<Case> findAllGeneric(Case.class);
	}
}
