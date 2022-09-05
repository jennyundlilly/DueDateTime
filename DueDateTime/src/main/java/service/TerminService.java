package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import controller.DueDateTimeController;
import dao.TerminDao;
import model.TerminModel;

public class TerminService extends TerminDao {
	private DueDateTimeController ddt;
	private List<TerminModel> list;

	public TerminService(DueDateTimeController ddt) {
		setDdt(ddt);
		setList(dummyList());
	}

	public List<TerminModel> getList() {
		return list;
	}

	private void setList(List<TerminModel> list) {
		this.list = list;
	}

	public DueDateTimeController getDdt() {
		return ddt;
	}

	public void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}

	private List<TerminModel> dummyList() {

		Calendar c1 = Calendar.getInstance(new Locale("DE_de"));
		c1.add(Calendar.HOUR, 2);
		c1.add(Calendar.SECOND, 1);
		Calendar c2 = Calendar.getInstance(new Locale("DE_de"));
		c2.add(Calendar.MINUTE, 50);
		c2.add(Calendar.SECOND, 1);
		Calendar c3 = Calendar.getInstance(new Locale("DE_de"));
		c3.add(Calendar.HOUR, 2);
		c3.add(Calendar.MINUTE, 25);
		c3.add(Calendar.SECOND, 1);
		Calendar c4 = Calendar.getInstance(new Locale("DE_de"));
		c4.add(Calendar.DAY_OF_YEAR, 4);
		c4.add(Calendar.HOUR, 4);
		c4.add(Calendar.SECOND, 1);
		Calendar c5 = Calendar.getInstance(new Locale("DE_de"));
		c5.add(Calendar.MINUTE, 45);
		c5.add(Calendar.SECOND, 1);
		Calendar c6 = Calendar.getInstance(new Locale("DE_de"));
		c6.add(Calendar.DAY_OF_YEAR, 2);
		c6.add(Calendar.HOUR, 6);
		c6.add(Calendar.SECOND, 1);
		List<TerminModel> list = new ArrayList<TerminModel>();
		list.add(new TerminModel("Geschirr spülen", "Spülmaschine benutzen", c1));
		list.add(new TerminModel("Staubsaugen", "Saugroboter benutzen", c2));
		list.add(new TerminModel("Jenny abholen", "Frauenlobstr. 91 44805 Bochum", c3));
		list.add(new TerminModel("UCI Kino", "Ruhrpark Bochum Am Einkaufszentrum 2 44791 Bochum", c4));
		list.add(new TerminModel("Auto waschen", "Aral Tankstelle", c5));
		list.add(new TerminModel("Einkaufen", "Eier, Milch und Bier", c6));
		return list;
	}

	public void addTermin() {
		Random random = new Random();
		Calendar c1 = Calendar.getInstance(new Locale("DE_de"));
		c1.add(Calendar.HOUR, random.nextInt(2));
		c1.add(Calendar.MINUTE, random.nextInt(50) + 5);
		TerminModel terminModel = new TerminModel("Neue Termin", "Neu Message", c1);
		getList().add(terminModel);
//		getDdt().getViewBuilder().getList().add(terminModel);
//		getDdt().getViewBuilder().setRefresh(true);

		getDdt().getViewBuilder().getTimer().cancel();
		getDdt().getViewBuilder().getTimer().purge();
		// getDdt().getViewBuilder().getTask().cancel();
		getDdt().getViewBuilder().loadStartView();
		;

	}

	public void editTermin() {
		System.out.println("TerminService.editTermin");
	}

	public void deleteTermin() {
		System.out.println("TerminService.deleteTermin");
	}

}
