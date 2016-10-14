package calendar.bundle.views.helpers;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;

public class DayComposite extends Composite{
	private Composite cmpDayOfMonth;
	private Composite composite;
	private Composite composite_1;
	private Label lblNewLabel;
	private int day;
	
	public DayComposite(Composite parent, int style) {
		super(parent, SWT.BORDER);
		setLayout(new GridLayout(2, false));
		
		cmpDayOfMonth = new Composite(this, SWT.BORDER);
		GridData gd_cmpDayOfMonth = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_cmpDayOfMonth.heightHint = 22;
		cmpDayOfMonth.setLayoutData(gd_cmpDayOfMonth);
		cmpDayOfMonth.setLayout(new GridLayout(1, false));
		
		lblNewLabel = new Label(cmpDayOfMonth, SWT.CENTER);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblNewLabel.setText("");
		
		composite_1 = new Composite(this, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite_1.heightHint = 16;
		composite_1.setLayoutData(gd_composite_1);
		
		composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	}
	
	public void setDay(int day)
	{
		this.day = day;
		lblNewLabel.setText(day+"");
	}
}
