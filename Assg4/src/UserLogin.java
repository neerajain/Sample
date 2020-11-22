import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLogin implements ActionListener{
	JFrame frame;
	JLabel titleLabel;
	JLabel userL, passL;
	JTextField userT;
	JPasswordField passT;
	JButton submit, back;
	public UserLogin() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("User's Login Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(270,150, 900,60);

		userL = new JLabel("Username: ");
		userL.setFont(userL.getFont().deriveFont(20.0f));
		userL.setForeground(Color.RED);
		userL.setBounds(450, 260, 200, 40);
		userT = new JTextField();
		userT.setBounds(375, 300, 250, 35);
		
		passL = new JLabel("Password: ");
		passL.setFont(passL.getFont().deriveFont(20.0f));
		passL.setForeground(Color.RED);
		passL.setBounds(450, 360, 200, 40);
		passT = new JPasswordField();
		passT.setBounds(375, 400, 250, 35);
		
		submit = new JButton("Submit");
		submit.setBounds(325, 490, 150, 75);
		submit.setBackground(Color.WHITE);
		submit.setForeground(Color.RED);
		submit.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(550, 490, 150, 75);
		back.setBackground(Color.WHITE);
		back.setForeground(Color.RED);
		back.addActionListener(this);
		
		frame.add(userL);
		frame.add(passL);
		frame.add(titleLabel);
		frame.add(passT);
		frame.add(userT);
		frame.add(submit);
		frame.add(back);
		
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back){
			frame.dispose();
			User a = new User();
		}
		else if(e.getSource()==submit){
			int username = Integer.parseInt(userT.getText());
			String password = String.copyValueOf(passT.getPassword());
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select password from Patient where id=?");
				stmt.setInt(1, username);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				if(rs.getString(1).equals(password)) {
					JOptionPane.showMessageDialog(frame, "Login Successfull");
					UserWindow u = new UserWindow(username);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Wrong Password");
					userT.setText("");
					passT.setText("");
				}
			}
			catch(Exception f) {
				JOptionPane.showMessageDialog(frame, "Wrong Username");
				userT.setText("");
				passT.setText("");
			}
				
		}
	}
}
