package calendar.bundle.views.helpers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DayComposite extends Composite {
	private Composite cmpDayOfMonth;
	private Composite cmpNotes;
	private Composite cmpRight;
	private Label lblDay;
	private int day;
	private Composite cmpMain;
	private Composite cmpEmpty;
	private StackLayout stackLayout;

	public DayComposite(Composite parent, int style) {
		super(parent, SWT.BORDER);
		stackLayout = new StackLayout();
		setLayout(stackLayout);

		cmpMain = new Composite(this, SWT.NONE);
		GridLayout gl_cmpMain = new GridLayout(2, false);
		gl_cmpMain.verticalSpacing = 2;
		gl_cmpMain.horizontalSpacing = 2;
		gl_cmpMain.marginWidth = 0;
		gl_cmpMain.marginHeight = 0;
		cmpMain.setLayout(gl_cmpMain);
		stackLayout.topControl = cmpMain;
		cmpDayOfMonth = new Composite(cmpMain, SWT.BORDER);
		GridData gd_cmpDayOfMonth = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_cmpDayOfMonth.widthHint = 25;
		cmpDayOfMonth.setLayoutData(gd_cmpDayOfMonth);
		cmpDayOfMonth.setLayout(new GridLayout(1, false));

		lblDay = new Label(cmpDayOfMonth, SWT.CENTER);
		lblDay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblDay.setText("");

		cmpRight = new Composite(cmpMain, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.heightHint = 32;
		cmpRight.setLayoutData(gd_composite_1);

		cmpNotes = new Composite(cmpMain, SWT.NONE);
		cmpNotes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		cmpNotes.setLayout(new FillLayout(SWT.VERTICAL));
		
		cmpEmpty = new Composite(this, SWT.NONE);
	}

	public void setDay(int day) {
		this.day = day;
		lblDay.setText(day + "");
	}
	
	
	
	@Override
	public Color getBackground() {
		return cmpMain.getBackground();
	}

	@Override
	public void setBackground(Color color) {
		cmpMain.setBackground(color);
		cmpRight.setBackground(color);
		cmpNotes.setBackground(color);
	}

	public void setText(String string) {
		if (string == null) {
			stackLayout.topControl = cmpEmpty;
		} else {
			stackLayout.topControl = cmpMain;
//			gridDataCmpMain.exclude = false;
			lblDay.setText(string + "");
		}
//		cmpMain.layout();
		this.layout();
	}
}
