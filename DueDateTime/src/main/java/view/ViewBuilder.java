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
			JLabel title = new JLabel(terminModel.getTitle());
			JLabel message = new JLabel(terminModel.getMessage());
			final JLabel restzeit = new JLabel("");
			Font font = new Font(null, 0, 20);

			title.setFont(font);
			message.setFont(font);
			restzeit.setFont(new Font(null, Font.BOLD, 24));
			if (terminModel.getRestZeit() >= 3600) {
				restzeit.setForeground(Color.BLUE);

			} else {
				restzeit.setForeground(Color.RED);
			}
			restzeit.setText(LongUtil.secountToString(terminModel.getRestZeit()));
			TerminPanel terminPanel = new TerminPanel();
			terminPanel.add(title);
			terminPanel.add(message);
			terminPanel.add(restzeit);

			JButton edit = new JButton("Edit");
			edit.setFont(font);
			terminPanel.add(edit);
			getDdt().getMainPanel().getContentPanel().add(terminPanel);

			getTimer().scheduleAtFixedRate(new TerminTask(terminModel, restzeit), terminModel.getInterval(),
					terminModel.getInterval());
		}
		getDdt().getMainPanel().revalidate();
	}
}
