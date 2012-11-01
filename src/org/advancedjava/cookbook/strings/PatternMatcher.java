/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

import java.util.regex.*;

/**
 * @author Murugan Nagarajan
 * @created date 24-Oct-2012 / 6:58:29 PM
 */
public class PatternMatcher {

	/**
	 * 
	 */
	public PatternMatcher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Make use of Pattern Matcher to extract the email Id's.
		String employeeDetails = "Murugan Murugan@infosys.com, " +
				"Caroline Caroline@infosys.com\n" +
				"Deepthi Deepthi_lobo@infosys.com, " +
				"Nalini Nalini_dhanvantha@infosys.com";
		Pattern pat = Pattern.compile("\\b\\w+@infosys\\.com\\b");
		Matcher match = pat.matcher(employeeDetails);
		int i=0;
		while (match.find()) {
			System.out.println("Employee Mail Id #"+(++i)+" :::   "+match.group());
		}
	}

}
