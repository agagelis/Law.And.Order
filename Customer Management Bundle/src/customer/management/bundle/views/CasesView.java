package customer.management.bundle.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;

import common.ui.bundle.jface.RowNumberLabelProvider;

public class CasesView extends ViewPart {

	public static final String ID = "customer.management.bundle.views.CasesView"; //$NON-NLS-1$
	private Table table;

	public CasesView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn tableViewerColumnDummy = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDummy = tableViewerColumnDummy.getColumn();
		tcl_composite.setColumnData(tblclmnDummy, new ColumnPixelData(0, false, false));
		tblclmnDummy.setText("Dummy");
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnSerialnumber = tableViewerColumn.getColumn();
		tcl_composite.setColumnData(tblclmnSerialnumber, new ColumnWeightData(1, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnSerialnumber.setText("SerialNumber");
		tableViewerColumn.setLabelProvider(new RowNumberLabelProvider());
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTitle = tableViewerColumn_1.getColumn();
		tcl_composite.setColumnData(tblclmnTitle, new ColumnPixelData(150, true, true));
		tblclmnTitle.setText("Title");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCustomer = tableViewerColumn_2.getColumn();
		tcl_composite.setColumnData(tblclmnCustomer, new ColumnPixelData(150, true, true));
		tblclmnCustomer.setText("Customer");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCourtdate = tableViewerColumn_3.getColumn();
		tcl_composite.setColumnData(tblclmnCourtdate, new ColumnPixelData(150, true, true));
		tblclmnCourtdate.setText("CourtDate");

		initializeToolBar();
		initializeMenu();
	}

	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		
	}
}
