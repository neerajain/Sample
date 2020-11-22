import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class User implements ActionListener{
	JFrame frame;
	JButton login, signup, back;
	JLabel titleLabel;
	public User() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
	
		titleLabel = new JLabel("User's Window");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(310, 100, 320, 58);
		
		login = new JButton("Log-in");
		login.setBounds(400, 200, 150, 75);
		login.setForeground(Color.RED);
		login.setBackground(Color.WHITE);
		login.addActionListener(this);
		
		signup = new JButton("Sign-up");
		signup.setBounds(400, 350, 150, 75);
		signup.setForeground(Color.RED);
		signup.setBackground(Color.WHITE);
		signup.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(400, 500, 150, 75);
		back.setForeground(Color.RED);
		back.setBackground(Color.WHITE);
		back.addActionListener(this);

		frame.add(login);
		frame.add(back);
		frame.add(signup);
		frame.add(titleLabel);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login){
		frame.dispose();
		  UserLogin u = new UserLogin();
		}
		else if(e.getSource()==signup){
			frame.dispose();
			UserSignup s = new UserSignup();
			
		}
		else if(e.getSource()==back){
			frame.dispose();
			Assg4 a = new Assg4(); 
		}
	}
}
