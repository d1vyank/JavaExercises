package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class Demo {
	public static void main(String args[]) {
		Cuboid[] Cuboids = new Cuboid[5];


		Arrays.sort(Cuboids, new Comparator<Cuboid>(){
			@Override
			public int compare(Cuboid c1, Cuboid c2){
				return (int) (c2.getLength() - c1.getLength());
			} });
		System.out.println(Cuboids);
		Arrays.sort(Cuboids,  new Comparator<Cuboid>(){
			@Override
			public int compare(Cuboid c1, Cuboid c2){
				return (int) (c2.getArea() - c1.getArea());
			}});
		System.out.println(Cuboids);
		Arrays.sort(Cuboids, new Comparator<Cuboid>(){
			@Override
			public int compare(Cuboid c1, Cuboid c2){
				return (int) (c2.getVolume() - c1.getVolume());
			}});
		System.out.println(Cuboids);
		

	}


}
