package code;

public class RefInt {
	private Integer1 integer1;
	private Integer2 integer2;
	private Integer3 integer3;
	
	public RefInt () {
		integer1 = new Integer1(0);
		integer2 = new Integer2(0);
		integer3 = new Integer3(0);
	}
	
	public RefInt (int x, int y, int z) {
		integer1 = new Integer1(x);
		integer2 = new Integer2(y);
		integer3 = new Integer3(z);
	}
}
