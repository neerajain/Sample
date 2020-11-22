import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Assg4 implements ActionListener{
	JFrame frame;
	JButton admin, user, exit;
	JLabel titleLabel;
	public Assg4() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Hospital Appointment Booking System");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(70,50,900,60);
		
		admin = new JButton("Admin");
		admin.setBounds(400, 200, 150, 75);
		admin.setBackground(Color.WHITE);
		admin.setForeground(Color.RED);
		admin.addActionListener(this);
		
		user = new JButton("User");
		user.setBounds(400, 350, 150, 75);
		user.setBackground(Color.WHITE);
		user.setForeground(Color.RED);
		user.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.setBounds(400, 500, 150, 75);
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.RED);
		exit.addActionListener(this);
		
		frame.add(admin);
		frame.add(exit);
		frame.add(user);
		frame.add(titleLabel);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==admin){
			frame.dispose();
			AdminLogin a = new AdminLogin();
			//a.loginMenu();
		}
		else if(e.getSource()==user){
			frame.dispose();
			User u = new User();
		}
		else if(e.getSource()==exit){
			frame.dispose();
		}
		
	}
}
