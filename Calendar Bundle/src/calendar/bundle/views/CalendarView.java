package calendar.bundle.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;

import calendar.bundle.views.helpers.DayComposite;

public class CalendarView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "calendar.bundle.views.CalendarView";
	private Composite cmpMain;
	private Composite cmpDays[];
	private Composite compositeMonday;
	private Composite compositeSunday;
	private Composite compositeSaturday;
	private Composite compositeFriday;
	private Composite compositeThursday;
	private Composite compositeWednesday;
	private Composite compositeTuesday;

	private CLabel lblMonday;
	private CLabel lblTuesday;
	private CLabel lblWednesday;
	private CLabel lblThursday;
	private CLabel lblFriday;
	private CLabel lblSaturday;
	private CLabel lblSunday;
	/**
	 * The constructor.
	 */
	public CalendarView() {

	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {

		cmpMain = new Composite(parent, SWT.NONE);
		cmpMain.setLayout(new GridLayout(7, false));

		createDaysTitle();
		createDaysArray();
		
		

	}

	private void createDaysArray() {
		cmpDays = new Composite[42];
		for (int i = 0; i < 42; i++) {
			cmpDays[i] = new DayComposite(cmpMain, SWT.BORDER);
//			cmpDays[i].setLayout(new GridLayout(1, false));
			cmpDays[i].setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}
	}

	private void createDaysTitle() {
		compositeMonday = new Composite(cmpMain, SWT.NONE);
		compositeMonday.setLayout(new GridLayout(1, false));
		compositeMonday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblMonday = new CLabel(compositeMonday, SWT.NONE);
		lblMonday.setAlignment(SWT.CENTER);
		lblMonday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblMonday.setText("Monday");

		compositeTuesday = new Composite(cmpMain, SWT.NONE);
		compositeTuesday.setLayout(new GridLayout(1, false));
		compositeTuesday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblTuesday = new CLabel(compositeTuesday, SWT.NONE);
		lblTuesday.setAlignment(SWT.CENTER);
		lblTuesday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblTuesday.setText("Tuesday");

		compositeWednesday = new Composite(cmpMain, SWT.NONE);
		compositeWednesday.setLayout(new GridLayout(1, false));
		compositeWednesday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblWednesday = new CLabel(compositeWednesday, SWT.NONE);
		lblWednesday.setAlignment(SWT.CENTER);
		lblWednesday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblWednesday.setText("Wednesday");

		compositeThursday = new Composite(cmpMain, SWT.NONE);
		compositeThursday.setLayout(new GridLayout(1, false));
		compositeThursday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblThursday = new CLabel(compositeThursday, SWT.NONE);
		lblThursday.setAlignment(SWT.CENTER);
		lblThursday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblThursday.setText("Thursday");

		compositeFriday = new Composite(cmpMain, SWT.NONE);
		compositeFriday.setLayout(new GridLayout(1, false));
		compositeFriday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblFriday = new CLabel(compositeFriday, SWT.NONE);
		lblFriday.setAlignment(SWT.CENTER);
		lblFriday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblFriday.setText("Friday");

		compositeSaturday = new Composite(cmpMain, SWT.NONE);
		compositeSaturday.setLayout(new GridLayout(1, false));
		compositeSaturday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblSaturday = new CLabel(compositeSaturday, SWT.NONE);
		lblSaturday.setAlignment(SWT.CENTER);
		lblSaturday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblSaturday.setText("Saturday");

		compositeSunday = new Composite(cmpMain, SWT.NONE);
		compositeSunday.setLayout(new GridLayout(1, false));
		compositeSunday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblSunday = new CLabel(compositeSunday, SWT.NONE);
		lblSunday.setAlignment(SWT.CENTER);
		lblSunday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblSunday.setText("Sunday");
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}