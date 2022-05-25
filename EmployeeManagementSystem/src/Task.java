import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Task extends JPanel implements ActionListener {
	private TaskItem taskItem;

	Task() {
		Header();
		List();

		this.setPreferredSize(new Dimension(1116, 678));
		this.setBackground(Color.white);
		this.setBorder(new EmptyBorder(0, 5, 5, 5));
	}

	JPanel header;
	JLabel titleHeader;
	JButton addTask;

	private void Header() {
		header = new JPanel();
		titleHeader = new JLabel("Tasks");
		titleHeader.setFont(new Font("Roboto", Font.BOLD, 30));
		titleHeader.setForeground(Color.white);
		titleHeader.setBorder(new EmptyBorder(0, 0, 0, 600));

		addTask = new JButton("Add Task");
		addTask.setFont(new Font("Roboto", Font.PLAIN, 24));
		addTask.setFocusable(false);
		addTask.setBackground(Color.white);
		addTask.setContentAreaFilled(false);

		addTask.addActionListener(this);

		header = new JPanel();
		header.setPreferredSize(new Dimension(1466, 90));
		header.setBackground(Color.decode("#9932cc"));
		header.setBorder(new EmptyBorder(20, 0, 0, 0));
		header.add(titleHeader);
		header.add(addTask);

		this.add(header, BorderLayout.NORTH);

	}

	JPanel listPanel;

	private void List() {
		listPanel = new JPanel();
		GridLayout layout = new GridLayout(10, 1);
		layout.setVgap(5);
		layout.setHgap(5);

		taskItem = new TaskItem();

		listPanel.setLayout(layout);
		listPanel.setBackground(Color.white);

		this.add(listPanel, BorderLayout.CENTER);
	}

//	public void updateIndex() {
//		Component[] indexItem = this.getComponents();
//		
//		for(int i = 0; i < indexItem.length; i++) {
//			if(indexItem[i] instanceof TaskItem) {
//				((TaskItem)indexItem[i]).changeIndex(i+1);
//			}
//		}
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTask) {
			TaskItem taskItem = new TaskItem();
			listPanel.add(taskItem);
//			updateIndex();
			revalidate();
		}

	}
}
