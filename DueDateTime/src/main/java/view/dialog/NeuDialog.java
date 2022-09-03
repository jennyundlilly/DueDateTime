package view.dialog;

import javax.swing.JDialog;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class NeuDialog extends JDialog {
	public NeuDialog() {

		init();
	}

	private void init() {
//this.getContentPane()setLayout(getLayout());
		this.setTitle("Termin eingeben");
		this.setSize(600, 400);
		this.setModal(true);
		this.setLocationRelativeTo(null);

		this.setResizable(false);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

		this.add(datePicker);
//		this.add(new Panel().add(new JButton("ok").add(new JLabel("Label"))));
//		this.add(new Panel().add(new JButton("ok").add(new JLabel("Label"))));
		this.setVisible(true);
		// getDdt().getTerminService().addTermin();

	}

}
