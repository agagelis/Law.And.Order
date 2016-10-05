package customer.management.bundle.views;

import java.util.List;

import lno.object.model.domain.Customer;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
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

import common.ui.bundle.ui.constants.UIConstantsViewIDs;
import customer.management.bundle.data.DataController;
import customer.management.bundle.views.customers.tables.columnlabelproviders.DummyColumnLabelProvider;
import customer.management.bundle.views.customers.tables.columnlabelproviders.FirstNameColumnLabelProvider;
import customer.management.bundle.views.customers.tables.columnlabelproviders.LastNameColumnLabelProvider;

public class CustomersView extends ViewPart {

	public static final String ID = UIConstantsViewIDs.CustomerManagementCustomersView; //$NON-NLS-1$
	private Composite container;
	private Table table;
	private TableColumn tblclmnLastName;
	private TableColumn tblclmnFirstName;
	private TableViewer tableViewer;
	private TableColumn tblclmnDummy;
	private TableViewerColumn tableViewerColumnDummy;
	private TableColumn tableColumn;
	private TableViewerColumn tableViewerColumnLastName;
	private TableViewerColumn tableViewerColumnFirstName;
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
		tableViewer.setContentProvider(new ArrayContentProvider());

		tableViewerColumnDummy = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnDummy = tableViewerColumnDummy.getColumn();
		tcl_composite.setColumnData(tblclmnDummy, new ColumnWeightData(0, 0, false));
		tableViewerColumnDummy.setLabelProvider(new DummyColumnLabelProvider());
		tblclmnDummy.setText("Dummy");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableColumn = tableViewerColumn.getColumn();
		tcl_composite.setColumnData(tableColumn, new ColumnWeightData(20, 5, true));
		tableColumn.setText("#");
		tableViewerColumn.setLabelProvider(new DummyColumnLabelProvider());

		tableViewerColumnLastName = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnLastName = tableViewerColumnLastName.getColumn();
		tcl_composite.setColumnData(tblclmnLastName, new ColumnWeightData(150, 40, true));
		tblclmnLastName.setText("Last Name");
		tableViewerColumnLastName.setLabelProvider(new FirstNameColumnLabelProvider());

		tableViewerColumnFirstName = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnFirstName = tableViewerColumnFirstName.getColumn();
		tcl_composite.setColumnData(tblclmnFirstName, new ColumnWeightData(150, 40, true));
		tblclmnFirstName.setText("First Name");
		tableViewerColumnFirstName.setLabelProvider(new LastNameColumnLabelProvider());

		createActions();
		initializeToolBar();
		initializeMenu();
		refresh();
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

	public void refresh() {
		List<Customer> customers = DataController.getDataController().getCustomers();
		if (customers != null)
			tableViewer.setInput(customers.toArray());
	}

}
