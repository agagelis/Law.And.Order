package customer.management.bundle.wizard.create.customer;

import lno.object.model.domain.Customer;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.fieldassist.ControlDecoration;

public class CustomerInfoPage extends WizardPage {
	private Label lblName;
	private Text txtName;
	private Label lblLastname;
	private Text txtLastname;
	private Label lblAFM;
	private Text txtAFM;
	private Label lblEmail;
	private Text txtEmail;
	private List list;
	private ListViewer listViewer;
	private Label lblPhones;
	private Button btnDeleteTelephone;
	private Composite cmpTelephoneButtons;
	private Button btnAddTelephone;

	private Image imgAdd = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);
	private Image imgDelete = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ELCL_REMOVE);
	private Label lblOccupation;
	private Text txtOccupation;
	private ControlDecoration controlDecorationName;
	private ControlDecoration controlDecorationLastName;

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
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		GridLayout gl_container = new GridLayout(3, false);
		gl_container.horizontalSpacing = 8;
		container.setLayout(gl_container);

		lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Όνομα");

		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		controlDecorationName = new ControlDecoration(txtName, SWT.LEFT | SWT.TOP);
		controlDecorationName.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_WARNING));
		controlDecorationName.setDescriptionText("Some description");

		lblLastname = new Label(container, SWT.NONE);
		lblLastname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastname.setText("Επίθετο");

		txtLastname = new Text(container, SWT.BORDER);
		txtLastname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		controlDecorationLastName = new ControlDecoration(txtLastname, SWT.LEFT | SWT.TOP);
		controlDecorationLastName.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_WARNING));
		controlDecorationLastName.setDescriptionText("Some description");

		lblAFM = new Label(container, SWT.NONE);
		lblAFM.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAFM.setText("ΑΦΜ");

		txtAFM = new Text(container, SWT.BORDER);
		txtAFM.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		lblEmail = new Label(container, SWT.NONE);
		lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEmail.setText("Ηλ/κό Ταχ/μίο");

		txtEmail = new Text(container, SWT.BORDER);
		txtEmail.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		lblOccupation = new Label(container, SWT.NONE);
		lblOccupation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOccupation.setText("Επάγγελμα");

		txtOccupation = new Text(container, SWT.BORDER);
		txtOccupation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		lblPhones = new Label(container, SWT.NONE);
		lblPhones.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblPhones.setText("Τηλέφωνα");

		listViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		list = listViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		cmpTelephoneButtons = new Composite(container, SWT.NONE);
		cmpTelephoneButtons.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		cmpTelephoneButtons.setLayout(new GridLayout(1, false));

		btnAddTelephone = new Button(cmpTelephoneButtons, SWT.NONE);
		btnAddTelephone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddTelephoneDialog dialog = new AddTelephoneDialog(Display.getCurrent().getActiveShell());
				int open = dialog.open();
				if (open == 0) {
					// ok
					saveDataToModel();
					// CreateCustomerWizard wizard = (CreateCustomerWizard)
					// getWizard();
					// wizard.getModel().addTelepnone(dialog.getPhone());
				} else {
					// cancel
				}
				System.out.println("open: " + open);
			}
		});
		btnAddTelephone.setImage(imgAdd);

		btnDeleteTelephone = new Button(cmpTelephoneButtons, SWT.NONE);
		btnDeleteTelephone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnDeleteTelephone.setImage(imgDelete);
	}

	public void saveDataToModel() {
		CreateCustomerWizard wizard = (CreateCustomerWizard) getWizard();
		Customer customer = wizard.getModel();
		customer.setFirstName(txtName.getText());
		customer.setLastName(txtLastname.getText());
		customer.setAfm(txtAFM.getText());
		customer.setOccupation(txtOccupation.getText());
		for (String element : list.getItems()) {
			customer.addTelepnone(element);
		}

	}

}
