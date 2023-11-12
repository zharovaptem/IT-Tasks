package secondtask;

public class swap_numbers {
	public static void main(String[] args) {
		int a = 40;
		int b = 20;
		System.out.println("До замены: a = " + a + ", b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("После замены: a = " + a + ", b = " + b);
	}
}
