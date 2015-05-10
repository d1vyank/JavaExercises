
public class CustomerRp extends Person implements Printable{
	private double projectPrice;
	public CustomerRp(String name,double projectPrice) {
		super(name);
		this.projectPrice = projectPrice;
	}

	@Override
	public String PrintInfo() {
		String info = name + "+" + projectPrice;
		return info;
	}
	public double getProjectPrice() {
		return projectPrice;
	}

}
