package controller;

import service.TerminService;
import view.MainFrame;
import view.ViewBuilder;
import view.panel.MainPanel;

public class DueDateTimeController {
	private MainPanel mainPanel;
	private ViewBuilder viewBuilder;
	private TerminService terminService;

	public DueDateTimeController() {
		setTerminService();
		setMainPanel();
		setViewBuilder();
		getViewBuilder().loadStartView();
		new MainFrame(getMainPanel());
	}

	public ViewBuilder getViewBuilder() {
		return viewBuilder;
	}

	private void setMainPanel() {
		this.mainPanel = new MainPanel(this);
		;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	private void setViewBuilder() {
		this.viewBuilder = new ViewBuilder(this);
	}

	public TerminService getTerminService() {
		return terminService;
	}

	private void setTerminService() {
		this.terminService = new TerminService(this);
	}

}
