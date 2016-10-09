package law.and.orders.platform.startup;

import law.and.orders.platform.dbaccess.JPAUtil;

import org.eclipse.ui.IStartup;

public class EarlyStartup implements IStartup {

	@Override
	public void earlyStartup() {
//		JPAUtil.getSessionFactory();
	}

}
