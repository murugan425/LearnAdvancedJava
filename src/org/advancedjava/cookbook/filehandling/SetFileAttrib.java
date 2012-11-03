/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Murugan Nagarajan
 * @created date 03-Nov-2012 / 9:39:01 AM
 */
public class SetFileAttrib {

	/**
	 * 
	 */
	public SetFileAttrib() {
	}

	/**
	 * Created on 03-Nov-2012 / 9:39:02 AM
	 */
	static void rwStatus(File f) {
		if(f.canRead()) {
			System.out.println("Readable");
		}
		else {
			System.out.println("Not Readable");
		}
		if(f.canWrite()) {
			System.out.println("Writable");
		}
		else {
			System.out.println("Not Writaable");
		}
		System.out.println("Last Modified on "+new Date(f.lastModified()));
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Please enter the file name for which the attributes needs" +
					"to be modified");
			return;
		}
		File f = new File(args[0]);
		
		if(!f.exists()) {
			System.out.println("File does not exists");
			return;
		}
		System.out.println("Original Read/Write Permission and time details");
		System.out.println("===============================================");
		rwStatus(f);
		
		//Change the file attribs.
		long t = Calendar.getInstance().getTimeInMillis();
		if(!f.setLastModified(t)) {
			System.out.println("Unable to set the time attrib.");
		}
		
		if(!f.setReadOnly()) {
			System.out.println("Unable to change the read status to read-only");
		}
		
		System.out.println("Updated Read/Write Permission and time details");
		System.out.println("==============================================");
		rwStatus(f);
		
		//Make the file writable again.
		if(!f.setWritable(true,false)) {
			System.out.println("Unable to make the file writable again.");
		}
		System.out.println("Updated Read/Write Permission and time details");
		System.out.println("==============================================");
		rwStatus(f);		
	}
}
