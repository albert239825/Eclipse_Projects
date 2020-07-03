
public class String_Problems {
	public static void main(String[] args) {
		String thing = "Potatoes";
		String str = "";
		
		
		for (int i = 0; i < thing.length(); i++) {
			char c = thing.charAt(i);
			str += c;
			System.out.println(c);
		}
		
		System.out.println(str);
	}
}
//Is there a writer's meeting today?
