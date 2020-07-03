
public class DavisListDriver {
	public static void main(String[] args) {
		DavisList<String> davis = new DavisList<>();
		davis.add("Hello");
		System.out.println(davis);
		davis.remove();
		System.out.println(davis);
		davis.add("I");
		davis.add("like");
		davis.add("potatoes");
		System.out.println(davis.size());
		davis.set(0, "you");
		System.out.println(davis);
		System.out.println(davis.indexOf("potatoes"));
	}
}
