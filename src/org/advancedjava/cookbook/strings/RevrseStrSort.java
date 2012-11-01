/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

import java.util.*;

/**
 * @author Murugan Nagarajan
 * @created date 23-Oct-2012 / 9:14:11 PM
 */
//Created a class which overrides the compare method of the Comparator
//interface to compare integer value in this way...

// +ve - if the str1 is lesser than str2
// 0   - if str1 and str2 are equal
// -ve - if str1 is greater than str2

//By default this will be done in reverse order.
//This is done to sort the strings in descending order.

class RevStrComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1.compareTo(arg0);
	}
	
}

//Ignore case while comparing the strings in comparator.
class IgnoreCaseComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.compareToIgnoreCase(arg1);
	}
	
}

//Ignore case while comparing the strings in comparator.
class RevStrIgnoreCaseComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1.compareToIgnoreCase(arg0);
	}
	
}

public class RevrseStrSort {

	/**
	 * 
	 */
	public RevrseStrSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strgs[] = {"Murugan","caroline","Praba","valar","Indira","Shareek","Kalyan","Vijayan"};
		
		//Initial Order of names.
		System.out.println("Initial list of Array Strings...");
		for(String str : strgs) {
			System.out.print(str + "  ");
		}
		//Reverse sorted array of strings		
		System.out.println("\n=======================================");
		RevStrComparator rsc = new RevStrComparator();
		Arrays.sort(strgs, rsc);
		System.out.println("Sorted in Reverse Order...");
		for (String reversestr : strgs) {
			System.out.print(reversestr + "  ");
		}
		//Sorted array of strings
		System.out.println("\n=======================================");
		Arrays.sort(strgs);
		System.out.println("Sorted in Ascending order...");
		for (String ascstr : strgs) {
			System.out.print(ascstr + "  ");
		}
		//Array of strings irrespective of case.
		System.out.println("\n=======================================");
		IgnoreCaseComparator isc = new IgnoreCaseComparator();
		Arrays.sort(strgs,isc);
		System.out.println("Sorted in Ascending order insensitive to case...");
		for (String ciascstr : strgs) {
			System.out.print(ciascstr + "  ");
		}
		//Array of strings irrespective of case.
		System.out.println("\n=======================================");
		RevStrIgnoreCaseComparator rsisc = new RevStrIgnoreCaseComparator();
		Arrays.sort(strgs,rsisc);
		System.out.println("Sorted in reverse order insensitive to case...");
		for (String cirevstr : strgs) {
			System.out.print(cirevstr + "  ");
		}
	}

}
