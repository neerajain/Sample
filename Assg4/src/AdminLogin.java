
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin implements ActionListener{
	JFrame frame;
	JLabel titleLabel;
	JLabel userL, passL;
	JTextField userT;
	JPasswordField passT;
	JButton submit, back;
	String uname = "Admin";
	String pass = "hospital";
	public AdminLogin() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Admin's Login Page");
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
			Assg4 a = new Assg4();
		}
		else {
			String username = userT.getText();
			String password = String.copyValueOf(passT.getPassword());
				if(username.equals(uname)==true){
					if(password.equals(pass)){
						JOptionPane.showMessageDialog(frame, "Log-in Successful");
						frame.dispose();
						AdminWindow mw = new AdminWindow();
					}
					else{
						JOptionPane.showMessageDialog(frame, "Wrong Password");
						userT.setText("");
						passT.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Wrong Username");
					userT.setText("");
					passT.setText("");
				}
			}
		}
	
}
