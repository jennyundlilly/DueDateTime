package view.panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.github.parubok.text.multiline.MultilineLabel;
import model.TerminModel;
import utils.LongUtil;

public class TerminPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MultilineLabel restZeitLabel;
	private TerminModel terminModel;

	public TerminPanel(TerminModel terminModel) {
		setTerminModel(terminModel);
		setRestZeitLabel(new MultilineLabel());
	}

	public MultilineLabel getRestZeitLabel() {
		return restZeitLabel;
	}

	public void setRestZeitLabel(MultilineLabel restZeitLabel) {
		this.restZeitLabel = restZeitLabel;
		init();
	}

	private TerminModel getTerminModel() {
		return terminModel;
	}

	private void setTerminModel(TerminModel terminModel) {
		this.terminModel = terminModel;
	}

	private void init() {
		Font font = new Font("Lucida Grande", Font.PLAIN, 16);
		EmptyBorder eBorder = new EmptyBorder(10, 15, 10, 15);

		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		MultilineLabel title = new MultilineLabel();
		title.setText(getTerminModel().getTitle());
		title.setPreferredWidthLimit(250);
		title.setPreferredSize(new Dimension(250, 60));
		title.setFont(font);
		title.setBorder(eBorder);
		add(title);

		MultilineLabel message = new MultilineLabel();

		message.setText(getTerminModel().getMessage());
		message.setPreferredSize(new Dimension(300, 60));
		message.setPreferredWidthLimit(300);
		message.setFont(font);
		message.setBorder(eBorder);
		add(message);

		getRestZeitLabel().setFont(font);

		if (getTerminModel().getRestZeit() >= 3600) {
			getRestZeitLabel().setForeground(Color.BLUE);

		} else {
			getRestZeitLabel().setForeground(Color.RED);
		}
		getRestZeitLabel().setText(LongUtil.secountToString(getTerminModel().getRestZeit()));
		getRestZeitLabel().setPreferredWidthLimit(350);
		getRestZeitLabel().setPreferredSize(new Dimension(350, 60));
		getRestZeitLabel().setLineSpacing(1.2f);
		getRestZeitLabel().setMaxLines(30);
		getRestZeitLabel().setBorder(eBorder);
		add(getRestZeitLabel());

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(300, 60));
		panel.setPreferredSize(new Dimension(300, 60));
		panel.setMaximumSize(new Dimension(300, 60));
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		add(panel);

		final JButton editBtn = new JButton("Bearbeiten");
		editBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true),
				BorderFactory.createEmptyBorder(15, 25, 15, 25)));
		editBtn.setFont(font);
		editBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				editBtn.setForeground(Color.RED);

			}
		});
		final JButton deleteBtn = new JButton("Löschen");
		deleteBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.RED, 2, true),
				BorderFactory.createEmptyBorder(15, 25, 15, 25)));
		deleteBtn.setFont(font);
		deleteBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deleteBtn.setForeground(Color.RED);

			}
		});
		panel.add(editBtn);
		panel.add(deleteBtn);
	}

}
