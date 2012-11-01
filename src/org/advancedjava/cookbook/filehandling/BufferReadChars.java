/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Murugan Nagarajan
 * @created date 30-Oct-2012 / 7:59:52 PM
 */
public class BufferReadChars {

	/**
	 * 
	 */
	public BufferReadChars() {
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
			int count;
			char chrs[] = new char[20];
			do {
				count = filerdr.read(chrs);
				for(int i=0; i<count; i++) {
					System.out.print(chrs[i]);
				}
				System.out.println();
			} while (count != -1);
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
