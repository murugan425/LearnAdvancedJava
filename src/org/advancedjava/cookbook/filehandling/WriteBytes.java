/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Murugan Nagarajan
 * @created date 30-Oct-2012 / 5:51:08 PM
 */
public class WriteBytes {

	/**
	 * 
	 */
	public WriteBytes() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte byteValue[] = {43, 52, 33, 11, 34, 45, 87, 66, 79, 01, 33, 21};
		
		FileOutputStream foutstr ;
		//Enter the file name in run time.
		if(args.length != 1) {
			System.err.println("No file name entered.");
			return;
		}
		//Open the file.
		try {
			foutstr = new FileOutputStream(args[0]);
			//Append the output to the exiting content of the file
			//foutstr = new FileOutputStream(args[0], true);
		} catch (FileNotFoundException e) {
			System.err.println("Error while opening the file.");
			return;
		}
		//Write the byte data from the byteValue array in the file.
		try {
			//Write the bytes individually.
			/*for (int i = 0; i < byteValue.length; i++) {			
				foutstr.write(byteValue[i]);
			}*/
			//Write the complete array in a single go...
			foutstr.write(byteValue);
		} catch (IOException e) {
			System.err.println("Error occurred while Writing the data in the File");
		}
		//Close the file
		try {
			foutstr.close();
		} catch (IOException e) {
			System.err.println("Error occurred while closing the file");
		}
		System.out.println("Program executed successfully...,");
	}
}
