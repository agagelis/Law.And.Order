package calendar.bundle.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import calendar.bundle.views.helpers.DayComposite;

public class CustomCalendar extends Composite implements MouseListener {

	private Display display = null;
	private Date nowDate = null; // current date

	private String selectedDate = null; // selected date
	private GridLayout gridLayout = null;
	private GridData gridData = null;
	private GridData gridData_7;
	private GridData gridData_6;
	private GridData gridData_5;
	private GridData gridData_4;
	private GridData gridData_3;
	private GridData gridData_2;
	private GridData gridData_1;

	private CLabel sunday = null;
	private CLabel monday = null;
	private CLabel tuesday = null;
	private CLabel wednesday = null;
	private CLabel thursday = null;
	private CLabel friday = null;
	private CLabel saturday = null;

	private Button yearUp = null;
	private Button yearNext = null;
	private Button monthUp = null;
	private Button monthNext = null;
	private CLabel nowLabel = null;

	private DayComposite[] days = new DayComposite[42];

	public CustomCalendar(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(7, false));

		display = Display.getCurrent();
//		shell = new Shell(parent, SWT.TITLE | SWT.PRIMARY_MODAL);
//		shell.setText("Calendar ver0.02");
//		shell.setSize(230, 220);
//
//		gridLayout = new GridLayout();
//		gridLayout.numColumns = 7;
//		shell.setLayout(gridLayout);
//
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		yearUp = new Button(this, SWT.PUSH | SWT.FLAT);
		yearUp.setText("<");
		yearUp.setLayoutData(gridData);
		yearUp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				previousYear();
			}
		});

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		monthUp = new Button(this, SWT.PUSH | SWT.FLAT);
		monthUp.setText("<<");
		monthUp.setLayoutData(gridData);
		monthUp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				previousMonth();
			}
		});

		nowLabel = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		nowLabel.setLayoutData(gridData);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		nowLabel.setText(formatter.format(new Date()));

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		monthNext = new Button(this, SWT.PUSH | SWT.FLAT);
		monthNext.setText(">>");
		monthNext.setLayoutData(gridData);
		monthNext.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				nextMonth();
			}
		});

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		yearNext = new Button(this, SWT.PUSH | SWT.FLAT);
		yearNext.setText(">");
		yearNext.setLayoutData(gridData);
		yearNext.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				nextYear();
			}
		});

		sunday = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData_1 = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gridData_1.grabExcessVerticalSpace = false;
		gridData_1.widthHint = 20;
		gridData_1.heightHint = 20;
		sunday.setLayoutData(gridData_1);
		sunday.setText("Sun");

		monday = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData_2 = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gridData_2.grabExcessVerticalSpace = false;
		gridData_2.widthHint = 20;
		gridData_2.heightHint = 20;
		monday.setLayoutData(gridData_2);
		monday.setText("Mon");

		tuesday = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData_3 = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gridData_3.grabExcessVerticalSpace = false;
		gridData_3.widthHint = 20;
		gridData_3.heightHint = 20;
		tuesday.setLayoutData(gridData_3);
		tuesday.setText("Tue");

		wednesday = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData_4 = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gridData_4.grabExcessVerticalSpace = false;
		gridData_4.widthHint = 20;
		gridData_4.heightHint = 20;
		wednesday.setLayoutData(gridData_4);
		wednesday.setText("Wed");

		thursday = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData_5 = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gridData_5.grabExcessVerticalSpace = false;
		gridData_5.widthHint = 20;
		gridData_5.heightHint = 20;
		thursday.setLayoutData(gridData_5);
		thursday.setText("Thu");

		friday = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData_6 = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gridData_6.grabExcessVerticalSpace = false;
		gridData_6.widthHint = 20;
		gridData_6.heightHint = 20;
		friday.setLayoutData(gridData_6);
		friday.setText("Fri");

		saturday = new CLabel(this, SWT.CENTER | SWT.SHADOW_OUT);
		gridData_7 = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gridData_7.grabExcessVerticalSpace = false;
		gridData_7.widthHint = 20;
		gridData_7.heightHint = 20;
		saturday.setLayoutData(gridData_7);
		saturday.setText("Sat");

		for (int i = 0; i < 42; i++) {
			days[i] = new DayComposite(this, SWT.FLAT | SWT.CENTER);
			gridData = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
			days[i].setLayoutData(gridData);
			days[i].setBackground(display.getSystemColor(SWT.COLOR_WHITE));
			days[i].addMouseListener(this);
			days[i].setToolTipText("double click get current date.");
		}

		Calendar now = Calendar.getInstance(); //
		nowDate = new Date(now.getTimeInMillis());
		setDayForDisplay(now);

//		return selectedDate;
	}

	private int getLastDayOfMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		}
		return 0;
	}

	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	private void moveTo(int type, int value) {
		Calendar now = Calendar.getInstance(); // get current Calendar object
		now.setTime(nowDate); // set current date
		now.add(type, value); // add to spec time.
		nowDate = new Date(now.getTimeInMillis()); // result
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");// format
																		// date
		nowLabel.setText(formatter.format(nowDate)); // set to label
		setDayForDisplay(now);
	}

	private void setDayForDisplay(Calendar now) {
		int currentDay = now.get(Calendar.DATE);
		now.add(Calendar.DAY_OF_MONTH, -(now.get(Calendar.DATE) - 1)); //
		int startIndex = now.get(Calendar.DAY_OF_WEEK) - 1; //
		int year = now.get(Calendar.YEAR); //
		int month = now.get(Calendar.MONTH) + 1; //
		int lastDay = this.getLastDayOfMonth(year, month); //
		int endIndex = startIndex + lastDay - 1; //
		int startday = 1;
		for (int i = 0; i < 42; i++) {
			Color temp = days[i].getBackground();
			if (temp.equals(display.getSystemColor(SWT.COLOR_BLUE))) {

				days[i].setBackground(display.getSystemColor(SWT.COLOR_WHITE));
			}
		}
		for (int i = 0; i < 42; i++) {
			if (i >= startIndex && i <= endIndex) {
				days[i].setText("" + startday);
				if (startday == currentDay) {

					days[i].setBackground(display.getSystemColor(SWT.COLOR_BLUE)); //
				}
				startday++;
			} else {
				days[i].setText(null);
			}
			days[i].layout();
		}

	}

	public void previousYear() {
		moveTo(Calendar.YEAR, -1);
	}

	public void nextYear() {
		moveTo(Calendar.YEAR, 1);
	}

	public void nextMonth() {
		moveTo(Calendar.MONTH, 1);
	}

	public void previousMonth() {
		moveTo(Calendar.MONTH, -1);
	}

	public void mouseDoubleClick(MouseEvent e) {
		CLabel day = (CLabel) e.getSource();
		if (!day.getText().equals("")) {
			this.selectedDate = nowLabel.getText() + "-" + day.getText();
//			this.shell.close();
		}
	}

	public void mouseDown(MouseEvent e) {
	}

	public void mouseUp(MouseEvent e) {
	}

	
}
