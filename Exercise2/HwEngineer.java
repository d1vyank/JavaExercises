
public class HwEngineer extends Employee implements Salary{

	public HwEngineer(String name, double baseSalary) {
		super(name, baseSalary);
	}

	@Override
	public double IncreaseSalary() {
		baseSalary += baseSalary * 0.18;
		return 0;
	}
	@Override
	public boolean equals(Object hw) {
		if(this == hw) return true;
		if((hw == null) || this.getClass()!= hw.getClass()) return false;
		HwEngineer test = (HwEngineer)hw;
		return ((test.name == name) && test.baseSalary == baseSalary); 
	}
	@Override 
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash ^ (int)baseSalary;
		hash = 31 * hash ^ (null == name ? 0 : name.hashCode());
		return hash;
	}


}