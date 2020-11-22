import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminWindow implements ActionListener{
	JFrame frame;
	JLabel titleLabel;
	JButton addDe,showDe,addMe,searchMe,deleteMe,updateMe,addDo,showDo,deleteDo,back,chat;
	public AdminWindow() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setTitle("Hospital Appointment Booking System");
		titleLabel = new JLabel("Admin Menu");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setBounds(350,90, 900,60);

		
		addDe = new JButton("Add Department");
		addDe.setBounds(150, 200, 150, 75);
		addDe.setBackground(Color.WHITE);
		addDe.setForeground(Color.RED);
		addDe.addActionListener(this);
		showDe = new JButton("Show Department");
		showDe.setBounds(400, 200, 150, 75);
		showDe.setBackground(Color.WHITE);
		showDe.setForeground(Color.RED);
		showDe.addActionListener(this);
		addMe = new JButton("Add Medicine");
		addMe.setBounds(650, 200, 150, 75);
		addMe.setBackground(Color.WHITE);
		addMe.setForeground(Color.RED);
		addMe.addActionListener(this);
		searchMe = new JButton("Search Medicine");
		searchMe.setBounds(150, 300, 150, 75);
		searchMe.setBackground(Color.WHITE);
		searchMe.setForeground(Color.RED);
		searchMe.addActionListener(this);
		updateMe = new JButton("Update Medicine");
		updateMe.setBounds(400, 300, 150, 75);
		updateMe.setBackground(Color.WHITE);
		updateMe.setForeground(Color.RED);
		updateMe.addActionListener(this);
		deleteMe = new JButton("Delete Medicine");
		deleteMe.setBounds(650, 300, 150, 75);
		deleteMe.setBackground(Color.WHITE);
		deleteMe.setForeground(Color.RED);
		deleteMe.addActionListener(this);
		addDo = new JButton("Add Doctor");
		addDo.setBounds(150, 400, 150, 75);
		addDo.setBackground(Color.WHITE);
		addDo.setForeground(Color.RED);
		addDo.addActionListener(this);
		showDo = new JButton("Show Doctor");
		showDo.setBounds(400, 400, 150, 75);
		showDo.setBackground(Color.WHITE);
		showDo.setForeground(Color.RED);
		showDo.addActionListener(this);
		deleteDo = new JButton("Delete Doctor");
		deleteDo.setBounds(650, 400, 150, 75);
		deleteDo.setBackground(Color.WHITE);
		deleteDo.setForeground(Color.RED);
		deleteDo.addActionListener(this);
		back = new JButton("Log Out");
		back.setBounds(650, 500, 150, 75);
		back.setBackground(Color.WHITE);
		back.setForeground(Color.RED);
		back.addActionListener(this);
		chat = new JButton("Chat");
		chat.setBounds(150, 500, 150, 75);
		chat.setBackground(Color.WHITE);
		chat.setForeground(Color.RED);
		chat.addActionListener(this);
		
		frame.add(titleLabel);
		frame.add(addDe);
		frame.add(addDo);
		frame.add(addMe);
		frame.add(deleteDo);
		frame.add(deleteMe);
		frame.add(searchMe);
		frame.add(showDe);
		frame.add(showDo);
		frame.add(updateMe);
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
		if(e.getSource()==addDe) {
			Department d = new Department(0);
			d.addDepartment();
		}
		else if(e.getSource()==addDo) {
			Doctor ad = new Doctor(0);
			ad.addDoctor();
		}
		else if(e.getSource()==addMe) {
			Medicine m = new Medicine(0);
			m.addMedicine();
		}
		else if(e.getSource()==deleteDo) {
			Doctor ad = new Doctor(0);
			ad.deleteDoctor();
		}
		else if(e.getSource()==deleteMe) {
			Medicine m = new Medicine(0);
			m.deleteMedicine();
		}
		else if(e.getSource()==searchMe) {
			Medicine m = new Medicine(0);
			m.searchMedicine();
		}
		else if(e.getSource()==showDo) {
			Doctor ad = new Doctor(0);
			ad.showDoctor();
		}
		else if(e.getSource()==showDe) {
			Department d = new Department(0);
			d.showDepartment();
		}
		else if(e.getSource()==updateMe) {
			Medicine m = new Medicine(0);
			m.updateMedicine();
		}
		else if(e.getSource()==chat) {
				Server s = new Server();
				try {
					s.go();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else {
			frame.dispose();
			AdminLogin a = new AdminLogin();
		}
	}
}
