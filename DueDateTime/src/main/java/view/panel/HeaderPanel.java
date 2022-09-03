package view.panel;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DueDateTimeController;
import view.button.NeuButton;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DueDateTimeController ddt;

	public HeaderPanel(DueDateTimeController ddt) {
		setDdt(ddt);
		init();
	}

	private void init() {

		TerminPanel panelTitle = new TerminPanel();
		JLabel t = new JLabel("Title");
		Font font = new Font(null, 0, 24);
		t.setFont(font);
		JLabel m = new JLabel("Message");
		m.setFont(font);
		JLabel r = new JLabel("Restzeit");
		r.setFont(font);
		panelTitle.add(t);
		panelTitle.add(m);
		panelTitle.add(r);

		panelTitle.add(new NeuButton(getDdt()));
		add(panelTitle);

	}

	private DueDateTimeController getDdt() {
		return ddt;
	}

	private void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}

}
