/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

/**
 * @author Murugan Nagarajan
 * @created date 03-Nov-2012 / 1:19:41 PM
 */
public class Zipper {

	static String rmPath(String fileName) {
		int pos = fileName.lastIndexOf(File.separatorChar);
		if(pos != -1) {
			fileName = fileName.substring(pos+1);			
		}
		return fileName;
	}
	/**
	 * 
	 */
	public Zipper() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedInputStream bfin;
		ZipOutputStream zout;
		
		if(args.length < 2) {
			System.out.println("Please enter the files which needs to be zipped.");
			return;
		}
		
		try {
			zout = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(args[0])));			
		}
		catch(IOException e) {
			System.err.println("Error while opening the file that stores the zipped files.");
			return;
		}
		
		for (int i = 1; i < args.length; i++) {
			try {
				bfin = new BufferedInputStream(new FileInputStream(args[i]));
			}
			catch(IOException e) {
				System.out.println("Input file not found");
				try {
					zout.close();
				} catch (ZipException e1) {
					System.err.println("Zip File is invalid.");
				} catch (IOException e2) {
					System.out.println("Error closing the the zipped file.");
				}
				return;
			}
			ZipEntry ze = new ZipEntry(rmPath(args[i]));
			try {
				zout.putNextEntry(ze);
				int bytes;
				do {
					bytes = bfin.read();
					if(bytes!=-1) zout.write(bytes);
				} while (bytes != -1);
				zout.closeEntry();
			} catch (ZipException e1) {
				System.err.println("Zip File is invalid.");
			} catch (IOException e2) {
				System.out.println("Error closing the the zipped file.");
			}
			try {
				bfin.close();
				System.out.println("Compressing "+args[i]);
				System.out.println("Original Size "+ze.getSize());
				System.out.println("Compressed Size "+ze.getCompressedSize()+"\n");
			}
			catch(IOException e) {
				System.out.println("Error closing the the input files.");	
			}
		}
		try {
			zout.close();
		} catch (ZipException e1) {
			System.err.println("Zip File is invalid.");
		} catch (IOException e2) {
			System.out.println("Error closing the the zipped file.");
		}
	}
}
