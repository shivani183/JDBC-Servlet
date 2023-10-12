package servicefactory;

import service.IPoliticsService;
import service.PoliticsServiceImpl;

public class PoliticsServiceFactory{
	private PoliticsServiceFactory() {
		
	}

	private static IPoliticsService politicsService = null;

	public static IPoliticsService getPoliticsService() {
		
		//singleton pattern code
		if (politicsService == null) {
			politicsService = new PoliticsServiceImpl();
		}
		return politicsService;
	}
}
