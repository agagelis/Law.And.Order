package customer.management.bundle.wizard.create.cases;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class CaseInfoPage extends WizardPage {
	private Composite container;
	private Text txtName;
	private Text txtTrialdate;
	private Text txtPostponements;
	private Text txtStatus;
	private Label lblStatus;
	private Label lblPostponements;
	private Label lblTrialdate;
	private Label lblType;
	private Label lblName;

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
		container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblType = new Label(container, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setText("Type");
		
		Combo cmbType = new Combo(container, SWT.NONE);
		cmbType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblTrialdate = new Label(container, SWT.NONE);
		lblTrialdate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTrialdate.setText("TrialDate");
		
		txtTrialdate = new Text(container, SWT.BORDER);
		txtTrialdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblPostponements = new Label(container, SWT.NONE);
		lblPostponements.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPostponements.setText("Postponements");
		
		txtPostponements = new Text(container, SWT.BORDER);
		txtPostponements.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtPostponements.setText("0");
		
		lblStatus = new Label(container, SWT.NONE);
		lblStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStatus.setText("Status");
		
		txtStatus = new Text(container, SWT.BORDER);
		txtStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	public void saveDataToModel() {
		// TODO Auto-generated method stub
		
	}

}
