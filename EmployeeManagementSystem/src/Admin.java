import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Admin extends JPanel implements ActionListener {
	Connect connect = new Connect();

	Admin() {

		Button();
		AdminTable();

		this.setPreferredSize(new Dimension(1116, 678));
		this.setBackground(Color.white);
		this.setBorder(new EmptyBorder(0, 5, 5, 5));
	}

	JPanel buttonPanel;
	JButton addEmp, delEmp, refresh;
	JLabel title;

	private void Button() {
		buttonPanel = new JPanel();

		title = new JLabel("Employee");
		title.setFont(new Font("Roboto", Font.BOLD, 30));
		title.setForeground(Color.white);
		title.setBorder(new EmptyBorder(0, 0, 0, 415));
		buttonPanel.add(title);

		addEmp = new JButton("ADD");
		delEmp = new JButton("DELETE");
		refresh = new JButton("REFRESH");

		addEmp.setContentAreaFilled(false);
		delEmp.setContentAreaFilled(false);
		refresh.setContentAreaFilled(false);

		addEmp.setFont(new Font("Roboto", Font.PLAIN, 20));
		delEmp.setFont(new Font("Roboto", Font.PLAIN, 20));
		refresh.setFont(new Font("Roboto", Font.PLAIN, 20));

		addEmp.setFocusable(false);
		delEmp.setFocusable(false);
		refresh.setFocusable(false);

		addEmp.addActionListener(this);
		delEmp.addActionListener(this);
		refresh.addActionListener(this);

		buttonPanel.add(addEmp);
		buttonPanel.add(delEmp);
		buttonPanel.add(refresh);

		buttonPanel.setPreferredSize(new Dimension(1116, 90));
		buttonPanel.setBackground(Color.decode("#9932cc"));

		buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

		this.add(buttonPanel, BorderLayout.NORTH);
	}

	DefaultTableModel model;
	JTable table;
	JPanel adminPanel;

	private void AdminTable() {
		adminPanel = new JPanel();

		String[] colName = { "ID", "Username", "Full Name", "Department" };

		model = new DefaultTableModel();
		model.setColumnIdentifiers(colName);

		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(47);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(900, 410));

		String id = "";
		String user = "";
		String fullName = "";
		String dprtmt = "";

		try {
			connect.pstmt = connect.con.prepareStatement("SELECT ID, USERNAME, FULLNAME, DEPARTMENT FROM SYSTEM_ADMIN");
			connect.res = connect.pstmt.executeQuery();

			int i = 0;

			while (connect.res.next()) {
				id = connect.res.getString("id");
				user = connect.res.getString("username");
				fullName = connect.res.getString("fullname");
				dprtmt = connect.res.getString("department");
				model.addRow(new Object[] { id, user, fullName, dprtmt });
				i++;
			}

			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception err) {
			Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, err);
		}

		adminPanel.add(scroll);
		this.add(adminPanel, BorderLayout.SOUTH);
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

//		ADD DATA TO TABLE
		if (e.getSource() == addEmp) {
			new AddEmployeeFrame();
		}

//		DELETE DATA FROM TABLE
		if (e.getSource() == delEmp) {
			try {
				int row = table.getSelectedRow();
				String selected = table.getModel().getValueAt(row, 0).toString();
				connect.pstmt = connect.con.prepareStatement("DELETE FROM system_admin WHERE id = '" + selected + "'");
				connect.pstmt.execute();

				if (row != 0) {
					model.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Selected row deleted successfully.");
				}

			} catch (Exception err) {
				Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, err);
			}
		}

		if (e.getSource() == refresh) {
			Dashboard dashboard = new Dashboard();
			SwingUtilities.updateComponentTreeUI(dashboard);
		}
	}
}