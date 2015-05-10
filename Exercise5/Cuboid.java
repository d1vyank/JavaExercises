package lab6;

public class Cuboid {
	private double l,b,h;
	private double area, volume;
	public Cuboid(double l, double b, double h) {
		this.l = l;
		this.h = h;
		this.b = b;
		this.area = (2*b*l) + (2*l*h) + (2*h*b);
		this.volume = (l*b*h);
	}
	public double getLength() {
		return l;
	}
	public double getBreadth() {
		return b;
	}
	public double getHeight() {
		return h;
	}
	public void setLength(double l) {
		this.l = l;
	}
	public void setBreadth(double b) {
		this.b = b;
	}
	public void setHeight(double h) {
		this.h = h;
	}
	public double getArea() {
		return this.area;
	}
	public double getVolume() {
		return this.volume;
	}
}
