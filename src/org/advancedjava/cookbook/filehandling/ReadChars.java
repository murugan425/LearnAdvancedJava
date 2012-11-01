/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.*;
/**
 * @author Murugan Nagarajan
 * @created date 30-Oct-2012 / 7:33:06 PM
 */
public class ReadChars {

	/**
	 * 
	 */
	public ReadChars() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader filerdr;
		//Enter the file name in run time.
		if(args.length != 1) {
			System.err.println("No file name entered.");
			return;
		}
		//Open the file.
		try {
			filerdr = new FileReader(args[0]);
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
			return;
		}
		//Read the content and print it in a char format.
		try {
			int ch;
			//int count=0;
			do {
				ch = filerdr.read();
				if(ch != -1) {
					System.out.print((char) ch);
				}
				/*count++;
				if (count == 40) {
					System.out.println();
					count = 0;
				}*/
			} while (ch != -1);
		} catch (IOException e) {
			System.out.println("Error Reading File..,");
		}
		//Close the file
		try {
			filerdr.close();
		} catch (IOException e) {
			System.err.println("Error Closing File..,");
		}
		System.out.println("Program executed successfully...,");
	}
}
