
public class DavisLinkedListDriver {

	public static void main(String[] args) {
		DavisLinkedList<String> names = new DavisLinkedList<>();
		names.addFirst("jeff");
		names.addFirst("troy");
		names.addFirst("potatoe");
		names.addFirst("Help");
		names.print();

		System.out.println();
		System.out.println("Kicked out: " + names.removeFirst().getData());
		names.print();
		
	}

}
