package customer.management.bundle.data;

import lno.object.model.domain.Customer;
import database.project.customer.management.*;

public class DAO {

	public static void saveCustomer(Customer customer)
	{
		CustomerManagementDB.<Customer>saveGeneric(customer);
	}
	
	public static void updateCustomer(Customer customer)
	{
		CustomerManagementDB.<Customer>updateGeneric(customer);
	}
	
	public static void deleteCustomer(Customer customer)
	{
		CustomerManagementDB.<Customer>deleteGeneric(customer);
	}
}
