/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Murugan Nagarajan
 * @created date 02-Nov-2012 / 7:50:04 PM
 */
public class RandomAccessReverseFiles {

	/**
	 * 
	 */
	public RandomAccessReverseFiles() {
	}

	/**
	 * Created on 02-Nov-2012 / 7:50:04 PM
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Please enter the file which needs to be reversed...");
			return;
		}
		RandomAccessFile rafile;
		try {
			rafile = new RandomAccessFile(args[0], "rw");
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find the file mentioned in runtime");
			return;
		}
		try {
			int x, y;
			
			for(long i=0, j=rafile.length()-1; i<j;i++,j--) {
				rafile.seek(i);
				x = rafile.read();
				rafile.seek(j);
				y = rafile.read();
				System.out.println("X::::" +(char)x+"      Y::::" +(char)y);
				rafile.write(x);
				rafile.seek(i);
				rafile.write(y);				
			}
		} catch (IOException e) {
			System.err.println("Error occurred while trying to reverse it's content's");
			return;
		}
		try {
			rafile.close();
		} catch (IOException e) {
			System.err.println("Error on closing the file");
		}
		System.out.println("Program executed successfully...");
	}
}
