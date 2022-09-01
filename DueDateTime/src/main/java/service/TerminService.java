package service;

import java.util.ArrayList;
import java.util.List;

import dao.TerminDao;
import model.TerminModel;

public class TerminService extends TerminDao {
	public TerminService() {
		// TODO Auto-generated constructor stub
	}

	public List<TerminModel> getTermins() {
		List<TerminModel> list = new ArrayList<TerminModel>();

		return list;
	}

	public void addTermin() {
		System.out.println("TerminService.addTermin");
		super.getTerminFilePath();
	}

	public void editTermin() {
		System.out.println("TerminService.editTermin");
	}

	public void deleteTermin() {
		System.out.println("TerminService.deleteTermin");
	}
}
