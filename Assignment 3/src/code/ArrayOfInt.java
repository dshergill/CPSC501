package code;

public class ArrayOfInt {
	private int intArray[];
	
	public ArrayOfInt() {
		intArray = new int[3];
		intArray[0] = 0;
		intArray[1] = 0;
		intArray[2] = 0;
	}
	
	public ArrayOfInt(int int1, int int2, int int3) {
		intArray = new int[3];
		intArray[0] = int1;
		intArray[1] = int2;
		intArray[2] = int3;
	}
}
