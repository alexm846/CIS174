/**
 *  Assignment: Getting Started - Demonstrate your comfort level with core Java concepts. 
 *  Description: Moosings - Creates some Moose objects, puts them in an array, & finds the Moose with the 
 *  tallest antlers.
 *  Author:  Alex McMahon
 */

 /**
  @author  alexanderjmcmahon
 */
package stu.yccc.cis174.amcmahon.gettingstarted;

public class Moosings {
	/** Method to find the Moose w/ the tallest antlers(winner)
	 * @param mooseArr the array of Moose objects
	 * @param numMoose the total number of Moose
	 */
	public Moose mooseFight(Moose[] mooseArr, int numMoose) {
		Moose winner = null;
		if(mooseArr.length > 0) {
			winner = mooseArr[0];
		}
		for(int i=0; i<numMoose; i++) {
			if(mooseArr[i].getAntlerHeight() > winner.getAntlerHeight()) {
				winner = mooseArr[i];
			}
		}
		return winner;
	}
	/** Method to print the array and winner
	 * @param mooseArr the array of Moose objects
	 * @param numMoose the total number of Moose
	 */
	public void printMoose(Moose[] mooseArr, int numMoose) {
		System.out.printf("%d Moose: \n", numMoose);
			for(int i=0; i<numMoose; i++) {
			System.out.println(mooseArr[i]);
			}
		System.out.println("The moose with the tallest antlers wins the moose fight.  The winner is:");
		System.out.println(mooseFight(mooseArr, numMoose).getName() + "!");	
	}
	/** Run method - creates Moose objects, calls print methods;
	 */
	public void run() {
		int numMoose = 2;
		//create Moose objects
		Moose a = new Moose("Moe", "brown", 2.0);
		Moose b = new Moose("Bullwinkle", "white", 1.5);
		
		System.out.printf("Here we have %d moose, %s and %s!\n", numMoose, a.getName(), b.getName());
		System.out.println("Let's add two more and put them in an array:");
		
		Moose c = new Moose("Shorty", "blue", 4.0);
		Moose d = new Moose("Mac", "black", 2.5);
		numMoose = 2 + 2;
		//create array
		Moose[] mooseArr = new Moose[numMoose];
		mooseArr[0] = a;
		mooseArr[1] = b;
		mooseArr[2] = c;
		mooseArr[3] = d;
		
		printMoose(mooseArr, numMoose);	
	}
	
	public static void main(String[] args) {
		Moosings go = new Moosings();
  	 	go.run();
	}
		
}
//The four pillars of OOP: Abstraction, Encapsulation, Inheritance, Polymorphism
//Abstraction refers to the ability to create representations of objects with definable and malleable 
//attributes and actions – which in effect manages complexity.
//Encapsulation refers to securing an objects private properties and while utilizing public properties 
//to employ the object – ie. the ‘class’ system.
//Inheritance refers to the ability to create ‘child’ classes built upon existing classes by inheriting
//certain properties, behavior and data.
//Polymorphism refers to being able to derive and utilize functions across parent/child classes.
