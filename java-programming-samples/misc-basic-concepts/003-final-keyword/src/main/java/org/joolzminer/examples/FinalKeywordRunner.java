package org.joolzminer.examples;

class MutablePerson {
	private String name;
	private int age;
	
	public MutablePerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
}


class ImmutablePerson {
	private final String name;
	private final int age;
	
	public ImmutablePerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}


public class FinalKeywordRunner {
	
	void modifyFinal() {
		final MutablePerson mutablePerson = new MutablePerson("sergio", 40);
		mutablePerson.setName("adrian");
		mutablePerson.setAge(5);	
		
		@SuppressWarnings("unused")
		final ImmutablePerson immutablePerson = new ImmutablePerson("sergio", 40);		
	}
}
