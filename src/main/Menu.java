package main;

import java.awt.Canvas;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends Canvas {
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panel;

	private static JMenuBar menuBar;
	private static JMenu fileMenu;

	private String clientName;
	private JButton button;

	public Menu() {
		frame = new JFrame();
		panel = new JPanel();

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");

		fileMenu.add(add);
		fileMenu.add(remove);

		menuBar.add(fileMenu);
	}

	JMenuItem add = new JMenuItem(new AbstractAction("Add Client") {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			clientName = JOptionPane.showInputDialog("Please enter desired name to add.");
			if (clientName != null) {
				button = new JButton(clientName);
				panel.add(button);
				frame.revalidate();
				frame.pack();
				frame.setLocationRelativeTo(null);
			}
		}
	});

	JMenuItem remove = new JMenuItem(new AbstractAction("Remove Client") {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
		}
	});

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.frame.setTitle("MedicationSheets for RFK");
		menu.frame.setJMenuBar(menuBar);
		menu.frame.add(menu.panel);
		menu.frame.pack();
		menu.frame.setLocationRelativeTo(null);
		menu.frame.setVisible(true);
	}
}
