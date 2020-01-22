//1/15/2020
//Dr.Kelleys class
public class Employee {

	private String name;
	private double ytdPay;
	public static int numEmployees;
	
	public Employee() 
	{
		name = "";
		ytdPay = 0.0;
		numEmployees++;
	}//end empty-argument constructor
	public Employee(String name)
	{
		this.name = name;
		ytdPay = 0.0;
		numEmployees++;
	}//preferred constructor
	
	public double calcPay(double annualSalary)
	{
		double pay = annualSalary / 26;
		ytdPay += pay;
		return pay;
	}//overloaded method
	public double calcPay(double hoursWorked, double hourlyPay)
	{
		double pay = hoursWorked * hourlyPay;
		ytdPay += pay;
		return pay;
		
	}//overloaded method
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getYtdPay() {
		return ytdPay;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", ytdPay=" + ytdPay + "]";
	}
	
	
}//end class
