package customer.management.bundle.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import customer.management.bundle.wizard.create.cases.CreateCaseWizard;
import customer.management.bundle.wizard.create.customer.CreateCustomerWizard;

public class CreateCaseHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Display currentDisplay = Display.getCurrent();
		WizardDialog dialog = new WizardDialog(currentDisplay.getActiveShell(), new CreateCaseWizard());
		
		dialog.open();
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

}
