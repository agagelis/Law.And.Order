package customer.management.bundle.wizard.create.customer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class CustomerInfoPage extends WizardPage {
	private Label lblName;
	private Text txtName;
	private Label lblLastname;
	private Text txtLastname;

	/**
	 * Create the wizard.
	 */
	public CustomerInfoPage() {
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
		container.setLayout(new GridLayout(2, false));
		
		lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.setText("Name");
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblLastname = new Label(container, SWT.NONE);
		lblLastname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastname.setText("LastName");
		
		txtLastname = new Text(container, SWT.BORDER);
		txtLastname.setText("LastName");
		txtLastname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

}
