package view.panel;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import controller.DueDateTimeController;
import io.github.parubok.text.multiline.MultilineLabel;
import view.dialog.NeuTerminDialog;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DueDateTimeController ddt;

	public HeaderPanel(DueDateTimeController ddt) {
		setDdt(ddt);
		init();
	}

	private void init() {
		Font font = new Font("Lucida Grande", Font.PLAIN, 18);
		Border border = new EmptyBorder(10, 15, 10, 15);

		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		MultilineLabel label = new MultilineLabel("Aufgabe");
		label.setPreferredWidthLimit(250);
		label.setPreferredSize(new Dimension(250, 60));
		label.setFont(font);
		label.setLineSpacing(1.2f);
		label.setMaxLines(30);
		label.setBorder(border);
		add(label);

		MultilineLabel label1 = new MultilineLabel("Beschreibung");
		label1.setPreferredSize(new Dimension(300, 60));
		label1.setPreferredWidthLimit(300);
		label1.setFont(font);
		label1.setLineSpacing(1.2f);
		label1.setMaxLines(30);
		label1.setBorder(border);
		add(label1);

		MultilineLabel label2 = new MultilineLabel("Verbleibene Zeit");
		label2.setPreferredSize(new Dimension(350, 60));
		label2.setPreferredWidthLimit(350);
		label2.setFont(font);
		label2.setLineSpacing(1.2f);
		label2.setMaxLines(30);
		label2.setBorder(border);
		add(label2);

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(300, 60));
		panel.setPreferredSize(new Dimension(300, 60));
		panel.setMaximumSize(new Dimension(300, 60));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		final JButton neuTerminbtn = new JButton("Erstellen");
		neuTerminbtn.setText("Erstellen");
		neuTerminbtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 2, true),
				BorderFactory.createEmptyBorder(15, 25, 15, 25)));
		neuTerminbtn.setFont(font);

		panel.add(neuTerminbtn);

		add(panel);

		neuTerminbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new NeuTerminDialog(getDdt());

			}
		});
	}

	private DueDateTimeController getDdt() {
		return ddt;
	}

	private void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}

}
