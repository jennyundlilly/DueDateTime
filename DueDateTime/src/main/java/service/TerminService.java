package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import controller.DueDateTimeController;
import dao.TerminDao;
import model.TerminModel;
import utils.StringUtils;
import view.dialog.NeuTerminDialog;

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
		Calendar c2 = Calendar.getInstance(new Locale("DE_de"));
		c2.add(Calendar.MINUTE, 50);
		c2.add(Calendar.SECOND, 1);

		Calendar c3 = Calendar.getInstance(new Locale("DE_de"));
		c3.add(Calendar.HOUR, 2);
		c3.add(Calendar.MINUTE, 25);
		c3.add(Calendar.SECOND, 1);

		Calendar c5 = Calendar.getInstance(new Locale("DE_de"));
		c5.add(Calendar.MINUTE, 25);
		c5.add(Calendar.SECOND, 1);

		Calendar c6 = Calendar.getInstance(new Locale("DE_de"));
		c6.add(Calendar.DAY_OF_YEAR, 2);
		c6.add(Calendar.HOUR, 6);
		c6.add(Calendar.SECOND, 1);

		List<TerminModel> list = new ArrayList<TerminModel>();
		list.add(new TerminModel("Staubsaugen", "Saugroboter benutzen", c2));
		list.add(new TerminModel("Jenny abholen", "Frauenlobstr. 91 44805 Bochum", c3));
		list.add(new TerminModel("Auto waschen", "Aral Tankstelle", c5));
		list.add(new TerminModel("Einkaufen", "Eier, Milch und Bier", c6));
		return list;
	}

	public void addTermin(NeuTerminDialog ntd) {

		Calendar c1 = Calendar.getInstance();
		String stringDate = ntd.getJahrCombobox().getSelectedItem().toString() + "-"
				+ ((ntd.getMonatCombobox().getSelectedIndex() + 1) < 10
						? "0" + (ntd.getMonatCombobox().getSelectedIndex() + 1)
						: ntd.getMonatCombobox().getSelectedIndex() + 1)
				+ "-" + ntd.getTagCombobox().getSelectedItem().toString() + " "
				+ ntd.getStundeCombobox().getSelectedItem().toString() + ":"
				+ ntd.getMinuteCombobox().getSelectedItem().toString() + ":00";
		c1.setTime(StringUtils.toDate(stringDate));

		TerminModel terminModel = new TerminModel(ntd.getTitelField().getText(), ntd.getBeschreibungArea().getText(),
				c1);
		getList().add(terminModel);

		getDdt().getViewBuilder().getTimer().cancel();
		getDdt().getViewBuilder().getTimer().purge();
		getDdt().getViewBuilder().loadStartView();
	}

	public void editTermin() {
		System.out.println("TerminService.editTermin");
	}

	public void deleteTermin(TerminModel tm) {
		List<TerminModel> list = getList();
		Iterator<TerminModel> iterator = list.iterator();

		while (iterator.hasNext()) {
			TerminModel terminModel = iterator.next();

			if (terminModel.equals(tm)) {
				iterator.remove();
			}
		}
		setList(null);
		setList(list);
		getDdt().getViewBuilder().getTimer().cancel();
		getDdt().getViewBuilder().getTimer().purge();
		getDdt().getViewBuilder().loadStartView();
	}

}
