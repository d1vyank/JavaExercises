package lab5;

import java.util.Random;
import java.util.Scanner;

public class SkipList<Key extends Comparable<? super Key>, Value> {
	private class Node {
		public Key key;
		public Value value;
		public long level;
		public Node next;
		public Node down;

		public Node(Key k, Value v, long level, Node next, Node down) {
			this.key = k;
			this.value = v;
			this.level = level;
			this.next = next;
			this.down = down;
		}
	}

	private Node _head;
	private Random _random;
	private long _size;
	private double _p;
	private long _level(){
		long level = 0;
		while(level <= _size && _random.nextDouble() < _p)
			level++;
		return level;
	}

	public SkipList() {
		_head = new Node(null,null,0,null,null);
		_random = new Random();
		_size = 0;
		_p = 0.5;
	}

	public void insert(Key k, Value v) {
		long level = _level();
		if(level > _head.level) {
			_head = new Node(null, null, level, null, _head);
		}

		Node cur = _head;
		Node last = null;

		while (cur != null) {
			if (cur.next == null || cur.next.key.compareTo(k) > 0) {
				if (level >= cur.level) {
					Node n = new Node(k, v, cur.level, cur.next, null);
					if (last != null) {
						last.down = n;
					}

					cur.next = n;
					last = n;
				}

				cur = cur.down;
				continue;
			} else if (cur.next.key.equals(k)) {
				cur.next.value = v;
				return;
			}

			cur = cur.next;
		}

		_size++;
	}
	public void remove(Key k) {

		Node cur = _head;
		while (cur != null) {
			if (cur.next == null || cur.next.key.compareTo(k) >= 0) {
				if (cur.next != null && cur.next.key.equals(k)) {
					cur.next = cur.next.next;
				}

				cur = cur.down;
				continue;
			}

			cur = cur.next;
		}

		_size--;
	}
	public Value find(Key k) {
		Node cur = _head;
		while (cur != null) {
			if (cur.next == null || cur.next.key.compareTo(k) > 0) {
				cur = cur.down;
				continue;
			} else if (cur.next.key.equals(k)) {
				return cur.next.value;
			}
			
			cur = cur.next;
		}
		return null;
	}
	public void clear() {
		_head = new Node(null,null,0,null,null);
		_random = new Random();
		_size = 0;
		_p = 0.5;
	}
	public long size() {
		// TODO: get the size of the skip list
		return _size;
	}
	public String toString() {
		String values = "";
		Node cur = _head;
		while (cur != null) {
			if (cur.next == null ) {
				cur = cur.down;
				continue;
			} else  {
				if(cur.value!=null)
					values.concat(cur.value.toString());
			}
			
			cur = cur.next;
		}
		return values;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SkipList<Integer,Integer> sl = new SkipList<Integer, Integer>();
		while(true) {
			System.out.println("1. insert 2. size 3.find 4. clear 5. toString 6.exit");
			int choice = in.nextInt();
			in.nextLine();
			switch(choice) {
				case 1:
					System.out.println("enter value");
					int value =  in.nextInt();
					in.nextLine();
					System.out.println("enter key");
					int key = in.nextInt();
					in.nextLine();
					sl.insert(key, value);
					break;
				case 2:
					System.out.println(sl.size());
					break;
				case 3:
					System.out.println("enter key");
					int k = in.nextInt();
					System.out.println(sl.find(k));
					in.nextLine();
					break;
				case 4:
					sl.clear();
					break;
				case 5:
					System.out.println(sl.toString());
					break;
				case 6:
					in.close();
					System.exit(0);
			}
		}
	}
}
