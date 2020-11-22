
import java.awt.Color;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Department implements ActionListener{
	int id;
	JFrame frame;
	JButton insert,back;
	JLabel titleLabel,departLabel;
	JTextField depName;
	JTextArea ress;
	public Department(int id) {
		this.id = id;
	}
	public void addDepartment(){
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Add Department");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(370,50,900,60);
		departLabel = new JLabel("Department Name: ");		
		departLabel.setForeground(Color.RED);
		departLabel.setFont (departLabel.getFont().deriveFont (15.0f));
		departLabel.setBounds(325, 185, 250, 50);
		depName = new JTextField();
		depName.setBounds(475, 195, 200, 30);
		insert = new JButton("Add Department");
		insert.setBounds(415, 575, 150, 75);
		insert.setForeground(Color.RED);
		insert.setBackground(Color.WHITE);
		insert.addActionListener(this);
	
		frame.add(departLabel);
		frame.add(titleLabel);
		frame.add(insert);
		frame.add(depName);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void showDepartment() {
		String str="";
		try {
	 
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from Department order by name");
			while(rs.next()) {
				str = str + rs.getString(1) + "\n";
			}
		}
		catch(Exception f) {
				System.out.println(f);
		}
		frame= new JFrame("Hospital Appointment Booking System");    
	    JPanel panel=new JPanel(new FlowLayout());  
	    panel.setBounds(160,110,700,450);    
	    JTextArea ress=new JTextArea(21,30);  
	 	JScrollPane textArea = new JScrollPane(ress);  
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    ress.setText(str);
	    ress.setFont(ress.getFont ().deriveFont (15.0f));
	    ress.setEditable(false);
	    panel.setBackground(Color.CYAN);
		panel.add(new JScrollPane(ress,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		titleLabel = new JLabel("Department");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(300,50,900,60); 
	 	back = new JButton("Back");
		back.setBounds(415, 575, 150, 75);
		back.setForeground(Color.RED);
		back.setBackground(Color.WHITE);
		back.addActionListener(this);
		frame.getContentPane().setBackground(Color.CYAN);
	    frame.add(panel);  
	    frame.add(titleLabel);
	    frame.add(back);
	    frame.setSize(1000,700);    
	    frame.setLayout(null);    
	    frame.setVisible(true);    
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==insert) {
			String dep = depName.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select * from Department where name=?");
				stmt.setString(1, dep);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()==false) {
					PreparedStatement stm=con.prepareStatement("insert into Department values(?)");
					stm.setString(1, dep);
					stm.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Department Added Succesfully");
				}
				else {
					JOptionPane.showMessageDialog(frame,"Department already exists ");
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
		if(e.getSource()==back) {
			frame.dispose();
		}
	}
}
