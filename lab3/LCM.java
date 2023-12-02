package lab3;

public class LCM implements IOperation {
	@Override
	public String getSign() {
		return "НОК";
	}
	
	@Override
	public String getName() {
		return "LCM";
	}
	
	@Override
	public int estimate(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int lcm = max;
		while (lcm % min != 0) {
			lcm += max;
		}
		return lcm;
	}
}
