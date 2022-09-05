package view.dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.DueDateTimeController;
import view.button.TerminErstellen;
import view.combobox.JahrCombobox;
import view.combobox.MinuteCombobox;
import view.combobox.MonatCombobox;
import view.combobox.StundeComboBox;
import view.combobox.TagCombobox;

public class NeuTerminDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField titelEdt;
	private DueDateTimeController ddt;
	private Calendar erstellenCalendar;
	private TagCombobox tagCombobox;
	private MonatCombobox monatCbb;
	private JahrCombobox jahrCombobox;

	public NeuTerminDialog(DueDateTimeController ddt) {
		setDdt(ddt);
		setErstellenCalendar(Calendar.getInstance());
		init();
	}

	public DueDateTimeController getDdt() {
		return ddt;
	}

	public void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}

	private TagCombobox getTagCombobox() {
		return tagCombobox;
	}

	private void setTagCombobox(TagCombobox tagCombobox) {
		this.tagCombobox = tagCombobox;
	}

	private MonatCombobox getMonatCbb() {
		return monatCbb;
	}

	private void setMonatCbb(MonatCombobox monatCbb) {
		this.monatCbb = monatCbb;
	}

	private JahrCombobox getJahrCombobox() {
		return jahrCombobox;
	}

	private void setJahrCombobox(JahrCombobox jahrCombobox) {
		this.jahrCombobox = jahrCombobox;
	}

	private void init() {
		Font fontBold = new Font("Lucida Grande", Font.BOLD, 18);

		setSize(740, 750);
		setTitle("Neuen Termin eintragen");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));

		JPanel l1 = new JPanel();
		l1.setPreferredSize(new Dimension(700, 30));
		add(l1);

		JLabel titelLbl = new JLabel("Titel");
		titelLbl.setPreferredSize(new Dimension(700, 30));
		titelLbl.setFont(fontBold);
		add(titelLbl);

		titelEdt = new JTextField();
		titelEdt.setPreferredSize(new Dimension(700, 30));
		titelEdt.setFont(fontBold);
		add(titelEdt);

		JPanel l11 = new JPanel();
		l11.setPreferredSize(new Dimension(700, 30));
		add(l11);

		JLabel beschreibungLbl = new JLabel("Beschreibung");
		beschreibungLbl.setPreferredSize(new Dimension(700, 30));
		beschreibungLbl.setFont(fontBold);
		add(beschreibungLbl);

		JTextArea beschreibungArea = new JTextArea();
		beschreibungArea.setFont(fontBold);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(700, 80));
		scrollPane.setViewportView(beschreibungArea);
		add(scrollPane);

		JPanel leftJPanel = new JPanel();
		leftJPanel.setPreferredSize(new Dimension(350, 300));

		FlowLayout leftJPanelLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		leftJPanel.setLayout(leftJPanelLayout);

		JPanel l2 = new JPanel();
		l2.setPreferredSize(new Dimension(330, 10));
		leftJPanel.add(l2);

		JLabel tagLbl = new JLabel("Tag");
		tagLbl.setFont(fontBold);
		tagLbl.setPreferredSize(new Dimension(100, 30));
		leftJPanel.add(tagLbl);

		TagCombobox tagCbb = new TagCombobox(this);
		leftJPanel.add(tagCbb);

		JPanel l3 = new JPanel();
		l3.setPreferredSize(new Dimension(330, 10));
		leftJPanel.add(l3);

		JLabel monatLbl = new JLabel("Monat");
		monatLbl.setPreferredSize(new Dimension(100, 30));
		monatLbl.setFont(fontBold);
		leftJPanel.add(monatLbl);
		setMonatCbb(new MonatCombobox(this));
		leftJPanel.add(getMonatCbb());

		JPanel l4 = new JPanel();
		l4.setPreferredSize(new Dimension(330, 10));
		leftJPanel.add(l4);

		JLabel jahrLbl = new JLabel("Jahr");
		jahrLbl.setPreferredSize(new Dimension(100, 30));
		jahrLbl.setFont(fontBold);
		leftJPanel.add(jahrLbl);

		setJahrCombobox(new JahrCombobox(this));

		leftJPanel.add(getJahrCombobox());

		add(leftJPanel);

		JPanel rightJPanel = new JPanel();
		rightJPanel.setPreferredSize(new Dimension(350, 300));

		FlowLayout rightJPanelLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		rightJPanel.setLayout(rightJPanelLayout);

		JPanel l5 = new JPanel();
		l5.setPreferredSize(new Dimension(330, 10));
		rightJPanel.add(l5);

		JLabel stundeLbl = new JLabel("Stunde");
		stundeLbl.setPreferredSize(new Dimension(100, 30));
		rightJPanel.add(stundeLbl);

		rightJPanel.add(new StundeComboBox());

		JLabel minuteLbl = new JLabel("Minute");
		minuteLbl.setPreferredSize(new Dimension(100, 30));
		rightJPanel.add(minuteLbl);

		rightJPanel.add(new MinuteCombobox());

		add(rightJPanel);

		JPanel bottomJPanel = new JPanel();
		bottomJPanel.setPreferredSize(new Dimension(350, 300));
		bottomJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));
		TerminErstellen erstellenBtn = new TerminErstellen(this);

		bottomJPanel.add(erstellenBtn);
		add(bottomJPanel);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	public Calendar getErstellenCalendar() {
		return erstellenCalendar;
	}

	public void setErstellenCalendar(Calendar erstellenCalendar) {
		this.erstellenCalendar = erstellenCalendar;
	}

}
