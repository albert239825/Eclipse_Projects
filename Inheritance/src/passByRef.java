
public class passByRef {

	private void args() {
		// TODO Auto-generated method stub
		EAPerson a = new EAPerson("name", "username");
		System.out.println(a.getUN());
		f2(a);
		System.out.println(a.getUN());
	}
	
	public static void f2(EAPerson e) {
		e.setUN("Potato Bob");
	}
}
