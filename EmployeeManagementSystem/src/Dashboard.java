import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Dashboard extends JFrame implements ActionListener {
	private Admin admin;
	private Task task;
	private Contact contact;

	Dashboard() {

		Header();
		Menu();

		admin = new Admin();
		this.add(admin, BorderLayout.CENTER);

		contact = new Contact();
		task = new Task();

		this.setSize(1366, 678);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	JPanel menu;
	JButton empBtn, taskBtn, contactBtn;

	private void Menu() {
		GridLayout layout = new GridLayout(5, 1);
		layout.setVgap(5);

		ImageIcon teamIcon = new ImageIcon("images/team.png");
		Image teamImg = teamIcon.getImage();
		Image newTeamIcon = teamImg.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		teamIcon = new ImageIcon(newTeamIcon);

		empBtn = new JButton(teamIcon);
		empBtn.setFocusable(false);
		empBtn.setText("Employee");
		empBtn.setFont(new Font("Roboto", Font.PLAIN, 20));
		empBtn.setBackground(Color.white);

		ImageIcon projIcon = new ImageIcon("images/project.png");
		Image projImg = projIcon.getImage();
		Image newProjIcon = projImg.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		projIcon = new ImageIcon(newProjIcon);

		taskBtn = new JButton(projIcon);
		taskBtn.setFocusable(false);
		taskBtn.setText("Tasks");
		taskBtn.setFont(new Font("Roboto", Font.PLAIN, 20));
		taskBtn.setBackground(Color.white);

		ImageIcon contactIcon = new ImageIcon("images/contact.png");
		Image contactImg = contactIcon.getImage();
		Image newContactIcon = contactImg.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		contactIcon = new ImageIcon(newContactIcon);

		contactBtn = new JButton(contactIcon);
		contactBtn.setFocusable(false);
		contactBtn.setText("Contact");
		contactBtn.setFont(new Font("Roboto", Font.PLAIN, 20));
		contactBtn.setBackground(Color.white);

		empBtn.addActionListener(this);
		taskBtn.addActionListener(this);
		contactBtn.addActionListener(this);

		menu = new JPanel();
		menu.add(empBtn);
		menu.add(taskBtn);
		menu.add(contactBtn);
		menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu.setLayout(layout);
		menu.setPreferredSize(new Dimension(250, 678));

		this.add(menu, BorderLayout.WEST);
	}

	JPanel header;
	JLabel titleHeader;

	private void Header() {
		titleHeader = new JLabel("Employee Management System");
		titleHeader.setFont(new Font("Roboto", Font.BOLD, 30));
		titleHeader.setForeground(Color.white);

		header = new JPanel();
		header.setPreferredSize(new Dimension(1466, 90));
		header.setBackground(Color.decode("#4b0082"));
		header.setBorder(new EmptyBorder(20, 0, 0, 0));
		header.add(titleHeader);

		this.add(header, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == empBtn) {
			admin.setVisible(true);
			task.setVisible(false);
			contact.setVisible(false);
		}

		if (e.getSource() == contactBtn) {
			this.add(contact, BorderLayout.CENTER);
			contact.setVisible(true);
			admin.setVisible(false);
			task.setVisible(false);
		}

		if (e.getSource() == taskBtn) {
			this.add(task, BorderLayout.CENTER);
			task.setVisible(true);
			admin.setVisible(false);
			contact.setVisible(false);
		}
	}
}
