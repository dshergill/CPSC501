package code;

public class ReferenceInteger {
	private Integer1 integer1;
	private Integer2 integer2;
	private Integer3 integer3;
	
	public ReferenceInteger () {
		integer1 = new Integer1(0);
		integer2 = new Integer2(0);
		integer3 = new Integer3(0);
	}
	
	public ReferenceInteger (int x, int y, int z) {
		integer1 = new Integer1(x);
		integer2 = new Integer2(y);
		integer3 = new Integer3(z);
	}
}
