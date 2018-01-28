package stu.yccc.cis174.amcmahon.gettingstarted;

/**
 *  Description: Moose - Describes a Moose object's properties and formats them to be printed.
 *  Author:  Alex McMahon
 */

 /**
  @author  alexanderjmcmahon
 */

public class Moose {
	//instance variables
	private String name;
	private String color;
	private double antlerHeight;

/**
	* Default Constructor
	*/ //initialize properties to default values
	public Moose() {
		name = "";
		color = "NO COLOR";
		antlerHeight = 0;
	}
	/**
	 * Initializing constructor
	 *@param name the name of the moose
	 *@param color the color of the moose
	 *@param antlerHeight the height of the moose's antlers
	 */
	public Moose(String name, String color, double antlerHeight) {
		this.name = name;
		this.color = color;
		this.antlerHeight = antlerHeight;
	}
	//getters
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}public double getAntlerHeight() {
		return antlerHeight;
	}
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setAntlerHeight(double antlerHeight) {
		this.antlerHeight = antlerHeight;
	}
	/**
 	 *Returns a string representation of the Moose 
 	 *@return String containing all of this Moose's properties
 	 **/
 	 public String toString() {
 	 	 String mooseStr = this.getName() + " the ";
 	 	 mooseStr += this.getColor() + " moose ";
 	 	 mooseStr += "has " + this.getAntlerHeight() + " foot antlers.";
 	 	 
 	 	 return mooseStr;
 	 }
	public static void main(String[] args) {
	
	}
}