package customer.management.bundle.perspectives;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class CaseManagementPerspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "customer.management.bundle.perspectives.casemanagement"; //$NON-NLS-1$
	
	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		layout.setEditorAreaVisible(false);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
