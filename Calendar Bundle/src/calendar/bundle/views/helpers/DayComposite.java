package calendar.bundle.views.helpers;

import java.util.ArrayList;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class DayComposite extends Composite implements MouseListener {
	private Composite cmpDayOfMonth;
	private Composite cmpNotes;
	private Composite cmpRight;
	private Label lblDay;
	private int day;
	private Composite cmpMain;
	private Composite cmpEmpty;
	private StackLayout stackLayout;
	private Composite composite;
	private Table table;
	private TableViewer tableViewer;
	private TableColumn tblclmnEvent;
	private TableViewerColumn tableViewerColumn;
	private TableItem tableItem;
	private TableItem tableItem_1;
	private TableItem tableItem_2;

	private ArrayList<DayCompositeSelectionListener> listeners;

	public DayComposite(Composite parent, int style) {
		super(parent, SWT.BORDER);
		stackLayout = new StackLayout();
		setLayout(stackLayout);

		cmpMain = new Composite(this, SWT.NONE);

		cmpMain.addMouseListener(this);
		GridLayout gl_cmpMain = new GridLayout(2, false);
		gl_cmpMain.verticalSpacing = 2;
		gl_cmpMain.horizontalSpacing = 2;
		gl_cmpMain.marginWidth = 2;
		gl_cmpMain.marginHeight = 2;
		cmpMain.setLayout(gl_cmpMain);
		stackLayout.topControl = cmpMain;

		cmpDayOfMonth = new Composite(cmpMain, SWT.BORDER);
		cmpDayOfMonth.addMouseListener(this);
		GridData gd_cmpDayOfMonth = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_cmpDayOfMonth.widthHint = 25;
		cmpDayOfMonth.setLayoutData(gd_cmpDayOfMonth);
		GridLayout gl_cmpDayOfMonth = new GridLayout(1, false);
		gl_cmpDayOfMonth.marginHeight = 0;
		gl_cmpDayOfMonth.marginWidth = 0;
		cmpDayOfMonth.setLayout(gl_cmpDayOfMonth);

		lblDay = new Label(cmpDayOfMonth, SWT.CENTER);
		lblDay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblDay.setText("");
		lblDay.addMouseListener(this);

		cmpRight = new Composite(cmpMain, SWT.NONE);
		cmpRight.addMouseListener(this);
		GridData gd_cmpRight = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_cmpRight.heightHint = 20;
		cmpRight.setLayoutData(gd_cmpRight);

		cmpNotes = new Composite(cmpMain, SWT.NONE);
		cmpNotes.addMouseListener(this);
		GridLayout gl_cmpNotes = new GridLayout(1, false);
		gl_cmpNotes.marginWidth = 0;
		gl_cmpNotes.marginHeight = 0;
		cmpNotes.setLayout(gl_cmpNotes);
		cmpNotes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		composite = new Composite(cmpNotes, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);

		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.getTable().addMouseListener(this);
		table = tableViewer.getTable();

		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnEvent = tableViewerColumn.getColumn();
		tblclmnEvent.setResizable(false);
		tcl_composite.setColumnData(tblclmnEvent, new ColumnWeightData(100, 20, false));
		tblclmnEvent.setText("Event");

		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("New TableItem");

		tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText("New TableItem");

		tableItem_2 = new TableItem(table, SWT.NONE);
		tableItem_2.setText("New TableItem");

		cmpEmpty = new Composite(this, SWT.NONE);
	}

	public void setDay(int day) {
		this.day = day;
		lblDay.setText(day + "");
	}

	@Override
	public Color getBackground() {
		return lblDay.getBackground();
	}

	@Override
	public void setBackground(Color color) {
		lblDay.setBackground(color);
	}

	public void setText(String string) {
		if (string == null) {
			stackLayout.topControl = cmpEmpty;
		} else {
			stackLayout.topControl = cmpMain;
			lblDay.setText(string + "");
		}
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(MouseEvent e) {
		System.out.println("selected");
		setSelected(true);
		notifyDaySelectionListeners();

	}

	@Override
	public void mouseUp(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setSelected(boolean selected) {
		if (selected) {
			cmpMain.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
			cmpRight.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		} else {
			cmpMain.setBackground(SWTResourceManager.getColor(240, 240, 240));
			cmpRight.setBackground(SWTResourceManager.getColor(240, 240, 240));
		}
	}

	public void addDayCompositeSelectionListener(DayCompositeSelectionListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<DayCompositeSelectionListener>();
		}
		listeners.add(listener);
	}

	public boolean removeDayCompositeLisener(DayCompositeSelectionListener listener) {
		boolean remove = listeners.remove(listener);
		return remove;
	}

	public void notifyDaySelectionListeners() {
		if (listeners == null)
			return;
		for (DayCompositeSelectionListener element : listeners) {
			element.dayCompositeSelected(this);
		}
	}
}
