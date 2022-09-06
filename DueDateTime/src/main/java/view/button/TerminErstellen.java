package view.button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import view.dialog.NeuTerminDialog;

public class TerminErstellen extends JButton {

	private static final long serialVersionUID = 1L;
	private NeuTerminDialog ntd;

	public TerminErstellen(NeuTerminDialog ntd) {
		setNtd(ntd);
		setText("Erstellen");
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 2, true),
				BorderFactory.createEmptyBorder(15, 25, 15, 25)));
		setForeground(Color.BLUE);
		addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getNtd().getDdt().getTerminService().addTermin(getNtd());
				getNtd().dispose();
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
