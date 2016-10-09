package customer.management.bundle.wizard.create.cases;

import java.util.Calendar;

import lno.object.model.domain.Case;
import lno.object.model.domain.Customer;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class CaseInfoPage extends WizardPage {
	private Composite container;
	private Text txtName;
	private DateTime txtTrialdate;
	private Text txtPostponements;
	private Text txtStatus;
	private Label lblStatus;
	private Label lblPostponements;
	private Label lblTrialdate;
	private Label lblType;
	private Label lblName;
	private DateTime txtTrialTime;

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
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));

		lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblName.setText("Name");

		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));

		lblType = new Label(container, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblType.setText("Type");

		Combo cmbType = new Combo(container, SWT.NONE);
		cmbType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));

		lblTrialdate = new Label(container, SWT.NONE);
		lblTrialdate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblTrialdate.setText("TrialDate");

		txtTrialdate = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN);
		txtTrialdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		txtTrialTime = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN
				| SWT.TIME | SWT.SHORT);
		txtTrialTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		lblPostponements = new Label(container, SWT.NONE);
		lblPostponements.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		lblPostponements.setText("Postponements");

		txtPostponements = new Text(container, SWT.BORDER);
		txtPostponements.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		txtPostponements.setText("0");

		lblStatus = new Label(container, SWT.NONE);
		lblStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblStatus.setText("Status");

		txtStatus = new Text(container, SWT.BORDER);
		txtStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
	}

	public void saveDataToModel() {
		CreateCaseWizard wizard = (CreateCaseWizard) getWizard();
		Case model = wizard.getModel();
		model.setTitle(txtName.getText());
		model.setPostponements(Integer.parseInt(txtPostponements.getText()));
		model.setStatus(txtStatus.getText());

		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_MONTH, txtTrialdate.getDay());
		instance.set(Calendar.YEAR, txtTrialdate.getYear());
		instance.set(Calendar.MONTH, txtTrialdate.getMonth());
		instance.set(Calendar.HOUR_OF_DAY, txtTrialTime.getHours());
		instance.set(Calendar.MINUTE, txtTrialTime.getMinutes());
		model.setCourtDate(instance.getTime());
		

	}

}
