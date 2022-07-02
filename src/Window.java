import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	DBManager dbm;
	
	public Window(DBManager dbm) {
		this.dbm = dbm;
		setSize(new Dimension(1000, 750));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("MANAGER");
		setVisible(true);
	}
}
