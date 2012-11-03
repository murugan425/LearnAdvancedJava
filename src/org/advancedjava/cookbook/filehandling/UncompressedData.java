/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * @author Murugan Nagarajan
 * @created date 03-Nov-2012 / 12:56:07 PM
 */
public class UncompressedData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataOutputStream fout;
		DataInputStream fin;
		
		String filename = "E:\\ProgramData\\Local_Repository\\murugan425_local_v0.0\\LearnAdvancedJava\\src\\org\\advancedjava\\cookbook\\filehandling\\data.txt";
		double data[] = {2.2,5.56,1.68,4.68,6.57,2.5,1.35,5.98,4.3,8.9,545.5,5.5,5.64,8.65,7.63,52.3,69.5,4.321,5.98,45.25};
		if(args.length != 0) {
			System.err.println("Please enter the file name that needs to be compressed.");
			return;
		}
		try {
			fout = new DataOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the output file");
			return;
		}
		
		try {
			fout.writeInt(data.length);
			for (double d : data) {
				fout.writeDouble(d);
			}
		} catch (IOException e) {
			System.out.println("Error occurred while compressing the File");
			try {
				fout.close();
			} catch (IOException exc) {
				System.err.println("Error while closing the source file.");
			}
			return;
		}
		try {			
			fout.close();
		} catch (IOException e) {
			System.out.println("Error occurred while closing the opened files.");
		}
		try {
			fin = new DataInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Input file not found.");
			try {
				fout.close();
			} catch (IOException exc) {
				System.err.println("Error while closing the source file.");
			}
			return;
		}
		try {			
			int num = fin.readInt();
			double sum = 0;
			double d;
			System.out.print("Data: ");
			for (int i = 0; i < num; i++) {
				d = fin.readDouble();
				sum += d;
				System.out.print(d+" ");
			}
			System.out.println("\nAverage is calculated as "+sum/num);
		} catch (IOException e) {
			System.out.println("Error Reading Input file.\n"+e.getMessage());
		}
		try {
			fin.close();			
		} catch (IOException e) {
			System.out.println("Error occurred while closing the opened files.");
		}
	}

}
