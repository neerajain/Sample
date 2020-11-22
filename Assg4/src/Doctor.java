import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Doctor implements ActionListener {
	int id;
	JFrame frame,frame1;
	JLabel titleLabel;
	JButton delete, insert ,show,back,return1;
	JLabel nameLabel,specializationLabel, registrationLabel, yoeLabel, timeLabel,feesLabel;
	JTextField specializationTxt, nameTxt, registrationTxt, yoeTxt, timeTxt,feesTxt;
	JScrollPane textArea;
	public Doctor(int id) {
		this.id = id;
	}
	void addDoctor(){
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
				
		titleLabel = new JLabel("Add Doctor");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(425, 100, 600, sizeTitle.height);

		registrationLabel = new JLabel("Registration: ");		
		registrationLabel.setForeground(Color.RED);
		registrationLabel.setFont (registrationLabel.getFont().deriveFont (15.0f));
		registrationLabel.setBounds(325, 185, 250, 50);
		nameLabel = new JLabel("Name: ");
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setForeground(Color.RED);
		nameLabel.setBounds(325, 245, 250, 50);
		specializationLabel = new JLabel("Specialization: ");
		specializationLabel.setFont (specializationLabel.getFont().deriveFont (15.0f));
		specializationLabel.setForeground(Color.RED);
		specializationLabel.setBounds(325, 305, 250, 50);        
		yoeLabel = new JLabel("Years of Exp.: ");
		yoeLabel.setFont (yoeLabel.getFont().deriveFont (15.0f));
		yoeLabel.setForeground(Color.RED);
		yoeLabel.setBounds(325, 365, 250, 50);
		feesLabel = new JLabel("Fees: ");
		feesLabel.setFont(feesLabel.getFont().deriveFont(15.0f));
		feesLabel.setForeground(Color.RED);
		feesLabel.setBounds(325, 425, 250, 50);
		timeLabel = new JLabel("Time(hh:mm:ss): ");
		timeLabel.setFont(timeLabel.getFont().deriveFont(15.0f));
		timeLabel.setForeground(Color.RED);
		timeLabel.setBounds(325, 485, 250, 50);
				
		registrationTxt = new JTextField();
		registrationTxt.setBounds(475, 195, 200, 30);
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 255, 200, 30);
		specializationTxt = new JTextField();
		specializationTxt.setBounds(475, 315, 200, 30);
		yoeTxt = new JTextField();
		yoeTxt.setBounds(475, 375, 200, 30);
		feesTxt = new JTextField();
		feesTxt.setBounds(475, 435, 200, 30);
		timeTxt = new JTextField();
		timeTxt.setBounds(475, 495, 200, 30);
				
		insert = new JButton("Create Doctor");
		insert.setBounds(415, 575, 150, 75);
		insert.setForeground(Color.RED);
		insert.setBackground(Color.WHITE);
		insert.addActionListener(this);
			
		frame.add(titleLabel);
		frame.add(nameLabel);
		frame.add(registrationLabel);
		frame.add(specializationLabel);
		frame.add(yoeLabel);
		frame.add(feesLabel);
		frame.add(timeLabel);
		frame.add(nameTxt);
		frame.add(specializationTxt);
		frame.add(feesTxt);
		frame.add(yoeTxt);
		frame.add(timeTxt);
		frame.add(registrationTxt);
		frame.add(insert);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void deleteDoctor() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
				
		titleLabel = new JLabel("Delete Doctor");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(425, 100, 600, sizeTitle.height);

		registrationLabel = new JLabel("Registration No.: ");		
		registrationLabel.setForeground(Color.RED);
		registrationLabel.setFont (registrationLabel.getFont().deriveFont (15.0f));
		registrationLabel.setBounds(325, 185, 250, 50);
		registrationTxt = new JTextField();
		registrationTxt.setBounds(475, 195, 200, 30);
				
		delete = new JButton("Delete Doctor");
		delete.setBounds(415, 575, 150, 75);
		delete.setForeground(Color.RED);
		delete.setBackground(Color.WHITE);
		delete.addActionListener(this);
		
		frame.add(titleLabel);
		frame.add(registrationLabel);
		frame.add(registrationTxt);
		frame.add(delete);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void showDoctor() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
				
		titleLabel = new JLabel("Show Doctor");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(425, 100, 600, sizeTitle.height);

		registrationLabel = new JLabel("Department: ");		
		registrationLabel.setForeground(Color.RED);
		registrationLabel.setFont (registrationLabel.getFont().deriveFont (15.0f));
		registrationLabel.setBounds(325, 185, 250, 50);
		registrationTxt = new JTextField();
		registrationTxt.setBounds(475, 195, 200, 30);
				
		show = new JButton("Show all Doctor");
		show.setBounds(415, 575, 150, 75);
		show.setForeground(Color.RED);
		show.setBackground(Color.WHITE);
		show.addActionListener(this);
		
		frame.add(titleLabel);
		frame.add(registrationLabel);
		frame.add(registrationTxt);
		frame.add(show);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	void show(String s,String department) {
		frame1= new JFrame("Hospital Appointment Booking System");    
	    JPanel panel=new JPanel(new FlowLayout());  
	    panel.setBounds(160,110,700,450);    
	    JTextArea ress=new JTextArea(21,30);  
	 	textArea = new JScrollPane(ress);  
	    ress.setText(s);
	    ress.setFont(ress.getFont ().deriveFont (15.0f));
	    ress.setEditable(false);
	    panel.setBackground(Color.CYAN);
		panel.add(new JScrollPane(ress,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		titleLabel = new JLabel("Doctor details of "+department+" are");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(220,50,900,60); 
	 	return1 = new JButton("Back");
		return1.setBounds(415, 575, 150, 75);
		return1.setForeground(Color.RED);
		return1.setBackground(Color.WHITE);
		return1.addActionListener(this);
		frame1.getContentPane().setBackground(Color.CYAN);
	    frame1.add(panel);  
	    frame1.add(titleLabel);
	    frame1.add(return1);
	    frame1.setSize(1000,700);    
	    frame1.setLayout(null);    
	    frame1.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==insert)
		{
			String name = nameTxt.getText();
			int fees = Integer.valueOf(feesTxt.getText());
			int yoe = Integer.valueOf(yoeTxt.getText());
			String registration = registrationTxt.getText();
			String specialization= specializationTxt.getText();
			String time= timeTxt.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stmt=con.prepareStatement("select * from Doctor where registration=?");
				stmt.setString(1, registration);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()==false) {
					PreparedStatement stm=con.prepareStatement("insert into Doctor values(?,?,?,?,?,?)");
					stm.setString(1, registration);
					stm.setString(2, name);
					stm.setInt(3, fees);
					stm.setInt(4,yoe);
					stm.setString(5, specialization);
					stm.setString(6,time);
					stm.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Doctor Added Successfully");
				}
				else {
					JOptionPane.showMessageDialog(frame,"Doctor already exists ");
				}
			}
			catch(Exception f) {
					System.out.println(e);
				}
			frame.dispose();
		}
		else if(e.getSource()==delete)
		{
			String registration = registrationTxt.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stm=con.prepareStatement("select * from Doctor where registration=?");
				stm.setString(1, registration);
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					PreparedStatement st=con.prepareStatement("delete from Doctor where registration=?");
					st.setString(1, registration);
					st.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Doctor deleted Successfully");
				}
				else {
					JOptionPane.showMessageDialog(frame,"Doctor Not Found ");
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
		else if(e.getSource()==show)
		{
			int i = 0;
			String s="";
			String department = registrationTxt.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stm=con.prepareStatement("select * from Doctor where specialization=?");
				stm.setString(1, department);
				ResultSet rs = stm.executeQuery();
				s="List of Doctors in "+department+" department are-\n";
				while(rs.next()) {
					i=1;
					s= s + "Registration - "+rs.getString(1)+"\nName - "+rs.getString(2)+"\nFees - "+rs.getInt(3)+"\nYears of Experience - "+rs.getInt(4)+"\nVisiting Time - "+rs.getString(6)+"\n";;
					s= s + "\n";
				}
				if(i!=1) {
					JOptionPane.showMessageDialog(frame,"Doctor Not Found ");
					frame.dispose();
				}
				else {
				show(s,department);
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
		}
		else if(e.getSource()==back)
		{
			frame.dispose();
			
		}
		else if(e.getSource()==return1)
		{
			frame1.dispose();
			frame.dispose();
			
		}
	}
}


