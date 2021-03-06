package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

/**
 * 用于展示统计结果的表格
 */
public class Table extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * 创建表格控件
	 * 
	 * @param title 表头
	 * @param data  数据
	 */
	public Table(Object[] title, Object[][] data) {
		setTitle("统计结果");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(MainGui.class.getResource("/img/icon.png")).getImage());
		setBounds(100, 100, 400, 550);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		table = new JTable(data, title);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton cancelButton = new JButton("关闭");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(cancelButton);

	}

}
