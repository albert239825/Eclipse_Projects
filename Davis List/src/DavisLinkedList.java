
public class DavisLinkedList<E> {
	private Node head;
	private Node tail;

	private int currentSize;

	//add to the front
	public void addFirst (E obj) {
		Node<E> node = new Node<E>(obj);
		node.next = head;
		head = node;
		currentSize++;
		if (node.next == null) {
			tail = head;
		}
	}

	public Node<E> removeFirst() {
		if (head == null) {
			return null;
		}
		Node<E> temp = head;
		
		//if don't have tail replace head == tail to head.getNext() != null
		if (head == tail) {
			head = tail = null;
		}
		else {
			head = head.next;
		}
		currentSize--;
		return temp;
	}
	
	private void printList(Node n) {
		//If doesn't have tail variable, change to n.next == null;
		if (n == tail) {
			System.out.print(n.getData() + "]");
		}
		else {
			System.out.print(n.getData() + ", ");
			printList(n.getNext());
		}
	}
	
	public void print() {
		System.out.print("[");
		printList(head);
	}
	//returns size of linked list
	public int size() {
		return currentSize;
	}



	//Anonymous inner class
	//I just learned about this and wanted to use it
	class Node<E> {
		Node next;
		E data;

		public Node(E obj) {
			data = obj;
			next = null;
		}

		public Node getNext() {
			return next;
		}

		public E getData() {
			return data;
		}

		public void setNext(Node newNext) {
			next = newNext;
		}
	}
}
