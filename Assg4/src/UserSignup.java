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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserSignup implements ActionListener{
	JFrame frame;
	JLabel titleLabel;
	JButton backBtn, insert;
	JComboBox genderC;
	JLabel nameLabel, ageLabel, genderLabel, previoushistoryLabel, passwordLabel;
	JTextField fnameTxt, nameTxt, ageTxt, genderTxt, previoushistoryTxt;
	JPasswordField passwordTxt;
	public UserSignup()
	{
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		
		titleLabel = new JLabel("Sign-Up");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(425, 100, 600, sizeTitle.height);

		nameLabel = new JLabel("Name: ");		
		nameLabel.setForeground(Color.RED);
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setBounds(325, 185, 250, 50);
		ageLabel = new JLabel("Age: ");
		ageLabel.setFont (ageLabel.getFont().deriveFont (15.0f));
		ageLabel.setForeground(Color.RED);
		ageLabel.setBounds(325, 245, 250, 50);
		genderLabel = new JLabel("Gender(M/F): ");
		genderLabel.setFont (genderLabel.getFont().deriveFont (15.0f));
		genderLabel.setForeground(Color.RED);
		genderLabel.setBounds(325, 305, 250, 50);        
		previoushistoryLabel = new JLabel("History: ");
		previoushistoryLabel.setFont (previoushistoryLabel.getFont().deriveFont (15.0f));
		previoushistoryLabel.setForeground(Color.RED);
		previoushistoryLabel.setBounds(325, 365, 250, 50);
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setFont(passwordLabel.getFont().deriveFont(15.0f));
		passwordLabel.setForeground(Color.RED);
		passwordLabel.setBounds(325, 425, 250, 50);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 195, 200, 30);
		ageTxt = new JTextField();
		ageTxt.setBounds(475, 255, 200, 30);
		String gender[]={"M","F","O"};
		genderC=new JComboBox(gender);
		genderC.setBounds(475, 315, 200, 30);
		previoushistoryTxt = new JTextField();
		previoushistoryTxt.setBounds(475, 375, 200, 30);
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(475, 435, 200, 30);
		
		insert = new JButton("Create User");
		insert.setBounds(415, 575, 150, 75);
		insert.setForeground(Color.RED);
		insert.setBackground(Color.WHITE);
		insert.addActionListener(this);
	
		frame.add(titleLabel);
		frame.add(ageLabel);
		frame.add(nameLabel);
		frame.add(genderLabel);
		frame.add(previoushistoryLabel);
		frame.add(passwordLabel);
		frame.add(nameTxt);
		frame.add(ageTxt);
		frame.add(previoushistoryTxt);
		frame.add(passwordTxt);
		frame.add(genderC);
		frame.add(insert);
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
			int age = Integer.valueOf(ageTxt.getText());
			String gender = (String) genderC.getSelectedItem(); 
			String prev = previoushistoryTxt.getText();
			String password = String.valueOf(passwordTxt.getPassword()); 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("insert into Patient(password,name,age,gender,previous_history)values(?,?,?,?,?)");
				stmt.setString(1, password);
				stmt.setString(2, name);
				stmt.setInt(3,age);
				stmt.setString(4, gender);
				stmt.setString(5,prev);
				stmt.executeUpdate();
				PreparedStatement st=con.prepareStatement("select id from Patient where name=? and password=?");
				st.setString(1, name);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();
				rs.next();
				int i = rs.getInt(1);
				String s = "Account Created with id " + String.valueOf(i);
				JOptionPane.showMessageDialog(frame,s);
				con.close();
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
			User u = new User();
		}
	}
}
