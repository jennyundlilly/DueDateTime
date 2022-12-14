package view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.DueDateTimeController;
import model.TerminModel;
import task.TerminTask;
import utils.LongUtil;
import view.panel.HeaderPanel;
import view.panel.TerminPanel;

public class ViewBuilder {
	private DueDateTimeController ddt;
	private List<TerminModel> list;
	private Timer timer;

	public ViewBuilder(DueDateTimeController ddt) {
		setDdt(ddt);
		setList();
	}

	public DueDateTimeController getDdt() {
		return ddt;
	}

	public void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}

	public List<TerminModel> getList() {
		return list;
	}

	public void setList() {
		this.list = getDdt().getTerminService().getList();
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public void loadStartView() {
		setTimer(new Timer());
		new HeaderPanel(getDdt());
		getDdt().getMainPanel().getContentPanel().removeAll();
		// new TestHeader(getDdt());
		for (final TerminModel terminModel : getList()) {

			TerminPanel terminPanel = new TerminPanel(terminModel);

			getDdt().getMainPanel().getContentPanel().add(terminPanel);

			getTimer().scheduleAtFixedRate(new TerminTask(terminModel, terminPanel), terminModel.getInterval(),
					terminModel.getInterval());
		}
		getDdt().getMainPanel().revalidate();
	}
}
