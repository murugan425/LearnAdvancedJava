/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

/**
 * @author Murugan Nagarajan
 * @created date 24-Oct-2012 / 8:49:49 AM
 */
public class IgnCaseStringRplment {

	/**
	 * 
	 */
	public IgnCaseStringRplment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		// Finding a string in a sentence.		
		String str1 = "It is a important text to be tEsted.";
		System.out.println("Ignore Case when searching...");
		System.out.println("Text to be searched is \"test\" in \""+str1+"\"");
		if(str1.matches(".*(?i)test.*")) {
			System.out.println("The string \"test\" is present in the string..\n\n\n");
		}
		// Replacing a string in a sentence
		String str2 = "Alpha beta alpha beta ALPHA beta alPHa beta";
		if(str2.matches(".*(?i)alpHa.*")) {
			System.out.println("Actual String   :::  \""+str2+"\"");
			System.out.println("The string \"alpha\" is replaced with zeta irrespective of the case..");
			String replacedstr = str2.replaceAll("(?i)alpha", "zeta");
			System.out.println("Replaced String   :::  \""+replacedstr+"\"\n\n");
		}
		// Replacing a string in a sentence
		String str3 = "Alpha beta alpha beta ALPHA beta alPHa beta";
		if("alphabet".regionMatches(true, 3, "athHAbut" , 3, 3)) {
			System.out.println("Actual String   :::  \""+str3+"\"");
			System.out.println("The string \"alpha\" is replaced with zeta irrespective of the case..");
			String replacedstr = str3.replaceAll("(?i)alpha", "zeta");
			System.out.println("Replaced String   :::  \""+replacedstr+"\"");
		}		
		}
		catch(Exception e) {
			System.out.println("Some exception occurred during string handling..."+e.getMessage());
		}
	}
}
