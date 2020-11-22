
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserWindow implements ActionListener{
	int id;
	JFrame frame;
	JLabel titleLabel;
	JButton updatePa,showDe,showDo,searchMe,bookAppoi,showAppoi,cancelAppoi,back,chat;
	public UserWindow(int id) {
		this.id = id; 
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		titleLabel = new JLabel("User Menu");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(350,90, 900,60);

		
		updatePa = new JButton("Update Patient");
		updatePa.setBounds(150, 200, 150, 75);
		updatePa.setBackground(Color.WHITE);
		updatePa.setForeground(Color.RED);
		updatePa.addActionListener(this);
		showDe = new JButton("Show Department");
		showDe.setBounds(400, 200, 150, 75);
		showDe.setBackground(Color.WHITE);
		showDe.setForeground(Color.RED);
		showDe.addActionListener(this);
		showDo = new JButton("Show Doctor");
		showDo.setBounds(650, 200, 150, 75);
		showDo.setBackground(Color.WHITE);
		showDo.setForeground(Color.RED);
		showDo.addActionListener(this);
		searchMe = new JButton("Search Medicine");
		searchMe.setBounds(150, 300, 150, 75);
		searchMe.setBackground(Color.WHITE);
		searchMe.setForeground(Color.RED);
		searchMe.addActionListener(this);
		showAppoi = new JButton("Search Appointment");
		showAppoi.setBounds(650, 300, 150, 75);
		showAppoi.setBackground(Color.WHITE);
		showAppoi.setForeground(Color.RED);
		showAppoi.addActionListener(this);
		bookAppoi = new JButton("Book Appointment");
		bookAppoi.setBounds(400, 300, 150, 75);
		bookAppoi.setBackground(Color.WHITE);
		bookAppoi.setForeground(Color.RED);
		bookAppoi.addActionListener(this);
		cancelAppoi = new JButton("Cancel Appointment");
		cancelAppoi.setBounds(150, 400, 150, 75);
		cancelAppoi.setBackground(Color.WHITE);
		cancelAppoi.setForeground(Color.RED);
		cancelAppoi.addActionListener(this);
		back = new JButton("Log Out");
		back.setBounds(650, 400, 150, 75);
		back.setBackground(Color.WHITE);
		back.setForeground(Color.RED);
		back.addActionListener(this);
		chat = new JButton("Chat");
		chat.setBounds(400, 400, 150, 75);
		chat.setBackground(Color.WHITE);
		chat.setForeground(Color.RED);
		chat.addActionListener(this);
		
		frame.add(titleLabel);
		frame.add(updatePa);
		frame.add(cancelAppoi);
		frame.add(showDo);
		frame.add(bookAppoi);
		frame.add(searchMe);
		frame.add(showDe);
		frame.add(showDo);
		frame.add(showAppoi);
		frame.add(back);
		frame.add(chat);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==updatePa) {
			Patient p = new Patient(id);
		}
		else if(e.getSource()==cancelAppoi) {
			Appointment ap = new Appointment(id);
			ap.cancelAppointment();
		}
		else if(e.getSource()==showDo) {
			Doctor ad = new Doctor(id);
			ad.showDoctor();
		}
		else if(e.getSource()==bookAppoi) {
			Appointment ap = new Appointment(id);
			ap.bookAppointment();
		}
		else if(e.getSource()==searchMe) {
			Medicine m = new Medicine(id);
			m.searchMedicine();
		}
		else if(e.getSource()==showDe) {
			Department d = new Department(id);
			d.showDepartment();
		}
		else if(e.getSource()==showAppoi) {
			Appointment ap = new Appointment(id);
			ap.showAppointment();
		}
		else if(e.getSource()==back){
			frame.dispose();
			UserLogin a = new UserLogin();
		}
		else if(e.getSource()==chat){
				Client c = new Client();
				try {
					c.go(String.valueOf(id));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
}


