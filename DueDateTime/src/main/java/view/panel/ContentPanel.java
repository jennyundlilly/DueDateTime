package view.panel;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DueDateTimeController;

public class ContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DueDateTimeController ddt;

	public ContentPanel(DueDateTimeController ddt) {
		setDdt(ddt);
		setMinimumSize(new Dimension(1200, 800));
		setBorder(new EmptyBorder(10, 15, 10, 15));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public DueDateTimeController getDdt() {
		return ddt;
	}

	public void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}
}
