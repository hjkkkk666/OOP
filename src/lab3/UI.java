package lab3;

public class UI {
	public static void main (String[] args) {
		IOperation[] operations = {
				new DIV(), new MOD(),
				new GCD(), new LCM()
		};
		
		int a = 12, b = 2;
		for (IOperation op : operations) {
			System.out.println(op.getName());
			System.out.printf("%d %s %d = %d\n", a, op.getSign(), b, op.estimate(a, b));
		}
	}

}
