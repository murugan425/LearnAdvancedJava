/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Murugan Nagarajan
 * @created date 30-Oct-2012 / 6:45:46 PM
 */
public class BuffereInputRead {

	/**
	 * 
	 */
	public BuffereInputRead() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		BufferedInputStream bufinstr;
		//Enter the file name in run time.
		if(args.length != 1) {
			System.err.println("No file name entered.");
			return;
		}
		//Open the file
		try {			
			bufinstr = new BufferedInputStream(new FileInputStream(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println("File not found exception");
			return;
		}
		//Configure the run time input parameter args[0] as 
		//{Complete File path of HexDump.java\test.txt} to read the test.txt content.
		//Read bytes and display their Hexadecimal value.
		try {
			int i;
			int count =0;
			do {				
				i =bufinstr.read();
				if (i != -1) {
					System.out.printf("%02X ", i);										
				}
				count++;
				if (count == 16) {
					System.out.println();
					count = 0;
				}
			} while (i != -1);
		} catch (IOException e) {
			System.err.println("Error Reading from the given file "+args[0]);
		}
		//Close the file
		try {			
			bufinstr.close();
		} catch (IOException e) {
			System.err.println("Error occurred while closing the file");
		}
		System.out.println("Program executed successfully...,");
	}

}
