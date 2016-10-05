package customer.management.bundle.views.customers.tables.columnlabelproviders;

import org.eclipse.jface.viewers.ColumnLabelProvider;

public class DummyColumnLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		return " - ";
	}
}
