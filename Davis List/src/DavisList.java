/**
 * 
 */

/**
 * @author Albert
 *
 */
public class DavisList<E> {

	private static final int DEFAULT_SIZE = 10;
	private Object[] arr;
	private int index = 0;

	public DavisList() {
		arr = new Object[DEFAULT_SIZE];
	}


	//add
	public void add(E object) {
		if (index == arr.length) {
			getBig();
		}
		arr[index] = object;
		index++;
	}

	private void getBig() {
		int size = arr.length * 2;
		Object[] arr2 = new Object[size];

		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		arr = arr2;
	}

	//get
	public E get(int i) {
		if (i >= index || i < 0) {
			throw new IndexOutOfBoundsException("Index doesn't exist. Cannot get index " + i + " for DavisList size " + index);
		}
		return (E) arr[i];
	}
	
	//set
	public void set(int i, E e) {
		arr[i] = e;
		//In the case that we use set as an add, I don't want to erase data after the next add
		if (i == index) {
			index++;
		}
		//I'm going to assume that we are going to act like an arraylist and cannot set indices above what we have set
		if (i > index) {
			throw new IndexOutOfBoundsException("Index doesn't exist. Cannot set index " + i + " for DavisList size " + index);
		}
	}
	
	//remove
	public E remove() {
		if (index == 0) {
			throw new IndexOutOfBoundsException("Cannot remove from an empty array");
		}
		E temp = (E) arr[index];
		arr[index - 1] = null;
		index--;
		return temp;
		
	}
	
	//size
	public int size() {
		return index;
	}
	
	//indexOf
	public int indexOf(E obj) {
		for (int i = 0; i < index; i++) {
			if (obj.equals((E) arr[i])) {
				return i;
			}
		}
		return -1;
	}
	
	//toString
	public String toString() {
		String output = "[";
		for (int i = 0; i < index - 1; i++ ) {
			output += arr[i].toString() + ", ";
		}
		//If somebody wants to print out an empty davisList
		if (index > 0) {
			output += arr[index - 1];
		}
		output += "]";
		return output;
	}

}
