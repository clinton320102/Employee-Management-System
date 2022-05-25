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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {
//	OBJECT FROM CONNECT CLASS
	Connect connect = new Connect();

	Login() {
		initComponents();
	}

//	LOGIN FRAME COMPONENTS 
	private JLabel userLabel, pwdLabel, message;
	private JTextField userField;
	private JPasswordField pwdField;
	private JButton loginBtn;

	private void initComponents() {

		JLabel title = new JLabel("Employee Management System");
		title.setForeground(Color.white);
		title.setFont(new Font("Roboto", Font.BOLD, 25));

		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(500, 100));
		header.setBackground(Color.decode("#4b0082"));
		header.add(title);
		header.setBorder(new EmptyBorder(30, 0, 0, 0));
		this.add(header, BorderLayout.NORTH);

		JPanel form = new JPanel();

		userLabel = new JLabel("Username");
		userLabel.setBounds(100, 50, 200, 40);
		userLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		form.add(userLabel);

		userField = new JTextField();
		userField.setBounds(100, 85, 280, 35);
		form.add(userField);

		pwdLabel = new JLabel("Password");
		pwdLabel.setBounds(100, 120, 200, 40);
		pwdLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		form.add(pwdLabel);

		pwdField = new JPasswordField();
		pwdField.setBounds(100, 155, 280, 35);
		form.add(pwdField);

		loginBtn = new JButton("Continue");
		loginBtn.setBounds(100, 202, 100, 35);
		loginBtn.setFocusable(false);
		loginBtn.addActionListener(this);
		form.add(loginBtn);

		message = new JLabel("Username or Password is incorrect!");
		message.setBounds(100, 350, 300, 40);
		message.setForeground(Color.red);
		message.setVisible(false);
		this.add(message);

		form.add(userField);
		form.setLayout(null);
		this.add(form);

		this.setSize(500, 500);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Developer Team System Management");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {

			String user = userField.getText();
			String pwd = new String(pwdField.getPassword());

			try {
				connect.pstmt = connect.con.prepareStatement("SELECT * FROM SYSTEM_ADMIN");
				connect.res = connect.pstmt.executeQuery();

				while (connect.res.next()) {
					String uname = connect.res.getString("username");
					String pword = connect.res.getString("password");

					if ((user.equals(uname)) && (pwd.equals(pword))) {
						new Dashboard();
						this.setVisible(false);
					} else {
						message.setVisible(true);
						userField.setText("");
						pwdField.setText("");
					}
				}

			} catch (Exception err) {
				Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, err);
			}
		}
	}
}
