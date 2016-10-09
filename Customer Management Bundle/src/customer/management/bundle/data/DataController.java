package customer.management.bundle.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

import common.ui.bundle.ui.constants.UIConstantsViewIDs;
import customer.management.bundle.views.CasesView;
import customer.management.bundle.views.CustomersView;
import lno.object.model.domain.Case;
import lno.object.model.domain.Customer;

public class DataController {

	private static DataController controller = new DataController();
	private List<Customer> customers;
	private List<Case> cases;

	private DataController() {
		customers = new ArrayList<>();
		cases = new ArrayList<>();
		initialize();
	}

	public static DataController getDataController() {
		return controller;
	}

	private void initialize() {
		customers = DAO.getAllCustomers();
		cases = DAO.getAllCases();

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

	public void saveCase(Case currentCase) {
		DAO.saveCase(currentCase);
		if (cases.contains(currentCase)) {
			cases.set(cases.indexOf(currentCase), currentCase);
		} else {
			cases.add(currentCase);
		}
		updateCustomersView();
	}

	// public void updateCustomer(Customer customer){
	// DAO.updateCustomer(customer);
	// }

	public void deleteCustomer(Customer customer) {
		DAO.deleteCustomer(customer);
	}

	private void updateCustomersView() {
		Display.getCurrent().asyncExec(new Runnable() {

			@Override
			public void run() {

				IViewReference[] viewReferences = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getViewReferences();
				for (IViewReference reference : viewReferences) {
					if (reference.getId().equals(
							UIConstantsViewIDs.CustomerManagementCustomersView)) {
						IViewPart view = reference.getView(true);
						((CustomersView) view).refresh();
						break;
					}
				}
			}
		});
	}

	private void updateCasesView() {
		Display.getCurrent().asyncExec(new Runnable() {

			@Override
			public void run() {

				IViewReference[] viewReferences = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getViewReferences();
				for (IViewReference reference : viewReferences) {
					if (reference
							.getId()
							.equals(UIConstantsViewIDs.CustomerManagementCustomerCasesView)) {
						IViewPart view = reference.getView(true);
						((CasesView) view).refresh();
						break;
					}
				}
			}
		});
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Case> getCases() {
		return cases;
	}

}
