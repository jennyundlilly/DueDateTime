package view.combobox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

import javax.swing.Action;
import javax.swing.JComboBox;

import view.dialog.NeuTerminDialog;

public class MonatCombobox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	private NeuTerminDialog ntd;

	public MonatCombobox(NeuTerminDialog ntd) {
		setNtd(ntd);
		final Calendar c = Calendar.getInstance();
		int monatInt = c.get(Calendar.MONTH);
		getNtd().getErstellenCalendar().set(Calendar.MONTH, monatInt);

		String[] monate = { "Januare", "Februare", "märz", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };

		setPreferredSize(new Dimension(200, 50));
		for (int i = 0; i < monate.length; i++) {
			addItem(new String(monate[i]));
		}
		setSelectedIndex(c.get(Calendar.MONTH));
		setFont(new Font("Lucida Grande", Font.BOLD, 18));

		addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int monatInt = c.get(Calendar.MONTH);

				getNtd().getErstellenCalendar().set(Calendar.MONTH, getSelectedIndex());

				System.out.println(getNtd().getErstellenCalendar().get(Calendar.MONTH));
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
