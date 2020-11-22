import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Patient implements ActionListener{
	int id;
	JFrame frame;
	JLabel titleLabel;
	JButton update;
	JLabel nameLabel,passwordLabel;
	JTextField nameTxt;
	JPasswordField passwordTxt;
	public Patient(int i) {
		id = i;
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Update Password");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(400, 100, 600, sizeTitle.height);

		nameLabel = new JLabel("Name: ");		
		nameLabel.setForeground(Color.RED);
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setBounds(325, 185, 250, 50);
		passwordLabel = new JLabel("New Password: ");
		passwordLabel.setFont(passwordLabel.getFont().deriveFont(15.0f));
		passwordLabel.setForeground(Color.RED);
		passwordLabel.setBounds(325, 245, 250, 50);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 195, 200, 30);
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(475, 255, 200, 30);
		
		update = new JButton("Update Password");
		update.setBounds(415, 575, 150, 75);
		update.setForeground(Color.RED);
		update.setBackground(Color.WHITE);
		update.addActionListener(this);
	
		frame.add(titleLabel);
		frame.add(nameLabel);
		frame.add(passwordLabel);
		frame.add(nameTxt);
		frame.add(passwordTxt);
		frame.add(update);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==update)
		{
			String password = String.valueOf(passwordTxt.getPassword()); 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select * from Patient where id=?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				if(rs.getInt(1) == id) {
					PreparedStatement stm = con.prepareStatement("update patient set password=? where id=?");
					stm.setString(1, password);
					stm.setInt(2, id);
					stm.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Patient Updated Successfully");
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
	}
}
