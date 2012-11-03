/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * @author Murugan Nagarajan
 * @created date 03-Nov-2012 / 2:53:33 PM
 */
public class Unzipper {
	
	static String getAbsolutePath(String absPath) {
		int pos = absPath.lastIndexOf(File.separatorChar);
		if(pos != -1) {
			absPath = absPath.substring(0,pos+1);			
		}
		return absPath;
	}
	/**
	 * 
	 */
	public Unzipper() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedInputStream bfin;
		BufferedOutputStream bfout;
		ZipFile zf;
		
		String absolutePath;
		
		if(args.length !=1) {
			System.err.println("Please enter the zipped file name that needs to be unzipped.");
			return;
		}
		//Open the Zip file
		try {
			zf = new ZipFile(args[0]);
			absolutePath = getAbsolutePath(zf.getName());
		} catch (ZipException e1) {
			System.out.println("Invalid zip file.");
			return;
		} catch (IOException e2) {
			System.out.println("Error opening zip file.");
			return;
		}
		//Obtain enumuration for the list of entries in the zip
		Enumeration<? extends ZipEntry> files = zf.entries();
		//Loop through each entry to decompress each
		while(files.hasMoreElements()) {
			ZipEntry ze = files.nextElement();
			System.out.println("Decompressing "+ze.getName());			
			System.out.println("Compressed Size: "+ze.getCompressedSize());
			System.out.println("UnCompressed Size: "+ze.getSize()+"\n");
		//Open the input stream to read the each entry
		try {
			bfin = new BufferedInputStream(zf.getInputStream(ze));
		} catch (ZipException e1) {
			System.out.println("Invalid zip file.");
			break;
		} catch (IOException e2) {
			System.out.println("Error opening the entry.");
			return;
		}
		//Open the output stream to write the each entry.
		try {
			bfout = new BufferedOutputStream(new FileOutputStream(absolutePath+ze.getName()));
		} catch (FileNotFoundException e) {
			System.out.println("Can't create the unzipped file.");
			try {
				bfin.close();
			} catch (IOException e2) {
				System.out.println("Error while closing the ZIP input file.");
			}
			break;
		}		
		//Decompress the entry
		try {
			int i;
			do {
				i = bfin.read();
				if(i != -1) bfout.write(i);
			} while (i!=-1);
		} catch (IOException e) {
			System.out.println("Error occurred while decompressing the entry from the zip file.");
		}
		
		//Close the output,input of the current entry
		try {
			bfout.close();
			bfin.close();
		} catch (IOException e) {
			System.out.println("Error while closing input/output file."); 
		}
		}
		//Close the zipfile which is opened intially.
		try {
			zf.close();
		} catch (IOException e) {
			System.out.println("Error while closing zip file."); 
		}		
	}
}
