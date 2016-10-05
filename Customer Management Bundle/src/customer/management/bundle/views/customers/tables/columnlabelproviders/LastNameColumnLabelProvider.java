package customer.management.bundle.views.customers.tables.columnlabelproviders;

import lno.object.model.domain.Customer;

import org.eclipse.jface.viewers.ColumnLabelProvider;

public class LastNameColumnLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		return ((Customer) element).getLastName();
	}
}
