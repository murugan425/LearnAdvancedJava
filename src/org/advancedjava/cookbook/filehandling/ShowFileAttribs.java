/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.File;
import java.sql.Date;

/**
 * @author Murugan Nagarajan
 * @created date 02-Nov-2012 / 8:47:42 PM
 */
public class ShowFileAttribs {
	
	/**
	 * 
	 */
	public ShowFileAttribs() {
	}
	/**
	 * Dislays the attibutes of file whichever being provided.
	 * @param name - name of the file.
	 */
	public static void showAttibutes(String name) {
		File f;
		
		f = new File(name);
		
		if(!f.exists()) {
			System.out.println("File not found");
			return;
		}
		System.out.println("Lis of File Attributes::");
		System.out.println("========================");
		
		if(f.canRead()) System.out.println("Readable");
		if(f.canWrite()) System.out.println("Writable");
		if(f.isDirectory()) System.out.println("Is a Directory");
		if(f.isFile()) System.out.println("Is a File");
		if(f.isHidden()) System.out.println("Is Hidden");
		if(f.canExecute()) System.out.println("Is Executable");
		
		System.out.println("Last modified on "+new Date(f.lastModified()));
		System.out.println("Length :"+f.length());
	}
	/**
	 * Created on 02-Nov-2012 / 8:47:42 PM
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Please enter the file name whose attribs are required...,");
			return;
		}
		showAttibutes(args[0]);
	}
}
