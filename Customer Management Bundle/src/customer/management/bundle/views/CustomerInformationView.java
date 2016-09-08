package customer.management.bundle.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class CustomerInformationView extends ViewPart {

	public static final String ID = "customer.management.bundle.views.CustomerInformationView"; //$NON-NLS-1$
	private Composite cmpLower;
	private TabFolder tabFolder;
	private TabItem tbtmCases;
	private TabItem tbtmFiles;
	private TabItem tbtmOtherInformation;
	private Label lblName;
	private Label lblLastName;
	private Text txtName;
	private Text txtLastName;
	private Label lblEmail;
	private Text txtemail;

	public CustomerInformationView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		{
			Group grpGeneralInformation = new Group(container, SWT.NONE);
			grpGeneralInformation.setLayout(new GridLayout(2, false));
			grpGeneralInformation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			grpGeneralInformation.setText("General Information");
			
			lblName = new Label(grpGeneralInformation, SWT.NONE);
			lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblName.setText("Name");
			
			txtName = new Text(grpGeneralInformation, SWT.BORDER);
			txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			lblLastName = new Label(grpGeneralInformation, SWT.NONE);
			lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblLastName.setText("Last Name");
			
			txtLastName = new Text(grpGeneralInformation, SWT.BORDER);
			txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			lblEmail = new Label(grpGeneralInformation, SWT.NONE);
			lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblEmail.setText("e-mail");
			
			txtemail = new Text(grpGeneralInformation, SWT.BORDER);
			txtemail.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		{
			cmpLower = new Composite(container, SWT.NONE);
			cmpLower.setLayout(new GridLayout(1, false));
			cmpLower.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			
			tabFolder = new TabFolder(cmpLower, SWT.NONE);
			tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			
			tbtmCases = new TabItem(tabFolder, SWT.NONE);
			tbtmCases.setText("Cases");
			
			tbtmFiles = new TabItem(tabFolder, SWT.NONE);
			tbtmFiles.setText("Files");
			
			tbtmOtherInformation = new TabItem(tabFolder, SWT.NONE);
			tbtmOtherInformation.setText("Other information");
		}

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
