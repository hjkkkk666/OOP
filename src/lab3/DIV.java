package lab3;

public class DIV implements IOperation {

	@Override
	public String getSign() {
		return "/";
	}
	
	@Override
	public String getName() {
		return "DIV";
	}
	
	@Override
	public int estimate(int a, int b) {
		return a/b;
	}
}
