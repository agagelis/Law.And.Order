package law.and.orders.platform.perspectives;

import java.util.Iterator;
import java.util.List;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class FileManagementPerspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String PERSPECTIVE_ID = "law.and.orders.platform.perspectives.FileManagementPerspective";

	/** Left folder's id. */
	public static final String FI_LEFT = PERSPECTIVE_ID + ".leftFolder";

	/** Top folder's id. */
	public static final String FI_TOP = PERSPECTIVE_ID + ".topFolder";
	/** Bottom folder's id. */
	public static final String FI_BOTTOM = PERSPECTIVE_ID + ".bottomFolder";

	/** Bottom folder's id. */
	public static final String FI_RIGHT = PERSPECTIVE_ID + ".rightFolder";
	
	private IPageLayout layout;
	
	/**
	 * Creates the initial layout for a page.
	 */
	
	public void createInitialLayout(IPageLayout layout) {
		this.layout = layout;
		String editorAreaId = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(false);

		layout.createPlaceholderFolder(FI_LEFT, IPageLayout.LEFT, 0.30f,
				editorAreaId);
		layout.createPlaceholderFolder(FI_RIGHT, IPageLayout.RIGHT, 0.70f,
				editorAreaId);
		layout.createPlaceholderFolder(FI_TOP, IPageLayout.TOP, 0.60f,
				editorAreaId);
		layout.createPlaceholderFolder(FI_BOTTOM, IPageLayout.BOTTOM, 0.30f,
				editorAreaId);
		
//		List<String> perspectectiveIds = MonitorsConfiguration.addPerspectiveShortcuts(PERSPECTIVE_ID);
//		Iterator<String> it = perspectectiveIds.iterator();
//		while(it.hasNext())
//			layout.addPerspectiveShortcut(it.next());
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
