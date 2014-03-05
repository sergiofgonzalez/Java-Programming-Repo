package org.joolzminer.examples;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FileSystemAndPathsRunner {
	public static void main(String[] args) {
		
		System.out.println("*** FileSystem:");
		FileSystem fileSystem = FileSystems.getDefault();
		System.out.println("fileSystem.getSeparator()=" + fileSystem.getSeparator());
		System.out.println("fileSystem.getRootDirectories()=" + fileSystem.getRootDirectories());
		
		System.out.println("*** Paths:");
		Path path = fileSystem.getPath("/home/user/images");
		System.out.println("path('/home/user/images')=" + path);
		
		Path path2 = fileSystem.getPath("/home", "user", "images");
		System.out.println("path('/home', 'user', 'images')=" + path2);
		
		Path path3 = Paths.get("c:\\users\\sergio.f.gonzalez\\Documents");
		System.out.println("Paths.get('c:\\users\\sergio.f.gonzalez\\Documents')=" 
							+ path3);
		
		Path path4 = Paths.get("c:\\", "users", "sergio.f.gonzalez", "Documents");
		System.out.println("Paths.get('c:\\', 'users', 'sergio.f.gonzalez', 'Documents')=" 
							+ path4);
		
		System.out.println("path4=" + path4);
		System.out.println("path4.getRoot()=" + path4.getRoot());
		System.out.println("path4.getFileName()=" + path4.getFileName());
		System.out.println("path4.getParent()=" + path4.getParent());
		
		System.out.println("path4.getNameCount()=" + path4.getNameCount());
		for (int i = 0; i < path4.getNameCount(); i++) {
			System.out.println("path4.getName(" + i + ")=" + path4.getName(i));
		}
	}
}
