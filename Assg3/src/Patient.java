public class Patient {
	private String name;
	private int age;
	private String gender;
	private String previous_history;
	private int patientid;
	private String password;
	public Patient() {}
	public Patient(String name, int age, String gender, String previous_history, int patientid,String password) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
	public void setPatientid(int i) {
		this.patientid = i;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
