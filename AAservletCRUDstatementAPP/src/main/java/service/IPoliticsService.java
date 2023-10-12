package service;



public interface IPoliticsService {

	public String addPolitics(Politics politics);

	public Politics searchPolitics(Integer pid);

	public String updatePolitics(Politics politics);

	public String deletePolitics(Integer pid);
}
