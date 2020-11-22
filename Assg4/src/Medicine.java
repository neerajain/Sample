import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Medicine implements ActionListener{
	int id;
	JFrame frame;
	JButton insert,delete,search,update;
	JLabel titleLabel,nameLabel, costLabel, quantityLabel;
	JTextField nameTxt, costTxt, quantityTxt;
	public Medicine(int id) {
		this.id = id;
	}
	void addMedicine() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Add Medicine");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(370,50,900,60);
		
		nameLabel = new JLabel("Name: ");		
		nameLabel.setForeground(Color.RED);
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setBounds(325, 185, 250, 50);
		costLabel = new JLabel("Cost: ");
		costLabel.setFont (costLabel.getFont().deriveFont (15.0f));
		costLabel.setForeground(Color.RED);
		costLabel.setBounds(325, 245, 250, 50);
		quantityLabel = new JLabel("Quantity: ");
		quantityLabel.setFont (quantityLabel.getFont().deriveFont (15.0f));
		quantityLabel.setForeground(Color.RED);
		quantityLabel.setBounds(325, 305, 250, 50);  
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 195, 200, 30);
		costTxt = new JTextField();
		costTxt.setBounds(475, 255, 200, 30);
		quantityTxt=new JTextField();
		quantityTxt.setBounds(475, 315, 200, 30);
		insert = new JButton("Add Medicine");
		insert.setBounds(415, 575, 150, 75);
		insert.setForeground(Color.RED);
		insert.setBackground(Color.WHITE);
		insert.addActionListener(this);
		frame.add(titleLabel);
		frame.add(nameLabel);
		frame.add(nameTxt);
		frame.add(quantityLabel);
		frame.add(quantityTxt);
		frame.add(costLabel);
		frame.add(costTxt);
		frame.add(insert);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void deleteMedicine() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Delete Medicine");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(370,50,900,60);
		
		nameLabel = new JLabel("Name: ");		
		nameLabel.setForeground(Color.RED);
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setBounds(325, 185, 250, 50); 
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 195, 200, 30);
		delete = new JButton("Delete Medicine");
		delete.setBounds(415, 575, 150, 75);
		delete.setForeground(Color.RED);
		delete.setBackground(Color.WHITE);
		delete.addActionListener(this);
		frame.add(titleLabel);
		frame.add(nameLabel);
		frame.add(nameTxt);
		frame.add(delete);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void updateMedicine() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Update Medicine");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(370,50,900,60);
		
		nameLabel = new JLabel("Name: ");		
		nameLabel.setForeground(Color.RED);
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setBounds(325, 185, 250, 50);
		costLabel = new JLabel("New Cost: ");
		costLabel.setFont (costLabel.getFont().deriveFont (15.0f));
		costLabel.setForeground(Color.RED);
		costLabel.setBounds(325, 245, 250, 50);
		quantityLabel = new JLabel("New Quantity: ");
		quantityLabel.setFont (quantityLabel.getFont().deriveFont (15.0f));
		quantityLabel.setForeground(Color.RED);
		quantityLabel.setBounds(325, 305, 250, 50);  
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 195, 200, 30);
		costTxt = new JTextField();
		costTxt.setBounds(475, 255, 200, 30);
		quantityTxt=new JTextField();
		quantityTxt.setBounds(475, 315, 200, 30);
		update = new JButton("Update Medicine");
		update.setBounds(415, 575, 150, 75);
		update.setForeground(Color.RED);
		update.setBackground(Color.WHITE);
		update.addActionListener(this);
		frame.add(titleLabel);
		frame.add(nameLabel);
		frame.add(nameTxt);
		frame.add(quantityLabel);
		frame.add(quantityTxt);
		frame.add(costLabel);
		frame.add(costTxt);
		frame.add(update);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void searchMedicine() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Search Medicine");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(370,50,900,60);
		
		nameLabel = new JLabel("Name: ");		
		nameLabel.setForeground(Color.RED);
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setBounds(325, 185, 250, 50); 
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 195, 200, 30);
		search = new JButton("Search Medicine");
		search.setBounds(415, 575, 150, 75);
		search.setForeground(Color.RED);
		search.setBackground(Color.WHITE);
		search.addActionListener(this);
		frame.add(titleLabel);
		frame.add(nameLabel);
		frame.add(nameTxt);
		frame.add(search);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==insert)
		{
			String name = nameTxt.getText();
			int cost = Integer.valueOf(costTxt.getText());
			int quantity = Integer.valueOf(quantityTxt.getText());
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
				stmt.setString(1,name);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()==false) {
					PreparedStatement stm=con.prepareStatement("insert into MedicineTest values(?,?,?)");
					stm.setString(1, name);
					stm.setInt(2, cost);
					stm.setInt(3, quantity);
					stm.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Medicine Added Successfully");
				}
				else {
					JOptionPane.showMessageDialog(frame,"Medicine already addeds ");
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
		else if(e.getSource()==delete)
		{
			String name = nameTxt.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				while(rs.next() == true) {
					PreparedStatement st=con.prepareStatement("delete from MedicineTest where name=?");
					st.setString(1, name);
					st.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Medicine deleted Successfully");
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
		else if(e.getSource()==update)
		{
			String name = nameTxt.getText();
			int cost = Integer.valueOf(costTxt.getText());
			int quantity = Integer.valueOf(quantityTxt.getText());
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()==false) {
					JOptionPane.showMessageDialog(frame,"Medicine Not Found");
				}
				else {
					PreparedStatement smt=con.prepareStatement("update MedicineTest set cost=?,quantity=? where name=?");
					smt.setString(3, name);
					smt.setInt(1, cost);
					smt.setInt(2, quantity);
					smt.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Medicine succesfully updated ");
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
		else if(e.getSource()==search)
		{
			int k=1;
			String name = nameTxt.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				String s="Medicine not found";
				while(rs.next()) {
					s = rs.getString(1)+"\nCost-"+rs.getInt(2)+"\nQuantity-"+rs.getInt(3);
					JOptionPane.showMessageDialog(frame,s);
			        k=2;
				}
				if(k==1)
					JOptionPane.showMessageDialog(frame,s);
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
	}
}
