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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Contact extends JPanel implements ActionListener {

	private int DO_NOTHING_ON_CLOSE;

	Contact() {
		Header();
		Members();

		this.setPreferredSize(new Dimension(1116, 678));
		this.setBackground(Color.white);
		this.setBorder(new EmptyBorder(0, 5, 5, 5));
	}

	JPanel header;
	JLabel titleHeader;
	JButton viewNames;

	private void Header() {
		header = new JPanel();
		titleHeader = new JLabel("Contact");
		titleHeader.setFont(new Font("Roboto", Font.BOLD, 30));
		titleHeader.setForeground(Color.white);
		titleHeader.setBorder(new EmptyBorder(0, 0, 0, 600));

		viewNames = new JButton("View Names");
		viewNames.setFont(new Font("Roboto", Font.PLAIN, 24));
		viewNames.setFocusable(false);
		viewNames.setBackground(Color.white);
		viewNames.addActionListener(this);

		header = new JPanel();
		header.setPreferredSize(new Dimension(1466, 90));
		header.setBackground(Color.decode("#9932cc"));
		header.setBorder(new EmptyBorder(20, 0, 0, 0));
		header.add(titleHeader);
		header.add(viewNames);

		this.add(header, BorderLayout.NORTH);

	}

	JPanel members;
	JLabel clinton, nino, earljay, johncarl, venedic;

	private void Members() {
		GridLayout layout = new GridLayout(2, 3);
		layout.setVgap(20);
		layout.setHgap(20);

		members = new JPanel();

		ImageIcon clintonIcon = new ImageIcon("images/clinton.jpg");
		Image clintonImg = clintonIcon.getImage();
		Image newClintonIcon = clintonImg.getScaledInstance(200, 200, DO_NOTHING_ON_CLOSE);
		clintonIcon = new ImageIcon(newClintonIcon);
		clinton = new JLabel(clintonIcon);

		ImageIcon ninoIcon = new ImageIcon("images/nino.jpg");
		Image ninoImg = ninoIcon.getImage();
		Image newNinoIcon = ninoImg.getScaledInstance(200, 200, DO_NOTHING_ON_CLOSE);
		ninoIcon = new ImageIcon(newNinoIcon);
		nino = new JLabel(ninoIcon);

		ImageIcon earljayIcon = new ImageIcon("images/earljay.jpg");
		Image earljayImg = earljayIcon.getImage();
		Image newEarljayIcon = earljayImg.getScaledInstance(200, 200, DO_NOTHING_ON_CLOSE);
		earljayIcon = new ImageIcon(newEarljayIcon);
		earljay = new JLabel(earljayIcon);

		ImageIcon johncarlIcon = new ImageIcon("images/johncarl.jpg");
		Image johncarlImg = johncarlIcon.getImage();
		Image newJohncarlIcon = johncarlImg.getScaledInstance(200, 200, DO_NOTHING_ON_CLOSE);
		johncarlIcon = new ImageIcon(newJohncarlIcon);
		johncarl = new JLabel(johncarlIcon);

		ImageIcon venedicIcon = new ImageIcon("images/venedic.gif");
		Image venedicImg = venedicIcon.getImage();
		Image newVenedicIcon = venedicImg.getScaledInstance(200, 200, DO_NOTHING_ON_CLOSE);
		venedicIcon = new ImageIcon(newVenedicIcon);
		venedic = new JLabel(venedicIcon);

		members.add(clinton);
		members.add(nino);
		members.add(earljay);
		members.add(johncarl);
		members.add(venedic);
		members.setLayout(layout);

		members.setBackground(Color.white);
		members.setBorder(new EmptyBorder(10, 0, 0, 0));

		this.add(members);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewNames) {
			new MemberNames().setVisible(true);
		}

	}
}
