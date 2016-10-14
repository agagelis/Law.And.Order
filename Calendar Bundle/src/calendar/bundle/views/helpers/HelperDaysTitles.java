package calendar.bundle.views.helpers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;

public class HelperDaysTitles {

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
	 * @wbp.parser.entryPoint
	 */

	private void createDaysTitle(Composite parent) {

		Composite cmpMain = new Composite(parent, 0);
		cmpMain.setLayout(new GridLayout(7, true));

		compositeMonday = new Composite(cmpMain, SWT.NONE);
		compositeMonday.setLayout(new GridLayout(1, false));
		compositeMonday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		lblMonday = new CLabel(compositeMonday, SWT.NONE);
		lblMonday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblMonday.setText("Monday");

		compositeTuesday = new Composite(cmpMain, SWT.NONE);
		compositeTuesday.setLayout(new GridLayout(1, false));
		compositeTuesday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		lblTuesday = new CLabel(compositeTuesday, SWT.NONE);
		lblTuesday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblTuesday.setText("Tuesday");

		compositeWednesday = new Composite(cmpMain, SWT.NONE);
		compositeWednesday.setLayout(new GridLayout(1, false));
		compositeWednesday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		lblWednesday = new CLabel(compositeWednesday, SWT.NONE);
		lblWednesday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblWednesday.setText("Wednesday");

		compositeThursday = new Composite(cmpMain, SWT.NONE);
		compositeThursday.setLayout(new GridLayout(1, false));
		compositeThursday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		lblThursday = new CLabel(compositeThursday, SWT.NONE);
		lblThursday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblThursday.setText("Thursday");

		compositeFriday = new Composite(cmpMain, SWT.NONE);
		compositeFriday.setLayout(new GridLayout(1, false));
		compositeFriday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		lblFriday = new CLabel(compositeFriday, SWT.NONE);
		lblFriday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblFriday.setText("Friday");

		compositeSaturday = new Composite(cmpMain, SWT.NONE);
		compositeSaturday.setLayout(new GridLayout(1, false));
		compositeSaturday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		lblSaturday = new CLabel(compositeSaturday, SWT.NONE);
		lblSaturday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblSaturday.setText("Saturday");

		compositeSunday = new Composite(cmpMain, SWT.NONE);
		compositeSunday.setLayout(new GridLayout(1, false));
		compositeSunday.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		lblSunday = new CLabel(compositeSunday, SWT.NONE);
		lblSunday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblSunday.setText("Sunday");
	}
}
