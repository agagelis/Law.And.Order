package customer.management.bundle.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

public class CustomersView extends ViewPart {

	public static final String ID = "customer.management.bundle.views.CustomersView"; //$NON-NLS-1$
	private Composite container;
	private Table table;
	private TableColumn tblclmnLastName;
	private TableColumn tblclmnFirstName;
	private TableViewer tableViewer;
	private TableColumn tblclmnDummy;
	private TableViewerColumn tableViewerColumnDummy;
	private TableColumn tableColumn;
	private TableViewerColumn tableViewerColumn_1;
	private TableViewerColumn tableViewerColumn_2;
	private Composite composite;
	private TableColumnLayout tcl_composite;

	public CustomersView() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);

		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		tableViewerColumnDummy = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnDummy = tableViewerColumnDummy.getColumn();
		tcl_composite.setColumnData(tblclmnDummy, new ColumnWeightData(0, 0, false));

		tblclmnDummy.setText("Dummy");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableColumn = tableViewerColumn.getColumn();
		tcl_composite.setColumnData(tableColumn, new ColumnWeightData(20, 5, true));
		tableColumn.setText("#");

		tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnLastName = tableViewerColumn_1.getColumn();
		tcl_composite.setColumnData(tblclmnLastName, new ColumnWeightData(150, 40, true));
		tblclmnLastName.setText("Last Name");

		tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnFirstName = tableViewerColumn_2.getColumn();
		tcl_composite.setColumnData(tblclmnFirstName, new ColumnWeightData(150, 40, true));
		tblclmnFirstName.setText("First Name");

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
