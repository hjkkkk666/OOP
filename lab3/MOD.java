package lab3;

public class MOD implements IOperation {
	@Override
	public String getSign() {
		return "%";
	}
	
	@Override
	public String getName() {
		return "MOD";
	}
	
	@Override
	public int estimate(int a, int b) {
		return a%b;
	}
}
