package customer.management.bundle.wizard.create.cases;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;

public class CaseInfoPage extends WizardPage {

	/**
	 * Create the wizard.
	 */
	public CaseInfoPage() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
	}

	public void saveDataToModel() {
		// TODO Auto-generated method stub
		
	}

}
