package customer.management.bundle.views.customers.xviewer;

import java.util.Collection;
import java.util.HashSet;

import lno.object.model.domain.Customer;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.xviewer.example.model.ISomeTask;
import org.eclipse.nebula.widgets.xviewer.example.model.SomeTask;

public class CustomersContentProvider implements ITreeContentProvider {

	protected Collection<Customer> rootSet = new HashSet<Customer>();
	   private final static Object[] EMPTY_ARRAY = new Object[0];

	   public CustomersContentProvider() {
	      super();
	   }

	   @Override
	   @SuppressWarnings("rawtypes")
	   public Object[] getChildren(Object parentElement) {
	      if (parentElement instanceof Object[]) {
	         return (Object[]) parentElement;
	      }
	      if (parentElement instanceof Collection) {
	         return ((Collection) parentElement).toArray();
	      }
	      if (parentElement instanceof SomeTask) {
	         return ((SomeTask) parentElement).getChildren().toArray();
	      }
	      return EMPTY_ARRAY;
	   }

	   @Override
	   public Object getParent(Object element) {
	      return null;
	   }

	   @Override
	   public boolean hasChildren(Object element) {
	      if (element instanceof SomeTask) {
	         return ((SomeTask) element).getChildren().size() > 0;
	      }
	      return false;
	   }

	   @Override
	   public Object[] getElements(Object inputElement) {
	      if (inputElement instanceof String) {
	         return new Object[] {inputElement};
	      }
	      return getChildren(inputElement);
	   }

	   @Override
	   public void dispose() {
	      // do nothing
	   }

	   @Override
	   public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	      // do nothing
	   }

	   public Collection<Customer> getRootSet() {
	      return rootSet;
	   }

	}
