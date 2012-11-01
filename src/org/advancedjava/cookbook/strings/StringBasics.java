/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

/**
 * @author Murugan Nagarajan
 * @created date 23-Oct-2012 / 8:08:03 PM
 */
public class StringBasics {

	/**
	 * 
	 */
	public StringBasics() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "alphabet";
		String str2 = "a";
		//Searching purpose
		System.out.println(str1.contains(str2));
		System.out.println(str1.endsWith(str2));
		System.out.println(str1.indexOf(str2));
		System.out.println(str1.lastIndexOf(str2));
		System.out.println(str1.startsWith(str2));
		System.out.println("--------");
		//Comparing purpose
		System.out.println(str1.compareTo("alphabet"));
		System.out.println(str1.compareTo("alpha"));
		System.out.println(str1.compareToIgnoreCase("ALPhabet"));		
		System.out.println(str1.contentEquals("alphabet"));		
		System.out.println(str1.equals("alphabet"));
		System.out.println(str1.equalsIgnoreCase("alphaBET"));
		
		
		
		
	}

}
