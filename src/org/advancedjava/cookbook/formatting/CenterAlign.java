/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.formatting;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/**
 * @author Murugan Nagarajan
 * @created date 12-Nov-2012 / 7:27:20 PM
 */
public class CenterAlign {

	/**
	 * 
	 */
	public CenterAlign() {
	}
	
	static void center(String fmtStr, Formatter fmt, Object obj, int width) {
		String str;
		try {
			//Format the data so that the actual required length can be determined.
			Formatter tmp = new Formatter();
			tmp.format(fmtStr, obj);
			str = tmp.toString();	
			tmp.close();
		}
		catch(IllegalArgumentException e) {
			System.err.println("Invalid Format Request..");
			fmt.format("");
			return;			
		}
		//Obtain the difference between the total width to know the free space available.
		int diff = width-str.length();
		if(diff<0) {
			fmt.format(str);
			return;
		}
		//Add padding to the string of the field.
		char[] pad = new char[diff/2];
		Arrays.fill(pad, ' ');
		fmt.format(new String(pad));
		
		fmt.format(str);
		
		pad = new char[width - (diff/2) - str.length()];
		Arrays.fill(pad, ' ');
		fmt.format(new String(pad));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Formatter fmt = new Formatter(Locale.FRENCH);		
		String source[] = {"Rent","Wholesale","Royalties","Retail","Interest","Patents","Investments"};
		int profit[] = {12133323,45434343,23345545,354563434,245686767,32323454,3344545};
		if(source.length == profit.length) {
			for (int i = 0; i < profit.length; i++) {
				fmt.format("|");
				center("%s",fmt,source[i],12);
				fmt.format("|");
				center("%,10d",fmt,profit[i],14);
				fmt.format("|\n");
			}
		}
		System.out.println(fmt);
	}

}
