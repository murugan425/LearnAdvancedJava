/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		try {
			fw = new FileWriter(new File("E:\\ProgramData\\Git_Repository\\murugan425_git_V0.0\\LearnJavaBasics\\src\\org\\java\\cookbook\\filehandling\\MyDetails.txt"), true);
		} catch (IOException e) {
			System.err.println("Error while creating a new file for adding the mail details");
			return;
		}
		try {
			for (String contactEmail : mailIds) {
				fw.write(contactEmail);
				fw.write("\n");
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
