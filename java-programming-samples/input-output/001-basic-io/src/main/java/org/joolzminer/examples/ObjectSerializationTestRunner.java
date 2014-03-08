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
import java.util.ArrayList;
import java.util.List;


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

class LineItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String item;
	private int quantity;
	
	public LineItem(String item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "LineItem [item=" + item + ", quantity=" + quantity + "]";
	}	
}

class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private String billingAddress;
	private List<LineItem> items = new ArrayList<>();
	
	public Order(Customer customer, String billingAddress) {
		this.customer = customer;
		this.billingAddress = billingAddress;
	}
	
	public void addLineItem(LineItem lineItem) {
		items.add(lineItem);
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", billingAddress="
				+ billingAddress + ", items=" + items + "]";
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
		
		System.out.println("*** Serialization of a Complex object:");
		Order order = new Order(customer, "64 White Witch, Kansas");
		order.addLineItem(new LineItem("iBook", 2));
		order.addLineItem(new LineItem("Nexus 6", 1));
		try (	OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE);
				ObjectOutputStream oos = new ObjectOutputStream(outputStream);) {
			// write first object
			oos.writeObject(order);
		} catch (IOException e) {
			System.out.println("Error serializing object: " + e);
		}

		System.out.println("*** Deserializing of Complex Object:");
		try (	InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ);
				ObjectInputStream ois = new ObjectInputStream(inputStream);) {
			Order retrievedOrder = (Order) ois.readObject();
			
			System.out.println(retrievedOrder);
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error deserializing object: " + e);
		}
	}
}
