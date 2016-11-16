package code;

public class Integer3 {
	private int integer3;
	
	public Integer3 () {
		integer3 = 1;
	}
	
	public Integer3 (int z) {
		integer3 = z;
		if ((integer3 < 1) || (integer3 > 50)) {
			integer3 = 1;
		}
	}
}
