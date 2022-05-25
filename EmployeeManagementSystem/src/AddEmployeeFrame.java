import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddEmployeeFrame extends JFrame implements ActionListener {

	Connect connect = new Connect();

	AddEmployeeFrame() {

		Header();
		AddPanel();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setSize(350, 500);
		this.setVisible(true);

	}

	JPanel header;
	JLabel headerLabel;

	private void Header() {
		header = new JPanel();
		headerLabel = new JLabel("Add New Member");
		headerLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		headerLabel.setForeground(Color.white);

		header.add(headerLabel);
		header.setBackground(Color.decode("#4b0082"));
		header.setPreferredSize(new Dimension(350, 70));
		header.setBorder(new EmptyBorder(20, 0, 0, 0));

		this.add(header, BorderLayout.NORTH);
	}

	JPanel addPanel;
	JLabel userLabel, passwordLabel, fullNameLabel, departmentLabel;
	JTextField userField, fullNameField, departmentField;
	JPasswordField passwordField;
	JButton addButton;

	private void AddPanel() {
		addPanel = new JPanel();
		userLabel = new JLabel("Enter Username");
		userLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		userLabel.setBounds(40, 20, 200, 30);
		addPanel.add(userLabel);

		passwordLabel = new JLabel("Enter Password");
		passwordLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		passwordLabel.setBounds(40, 90, 200, 30);
		addPanel.add(passwordLabel);

		fullNameLabel = new JLabel("Enter Full Name");
		fullNameLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		fullNameLabel.setBounds(40, 160, 200, 30);
		addPanel.add(fullNameLabel);

		departmentLabel = new JLabel("Enter Department");
		departmentLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		departmentLabel.setBounds(40, 230, 200, 30);
		addPanel.add(departmentLabel);

		userField = new JTextField();
		userField.setBounds(40, 50, 250, 35);
		addPanel.add(userField);

		passwordField = new JPasswordField();
		passwordField.setBounds(40, 120, 250, 35);
		addPanel.add(passwordField);

		fullNameField = new JTextField();
		fullNameField.setBounds(40, 190, 250, 35);
		addPanel.add(fullNameField);

		departmentField = new JTextField();
		departmentField.setBounds(40, 260, 250, 35);
		addPanel.add(departmentField);

		addButton = new JButton("Add Member");
		addButton.setBounds(40, 310, 150, 35);
		addButton.setFocusable(false);
		addPanel.add(addButton);

		addButton.addActionListener(this);

		addPanel.setLayout(null);

		this.add(addPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addButton) {

			String user = userField.getText();
			String password = new String(passwordField.getPassword());
			String fullName = fullNameField.getText();
			String department = departmentField.getText();

			try {
				if ((user.equals("")) && (password.equals("")) && (fullName.equals("")) && department.equals("")) {
					JOptionPane.showMessageDialog(null, "All field must be fill!");
				} else {
					connect.pstmt = connect.con
							.prepareStatement("INSERT INTO system_admin (username, password, fullname, department)"
									+ " values(?, ?, ?, ?)");
					connect.pstmt.setString(1, user);
					connect.pstmt.setString(2, password);
					connect.pstmt.setString(3, fullName);
					connect.pstmt.setString(4, department);

					connect.pstmt.execute();

					connect.con.close();

					JOptionPane.showMessageDialog(null, "New member added successfully!");
				}
			} catch (Exception err) {
				Logger.getLogger(AddEmployeeFrame.class.getName()).log(Level.SEVERE, null, err);
			}

			this.setVisible(false);

		}

	}
}