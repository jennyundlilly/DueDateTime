package task;

import java.awt.Color;
import java.util.TimerTask;

import javax.swing.JLabel;

import model.TerminModel;
import utils.LongUtil;
import view.panel.TerminPanel;

public class TerminTask extends TimerTask {

	private TerminModel terminModel;
	private TerminPanel terminPanel;

	public TerminTask(TerminModel terminModel, TerminPanel terminPanel) {
		setModel(terminModel);
		setTerminPanel(terminPanel);
	}

	private TerminModel getModel() {
		return terminModel;
	}

	private void setModel(TerminModel terminModel) {
		this.terminModel = terminModel;
	}

	@Override
	public void run() {
		getModel().setInterval();
		getModel().setRestZeit();
		if (terminModel.getRestZeit() >= 3600) {
			getTerminPanel().getRestZeitLabel().setForeground(Color.BLUE);

		} else {
			getTerminPanel().getRestZeitLabel().setForeground(Color.RED);
		}
		getTerminPanel().getRestZeitLabel().setText(LongUtil.secountToString(terminModel.getRestZeit()));
	}

	public TerminPanel getTerminPanel() {
		return terminPanel;
	}

	public void setTerminPanel(TerminPanel terminPanel) {
		this.terminPanel = terminPanel;
	}
}
