import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberNames extends JFrame {

	MemberNames() {
		Names();

		this.setSize(500, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle("Members and Role");
	}

	JTable table;

	private void Names() {
		String[][] data = { { "Clinton Orbaña", "Programmer/Leader" }, { "Niño Lebatique", "Programmer" },
				{ "Earl Jay Mariano", "Programmer" }, { "Johncarl Mariano", "Programmer" },
				{ "Venedic Evangelista", "Programmer" } };

		String[] columnNames = { "Name", "Role" };

		table = new JTable(data, columnNames);
		table.setBounds(0, ABORT, 500, 300);
		table.setRowHeight(50);

		JScrollPane scroll = new JScrollPane(table);

		this.add(scroll);
	}
}
