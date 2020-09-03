import java.util.LinkedList;
import java.util.Scanner;

public class Department {
	private String name;
	LinkedList<Doctor> lod;
	public Department(String name) {
		this.name = name;
		lod = new LinkedList<Doctor>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addDoctor(){
		Scanner sc = new Scanner(System.in);
		Doctor d1 = new Doctor(" "," "," ",0,0,0.0);
		System.out.println("Please enter Doctors registration no.");
		d1.setRegistration(sc.nextLine());
		System.out.println("Please enter doctors name ");
		d1.setName(sc.nextLine());
		d1.setSpecialization(this.name);
		System.out.println("Please enter year of experience ");
		d1.setYoe(sc.nextInt());
		System.out.println("Please enter doctors fees ");
		d1.setFees(sc.nextInt());
		System.out.println("Please enter doctors visiting time in the format from 0 to 23 followed by a decimal to represent minitues ");
		d1.setTime(sc.nextDouble());
		lod.add(d1);
	}
	public void showDoctor(){
		int i=1;
		for(Doctor d1 : this.lod) {
			System.out.println(i+".");
			System.out.println("RegNo.-" + d1.getRegistration() + "\nName-"+ d1.getName() + "\nYear of Experience-"+ d1.getYoe() + "\nFees-" + d1.getFees()+"\nDoctor available from "+d1.getTime()+" for 2 hours daily\n");
			i++;
		}
	}
	public void deleteDoctor() {
		String d;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Doctors registration no.");
		d = sc.nextLine();
		for(Doctor d1:this.lod) {
			if(d1.getRegistration().equals(d)) {
				lod.remove(d1);
			}
		}
	}
	public void bookappoi(int ptid) {
		String s;
		System.out.println("Please enter doctors registration number ");
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		for(Doctor d1 : this.lod) {
			if(d1.getRegistration().equals(s)) {
				d1.bookAppointment(ptid);
			}
		}
	}
	public void searchappoi() {
		String s;
		System.out.println("Please enter doctors registration number ");
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		for(Doctor d1 : this.lod) {
			if(d1.getRegistration().equals(s)) {
				d1.showAppointment();
			}
		}
	}
	public void cancelappoi(int ptid) {
		String s;
		System.out.println("Please enter doctors registration number ");
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		for(Doctor d1 : this.lod) {
			if(d1.getRegistration().equals(s)) {
				d1.cancelAppointment(ptid);
			}
		}
	}
}
