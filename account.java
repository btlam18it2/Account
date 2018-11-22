package JDBCStudentManagement;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class Account extends JFrame {
	JLabel lbluser;
	JTextField tfuser;
	JLabel lblpass;
	JTextField tfpass;
	JButton btnregist;

	//tao doi tuong connect
	Connection conn;
	Statement stmt;
	//tao ham connect DB
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/StudentDB","root","");
			System.out.println("connect success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Account() {
		lbluser = new JLabel("Username");
		tfuser = new JTextField(10);
		lblpass = new JLabel("Password");
		tfpass = new JTextField(10);
		btnregist = new JButton();
		btnregist.setText("Regist");
		btnregist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					Statement stmt = conn.createStatement();
					int n = stmt.executeUpdate("Insert into Account values('"+tfuser.getText()+"','"+tfpass.getText()+"')");
					if (n>0) JOptionPane.showMessageDialog(null, "Success");
					else JOptionPane.showMessageDialog(null,"Fail");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		Container cont = this.getContentPane();
		setLayout(new FlowLayout());
		setSize(400, 300);
		cont.add(lbluser);
		cont.add(tfuser);
		cont.add(lblpass);
		cont.add(tfpass);
		cont.add(btnregist);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Account();
	}

}
