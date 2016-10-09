package customer.management.bundle.views.customers.tables.columnlabelproviders.cases;

import lno.object.model.domain.Case;

import org.eclipse.jface.viewers.ColumnLabelProvider;

public class TrialDateColumnLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		return ((Case) element).getCourtDate().toString();
	}
}
