package view.panel;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.DueDateTimeController;

public class MainPanel extends JPanel {
	private DueDateTimeController ddt;
	private HeaderPanel headerPanel;
	private ContentPanel contentPanel;

	private static final long serialVersionUID = 1L;

	public MainPanel(DueDateTimeController ddt) {
		setDdt(ddt);
		setHeaderPanel();
		setContentPanel();

		setSize(1200, 800);
		setLayout(new BorderLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		add(getHeaderPanel(), BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(getContentPanel(), ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);
	}

	private DueDateTimeController getDdt() {
		return ddt;
	}

	private void setDdt(DueDateTimeController ddt) {
		this.ddt = ddt;
	}

	public HeaderPanel getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel() {
		this.headerPanel = new HeaderPanel(getDdt());
	}

	public ContentPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel() {
		this.contentPanel = new ContentPanel(getDdt());
	}
}
