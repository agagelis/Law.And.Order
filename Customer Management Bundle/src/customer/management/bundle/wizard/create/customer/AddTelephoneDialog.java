package customer.management.bundle.wizard.create.customer;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class AddTelephoneDialog extends Dialog {
	private Text text;
	private String phone;
	private Button btnCancel;
	private Button btnOK;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AddTelephoneDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;

		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 1, 1));
		label.setText("Αριθμός Τηλεφώνου :");

		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		text.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				phone = text.getText();
				if (phone != null && phone != "") {
					btnOK.setEnabled(true);
				} else {
					btnOK.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		btnOK = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		btnCancel = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(416, 163);
	}

	public String getPhone() {
		return phone;
	}

}
