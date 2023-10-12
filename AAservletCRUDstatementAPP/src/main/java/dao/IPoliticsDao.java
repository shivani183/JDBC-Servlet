package dao;

import dto.Politics;

public interface IPoliticsDao {
	public String addPolitics(Politics politics);

	public Politics searchPolitics(Integer sid);

	public String updatePolitics(Politics politics);

	public String deletePolitics(Integer sid);

}
