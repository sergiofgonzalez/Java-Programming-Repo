package org.joolzminer.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	public String address;
	
	public Customer(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
}

public class ObjectSerializationTestRunner {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\temp\\objectOutput.bin");
		Customer customer = new Customer(1, "Joe Blog", "12 West Coast");
		
		System.out.println("*** Serializing Customer + String:");
		try (	OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE);
				ObjectOutputStream oos = new ObjectOutputStream(outputStream);) {
			// write first object
			oos.writeObject(customer);
			oos.writeObject("Customer Info");
		} catch (IOException e) {
			System.out.println("Error serializing object: " + e);
		}
		
		System.out.println("*** Deserializing Customer + String:");
		try (	InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ);
				ObjectInputStream ois = new ObjectInputStream(inputStream);) {
			Customer retrievedCustomer = (Customer) ois.readObject();
			String info = (String) ois.readObject();
			
			System.out.println(info);
			System.out.println(retrievedCustomer);
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error deserializing object: " + e);
		}
	}
}
