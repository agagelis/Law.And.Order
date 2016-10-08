package database.project.customer.management;

import lno.object.model.domain.Customer;

public class TestCustomerManagement {

	public static void main(String[] args) {

		Customer c1 = new Customer();
		c1.setFirstName("Aggelos");
		c1.setLastName("Aggelis");
		c1.setAfm("123456");
		c1.setOccupation("MHX");
		
		
		CustomerManagementDB.saveOrUpdateGeneric(c1);
		System.out.println(c1.getId());
	}

}
