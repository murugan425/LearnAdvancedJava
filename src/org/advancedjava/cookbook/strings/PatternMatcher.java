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
				"Caroline Caroline@infosys.com" +
				"Mani Mani.eie611@gmail.com" +
				"Deepthi Deepthi_lobo@infosys.com" +
				"Nalini Nalini_dhanvantha@infosys.com" +				
				"Shiva Shiva.it13@gmail.com" ;
		Pattern inftEmailPat = Pattern.compile("[\\w+\\.]+@infosys\\.com");
		Pattern gmailEmailPat = Pattern.compile("[\\w+\\.]+@gmail\\.com");
		Matcher infyMatch = inftEmailPat.matcher(employeeDetails);
		Matcher gmailMatch = gmailEmailPat.matcher(employeeDetails);
		int i=0;
		while (infyMatch.find()) {
			System.out.println("Employee Mail Id #"+(++i)+" :::   "+infyMatch.group());
		}
		while (gmailMatch.find()) {
			System.out.println("Employee Mail Id #"+(++i)+" :::   "+gmailMatch.group());
		}	
	}

}
