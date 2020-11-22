class Doctor{
	private String registration;
	private String name;
	private String specialization;
	private int yoe;
	private int fees;
	private String time;
	public Doctor(String registration, String name, String specialization, int yoe, int fees,String time) {
		this.registration = registration;
		this.name = name;
		this.specialization = specialization;
		this.yoe = yoe;
		this.fees = fees;
		this.time = time;
		
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}