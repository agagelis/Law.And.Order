package customer.management.bundle.views.customers.tables.columnlabelproviders.cases;

import lno.object.model.domain.Case;
import lno.object.model.domain.Customer;

import org.eclipse.jface.viewers.ColumnLabelProvider;

public class CustomerColumnLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		Customer customer = ((Case) element).getCustomer();
		return customer != null ? customer.getFirstName() + " "
				+ customer.getLastName() : " -  ";
	}

}
