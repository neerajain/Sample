import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Appointment implements ActionListener{
	int id;
	JFrame frame,frame1;
	JLabel titleLabel;
	JButton insert,show,showD,showA,return1,cancel;
	JLabel registrationLabel, dateLabel, timeLabel;
	JTextField  registrationTxt, dateTxt, timeTxt;
	JScrollPane textArea;
	public Appointment(int id) {
		this.id = id;
	}
	void bookAppointment() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
				
		titleLabel = new JLabel("Add Appointment");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(425, 100, 600, sizeTitle.height);
		dateLabel = new JLabel("Date of App(yyyy-mm-dd).: ");		
		dateLabel.setForeground(Color.RED);
		dateLabel.setFont (dateLabel.getFont().deriveFont (15.0f));
		dateLabel.setBounds(275, 245, 250, 50);
		registrationLabel = new JLabel("Doctor's RegId: ");
		registrationLabel.setFont (registrationLabel.getFont().deriveFont (15.0f));
		registrationLabel.setForeground(Color.RED);
		registrationLabel.setBounds(275, 185, 250, 50);        
		timeLabel = new JLabel("Time of App.(hh:mm:ss): ");
		timeLabel.setFont (timeLabel.getFont().deriveFont (15.0f));
		timeLabel.setForeground(Color.RED);
		timeLabel.setBounds(275, 305, 250, 50);
		dateTxt = new JTextField();
		dateTxt.setBounds(475, 255, 200, 30);
		registrationTxt = new JTextField();
		registrationTxt.setBounds(475, 195, 200, 30);
		timeTxt = new JTextField();
		timeTxt.setBounds(475, 315, 200, 30);
		
		insert = new JButton("Add Appointment");
		insert.setBounds(300, 575, 150, 75);
		insert.setForeground(Color.RED);
		insert.setBackground(Color.WHITE);
		insert.addActionListener(this);
		show = new JButton("Show Department");
		show.setBounds(460, 575, 150, 75);
		show.setForeground(Color.RED);
		show.setBackground(Color.WHITE);
		show.addActionListener(this);
		showD = new JButton("Show Doctor");
		showD.setBounds(620, 575, 150, 75);
		showD.setForeground(Color.RED);
		showD.setBackground(Color.WHITE);
		showD.addActionListener(this);
		frame.add(titleLabel);
		frame.add(dateLabel);
		frame.add(registrationLabel);
		frame.add(timeLabel);
		frame.add(registrationTxt);
		frame.add(timeTxt);
		frame.add(show);
		frame.add(showD);
		frame.add(dateTxt);
		frame.add(insert);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void showAppointment() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
				
		titleLabel = new JLabel("Show Appointment");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(425, 100, 600, sizeTitle.height);
		dateLabel = new JLabel("Date of App(yyyy-mm-dd).: ");		
		dateLabel.setForeground(Color.RED);
		dateLabel.setFont (dateLabel.getFont().deriveFont (15.0f));
		dateLabel.setBounds(275, 245, 250, 50);
		registrationLabel = new JLabel("Doctor's RegId: ");
		registrationLabel.setFont (registrationLabel.getFont().deriveFont (15.0f));
		registrationLabel.setForeground(Color.RED);
		registrationLabel.setBounds(275, 185, 250, 50);        
		dateTxt = new JTextField();
		dateTxt.setBounds(475, 255, 200, 30);
		registrationTxt = new JTextField();
		registrationTxt.setBounds(475, 195, 200, 30);
		
		showA = new JButton("Show Appointment");
		showA.setBounds(300, 575, 150, 75);
		showA.setForeground(Color.RED);
		showA.setBackground(Color.WHITE);
		showA.addActionListener(this);
		show = new JButton("Show Department");
		show.setBounds(460, 575, 150, 75);
		show.setForeground(Color.RED);
		show.setBackground(Color.WHITE);
		show.addActionListener(this);
		showD = new JButton("Show Doctor");
		showD.setBounds(620, 575, 150, 75);
		showD.setForeground(Color.RED);
		showD.setBackground(Color.WHITE);
		showD.addActionListener(this);
		frame.add(titleLabel);
		frame.add(dateLabel);
		frame.add(registrationLabel);
		frame.add(registrationTxt);
		frame.add(show);
		frame.add(showD);
		frame.add(dateTxt);
		frame.add(showA);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void showA(String s) {
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
		titleLabel = new JLabel("Appointment Details are ");
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
	void cancelAppointment() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
				
		titleLabel = new JLabel("Cancel Appointment");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.RED);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(325, 100, 600, sizeTitle.height);
		dateLabel = new JLabel("Date of App(yyyy-mm-dd).: ");		
		dateLabel.setForeground(Color.RED);
		dateLabel.setFont (dateLabel.getFont().deriveFont (15.0f));
		dateLabel.setBounds(275, 245, 250, 50);
		registrationLabel = new JLabel("Doctor's RegId: ");
		registrationLabel.setFont (registrationLabel.getFont().deriveFont (15.0f));
		registrationLabel.setForeground(Color.RED);
		registrationLabel.setBounds(275, 185, 250, 50);        
		dateTxt = new JTextField();
		dateTxt.setBounds(475, 255, 200, 30);
		registrationTxt = new JTextField();
		registrationTxt.setBounds(475, 195, 200, 30);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(415, 575, 150, 75);
		cancel.setForeground(Color.RED);
		cancel.setBackground(Color.WHITE);
		cancel.addActionListener(this);
		frame.add(titleLabel);
		frame.add(dateLabel);
		frame.add(registrationLabel);
		frame.add(registrationTxt);
		frame.add(dateTxt);
		frame.add(cancel);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==show) {
			Department d = new Department(id);
			d.showDepartment();
		}
		else if (e.getSource()==showD) {
			Doctor d = new Doctor(id);
			d.showDoctor();
		}
		else if(e.getSource()==insert) {
			String registration = registrationTxt.getText();
			String date= dateTxt.getText();
			String time= timeTxt.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stm=con.prepareStatement("select registration from appointment where registration=? and doa=? and vtime=?");
				stm.setString(1, registration);
				stm.setString(2, date);
				stm.setString(3,time);
				ResultSet r = stm.executeQuery();
				if(r.next()) {
					JOptionPane.showMessageDialog(frame,"Appointment alreay booked at this time");
				}
				else {
					PreparedStatement st=con.prepareStatement("insert into appointment values(?,?,?,?)");
					st.setString(1, registration);
					st.setInt(2, id);
					st.setString(3, time);
					st.setString(4, date);
					st.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Appointment booked ");
				}
			}
			catch(Exception f) {
				System.out.println(f);
			}
			frame.dispose();
		}
		else if(e.getSource()==showA) {
			String registration = registrationTxt.getText();
			String date= dateTxt.getText();
			String s="";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stm=con.prepareStatement("select * from appointment where registration=? and doa=? order by vtime");
				stm.setString(1, registration);
				stm.setString(2, date);
				ResultSet r = stm.executeQuery();
				if(r.next()==false){
					JOptionPane.showMessageDialog(frame,"No appoitments are booked on this particular date");
					frame.dispose();
				}
				s=s+"Appointments of doctor with \nRegistration ID "+registration +" on "+date+" are-\n";
				s = s + "Patient Id - "+r.getInt(2)+"	Time - "+r.getString(3)+"\n";
				while(r.next()) {
					s = s + "Patient Id - "+r.getInt(2)+"	Time - "+r.getString(3)+"\n";
				}
				showA(s);
			}
			catch(Exception f) {
				System.out.println(f);
			}
		}
		else if(e.getSource()==return1)
		{
			frame1.dispose();
			frame.dispose();
			
		}
		else if(e.getSource()==cancel) {
			String registration = registrationTxt.getText();
			String date= dateTxt.getText();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
				PreparedStatement stm=con.prepareStatement("select id from appointment where registration=? and doa=? and id=?");
				stm.setString(1, registration);
				stm.setString(2, date);
				stm.setInt(3, id);
				ResultSet r = stm.executeQuery();
				if(r.next()) {
					PreparedStatement st=con.prepareStatement("delete from appointment where registration=? and doa=? and id=?");
					st.setString(1, registration);
					st.setString(2, date);
					st.setInt(3,id);
					st.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Appointment cancelled successfully ");
				}
				else {
					JOptionPane.showMessageDialog(frame,"Appointment not booked at this time ");
				}
			}
			catch(Exception f) {
				System.out.println(e);
			}
			frame.dispose();
		}
	}
}
