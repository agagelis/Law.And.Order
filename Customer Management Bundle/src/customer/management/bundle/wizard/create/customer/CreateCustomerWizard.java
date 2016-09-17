package customer.management.bundle.wizard.create.customer;

import org.eclipse.jface.wizard.Wizard;

public class CreateCustomerWizard extends Wizard {

	CustomerInfoPage customerInfo = new CustomerInfoPage();

	public CreateCustomerWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
		addPage(customerInfo);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
