/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.formatting;

import java.util.Formatter;

/**
 * @author Murugan Nagarajan
 * @created date 12-Nov-2012 / 8:59:58 PM
 */
public class LeftAlign {

	/**
	 * 
	 */
	public LeftAlign() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Formatter fmt = new Formatter();
		String source[] = {"Rent","Wholesale","Royalties","Retail","Interest","Patents","Investments"};
		int profit[] = {12133323,45434343,23345545,354563434,245686767,32323454,3344545};
		if(source.length == profit.length) {
			for (int i = 0; i < profit.length; i++) {
				fmt.format("%-12s  %-,12d\n",source[i],profit[i]);
			}				
		}
		System.err.println(fmt);
	}

}
