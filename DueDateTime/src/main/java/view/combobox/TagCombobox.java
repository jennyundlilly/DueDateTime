package view.combobox;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JComboBox;

import view.dialog.NeuTerminDialog;

public class TagCombobox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	private NeuTerminDialog ntd;

	public TagCombobox(NeuTerminDialog ntd) {
		setNtd(ntd);
		Calendar c = Calendar.getInstance();

		setPreferredSize(new Dimension(200, 50));

		if (getNtd().getErstellenCalendar().get(Calendar.MONTH) == 1) {
			for (int i = 1; i < 30; i++) {
				if (i < 10) {
					addItem(new String("0" + i));
				} else {
					addItem(new String("" + i));
				}
			}
		} else {
			for (int i = 1; i < 32; i++) {
				if (i < 10) {
					addItem(new String("0" + i));
				} else {
					addItem(new String("" + i));
				}
			}
		}

		setSelectedIndex(c.get(Calendar.DAY_OF_MONTH) - 1);
		setFont(new Font("Lucida Grande", Font.BOLD, 18));
	}

	public NeuTerminDialog getNtd() {
		return ntd;
	}

	public void setNtd(NeuTerminDialog ntd) {
		this.ntd = ntd;
	}

}
