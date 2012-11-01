/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

import java.util.regex.*;

/**
 * @author Murugan Nagarajan
 * @created date 24-Oct-2012 / 9:30:19 PM
 */
class Tokenizer {
	private Matcher mat;
	
	private static Pattern unknown 		= Pattern.compile("\\G.");
	private static Pattern EOS 		= Pattern.compile("\\G\\z");
	private static Pattern word 	= Pattern.compile("\\G\\p{Alpha}+");
	private static Pattern punct 	= Pattern.compile("\\G\\p{Punct}");
	private static Pattern space 	= Pattern.compile("\\G\\s+");
	private static Pattern number 	= Pattern.compile("\\G\\d+\\.?\\d*");
	private static Pattern kwOrIndent = Pattern.compile("\\G[\\w&&\\D]\\w*"); //Identifiers can start with alpha/_ but not digits.
	private static Pattern separator  = Pattern.compile("\\G[(){};,.\\[\\]]");
	private static Pattern singleOp = Pattern.compile("\\G[=><!~/&|%@*\\-\\+\\^]");
	private static Pattern doubleOp = Pattern.compile("\\G((<=)|(>=)|(==)|(!=)|(\\|\\|)|(\\&\\&)|(<<)|(>>)|(--)|(\\+\\+))");
	private static Pattern assignOp = Pattern.compile("\\G((\\+=)|(-=)|(\\*=)|(/=)|(<<=)|(>>=)|(\\|=)|(&=)|(\\^=)|(>>>=)|(<<<=))");
	private static Pattern tripleOp = Pattern.compile("\\G>>>");
	private static Pattern strLiteral = Pattern.compile("\\G\".*?\"");
	private static Pattern comment 	= Pattern.compile("\\G((//.*(?m)$)|(/\\*(?s).*?\\*/))");
	//?m --- switch on multi-line mode but check for end of line $ for single line comment. 
	//?s --- match all character including line terminator
	
	enum TokenType {
		WORD(word),
		PUNCTUATION(punct),
		SPACE(space),
		NUMBER(number),
		KW_OR_IDENTIFIER(kwOrIndent),
		SEPARATOR(separator),
		SINGLE_OP(singleOp),
		DOUBLE_OP(doubleOp),
		TRIPLE_OP(tripleOp),
		ASSIGN_OP(assignOp),
		STR_LITERAL(strLiteral),
		COMMENT(comment),
		END(EOS),
		UNKNOWN(unknown);
		
		Pattern pat;
		TokenType(Pattern p) {
			pat = p;
		}
	}
	
	//Holds the list of pattern using which the tokens has to be searched.
	TokenType patterns[];
	
	class Token {
		String token;
		TokenType tokenType;
	}
	
	Token currentToken;
	/*
	 * Create a default tokenizer constructor which can be used as a text tokenizer.
	 */
	Tokenizer(String str) {
		mat = unknown.matcher(str);
		TokenType textTokens[] = {
				TokenType.NUMBER,
				TokenType.WORD,
				TokenType.PUNCTUATION,
				TokenType.END,
				TokenType.UNKNOWN
		};
		patterns = textTokens;
		currentToken = new Token();
	}
	/*
	 * Create a custom Tokenizer for which the pattern list can be passed as per the requirement.
	 */
	Tokenizer(String str, TokenType[] ptns) {
		mat = unknown.matcher(str);
		TokenType[] tmpTokenType = new TokenType[ptns.length+2]; //+2 is for adding the END and UNKNOWN type.
		System.arraycopy(ptns, 0, tmpTokenType, 0, ptns.length);
		tmpTokenType[ptns.length] = TokenType.END;
		tmpTokenType[ptns.length+1] = TokenType.UNKNOWN;
		patterns = tmpTokenType;
		currentToken = new Token();
	}
	/*
	 * Returns the token and token type as a single Token object.
	 */
	public Token getToken() {
		mat.usePattern(space).find();
		for (int i = 0; i < patterns.length; i++) {
			mat.usePattern(patterns[i].pat);
			if(mat.find()) {
				currentToken.token = mat.group();
				currentToken.tokenType = patterns[i];
				break;
			}			
		}
		return currentToken;
	}

}
public class ComplexTokenizer {
	/**
	 * 
	 */
	public ComplexTokenizer() {
		// TODO Auto-generated constructor stub
	}
	
		/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tokenizer.Token t;
		String textString = "Murugan was employed in infy.He started his training from March 16,2009.The avg office hrs for infy should be 9.15 hrs";
		String prgmString = "(float pi = 3.14f;" +
				"float r = 0, h = 0, m1 = 0, m2 = 0, g = 0, a = 0, b = 0," +
				"x = 0, mass = 0, acceleration = 0, height = 0, velocity = 0;" +
				"r = 2.5f; h = 2; m1 = 4.5f; m2 = 3.2f; g = 6.4f; a = 2.2f; b = 4.7f;" +
				"x = 1.5f; mass = 3.2f; acceleration = 30.25f; height = 8; velocity = 23.3f;" +
				"// Avoid using unnecessary braces if u r too constrained about prgm size.\n"+
				"//(pi*Math.pow(r,2)) + (2*pi*r*h)\n" +
				"double Area = pi*Math.pow(r,2) + 2*pi*r*h;" +
				"//((2*m1*m2)/(m1+m2))*g)\n" +
				"double Torque = 2*m1*m2/(m1+m2)*g;" +
				"double Side = Math.sqrt(Math.pow( a, 2)+Math.pow(b, 2)-2*a*b*Math.cos(x));" +
				"double Energy = mass*(acceleration*height+Math.pow(velocity,2)/2);" +
				"		System.out.println(\"Area	:\"+Math.abs(Area));" +
				"	System.out.println(\"Torque	:\"+Torque);" +
				"	//Truncated value of Torque\n" +
				"	System.out.println(\"Torque	:\"+Math.rint(Torque));" +
				"System.out.println(\"Side	:\"+Side);" +
				"System.out.println(\"Energy	:\"+Energy);)";
		
		Tokenizer.TokenType pgmToken[] = {
				Tokenizer.TokenType.NUMBER,
				Tokenizer.TokenType.KW_OR_IDENTIFIER,
				Tokenizer.TokenType.STR_LITERAL,
				Tokenizer.TokenType.COMMENT,
				Tokenizer.TokenType.ASSIGN_OP,
				Tokenizer.TokenType.TRIPLE_OP,
				Tokenizer.TokenType.DOUBLE_OP,
				Tokenizer.TokenType.SINGLE_OP,
				Tokenizer.TokenType.SEPARATOR,
		};
		
		Tokenizer textTok = new Tokenizer(textString);		
		
		System.out.println("Tokenizing Text..............\n");
		do {
			t = textTok.getToken();
			System.out.println("Token : "+t.token+"\t TokenType :"+t.tokenType);
		} 
		while(t.tokenType != Tokenizer.TokenType.END);
		
		Tokenizer prgmTok = new Tokenizer(prgmString, pgmToken);
		System.out.println("\n\nTokenizing Program...........\n");		
		do {
			t = prgmTok.getToken();
			System.out.println("Token : "+t.token+"\t\t TokenType :"+t.tokenType);
		} 
		while(t.tokenType != Tokenizer.TokenType.END);
	}

}
