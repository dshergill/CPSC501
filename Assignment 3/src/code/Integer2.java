package code;

public class Integer2 {
	private int integer2;
	
	public Integer2 () {
		integer2 = 1;
	}
	
	public Integer2 (int y) {
		integer2 = y;
		if ((integer2 < 1) || (integer2 > 25)) {
			integer2 = 1;
		}
	}
}
