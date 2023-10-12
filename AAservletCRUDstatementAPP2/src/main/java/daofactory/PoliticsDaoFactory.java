package daofactory;

import dao.IPoliticsDao;
import dao.PoliticsDaoImpl;

public class PoliticsDaoFactory {

	private PoliticsDaoFactory() {}

	private static IPoliticsDao politicsDao = null;

	public static IPoliticsDao getPoliticsDao() {
		if (politicsDao == null) {
			politicsDao = new PoliticsDaoImpl();
		}
		return politicsDao;
	}
}
