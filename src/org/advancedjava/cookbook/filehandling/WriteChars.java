/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Murugan Nagarajan
 * @created date 30-Oct-2012 / 8:08:22 PM
 */
public class WriteChars {

	/**
	 * 
	 */
	public WriteChars() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriter fw;
		
		String[] mailIds = {"Murugan murugan425@gmail.com",
							"Mani mani.eie611@gmail.com",
							"Shiva shiva.it13@gmail.com" };
		Pattern emailPat = Pattern.compile("[\\w+\\.]+@gmail\\.com");		
		try {
			fw = new FileWriter(new File("E:\\ProgramData\\Local_Repository\\murugan425_local_v0.0\\LearnAdvancedJava\\src\\org\\advancedjava\\cookbook\\filehandling\\MyDetails.txt"));
		} catch (IOException e) {
			System.err.println("Error while creating a new file for adding the mail details");
			return;
		}
		try {			
			for (String contactEmail : mailIds) {
				Matcher emailMatch = emailPat.matcher(contactEmail);				
				if(emailMatch.find()) {
					System.out.println(emailMatch.group());
					fw.write(emailMatch.group());
					fw.write("\n");
				}
			}
			fw.write("\n\n\n");
		} catch (IOException e) {
			System.err.println("Error occurred while writing..,");
			return;
		}
		try {
			fw.close();
		} catch (IOException e) {
			System.err.println("Error occurred while closing..,");
		}
		System.out.println("Program executed successfully...,");
	}
}
