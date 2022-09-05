package view.combobox;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JComboBox;

public class StundeComboBox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;

	public StundeComboBox() {
		Calendar c = Calendar.getInstance();

		setPreferredSize(new Dimension(200, 50));
		for (int i = 0; i < 24; i++) {
			if (i < 10) {
				addItem(new String("0" + i));
			} else {
				addItem(new String("" + i));
			}
		}
		setSelectedIndex(c.get(Calendar.HOUR_OF_DAY));
		setFont(new Font("Lucida Grande", Font.BOLD, 18));
	}

}
