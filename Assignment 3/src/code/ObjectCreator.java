package code;

import java.util.Scanner;

public class ObjectCreator {
	
	Object obj;
	Scanner scan;
	
		public ObjectCreator () {
		int selection;
		System.out.println("List of objects to be created");
		System.out.println("1. Single Int Field");
		System.out.println("2. References to other objects (int fields of (1))");
		System.out.println("3. Array of Integers");
		System.out.println("4. Array of Object References (array of (1) objects)");
		System.out.println("5. ArrayList of Array of Ints");
		System.out.println("Please enter your selection (1-5): ");
		scan = new Scanner(System.in);
		selection = scan.nextInt();
		switch (selection) {
			case 1: 
				makeInt();
				break;
			case 2: 
				makeRefInt();
				break;
			case 3: 
				makeAOI();
				break;
			case 4: 
				makeAOO();
				break;
			case 5: 
				makeAOIAL();
				break;
			default:
				makeInt();
		}
	}
	
	private void makeInt() {
		int integer1;
		System.out.println("Enter an integer: ");
		integer1 = scan.nextInt();
		obj = new Integer1(integer1);
	}
	
	
	private void makeRefInt() {
		int integer1;
		int integer2;
		int integer3;
		System.out.println("Enter the first integer: ");
		integer1 = scan.nextInt();
		System.out.println("Enter an integer between 1-25: ");
		integer2 = scan.nextInt();
		System.out.println("Enter an integer between 1-50: ");
		integer3 = scan.nextInt();
		obj = new RefInt(integer1, integer2, integer3);
	}
	
	
	private void makeAOI() {
		int int1;
		int int2;
		int int3;
		System.out.println("Enter the first integer: ");
		int1 = scan.nextInt();
		System.out.println("Enter the second integer: ");
		int2 = scan.nextInt();
		System.out.println("Enter the third integer: ");
		int3 = scan.nextInt();
		obj = new ArrayOfInt(int1, int2, int3);
	}
	
	
	private void makeAOO() {
		int int1Set1;
		int int2Set1;
		int int3Set1;
		int int1Set2;
		int int2Set2;
		int int3Set2;
		int int1Set3;
		int int2Set3;
		int int3Set3;
		System.out.println("Enter the first integer of the first set: ");
		int1Set1 = scan.nextInt();
		System.out.println("Enter the second integer of the first set: ");
		int2Set1 = scan.nextInt();
		System.out.println("Enter the third integer of the first set: ");
		int3Set1 = scan.nextInt();
		System.out.println("Enter the first integer of the second set: ");
		int1Set2 = scan.nextInt();
		System.out.println("Enter the second integer of the second set: ");
		int2Set2 = scan.nextInt();
		System.out.println("Enter the third integer of the second set: ");
		int3Set2 = scan.nextInt();
		System.out.println("Enter the first  integer of the third set: ");
		int1Set3 = scan.nextInt();
		System.out.println("Enter the second integer of the third set: ");
		int2Set3 = scan.nextInt();
		System.out.println("Enter the third integer of the third set: ");
		int3Set3 = scan.nextInt();
		obj = new ArrayOfObj(int1Set1, int2Set1, int3Set1, int1Set2, int2Set2, int3Set2, int1Set3, int2Set3, int3Set3);
	}
	
	
	private void makeAOIAL() {
		int int1;
		int int2;
		int int3;
		int int4;
		int int5;
		int int6;
		int int7;
		int int8;
		int int9;
		System.out.println("Enter the first integer: ");
		int1 = scan.nextInt();
		System.out.println("Enter the second integer: ");
		int2 = scan.nextInt();
		System.out.println("Enter the third integer: ");
		int3 = scan.nextInt();
		System.out.println("Enter the fourth integer: ");
		int4 = scan.nextInt();
		System.out.println("Enter the fifth integer: ");
		int5 = scan.nextInt();
		System.out.println("Enter the sixth integer: ");
		int6 = scan.nextInt();
		System.out.println("Enter the seventh integer: ");
		int7 = scan.nextInt();
		System.out.println("Enter the eigth integer: ");
		int8 = scan.nextInt();
		System.out.println("Enter the ninth integer: ");
		int9 = scan.nextInt();
		obj = new ArrayOfIntAL(int1, int2, int3, int4, int5, int6, int7, int8, int9);
	}
	
	
	public Object getObj() {
		return obj;
	}


}
