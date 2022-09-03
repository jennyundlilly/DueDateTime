package view.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.DueDateTimeController;
import view.dialog.NeuDialog;

public class NeuButton extends JButton {

	private static final long serialVersionUID = 1L;
	private DueDateTimeController ddt;

	public NeuButton(DueDateTimeController ddt) {
		setDdt(ddt);
		init();
	}

	private DueDateTimeController getDdt() {
		return ddt;
	}

	private void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}

	private void init() {
		this.setText("Neu");
		this.setForeground(Color.BLUE);
		// this.setBackground(new Color(255, 0, 0));
		// this.setBorder(new LineBorder(Color.BLUE, 4, true));

		this.setFont(new Font("Albertus Extra Bold", Font.BOLD, 20));
		// this.setSize(400, 150);

		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NeuDialog();
				getDdt().getTerminService().addTermin();
			}
		});
	}
}
