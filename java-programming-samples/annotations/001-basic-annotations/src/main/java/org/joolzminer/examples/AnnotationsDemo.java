package org.joolzminer.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.joolzminer.examples.annotation.Author;

public class AnnotationsDemo {
	
	public static void printClassInfo(Class<?> c) {
		System.out.print(c.getName() + " : ");
		Author author = c.getAnnotation(Author.class);
		if (author != null) {
			System.out.println(author.lastName() + ", " + author.firstName());
		} else {
			System.out.println("(unknown)");
		}
	}
	
	public static void printMethodInfo(Class<?> c) {
		System.out.print(c.getName() + ".");
		Constructor<?>[] ctors = c.getConstructors();
		for (Constructor<?> ctor : ctors) {
			System.out.print(ctor + ":");
			Author author = ctor.getAnnotation(Author.class);
			System.out.println(author == null ? "(unknown)" : author.lastName() + ", " + author.firstName());
		}
				
		for (Method method : c.getMethods()) {
			System.out.print(c.getName() + "." + method + " : ");
			Author author = method.getAnnotation(Author.class);
			System.out.println(author == null ? "(unknown)" : author.lastName() + ", " + author.firstName());						
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Reading @Author at type level: ");
		printClassInfo(Customer.class);
		printClassInfo(Employee.class);
		
		System.out.println("*** Reading @Author at method/constructor level: ");
		printMethodInfo(Customer.class);
		printMethodInfo(Employee.class);
		
		
	}
}
