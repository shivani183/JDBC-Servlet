package servicefactory;


public class PoliticsServiceFactory{
	private PoliticsServiceFactory() {
		
	}

	private static IPoliticsService politicsService = null;

	public static IPoliticsService getStudentService() {
		
		//singleton pattern code
		if (politicsService == null) {
			politicsService = new PoliticsServiceImpl();
		}
		return politicsService;
	}
}
