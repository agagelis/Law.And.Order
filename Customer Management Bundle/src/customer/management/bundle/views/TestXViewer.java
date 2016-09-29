package customer.management.bundle.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.nebula.widgets.xviewer.example.MyXViewer;
import org.eclipse.nebula.widgets.xviewer.example.MyXViewerContentProvider;
import org.eclipse.nebula.widgets.xviewer.example.MyXViewerLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class TestXViewer extends ViewPart {

	public static final String ID = "customer.management.bundle.views.TestXViewer"; //$NON-NLS-1$

	public TestXViewer() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		MyXViewer myXviewer = new MyXViewer(container, SWT.NONE);
		  myXviewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		  myXviewer.setContentProvider(new MyXViewerContentProvider());
		  myXviewer.setLabelProvider(new MyXViewerLabelProvider(myXviewer));
//		  myXviewer.setInput(tasks);
		  
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
