package view.dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.DueDateTimeController;
import view.button.AbbrechenButton;
import view.button.TerminErstellen;
import view.combobox.JahrCombobox;
import view.combobox.MinuteCombobox;
import view.combobox.MonatCombobox;
import view.combobox.StundeComboBox;
import view.combobox.TagCombobox;
import view.panel.LeerPanel;

public class NeuTerminDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private DueDateTimeController ddt;
	private Calendar erstellenCalendar;

	private JTextField titelField;
	private JTextArea beschreibungArea;
	private MinuteCombobox minuteCombobox;
	private StundeComboBox stundeCombobox;
	private TagCombobox tagCombobox;
	private MonatCombobox monatCombobox;
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

	public Calendar getErstellenCalendar() {
		return erstellenCalendar;
	}

	public void setErstellenCalendar(Calendar erstellenCalendar) {
		this.erstellenCalendar = erstellenCalendar;
	}

	public MinuteCombobox getMinuteCombobox() {
		return minuteCombobox;
	}

	public void setMinuteCombobox(MinuteCombobox minuteCombobox) {
		this.minuteCombobox = minuteCombobox;
	}

	public StundeComboBox getStundeCombobox() {
		return stundeCombobox;
	}

	public void setStundeCombobox(StundeComboBox stundeCombobox) {
		this.stundeCombobox = stundeCombobox;
	}

	public TagCombobox getTagCombobox() {
		return tagCombobox;
	}

	public void setTagCombobox(TagCombobox tagCombobox) {
		this.tagCombobox = tagCombobox;
	}

	public MonatCombobox getMonatCombobox() {
		return monatCombobox;
	}

	public void setMonatCombobox(MonatCombobox monatCombobox) {
		this.monatCombobox = monatCombobox;
	}

	public JahrCombobox getJahrCombobox() {
		return jahrCombobox;
	}

	public void setJahrCombobox(JahrCombobox jahrCombobox) {
		this.jahrCombobox = jahrCombobox;
	}

	public JTextField getTitelField() {
		return titelField;
	}

	public void setTitelField(JTextField titelField) {
		this.titelField = titelField;
	}

	public JTextArea getBeschreibungArea() {
		return beschreibungArea;
	}

	public void setBeschreibungArea(JTextArea beschreibungArea) {
		this.beschreibungArea = beschreibungArea;
	}

	private void init() {
		Font fontBold = new Font("Lucida Grande", Font.BOLD, 18);

		setSize(740, 550);
		setTitle("Neuen Termin eintragen");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));

		add(new LeerPanel(700, 30));

		JLabel titelLbl = new JLabel("Titel");
		titelLbl.setPreferredSize(new Dimension(700, 30));
		titelLbl.setFont(fontBold);
		add(titelLbl);

		setTitelField(new JTextField());
		getTitelField().setPreferredSize(new Dimension(700, 30));
		getTitelField().setFont(fontBold);
		add(getTitelField());

		add(new LeerPanel(700, 30));

		JLabel beschreibungLbl = new JLabel("Beschreibung");
		beschreibungLbl.setPreferredSize(new Dimension(700, 30));
		beschreibungLbl.setFont(fontBold);
		add(beschreibungLbl);

		setBeschreibungArea(new JTextArea());
		getBeschreibungArea().setFont(fontBold);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(700, 80));
		scrollPane.setViewportView(beschreibungArea);
		add(scrollPane);

		JPanel leftJPanel = new JPanel();
		leftJPanel.setPreferredSize(new Dimension(350, 200));

		FlowLayout leftJPanelLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		leftJPanel.setLayout(leftJPanelLayout);

		leftJPanel.add(new LeerPanel(330, 10));

		JLabel tagLbl = new JLabel("Tag");
		tagLbl.setFont(fontBold);
		tagLbl.setPreferredSize(new Dimension(100, 30));
		leftJPanel.add(tagLbl);

		setTagCombobox(new TagCombobox(this));
		leftJPanel.add(getTagCombobox());

		leftJPanel.add(new LeerPanel(330, 10));

		JLabel monatLbl = new JLabel("Monat");
		monatLbl.setPreferredSize(new Dimension(100, 30));
		monatLbl.setFont(fontBold);
		leftJPanel.add(monatLbl);

		setMonatCombobox(new MonatCombobox(this));
		leftJPanel.add(getMonatCombobox());

		leftJPanel.add(new LeerPanel(330, 10));

		JLabel jahrLbl = new JLabel("Jahr");
		jahrLbl.setPreferredSize(new Dimension(100, 30));
		jahrLbl.setFont(fontBold);
		leftJPanel.add(jahrLbl);

		setJahrCombobox(new JahrCombobox(this));
		leftJPanel.add(getJahrCombobox());

		add(leftJPanel);

		JPanel rightJPanel = new JPanel();
		rightJPanel.setPreferredSize(new Dimension(350, 200));
		FlowLayout rightJPanelLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		rightJPanel.setLayout(rightJPanelLayout);

		rightJPanel.add(new LeerPanel(330, 10));

		JLabel stundeLbl = new JLabel("Stunde");
		stundeLbl.setPreferredSize(new Dimension(100, 30));
		rightJPanel.add(stundeLbl);

		setStundeCombobox(new StundeComboBox(this));
		rightJPanel.add(getStundeCombobox());

		JLabel minuteLbl = new JLabel("Minute");
		minuteLbl.setPreferredSize(new Dimension(100, 30));
		rightJPanel.add(minuteLbl);

		setMinuteCombobox(new MinuteCombobox());
		rightJPanel.add(getMinuteCombobox());

		add(rightJPanel);

		JPanel bottomJPanel = new JPanel();
		bottomJPanel.setPreferredSize(new Dimension(700, 100));
		bottomJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));
		TerminErstellen erstellenBtn = new TerminErstellen(this);

		bottomJPanel.add(erstellenBtn);
		bottomJPanel.add(new AbbrechenButton(this));
		add(bottomJPanel);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

}
