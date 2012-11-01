/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

import java.util.regex.*;

/**
 * @author Murugan Nagarajan
 * @created date 24-Oct-2012 / 8:04:42 PM
 */
public class SimpleTokenizer {

	//Create Patterns..Declared static as these variables shouldn't be altered.
	static Pattern end	= Pattern.compile("\\G\\z");
	static Pattern word	= Pattern.compile("\\G\\w+");
	static Pattern punct= Pattern.compile("\\G\\p{Punct}");
	static Pattern space= Pattern.compile("\\G\\s+");
	static Pattern numb	= Pattern.compile("\\G\\d+\\.?\\d*"); //Used .? to match decimal values(. is allowed zero or once only).
	
	static String getTextToken(Matcher mat) {
		//skip the leading tokens as per the requirement
		//if required trim the spaces.		
		mat.usePattern(space);
		mat.find();
		
		//The order in which the pattern is tried on a sentence matters a lot.
		mat.usePattern(numb);
		if(mat.find()) {
			return  mat.group();
		}
		mat.usePattern(word);
		if(mat.find()) {
			return  mat.group();
		}
		mat.usePattern(punct);
		if(mat.find()) {
			return  mat.group();
		}
		/*mat.usePattern(space);
		if(mat.find()) {
			return  "\" \" Extra Spaces";
		}*/
		mat.usePattern(end);
		if(mat.find()) {
			return  "";
		}
		//In case the token is not categorized in any of the above patterns return null.
		return null;
	}
	/**
	 * 
	 */	
	public SimpleTokenizer() {
		// TODO Auto-generated constructor stub		
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String token;
		String str = "    I joined in infosys   by March 16th:2009, and working still date.         ";
		//str = str.trim();
		//Create a matcher which marks to the end of line just to pass the matcher to the getTextTokens method.
		Matcher mat = end.matcher(str);
		do {
			token =  getTextToken(mat);
			if(token == null) {
				System.out.println("Invalid Token");
				break;
			}
			if(token.length() != 0) {
				System.out.println("Token : "+token);				
			}
			else {
				System.out.println("End Of Line");				
			}			
		} while(token.length() != 0);
	}

}
