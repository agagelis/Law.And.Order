package customer.management.bundle.wizard.create.cases;

import lno.object.model.domain.Case;
import lno.object.model.domain.Customer;

import org.eclipse.jface.wizard.Wizard;

import customer.management.bundle.data.DataController;

public class CreateCaseWizard extends Wizard {

	CaseInfoPage caseInfo;
	Case model;

	public CreateCaseWizard() {
		setWindowTitle("New Wizard");
		model = new Case();
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
			DataController.getDataController().saveCase(model);
			return true;
		} else
			return false;
	}

	public Case getModel() {
		return model;
	}

}
