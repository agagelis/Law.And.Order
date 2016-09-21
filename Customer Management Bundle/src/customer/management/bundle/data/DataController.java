package customer.management.bundle.data;

import java.util.ArrayList;
import java.util.List;

import lno.object.model.domain.Customer;

public class DataController {

	private static DataController controller = new DataController();
	private List<Customer> customers;

	private DataController() {
		customers = new ArrayList<>();
	}

	public static DataController getDataController() {
		return controller;
	}

	public void saveCustomer(Customer customer) {
		DAO.saveCustomer(customer);
		if (customers.contains(customer)) {
			customers.set(customers.indexOf(customer), customer);
		} else {
			customers.add(customer);
		}
	}

	public void updateCustomer(Customer customer){
		DAO.updateCustomer(customer);
	}
	
	public void deleteCustomer(Customer customer){
		DAO.deleteCustomer(customer);
	}
}
