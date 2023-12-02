package lab3;

public class GCD implements IOperation {
	@Override
	public String getSign() {
		return "НОД";
	}
	
	@Override
	public String getName() {
		return "GCD";
	}
	
	@Override
	public int estimate(int a, int b) {
		//if (b==0) return a;
		//return estimate(b, a % b);
		while (b!=0) {
			int temp = b;
			b=a%b;
			a=temp;
		}
		return a;
	}
}
