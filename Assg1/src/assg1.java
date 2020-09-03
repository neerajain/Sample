import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class assg1 {
	 ArrayList<Department> dp;
	 HashMap<String,Medicine> mt;
	 HashMap<Integer,Patient> pt;
	public assg1() {
		dp = new ArrayList<Department>();
		mt = new HashMap<String,Medicine>();
		pt = new HashMap<Integer,Patient>();
		
	}
	
	void addDepartment() {
		Department d1 = new Department(" ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Department name");
		d1.setName(sc.nextLine());
		if(dp.contains(d1)) {
			System.out.println("Department Already Exists ");
		}
		else {
			dp.add(d1);
		}
	}
	void showDepartment() {
		for(Department d1 :dp){
			System.out.println(d1.getName());
		}
	}
	void addMedicine() {
		String med;
		Medicine m = new Medicine(0,0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Medicine/Test name");
		med = sc.nextLine();
		System.out.println("Please Enter the cost of above medicine/test");
		m.setCost(sc.nextInt());
		System.out.println("Please Enter the quantity available ");
		m.setNoma(sc.nextInt());
		if(mt.containsKey(med) == false)
			mt.put(med, m);
		else
			System.out.println("This medicine/test is already available");
	}
	void searchMedicine(){
		String med;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Medicine/Test name to be search ");
		med = sc.nextLine();
		if(mt.get(med)!=null) {
		System.out.println("Medicine/Test Available :-");
		System.out.println(med + "\tCost- " + mt.get(med).getCost() + "\tQuantity- " + mt.get(med).getNoma());
		}
		else {
			System.out.println("Medicine Not Found ");
		}
	}
	void updateMedicine() {
		String med;
		Medicine m = new Medicine(0,0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Medicine/Test name to be updated");
		med = sc.nextLine();
		System.out.println("Please Enter the new medicine/test cost ");
		m.setCost(sc.nextInt());
		System.out.println("Please Enter the Medicine/Test quantity ");
		m.setNoma(sc.nextInt());
		mt.remove(med);
		mt.put(med, m);
	}
	void deleteMedicine() {
		String med;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Medicine/Test name to be deleted ");
		med = sc.nextLine();
		mt.remove(med);
	}
	void adddoctor() {
		String s;
		Department d1 = new Department(" ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the department in which doctor is to be added ");
		s = sc.nextLine();
		for(Department d:dp) {
			if(d.getName().equals(s)){
				d.addDoctor();
			}
		}
	}
	void searchdoctor() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the department name");
		s = sc.nextLine();
		for(Department d:dp) {
			if(d.getName().equals(s)){
				d.showDoctor();
			}
		}
	}
	void updatedoctor() {
		String s;
		Department d1 = new Department(" ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the department name");
		s = sc.nextLine();
		for(Department d:dp) {
			if(d.getName().equals(s)){
				d1 =d;
			}
		}
		d1.deleteDoctor();
		System.out.println("Please enter the new details again ");
		d1.addDoctor();
	}
	void deletedoctor() {
		String s;
		Department d1 = new Department(" ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the department name");
		s = sc.nextLine();
		for(Department d:dp) {
			if(d.getName().equals(s)){
				 d1 = d;
				break;
			}
		}
		d1.deleteDoctor();
	}
	int addPatient() {
		Patient p = new Patient(10);
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
		p.setGender(sc.next().charAt(0));
		p.setPatientid();
		System.out.println("Patient successfully created with patient id " + p.getPatientid());
		pt.put(p.getPatientid(), p);
		return p.getPatientid();
	}
	int checkPatient() {
		Patient p = new Patient();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the patients id ");
		int i = sc.nextInt();
		System.out.println("Please enter password ");
		String s = sc.next();
		p = pt.get(i);
		if(p!=null) {
			if(s.equals(p.getPassword())) {
				System.out.println("Password Accepted");
				return p.getPatientid();
			}
		}
		else {
			System.out.println("Patient ID invalid");
		}
		return 0;
	}
	void updatePatient(int i) {
		Patient p = new Patient();
		Scanner sc = new Scanner(System.in);
		p = pt.get(i);
		if(p!=null) {
			System.out.println("Please enter new patients age ");
			p.setAge(sc.nextInt());
		}
		else {
			System.out.println("Patient ID invalid");
		}
	}
	void showPatient() {
		Patient p = new Patient();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter patients id ");
		int i = sc.nextInt();
		p = pt.get(i);
		System.out.println("PatientID    Name       Age    Gender  Previous History");
		System.out.println("-------------------------------------------------------");
		if(p!=null) {
			System.out.println(p.getPatientid()+"       "+p.getName()+"       "+p.getAge()+"      "+p.getGender()+"          "+p.getPrevious_history());
		}
		else {
			System.out.println("Patient ID invalid");
		}
	}
	void bookappointment(int ptid) {
		String s;
		Scanner sc = new Scanner(System.in);
		Patient p = new Patient();
		p = pt.get(ptid);
		if(p!=null) {
			System.out.println("Please enter the department name");
			s = sc.nextLine();
			for(Department d:dp) {
				if(d.getName().equals(s)){
					d.showDoctor();
					d.bookappoi(ptid);
				}
			}
		}
		else {
			System.out.println("Invalid Patiet id");
		}
	}
		void searchappointment() {
			String s;
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the department name");
			s = sc.nextLine();
			for(Department d:dp) {
				if(d.getName().equals(s)){
					d.showDoctor();
					d.searchappoi();
				}
			}
		}
		void cancelappointment(int ptid) {
			String s;
			Scanner sc = new Scanner(System.in);
			Patient p = new Patient();
			p = pt.get(ptid);
			if(p!=null) {
				System.out.println("Please enter the department name");
				s = sc.nextLine();
				for(Department d:dp) {
					if(d.getName().equals(s)){
						d.showDoctor();
						d.cancelappoi(ptid);
					}
				}
			}
			else {
				System.out.println("Invalid Patiet id");
			}
		}
}


