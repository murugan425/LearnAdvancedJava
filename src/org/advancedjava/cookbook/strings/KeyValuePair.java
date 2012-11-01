/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.strings;

import java.util.regex.PatternSyntaxException;
/**
 * @author Murugan Nagarajan
 * @created date 24-Oct-2012 / 4:45:44 PM
 */
//Creation of Key Value Pair object.
class KVPair {
	String key;
	String value;
	public KVPair(String k,String v) {
		key = k;
		value = v;
	}
}
//Create exception for KVPAir class.
@SuppressWarnings("serial")
class KVPairSplitException extends Exception {
	public KVPairSplitException() {
		System.out.println("Exception occurred while splitting the key value pair.\n" +
				"Please make sure that the KeyValue pair string is of proper format.\n" +
				"Sample Format: \"Key1:Value1,Key2:Value2,Key3:Value3,Key4:Value4\"");
	}
}
//Class created to split the key:value pairs from the given string.
class KVSplit {
	/*
	 * String : String to be splitted.
	 * pairSep: The separator regex pattern between each Key Value Pairs.
	 * kvSep  : The separator regex pattern between each Key and Value.
	 */
	public static KVPair[] getKVPairs(String str, String pairSep, String kvSep) 
		throws PatternSyntaxException, KVPairSplitException {
		str = str.trim();
		String[] kvStrings = str.split(pairSep);
		KVPair[] kvpairs = new KVPair[kvStrings.length];
		
		String[] tmp ;
		for (int i = 0; i < kvStrings.length; i++) {
			tmp = kvStrings[i].split(kvSep);
			if(tmp.length != 2) throw new KVPairSplitException();
			kvpairs[i] = new KVPair(tmp[0], tmp[1]);
		}
		return kvpairs;
	}
}
public class KeyValuePair {

	public KeyValuePair() {
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		String testStr = "Name:Murugan ; Employer:Infosys; DOB:22-Mar-1987; Emp#:126440";
		System.out.println("Key/Value String : "+testStr);
		KVPair kvpairs[];
		try {
			kvpairs = KVSplit.getKVPairs(testStr, "\\s*;\\s*", "\\s*:\\s*");
		}
		catch(PatternSyntaxException exc) {
			System.out.println("Invalid separator pattern between the keys");
			return;
		}
		catch(KVPairSplitException exc) {
			System.out.println("Error occurred while splitting the key & value");
			return;
		}
		for (KVPair kvPair : kvpairs) {
			System.out.println("Key : "+kvPair.key+"\t Value  :"+kvPair.value);
		}
	}
}
