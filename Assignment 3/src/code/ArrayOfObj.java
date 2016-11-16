package code;

public class ArrayOfObj {
	private RefInt[] setInts;
	
	public ArrayOfObj() {
		setInts = new RefInt[3];
		setInts[0] = new RefInt(0, 0, 0);
		setInts[1] = new RefInt(0, 0, 0);
		setInts[2] = new RefInt(0, 0, 0);
	}
	
	public ArrayOfObj (int setIntX1, int setIntY1, int setIntZ1, int setIntX2, int setIntY2, int setIntZ2, int setIntX3, int setIntY3, int setIntZ3) {
		setInts = new RefInt[3];
		setInts[0] = new RefInt(setIntX1, setIntY1, setIntZ1);
		setInts[1] = new RefInt(setIntX2, setIntY2, setIntZ2);
		setInts[2] = new RefInt(setIntX3, setIntY3, setIntZ3);
	}
}

	

