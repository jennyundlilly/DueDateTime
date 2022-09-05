package view;

import javax.swing.JFrame;

import view.panel.MainPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame(MainPanel mainPanel) {

		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Due Date Time");
		// ImageIcon img = new ImageIcon("src/img/schwein.png");
		// this.setIconImage(img.getImage());

		add(mainPanel);
		setVisible(true);
	}
}
