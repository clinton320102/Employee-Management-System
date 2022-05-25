import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskItem extends JPanel implements ActionListener{
//	private JLabel index;
	private JTextField taskName;
	private JButton done;

	TaskItem() {

//		index = new JLabel("");
//		index.setPreferredSize(new Dimension(40, 20));
//		index.setHorizontalAlignment(JLabel.CENTER);
//		index.setFont(new Font("Roboto", Font.PLAIN, 17));
//		this.add(index, BorderLayout.WEST);

		taskName = new JTextField("Write Task Here...");
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setPreferredSize(new Dimension(700, 20));
		taskName.setFont(new Font("Roboto", Font.PLAIN, 17));
		this.add(taskName, BorderLayout.CENTER);

		done = new JButton("Done?");
		done.setPreferredSize(new Dimension(100, 20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setContentAreaFilled(false);
		done.setFont(new Font("Roboto", Font.PLAIN, 17));
		done.setFocusable(false);
		done.addActionListener(this);
		this.add(done, BorderLayout.EAST);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done) {
			done.setText("Completed");
			this.setBackground(Color.decode("#9932cc"));
		}
		
	}

//	public void changeIndex(int num) {
//		this.index.setText(num+"");
//		this.revalidate();
//	}
}
