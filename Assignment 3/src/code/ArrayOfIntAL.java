package code;

import java.util.*;

public class ArrayOfIntAL {
	private ArrayList<ArrayOfInt> AOI;
	
	public ArrayOfIntAL () {
		AOI = new ArrayList<ArrayOfInt>();
		ArrayOfInt AOI1 = new ArrayOfInt(0, 0, 0);
		ArrayOfInt AOI2 = new ArrayOfInt(0, 0, 0);
		ArrayOfInt AOI3 = new ArrayOfInt(0, 0, 0);
		AOI.add(AOI1);
		AOI.add(AOI2);
		AOI.add(AOI3);
	}
	
	public ArrayOfIntAL (int int1, int int2, int int3, int int4, int int5, int int6, int int7, int int8, int int9) {
		AOI = new ArrayList<ArrayOfInt>();
		ArrayOfInt AOI1 = new ArrayOfInt(int1, int2, int3);
		ArrayOfInt AOI2 = new ArrayOfInt(int4, int5, int6);
		ArrayOfInt AOI3 = new ArrayOfInt(int7, int8, int9);
		AOI.add(AOI1);
		AOI.add(AOI2);
		AOI.add(AOI3);
	}
}