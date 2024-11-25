package package1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class draft {

	public static void main(String[] args) {
		Courses course = new Courses();
		JFrame courses_table_frame = new JFrame();
		courses_table_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		courses_table_frame.setSize(500,500);
		JTable table = new JTable(course.getData(table),course.getColumns());
		JScrollPane pane = new JScrollPane(table);
		courses_table_frame.add(pane);
		courses_table_frame.setVisible(true);
		
	}

}
