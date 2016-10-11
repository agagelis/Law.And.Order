package customer.management.bundle.views.customers.xviewer;

import org.eclipse.nebula.widgets.xviewer.IXViewerFactory;
import org.eclipse.nebula.widgets.xviewer.XViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

public class CustomersXViewer extends XViewer {

	public CustomersXViewer(Composite parent, int style, IXViewerFactory xViewerFactory, boolean filterRealTime, boolean searchRealTime) {
		super(parent, style, xViewerFactory, filterRealTime, searchRealTime);
		// TODO Auto-generated constructor stub
	}

	public CustomersXViewer(Tree tree) {
		super(tree, new CustomersXViewerFactory());
	}

	public CustomersXViewer(Shell shell_1, int i) {
		super(shell_1, i, new CustomersXViewerFactory());
	}

	public CustomersXViewer(Composite parent, int i) {
		super(parent, i, new CustomersXViewerFactory(),true,true);
	}

	/*@Override
	public boolean handleLeftClickInIconArea(TreeColumn treeColumn, TreeItem treeItem) {
		if (treeColumn.getData().equals(MyXViewerFactory.Run_Col)) {
			setRun((ISomeTask) treeItem.getData(), !isRun((ISomeTask) treeItem.getData()));
			update(treeItem.getData(), null);
			return true;
		} else {
			return super.handleLeftClickInIconArea(treeColumn, treeItem);
		}
	}*/

}
