
public class Employee extends Person {

 
	double baseSalary;
	public Employee(String name, double baseSalary) {
		super(name);
		this.baseSalary = baseSalary;
	}
	
	public double getSalary() {
		return baseSalary;
	}

}
