/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.formatting;

import java.util.Formatter;

/**
 * @author Murugan Nagarajan
 * @created date 12-Nov-2012 / 7:09:32 PM
 */
public class VerticalAlign {

	/**
	 * 
	 */
	public VerticalAlign() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Formatter fmt = new Formatter();
		fmt.format("%6s %12s %15s %18s %15s\n","Value","Square","Cube","Square-Root","Cube-Root");
		for(double i=10;i<=100;i+=10) {
			fmt.format("%5.0f %15.5f %15.5f %15.5f %15.5f\n",i,Math.pow(i, 2),Math.pow(i, 3),
					Math.sqrt(i),Math.cbrt(i));
		}
		System.out.println(fmt);
	}

}
