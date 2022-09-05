package view.combobox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JComboBox;

import view.dialog.NeuTerminDialog;

public class JahrCombobox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	private NeuTerminDialog ntd;

	public JahrCombobox(NeuTerminDialog ntd) {
		Calendar c = Calendar.getInstance();

		setPreferredSize(new Dimension(200, 50));
		for (int i = c.get(Calendar.YEAR); i < c.get(Calendar.YEAR) + 10; i++) {
			addItem(i + "");
		}
		setSelectedIndex(0);
		setFont(new Font("Lucida Grande", Font.BOLD, 18));

		addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println(getSelectedIndex());

			}
		});
	}

	public NeuTerminDialog getNtd() {
		return ntd;
	}

	public void setNtd(NeuTerminDialog ntd) {
		this.ntd = ntd;
	}
}
