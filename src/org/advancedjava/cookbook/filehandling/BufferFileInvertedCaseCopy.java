/**
 * LearnJavaBasics
 */
package org.advancedjava.cookbook.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Murugan Nagarajan
 * @created date 30-Oct-2012 / 9:07:14 PM
 */
public class BufferFileInvertedCaseCopy {

	/**
	 * 
	 */
	public BufferFileInvertedCaseCopy() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br;
		BufferedWriter bw;
		
		if(args.length != 2) {
			System.err.println("Please enter the complete path of the source file " +
					"and destination file...");
			return;
		}
		try {
			br = new BufferedReader(new FileReader(args[0]));
		} catch (IOException e) {
			System.err.println("Error while opening source file");
			return;
		}

		try {
			bw = new BufferedWriter(new FileWriter(args[1]));
		} catch (IOException e) {
			System.err.println("Error while opening destination file");
			try {
				br.close();
			} catch (IOException exc) {
				System.err.println("Error while closing the source file");				
			}
			return;
		}
		
		try {
			int i;			
			do {
				i = br.read();
				if(i != -1) {
					if(Character.isUpperCase((char) i)) {
						bw.write(Character.toLowerCase((char) i));
					}
					else if(Character.isLowerCase((char) i)) {
						bw.write(Character.toUpperCase((char) i));
					}
					else {
						bw.write((char) i);
					}
				}
			} while (i!=-1);			
		} catch (IOException e) {
			System.err.println("Error while copying..,");
		}		
		try {
			br.close();
		} catch (IOException exc) {
			System.err.println("Error while closing the input file");
			return;
		}
		
		try {
			bw.close();
		} catch (IOException exc) {
			System.err.println("Error while closing the output file");			
			return;
		}
		System.out.println("Program executed successfully...,");
	}
}
