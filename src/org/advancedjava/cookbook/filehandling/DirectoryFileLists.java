/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @author Murugan Nagarajan
 * @created date 03-Nov-2012 / 10:20:52 AM
 */
class ListClassFiles implements FileFilter {

	/* (non-Javadoc)
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) {
		if(f.getName().endsWith(".class")) return true;
		return false;
	}
}

/**
 * @author Murugan Nagarajan
 * @created date 03-Nov-2012 / 9:59:33 AM
 */
public class DirectoryFileLists {

	/**
	 * 
	 */
	public DirectoryFileLists() {
	}

	/**
	 * Created on 03-Nov-2012 / 9:59:33 AM
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Please enter the directory name..");
			return;
		}
		
		File dir = new File(args[0]);
		if(!dir.exists()) {
			System.out.println(args[0] + "- Directory not found.");
		}
		
		if(!dir.isDirectory()) {
			System.out.println(args[0] +"is not a directory.Please enter a directory name.");
		}
		
		File[] filelist;
		
		filelist = dir.listFiles();
		System.out.println("List of All Files.\n");
		for(File f:filelist) {
			System.out.println(f.getName());
		}
		
		ListJavaFiles listjavaf = new ListJavaFiles();  
		filelist = dir.listFiles(listjavaf);
		
		System.out.println("\n\nList of Java Source Files:\n");
		for(File f:filelist) {
			System.out.println(f.getName());
		}
		
		ListClassFiles listclassf = new ListClassFiles();  
		filelist = dir.listFiles(listclassf);
		
		System.out.println("\n\nList of Class Files:\n");
		for(File f:filelist) {
			System.out.println(f.getName());
		}
	}
}
