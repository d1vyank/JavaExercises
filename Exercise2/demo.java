import java.util.Date;


public class demo {
	public static void main(String args[]) {
		HwEngineer hw1 = new HwEngineer("Steve", 3000);
		ProjectM pm1 = new ProjectM("Ray", 6000.00,"project 2" ,new Date());
		CustomerRp cr1 = new CustomerRp("Bill",50000.00);
		//DELIVERABLE 1
		pm1.IncreaseSalary();
		hw1.IncreaseSalary();
		System.out.println("manager final salary"+pm1.baseSalary);
		System.out.println("hwEngineer final salary"+hw1.baseSalary);
		System.out.println(pm1.PrintInfo());
		System.out.println(cr1.PrintInfo());
	}
	long fnv(String b) {
		int c = b.length();
		String p = b;
		long h =  0xcbf29ce484222325L;
		int i;
		for (i = 0; i < c; i++)
		h = (h * 1099511628211L) ^ p.charAt(i);
		return h;
		}

}
