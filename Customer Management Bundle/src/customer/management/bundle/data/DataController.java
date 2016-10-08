package customer.management.bundle.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

import common.ui.bundle.ui.constants.UIConstantsViewIDs;
import customer.management.bundle.views.CustomersView;
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
		updateCustomersView();
	}

//	public void updateCustomer(Customer customer){
//		DAO.updateCustomer(customer);
//	}
	
	public void deleteCustomer(Customer customer){
		DAO.deleteCustomer(customer);
	}
	
	private void updateCustomersView()
	{
		Display.getCurrent().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				
				IViewReference[] viewReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
				for (IViewReference reference : viewReferences) {
					if(reference.getId().equals(UIConstantsViewIDs.CustomerManagementCustomersView))
					{
						IViewPart view = reference.getView(true);
						((CustomersView)view).refresh();
						break;
					}
				}
			}
		});
	}
	
	public List<Customer> getCustomers()
	{
		return customers;
	}
	
}
