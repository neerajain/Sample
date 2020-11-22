import java.sql.*;
import java.util.Scanner;

public class Assg3 {
	int addPatient() {
		int i = 0;
		Patient p = new Patient();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter patients name ");
		p.setName(sc.nextLine());
		System.out.println("Please enter the patients password ");
		p.setPassword(sc.nextLine());
		System.out.println("Please enter patients medical history ");
		p.setPrevious(sc.nextLine());
		System.out.println("Please enter patients age ");
		p.setAge(sc.nextInt());
		System.out.println("Please enter patients gender ");
		p.setGender(sc.next());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("insert into Patient(password,name,age,gender,previous_history)values(?,?,?,?,?)");
			stmt.setString(1, p.getPassword());
			stmt.setString(2, p.getName());
			stmt.setInt(3,p.getAge());
			stmt.setString(4, p.getGender());
			stmt.setString(5, p.getPrevious_history());
			stmt.executeUpdate();
			PreparedStatement st=con.prepareStatement("select id from Patient where name=? and password=?");
			st.setString(1, p.getName());
			st.setString(2, p.getPassword());
			ResultSet rs = st.executeQuery();
			rs.next();
			i = rs.getInt(1);
			System.out.println("Patient created successfully with PatientID "+i);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}
	int checkPatient() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the patients id ");
		int i = sc.nextInt();
		System.out.println("Please enter password ");
		String s = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select password from Patient where id=?");
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			if(rs.getString(1).equals(s)) {
				return i;
			}
			else
				return 0;
		}
		catch(Exception e) {
			System.out.println("Wrong PatientID");
			return -1;
		}
	}
	void updatePatient(int id) {
		int age;
		String pass,prev;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select * from Patient where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt(1) == id) {
				System.out.println("Please enter the patients password ");
				pass = sc.nextLine();
				System.out.println("Please enter new patients age ");
				age=sc.nextInt();
				PreparedStatement stm = con.prepareStatement("update patient set age=?,password=? where id=?");
				stm.setInt(1, age);
				stm.setString(2, pass);
				stm.setInt(3, id);
				stm.executeUpdate();
			}
			else {
				System.out.println("Patient ID does not exists ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void showPatient() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Patient");
			while(rs.next()) {
				System.out.println("Patient Id - "+rs.getInt(1)+"\nName - "+rs.getString(3)+"\nAge - "+rs.getInt(4)+"\nGender - "+rs.getString(5)+"\nPrevious History - "+rs.getString(6));
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void addDepartment() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Department name");
		s = sc.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select * from Department where name=?");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()==false) {
				PreparedStatement stm=con.prepareStatement("insert into Department values(?)");
				stm.setString(1, s);
				stm.executeUpdate();
				System.out.println("Department added ");
			}
			else {
				System.out.println("Department already exists ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void showDepartment() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from Department order by name");
			System.out.println("List of Departments are-");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void addMedicine() {
		Medicine m = new Medicine("",0,0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Medicine/Test name");
		m.setName(sc.nextLine());
		System.out.println("Please Enter the cost of above medicine/test");
		m.setCost(sc.nextInt());
		System.out.println("Please Enter the quantity available ");
		m.setQuantity(sc.nextInt());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
			stmt.setString(1, m.getName());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()==false) {
				PreparedStatement stm=con.prepareStatement("insert into MedicineTest values(?,?,?)");
				stm.setString(1, m.getName());
				stm.setInt(2, m.getCost());
				stm.setInt(3, m.getQuantity());
				stm.executeUpdate();
				System.out.println("Medicine/Test added ");
			}
			else {
				System.out.println("Medicine/Test already exists ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void searchMedicine() {
		try {
			String s;
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the Medicine/Test name");
			s = sc.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\nCost-"+rs.getInt(2)+"\nQuantity-"+rs.getInt(3));
				return;
			}
			System.out.println("Medicine not found");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void deleteMedicine() {
		try {
			String s;
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the Medicine/Test name");
			s = sc.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			while(rs.next() == true) {
				PreparedStatement st=con.prepareStatement("delete from MedicineTest where name=?");
				st.setString(1, s);
				st.executeUpdate();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void updateMedicine() {
		Medicine m = new Medicine("",0,0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Medicine/Test name to be ");
		m.setName(sc.nextLine());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select * from MedicineTest where name=?");
			stmt.setString(1, m.getName());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()==false) {
				System.out.println("Medicine not found");
			}
			else {
				System.out.println("Please Enter the cost of above medicine/test");
				m.setCost(sc.nextInt());
				System.out.println("Please Enter the quantity available ");
				m.setQuantity(sc.nextInt());
				PreparedStatement smt=con.prepareStatement("update MedicineTest set cost=?,quantity=? where name=?");
				smt.setString(3, m.getName());
				smt.setInt(1, m.getCost());
				smt.setInt(2, m.getQuantity());
				smt.executeUpdate();
				System.out.println("Medicine succesfully updated ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void addDoctor(){
		Scanner sc = new Scanner(System.in);
		Doctor d1 = new Doctor(" "," "," ",0,0,"");
		System.out.println("Please enter Doctors registration no.");
		d1.setRegistration(sc.nextLine());
		System.out.println("Please enter doctors name ");
		d1.setName(sc.nextLine());
		System.out.println("Please enter departments name in which doctor is working ");
		d1.setSpecialization(sc.nextLine());
		System.out.println("Please enter year of experience ");
		d1.setYoe(sc.nextInt());
		System.out.println("Please enter doctors visiting time in the format of hh:mm:ss ");
		d1.setTime(sc.next());
		System.out.println("Please enter doctors fees ");
		d1.setFees(sc.nextInt());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select * from Doctor where registration=?");
			stmt.setString(1, d1.getRegistration());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()==false) {
				PreparedStatement stm=con.prepareStatement("insert into Doctor values(?,?,?,?,?,?)");
				stm.setString(1, d1.getRegistration());
				stm.setString(2, d1.getName());
				stm.setInt(3, d1.getFees());
				stm.setInt(4,d1.getYoe());
				stm.setString(5, d1.getSpecialization());
				stm.setString(6,d1.getTime());
				stm.executeUpdate();
				System.out.println("Doctor added ");
			}
			else {
				System.out.println("Doctor already exists ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void showDoctor() {
		try {
			Scanner sc = new Scanner(System.in);
			String s;
			System.out.println("Enter the name of the Department");
			s = sc.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stm=con.prepareStatement("select * from Doctor where specialization=?");
			stm.setString(1, s);
			ResultSet rs = stm.executeQuery();
			System.out.println("List of Doctors in "+s+" department are-");
			while(rs.next()) {
				System.out.println("Registration - "+rs.getString(1)+"\nName - "+rs.getString(2)+"\nFees - "+rs.getInt(3)+"\nYears of Experience - "+rs.getInt(4)+"\nVisiting Time - "+rs.getString(6));;
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void deleteDoctor() {
		try {
			Scanner sc = new Scanner(System.in);
			String s;
			System.out.println("Enter the registration ID of doctor");
			s = sc.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stm=con.prepareStatement("select * from Doctor where registration=?");
			stm.setString(1, s);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				PreparedStatement st=con.prepareStatement("delete from Doctor where registration=?");
				st.setString(1, s);
				st.executeUpdate();
				System.out.println("Doctor Deleted ");
				return;
			}
			System.out.println("Doctor Not Found ");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void bookAppointment(int id) {
		showDoctor();
		String doc,tim,dat;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Doctors registration no.");
		doc = sc.next();
		System.out.println("Please enter your appointment date in format yyyy-mm-dd");
		dat = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stmt=con.prepareStatement("select visit_time from Doctor where registration=?");
			stmt.setString(1, doc);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String dct = rs.getString(1);
			System.out.println("Doctor is available from "+dct+" for two hours ");
			System.out.println("Please enter your visiting time in format hh:mm:ss ");
			tim = sc.next();
			PreparedStatement stm=con.prepareStatement("select registration from appointment where registration=? and doa=? and vtime=?");
			stm.setString(1, doc);
			stm.setString(2, dat);
			stm.setString(3,tim);
			ResultSet r = stm.executeQuery();
			if(r.next()) {
				System.out.println("Appointment already booked for this time ");
			}
			else {
				PreparedStatement st=con.prepareStatement("insert into appointment values(?,?,?,?)");
				st.setString(1, doc);
				st.setInt(2, id);
				st.setString(3, tim);
				st.setString(4, dat);
				st.executeUpdate();
				System.out.println("Appointment booked ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void showAppointment() {
		String doc,dat;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Doctors registration no.");
		doc = sc.next();
		System.out.println("Please enter the date you want to view  in format yyyy-mm-dd");
		dat = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stm=con.prepareStatement("select * from appointment where registration=? and doa=? order by vtime");
			stm.setString(1, doc);
			stm.setString(2, dat);
			ResultSet r = stm.executeQuery();
			if(r.next()==false){
				System.out.println("No appoitments are booked on this particular date");
				return;
			}
			System.out.println("Appointments of doctor with registration ID "+doc +" on "+dat+" are-" );
			System.out.println("---------------------------------");
			System.out.println("Patient Id - "+r.getInt(2)+" Time - "+r.getString(3));
			while(r.next()) {
				System.out.println("Patient Id - "+r.getInt(2)+" Time - "+r.getString(3));
			}
			System.out.println("---------------------------------");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void cancelAppointment(int id) {
		String doc,dat;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Doctors registration no.");
		doc = sc.next();
		System.out.println("Please enter your appointment date in format yyyy-mm-dd");
		dat = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","okokokok"); 
			PreparedStatement stm=con.prepareStatement("select id from appointment where registration=? and doa=? and id=?");
			stm.setString(1, doc);
			stm.setString(2, dat);
			stm.setInt(3, id);
			ResultSet r = stm.executeQuery();
			if(r.next()) {
				PreparedStatement st=con.prepareStatement("delete from appointment where registration=? and doa=? and id=?");
				st.setString(1, doc);
				st.setString(2, dat);
				st.setInt(3,id);
				st.executeUpdate();
				System.out.println("Appointment cancelled successfully ");
			}
			else {
				System.out.println("Appointment not booked at this time ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
