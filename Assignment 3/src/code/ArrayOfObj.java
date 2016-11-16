package code;

public class ArrayOfObj {
	private ReferenceInteger[] setInts;
	
	public ArrayOfObj() {
		setInts = new ReferenceInteger[3];
		setInts[0] = new ReferenceInteger(0, 0, 0);
		setInts[1] = new ReferenceInteger(0, 0, 0);
		setInts[2] = new ReferenceInteger(0, 0, 0);
	}
	
	public ArrayOfObj (int setIntX1, int setIntY1, int setIntZ1, int setIntX2, int setIntY2, int setIntZ2, int setIntX3, int setIntY3, int setIntZ3) {
		setInts = new ReferenceInteger[3];
		setInts[0] = new ReferenceInteger(setIntX1, setIntY1, setIntZ1);
		setInts[1] = new ReferenceInteger(setIntX2, setIntY2, setIntZ2);
		setInts[2] = new ReferenceInteger(setIntX3, setIntY3, setIntZ3);
	}
}

	

