/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.formatting;

import java.util.Formatter;

/**
 * @author Murugan Nagarajan
 * @created date 08-Nov-2012 / 7:50:06 PM
 */
public class Class1_NumericFormats {

	/**
	 * 
	 */
	public Class1_NumericFormats() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Formatter fmt = new Formatter();
		
		//Returns the current locale of the fmt object.
		System.out.println(fmt.locale());
		
		float val1 = 10.3f/3.8f;
		double val2 = 10.3/3.8;
		float val3 = (float) (10.3/3.8);
		
		fmt.format("Default Precision: %f\n", val1);
		fmt.format("Default Precision: %f\n", val2);
		fmt.format("Default Precision: %f\n", val3);
		
		fmt.format("Default Precision: %.2f\n", val1);
		fmt.format("Default Precision: %010.5f\n", val2);
		fmt.format("Default Precision: %.0f\n", val3); 
		
		System.out.println(fmt);
		}

}
