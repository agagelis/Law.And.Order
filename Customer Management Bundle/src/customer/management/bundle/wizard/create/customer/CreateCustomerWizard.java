package customer.management.bundle.wizard.create.customer;

import lno.object.model.domain.Customer;

import org.eclipse.jface.wizard.Wizard;

import customer.management.bundle.data.DataController;

public class CreateCustomerWizard extends Wizard {

	CustomerInfoPage customerInfo;
	Customer model;

	public CreateCustomerWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
		customerInfo = new CustomerInfoPage();
		addPage(customerInfo);
	}

	@Override
	public boolean performFinish() {
		if (customerInfo.isPageComplete()) {
			DataController.getDataController().saveCustomer(model);
			return true;
		} else
			return false;
	}

	public Customer getModel() {
		return model;
	}

}
