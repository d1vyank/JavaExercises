
public class SfEngineer extends Employee{
	String projectName;
	public SfEngineer(String name, double baseSalary, String projectName) {
		super(name, baseSalary);
		this.projectName = projectName;
	}
	public String getProjectName() {
		return projectName;
	}
	@Override
	public boolean equals(Object hw) {
		if(this == hw) return true;
		if((hw == null) || this.getClass()!= hw.getClass()) return false;
		SfEngineer test = (SfEngineer)hw;
		return ((test.name.equals(name)) && test.baseSalary == baseSalary
				&& projectName.equalsIgnoreCase(test.projectName)); 
	}
	@Override 
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash ^ (int)baseSalary;
		hash = 31 * hash ^ (null == name ? 0 : name.hashCode());
		hash = 31 * hash ^ (null == projectName ? 0 : projectName.hashCode());
		return hash;
	}
	
}
