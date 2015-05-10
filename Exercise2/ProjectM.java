import java.util.Date;


public class ProjectM extends SfEngineer implements Salary,Printable{
	Date projectDeadline;
	public ProjectM(String name, double baseSalary, String projectName, Date projectDeadline) {
		super(name, baseSalary, projectName);
		this.projectDeadline = projectDeadline;
	}

	@Override
	public String PrintInfo() {
		String info = name +"+"+ projectName + "+" + baseSalary + "+" + projectDeadline;
		return info;
	}

	@Override
	public double IncreaseSalary() {
		baseSalary += baseSalary * 0.24;
		return 0;
	}
	
	public Date getProjectDeadline() {
		return projectDeadline;
	}
	@Override
	public boolean equals(Object hw) {
		if(this == hw) return true;
		if((hw == null) || this.getClass()!= hw.getClass()) return false;
		ProjectM test = (ProjectM)hw;
		return ((test.name.equals(name)) && test.baseSalary == baseSalary
				&& projectName.equalsIgnoreCase(test.projectName) && test.projectDeadline == projectDeadline); 
	}
	@Override 
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash ^ (int)baseSalary;
		hash = 31 * hash ^ (null == name ? 0 : name.hashCode());
		hash = 31 * hash ^ (null == projectName ? 0 : projectName.hashCode());
		hash = 31 * hash ^ projectDeadline.toString().hashCode();
		return hash;
	}
}
 