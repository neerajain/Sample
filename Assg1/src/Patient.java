
public class Patient {
	private String name;
	private int age;
	private char gender;
	private String previous_history;
	private int patientid;
	private String password;
	private static int cnt;
	public Patient(int i) {cnt++;}
	public Patient() {}
	public Patient(String name, int age, char gender, String previous_history, int patientid,String password) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.previous_history = previous_history;
		this.patientid = patientid;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPrevious_history() {
		return previous_history;
	}
	public void setPrevious(String previous) {
		this.previous_history = previous;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid() {
		this.patientid = 50000+cnt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
