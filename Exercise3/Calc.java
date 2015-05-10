
public class Calc<E extends Number> {
	public Double add(E num1, E num2) {
		return (num1.doubleValue()+ num2.doubleValue());
	}
	public Double sub(E num1, E num2) {
		return (num1.doubleValue() - num2.doubleValue());
	}
	public Double mul(E num1, E num2) {
		return (num1.doubleValue() * num2.doubleValue());
	}
	public Double div(E num1, E num2) {
		return (num1.doubleValue() / num2.doubleValue());
	}
	public Double pow(E num1, E num2) {
		return Math.pow(num1.doubleValue(),num2.doubleValue());
	}
}
