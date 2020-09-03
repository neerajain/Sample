import java.time.LocalDate;
import java.util.*;

class Doctor{
	private String registration;
	private String name;
	private String specialization;
	private int yoe;
	private int fees;
	private double time;
	HashMap<LocalDate,TreeMap<Double,Integer>> app;
	public Doctor(String registration, String name, String specialization, int yoe, int fees,double time) {
		this.registration = registration;
		this.name = name;
		this.specialization = specialization;
		this.yoe = yoe;
		this.fees = fees;
		this.time = time;
		app = new HashMap<LocalDate,TreeMap<Double,Integer>>();
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getYoe() {
		return yoe;
	}
	public void setYoe(int yoe) {
		this.yoe = yoe;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public void bookAppointment(int ptid) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter date on which you would like to enter your appointment");
		System.out.println("Please enter year");
		int y = sc.nextInt();
		System.out.println("Please enter month number");
		int m = sc.nextInt();
		System.out.println("Please enter day number");
		int d = sc.nextInt();
		LocalDate l = LocalDate.of(y,m,d);
		TreeMap<Double,Integer> i = app.get(l);		
		Double tt = this.getTime()+2.0;
		if(i!=null) {
			System.out.println("Please enter your time for appointment from " + this.getTime()+" to " + tt);
			double j = sc.nextDouble();
			if(j>tt || j<this.getTime()) {
				System.out.println("Doctor not avaialable at this time");
				return;
			}
			if(i.putIfAbsent(j, ptid) !=null) {
				System.out.println("Apoointment already book for this timing");
			}
			else {
				i.put(j, ptid);
			}
			
		}
		else {
			System.out.println("Please enter your time for appointment from " + this.getTime()+" to " + tt);
			double j = sc.nextDouble();
			if(j>tt || j<this.getTime()) {
				System.out.println("Doctor not avaialable at this time");
				return;
			}
			TreeMap<Double,Integer> k = new TreeMap<Double,Integer>();
			k.put(j,ptid);
			app.put(l, k);
		}
	}
	public void showAppointment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter date on which you would like to see the schedule of the appointmnet ");
		System.out.println("Please enter year");
		int y = sc.nextInt();
		System.out.println("Please enter month number");
		int m = sc.nextInt();
		System.out.println("Please enter day number");
		int d = sc.nextInt();
		LocalDate l = LocalDate.of(y,m,d);
		TreeMap<Double,Integer> i = app.get(l);
		if(i!=null) {
			System.out.println("Appointment book on this day are ");
			System.out.println("---------------------------------");
			for(Map.Entry mp:i.entrySet()){    
			       System.out.println("Time-"+mp.getKey()+"    Patient ID- "+mp.getValue());
			      }  
			System.out.println("---------------------------------");
		}
		else {
			System.out.println("No appointment on this day ");
		}
	}
	public void cancelAppointment(int ptid) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter date on which you would like to cancel your appointmnet ");
		System.out.println("Please enter year");
		int y = sc.nextInt();
		System.out.println("Please enter month number");
		int m = sc.nextInt();
		System.out.println("Please enter day number");
		int d = sc.nextInt();
		LocalDate l = LocalDate.of(y,m,d);
		TreeMap<Double,Integer> i = app.get(l);
		if(i!=null) {
			System.out.println("Please enter your previous time for appointment");
			Double d1 = sc.nextDouble();
			i.remove(d1);
		}
		else {
			System.out.println("No appointment on this day ");
		}
	}
	
}