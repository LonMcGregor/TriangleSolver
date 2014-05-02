package triangleSolver;

import java.util.Scanner;
import java.lang.Math;

public class TriangleSolver {
	private static int totalInputs, noAngles, noSides;
	private static double a, b, c, A, B, C;
	private static String [] inputs;
	private static boolean [] id;

	public static void main(String[] args) {
		//initial prompt
		Scanner s = new Scanner(System.in);
		System.out.println("How many inputs do you want to give?");
		boolean ready = true;
		
		//make sure it's between 6, 3 and is a number
		while(ready){
			totalInputs = 0;
			try {
				totalInputs = Integer.parseInt(s.nextLine());
			} catch(Exception e){			
				System.err.println("Make sure you enter a number betwen 3-5...");
			}
			if(totalInputs>6||totalInputs<3)
				System.err.println("Make sure you enter a number betwen 3-5...");
			else
				ready=false;
		}
		
		//get the inputs
		System.out.println("Enter your " + totalInputs + " inputs:");
		inputs = new String [totalInputs];
		for (int i = 0; i < totalInputs; i++)
			inputs[i] = s.nextLine();
		s.close();
		
		//find out what the inputs are, and which were given
		id = new boolean [6];
		noSides=0;
		noAngles=0;
		determineInputs();
		updateTotals();
		
		if (noSides == 0){
			System.out.println("At least 1 input needs to be a side.");
			System.exit(0);
		}
		
		//loop until everything is found.
		
		while(noSides!=3 && noAngles!=3){
			
			//2 angles: 180 subtraction
			if (noAngles==2)  
				determineAngle180();
			
			//1 angle, 3 sides: cos rule
			if ((noAngles==1)&&(noSides==3))
				determineAngleCos();
			
			//1 angle, 2 sides: cos rule
			if((noAngles==1) && (noSides==2))
				determineSideCos();
			
			//2 angles, 1 side: sin rule
			if((noAngles==2&&(noSides==1)))
				determineSideSin();
			
			//dooublecheck all calculations made
			updateTotals();		
		}
		
		printTriangle();
	}

	
	//main program logic methods
	
	private static void updateTotals(){
		noSides=0;
		noAngles=0;
		for (int i = 0; i < 3; i++)
			if(id[i])
				noSides++;
		for (int i = 3; i < 5; i++)
			if(id[i])
				noAngles++;
	}

	private static void printTriangle() {
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("A: " + A);
		System.out.println("B: " + B);
		System.out.println("C: " + C);
	}

	private static void determineInputs() {
		for(String s : inputs){
			String ids = s.substring(0,1);
			if(ids.equals("a")){
				id[0] = true;
				noSides++;
				a = extractData(s);
			} else if(ids.equals("b")){
				id[1] = true;
				noSides++;
				b = extractData(s);
			} else if(ids.equals("c")){
				id[2] = true;
				noSides++;
				c = extractData(s);
			} else if(ids.equals("A")){
				id[3] = true;
				noAngles++;
				A = extractData(s);
			} else if(ids.equals("B")){
				id[4] = true;
				noAngles++;
				B = extractData(s);
			} else if(ids.equals("C")){
				id[5] = true;
				noAngles++;
				C = extractData(s);
			}
		}
	}
	
	private static double extractData(String s){
		try {
			return Double.parseDouble(s.substring(2));
		} catch (Exception e){
			throw new Error("Error parsing double: " +s );
		}
	}
	
	
	
	//trigonometry methods
	
	private static void determineAngle180(){
		if(!id[3]){
			if(id[4]&&id[5])
				A = (180-B-C);
		}else if (!id[4]){
			if(id[3]&&id[5])
				B = (180-A-C);
		}else if (!id[5]){
			if(id[3]&&id[4])
				C = (180-A-B);
		}
	}
	
	private static void determineAngleCos(){
		for (int i = 3; i < 6; i++){
			if(!id[i]){
				
				Math.cos(0);
				//code for angle i
				//3=A
				//4=B
				//5=C
				
				
				
				
				updateTotals();
			}
		}
	}

	private static void determineSideCos(){
		for (int i = 0; i < 3; i++){
			if(!id[i]){
				
				Math.cos(0);
				//code for side i
				//0=a
				//1=b
				//2=c
				
				
				
				
				updateTotals();
			}
		}
	}
	private static void determineSideSin(){
		for (int i = 0; i < 3; i++){
			if(!id[i]){
				
				Math.sin(0);
				//code for side i
				//0=a
				//1=b
				//2=c
				
				
				
				
				updateTotals();
			}
		}
	}
}
