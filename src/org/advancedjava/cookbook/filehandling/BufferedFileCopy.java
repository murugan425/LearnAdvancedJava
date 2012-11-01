/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Murugan Nagarajan
 * @created date 30-Oct-2012 / 6:19:59 PM
 */
public class BufferedFileCopy {

	/**
	 * 
	 */
	public BufferedFileCopy() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedInputStream bufinstream;
		BufferedOutputStream bufoutstream;
		
		if (args.length !=2 ) {
			System.err.println("Please enter the complete path of the source and destination file");
			return;
		}
		
		try {
			bufinstream = new BufferedInputStream(new FileInputStream(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println("Input Source File not found");
			return;
		}
		
		try {
			bufoutstream = new BufferedOutputStream(new FileOutputStream(args[1]));
		} catch (FileNotFoundException e) {
			System.err.println("Output Destination File not found");
			try {
				bufinstream.close();
			} catch (IOException exc1) {
				System.err.println("Error occurred while closing the input file");
			}
			return;			
		}
		try {
			int i;
			do {
				i = bufinstream.read();
				if (i != -1) {
					bufoutstream.write(i);					
				}				
			} while (i != -1);
		} catch (IOException e) {
			System.err.println("Error occurred while copying from source file to destination file.");
		}
		
		//Close both source and destination file.
		try {
			bufinstream.close();
		} catch (IOException exc1) {
			System.err.println("Error occurred while closing the input file");
		}
		try {
			bufoutstream.close();
		} catch (IOException exc1) {
			System.err.println("Error occurred while closing the input file");
		}
		System.out.println("Program executed successfully...,");
	}
}
