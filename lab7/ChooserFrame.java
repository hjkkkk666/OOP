package lab7;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.List;
import java.util.Enumeration;
import javax.swing.*;

public class ChooserFrame extends JFrame {

	public ChooserFrame() {
		super("List");
		setSize(500,500);
		setLocation(200,100);
		setLayout(new BorderLayout());
		
		createMenubar();
		createToolbar();
		createListsPanel();
		createToolbarListeners();
		createButtonsListeners();
	}
	
	private void createMenubar() {
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(getParent(),
						"Are you sure you want to quit?", "Confirm quit",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null);
				if (option == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		fileMenu.add(exitItem);
	}
	
	private JButton resetButton, saveButton;
	
	private void createToolbar() {
		saveButton = new JButton("Save");
		resetButton = new JButton("Reset");
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout());
		toolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		toolbar.add(saveButton);
		toolbar.add(resetButton);
		add(toolbar, BorderLayout.NORTH);
		
	}
	
	private DefaultListModel<String> moviesModel, teamModel;
	private JList<String> moviesList, teamList;
	
	private JButton takeButton, returnButton, takeAllButton, returnAllButton;

	private JPanel createButtonsPanel() {
		JPanel buttonspanel = new JPanel();
		buttonspanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttonspanel.setLayout(new GridLayout(4,0));
		takeButton = new JButton(">");
		takeButton.setToolTipText("Добавить выбранный фильм");
		takeAllButton = new JButton(">>");
		takeAllButton.setToolTipText("Добавить все фильмы");
		returnButton = new JButton("<");
		returnButton.setToolTipText("Вернуть выбранный фильм");
		returnAllButton = new JButton("<<");
		returnAllButton.setToolTipText("Вернуть все фильмы");
		buttonspanel.add(takeButton);
		buttonspanel.add(takeAllButton);
		buttonspanel.add(returnButton);
		buttonspanel.add(returnAllButton);
		return buttonspanel;	}
	
	private void createListsPanel() {
		moviesModel = new DefaultListModel<String>();
		for (String player : MoviesBase.getMovies()) {
			moviesModel.addElement(player);
		}
		teamModel = new DefaultListModel<String>();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		moviesList = new JList<String>(moviesModel);
		moviesList.setToolTipText("Доступные фильмы");
		moviesList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		teamList = new JList<String>(teamModel);
		teamList.setToolTipText("Выбранные фильмы");
		teamList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(moviesList);
		panel.add(createButtonsPanel());
		panel.add(teamList);
		add(panel,BorderLayout.CENTER);
		
	}
	
	private void createToolbarListeners() {
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String all = "";
				Enumeration<String> elements = teamModel.elements();
				while(elements.hasMoreElements()) {
					all += elements.nextElement() +"\n";
					JOptionPane.showMessageDialog(getParent(), all,
							"Выбраны следующие фильмы:",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teamModel.removeAllElements();
				moviesModel.removeAllElements();
				for (String movie : MoviesBase.getMovies()) {
					moviesModel.addElement(movie);
				}
				
			}
			
		});
	}
	
	private void createButtonsListeners() {
		takeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> selection = moviesList.getSelectedValuesList();
				for (String movie : selection) {
					teamModel.addElement(movie);
				}
				
				for (String movie : selection) {
					moviesModel.removeElement(movie);
				}
		}
			
	});
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> selection = teamList.getSelectedValuesList();
				for (String team : selection) {
					moviesModel.addElement(team);
				}
				
				for (String team : selection) {
					teamModel.removeElement(team);
				}
				
				
			}
			
		});
		
		takeAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<String> elements = moviesModel.elements();
				while (elements.hasMoreElements()) {
					String next = elements.nextElement();
					teamModel.addElement(next);
				}
				moviesModel.removeAllElements();
				
			}
			
		});
		
		returnAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<String> elements = teamModel.elements();
				while (elements.hasMoreElements()) {
					String next = elements.nextElement();
					moviesModel.addElement(next);
				}
				teamModel.removeAllElements();
				
			}
			
		});
		
	}
	
}
