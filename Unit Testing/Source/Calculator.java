public class Calculator {
	public Double add(double a, double b){
		return (a+b);
	}
	public Double add(int a,int b){
		return Double.valueOf(a+b);
	}
	public Double subtract(double a, double b) {
		return (a-b);
	}
	public Double multiply(double a, double b) {
		return (a*b);
	}
	public Double multiply(int a, int b) {
		return Double.valueOf(a*b);
	}
	public Double divide(double a, double b) {
		return (a/b);
	}
	public Double divide(int a, int b) {
		return Double.valueOf(a/b);
	}
	public Double[] getRoots(double a, double b, double c) {
		double root1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
		double root2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);	
		Double[] roots ={root1,root2};
		if (root1 == root2) {
			Double[] r= {root1};
			return (r);
		}
		return roots;
	}
	public Double getSquareRoots(double a) {
		return Math.sqrt(a);
	}
}