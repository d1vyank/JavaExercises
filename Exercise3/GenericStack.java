import java.util.ArrayList;


public class GenericStack<T> {
	private ArrayList<T> items = new ArrayList<T>();
	public boolean push(T item) {
		try {
			items.add(item);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public T pop() {
		if(items.isEmpty()) {
			return null;
		}
		else {
			return items.remove(items.size() -1);
		}
	}
	public boolean Empty() {
		return items.isEmpty();
	}
}
