
public class EmployeeApplication {

	public static void main(String[] args) {
		
		Employee scott = new Employee("Scott Emmerson");
	
		System.out.println(scott.toString());
		System.out.println(Employee.numEmployees);
		
		System.out.println();
		
		Employee elizabeth = new Employee("Elizabeth Powell");
		
		System.out.println(elizabeth.toString());
		System.out.println(Employee.numEmployees);
		
		double pay = elizabeth.calcPay(250000);
		System.out.println(pay);
		System.out.println(elizabeth.getYtdPay());
		pay = elizabeth.calcPay(250000);
		System.out.println(elizabeth.getYtdPay());
		
		pay = scott.calcPay(40, 95.0);
		System.out.println(pay);
		System.out.println(scott.getYtdPay());
	}
}
