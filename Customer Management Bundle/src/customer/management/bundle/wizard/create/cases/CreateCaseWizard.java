package customer.management.bundle.wizard.create.cases;

import lno.object.model.domain.Customer;

import org.eclipse.jface.wizard.Wizard;

import customer.management.bundle.data.DataController;

public class CreateCaseWizard extends Wizard {

	CaseInfoPage caseInfo;
	Customer model;

	public CreateCaseWizard() {
		setWindowTitle("New Wizard");
		model = new Customer();
	}

	@Override
	public void addPages() {
		caseInfo = new CaseInfoPage();
		addPage(caseInfo);
	}

	@Override
	public boolean performFinish() {
		if (caseInfo.isPageComplete()) {
			caseInfo.saveDataToModel();
			DataController.getDataController().saveCustomer(model);
			return true;
		} else
			return false;
	}

	public Customer getModel() {
		return model;
	}

}
