package service;

import dao.IPoliticsDao;
import daofactory.PoliticsDaoFactory;
import dto.Politics;

public class PoliticsServiceImpl implements IPoliticsService{
	
	private IPoliticsDao polDao;

	@Override
	public String addPolitics(Politics politics) {
		polDao = PoliticsDaoFactory.getPoliticsDao();
		return polDao.addPolitics(politics);
	}

	@Override
	public Politics searchPolitics(Integer pid) {
		polDao = PoliticsDaoFactory.getPoliticsDao();
		return polDao.searchPolitics(pid);
	}

	@Override
	public String updatePolitics(Politics politics) {
		polDao = PoliticsDaoFactory.getPoliticsDao();
		return polDao.updatePolitics(politics);
	}

	@Override
	public String deletePolitics(Integer pid) {
		polDao = PoliticsDaoFactory.getPoliticsDao();
		return polDao.deletePolitics(pid);
	}



}
