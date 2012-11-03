/**
 * LearnAdvancedJava
 */
package org.advancedjava.cookbook.filehandling;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Murugan Nagarajan
 * @created date 03-Nov-2012 / 10:01:06 AM
 */
public class ListJavaFiles implements FileFilter {
	public boolean accept(File f) {
		if(f.getName().endsWith(".java")) return true;
		return false;
	}
}
