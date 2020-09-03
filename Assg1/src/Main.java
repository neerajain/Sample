import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		assg1 a = new assg1();
		System.out.println("**************************HOSPITAL BOOKING SYSTEM****************************");
		System.out.println("--------------------------");
		System.out.println("Please Enter \n1 for Admin \n2 for Patient");
		System.out.println("--------------------------");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int k;
		int flag = 0;
		do {
			switch(i) {
				case 1:
					System.out.println("Please enter admin password ");
					String s = sc.next();
					if(s.equals("hospital")) {
						System.out.println("Access granted as an Admin");
						flag = 0;
					}
					else {
						System.out.println("Access denied ");
						flag = 1;
					}
					if(flag!=1) {
					System.out.println("Enter \n1 Add department\n2 Show department\n3 Add medicine/test \n4 to search medicine/test \n5 Delete medicine/test\n6 Update medicine\n7 Add doctor in a particlar department \n8 Show doctor in a particlar department\n9 Delete doctor in a particlar department \n10 Update doctor in a particular doctor \n11 Show Patient");
					do {
						System.out.println("Enter choice");
						int j = sc.nextInt();
						switch(j) {
						case 1:
							a.addDepartment();
							break;
						case 2:
							a.showDepartment();
							break;
						case 3:
							a.addMedicine();
							break;
						case 4:
							a.searchMedicine();
							break;
						case 5:
							a.deleteMedicine();
							break;
						case 6:
							a.updateMedicine();
							break;
						case 7:
							a.adddoctor();
							break;
						case 8:
							a.searchdoctor();
							break;
						case 9:
							a.deletedoctor();
							break;
						case 10:
							a.updatedoctor();
							break;
						case 11:
							a.showPatient();
							break;
						}
						System.out.println("Do you want to continue Press 1 to continue 0 to exit ");
						k = sc.nextInt();
					}while(k!=0);
					}
				break;
				case 2:
					int id;
					System.out.println("--------------------------");
					System.out.println("Please Enter \n1 for New Patient \n2 for Old patient");
					System.out.println("--------------------------");
					int in = sc.nextInt();
					if(in==1) {
						 id=a.addPatient();
					}
					else {
						id = a.checkPatient();
					}
					if(id > 50000){
					System.out.println("Enter\n1 Update Patient  \n2 Search Department \n3 Search Doctor \n4 Search Medicine/Test \n5 Book Appointment \n6 Show All Appointment \n7 Cancel Appointment");
					do {
						System.out.println("Enter choice");
						int j = sc.nextInt();
						switch(j) {
						case 1:
							a.updatePatient(id);
							break;
						case 2:
							a.showDepartment();
							break;
						case 3:
							a.searchdoctor();
							break;
						case 4:
							a.searchMedicine();
							break;
						case 5:
							a.bookappointment(id);
							break;
						case 6:
							a.searchappointment();
							break;
						case 7:
							a.cancelappointment(id);
							break;
						}
						System.out.println("Do you want to continue Press 1 to continue 0 to exit ");
						k = sc.nextInt();
					}while(k!=0);
				}
				break;
			
			}
			System.out.println("--------------------------");
			System.out.println("Please enter\n0 to exit \n1 for Admin \n2 for patient  ");
			System.out.println("--------------------------");
			i = sc.nextInt();
		}
		while(i!=0);
	}
}
