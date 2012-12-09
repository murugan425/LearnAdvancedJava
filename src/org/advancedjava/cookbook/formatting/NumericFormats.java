/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.formatting;

import java.util.Formatter;

/**
 * @author Murugan Nagarajan
 * @created date 08-Nov-2012 / 7:50:06 PM
 */
public class NumericFormats {

	/**
	 * 
	 */
	public NumericFormats() {
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
		//No of decimals..,
		fmt.format("Default Precision: %.2f\n", val1);
		fmt.format("Default Precision: %010.5f\n", val2);
		fmt.format("Default Precision: %.0f\n", val3); 
		//Group Separators..,
		fmt.format("%d\n",1234567989);
		fmt.format("%,d\n",1234567989);
		//Positive value
		fmt.format("%+,d\n",1234567989);
		fmt.format("%+,f\n",-123.456798998888);
		fmt.format("%+,g\n",-123.45679899888876798748);
		fmt.format("%(.20f\n",-123.45679899888876798748);
		System.out.println(fmt);
		System.out.println("");
		}
}
