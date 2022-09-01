package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame(MainPanel mp) {

		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Due Date Time");
		// ImageIcon img = new ImageIcon("src/img/schwein.png");
		// this.setIconImage(img.getImage());
		this.add(mp);
		this.setVisible(true);
	}

}
