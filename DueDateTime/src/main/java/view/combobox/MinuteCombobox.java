package view.combobox;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JComboBox;

import view.dialog.NeuTerminDialog;

public class MinuteCombobox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	private NeuTerminDialog ntd;

	public MinuteCombobox() {
		setNtd(ntd);
		Calendar c = Calendar.getInstance();

		setPreferredSize(new Dimension(200, 50));
		for (int i = 0; i < 60; i = i + 5) {
			if (i < 10) {
				addItem(new String("0" + i));
			} else {
				addItem(new String("" + i));
			}
		}
		int index = 0;
		try {
			index = (c.get(Calendar.MINUTE) / 5) + 1;
			if (index == 12) {
				index = 0;
			}
		} catch (Exception e) {
			index = 0;
		}

		setSelectedIndex(index);
		setFont(new Font("Lucida Grande", Font.BOLD, 18));
	}

	public NeuTerminDialog getNtd() {
		return ntd;
	}

	public void setNtd(NeuTerminDialog ntd) {
		this.ntd = ntd;
	}
}
