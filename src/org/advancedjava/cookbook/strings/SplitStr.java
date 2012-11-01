/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

/**
 * @author Murugan Nagarajan
 * @created date 24-Oct-2012 / 12:31:20 PM
 */
public class SplitStr {

	/**
	 * 
	 */
	public SplitStr() {
		// TODO Auto-generated constructor stub
	}
	
	static void printSplitedString(String[] args) {
		for (String str : args) {
			System.out.println(str);
		}
		System.out.println("\n");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result[];
		
		//Split at spaces.
		String testStr1 = "Murugan, Mani, Nalini and Deepthi.";
		System.out.println("Original string :"+testStr1);
		result = testStr1.split("\\s+");
		System.out.println("Split at spaces :::\\s+");
		printSplitedString(result);
		
		//Split at word boundaries.
		String testStr2 = "Murugan,Mani,Nalini and Deepthi.";
		System.out.println("Original string :"+testStr2);
		result = testStr2.split("\\W+");
		System.out.println("Split at word boundaries :::\\W+");
		printSplitedString(result);
		
		//Split string on commas and zero or more spaces.
		String testStr3 = "Murugan, Mani,Nalini   and Deepthi.";
		System.out.println("Original string :"+testStr3);
		result = testStr3.split(",\\s*");
		System.out.println("Split at commas :::,\\s*");
		printSplitedString(result);
				
		//Split at word boundaries, but allow embedded periods and @.
		String testStr4 = "Murugan Murugan425@gmail.com deepthi deepthi_lobo@gmail.com";
		System.out.println("Original string :"+testStr4);
		result = testStr4.split("[\\W && [^.@]]");
		System.out.println("Split at word boundaries but allow . and @ :::[\\W && [^.@]]");
		printSplitedString(result);
		
		//Split at punctuation marks and zero or more spaces.
		String testStr5 = "This,- is.:)( a test???? sentence used.::::.,/ for spliting,,, sentences.";
		System.out.println("Original string :"+testStr5);
		result = testStr5.split("[.,!)?:;]+\\s*");
		System.out.println("Split at various punctuation :::[.,!?:;]+\\s*+");
		printSplitedString(result);
		
	}

}
