package task;

import java.awt.Color;
import java.util.TimerTask;

import javax.swing.JLabel;

import model.TerminModel;
import utils.LongUtil;

public class TerminTask extends TimerTask {

	private TerminModel terminModel;
	private JLabel restZeit;

	public TerminTask(TerminModel terminModel, JLabel restZeit) {
		setModel(terminModel);
		setRestZeit(restZeit);
	}

	private TerminModel getModel() {
		return terminModel;
	}

	private void setModel(TerminModel terminModel) {
		this.terminModel = terminModel;
	}

	public JLabel getRestZeit() {
		return restZeit;
	}

	public void setRestZeit(JLabel restZeit) {
		this.restZeit = restZeit;
	}

	@Override
	public void run() {
		getModel().setInterval();
		getModel().setRestZeit();
		if (terminModel.getRestZeit() >= 3600) {
			getRestZeit().setForeground(Color.BLUE);

		} else {
			getRestZeit().setForeground(Color.RED);
		}
		getRestZeit().setText(LongUtil.secountToString(terminModel.getRestZeit()));
	}
}
