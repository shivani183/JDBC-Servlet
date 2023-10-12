package daofactory;


public class PoliticsDaoFactory {

	private PoliticsDaoFactory() {}

	private static IPoliticsDao politicsDao = null;

	public static IPoliticsDao getStudentDao() {
		if (politicsDao == null) {
			politicsDao = new PoliticsDaoImpl();
		}
		return politicsDao;
	}
}
