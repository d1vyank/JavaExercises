package lab6;

import java.util.HashMap;
import java.util.Map;

interface Animal {
	public void speak ();
	}
class Lion implements Animal {
	public void speak() {
		System.out.println("ROAR");
	}


}

class Mouse implements Animal {
	public void speak() {
		System.out.println("SQUEAK");
	}


}
class Bison implements Animal {
	public void speak() {
		System.out.println("BELLOW");
	}

}
class AnimalType {

	private static Map<String, Animal> types = new HashMap<String, Animal>();
	static {
	types.put("small",new Mouse());
	types.put("big", new Bison());
	types.put("lazy", new Lion());
	}
	public static Animal getAnimal(String criteria) {

		return types.get(criteria);
		
	}
}
public class JavaFPExample {
	public static void main(String[] args) {
		Animal animal = AnimalType.getAnimal("small");
		animal.speak();
		animal = AnimalType.getAnimal("big");
		animal.speak();
		animal = AnimalType.getAnimal("lazy");
		animal.speak();
	}
}
