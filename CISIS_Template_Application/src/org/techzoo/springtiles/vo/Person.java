package org.techzoo.springtiles.vo;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name, email;
	private int age;
	
	public Person(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	@Override
	public String toString()
	{ 
		return String.format(
			"Person [name = %s, email = %s, age = %d]", 
				name, email, age);
	}
	
	public static List<Person> createPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Tousif", "tousif@mail.com", 32));
		persons.add(new Person("Asif", "asif@mail.com", 28));
		persons.add(new Person("Ramiz", "ramiz@mail.com", 26));
		persons.add(new Person("Rizwan", "rizwan@mail.com", 32));
		persons.add(new Person("Amol", "amol@mail.com", 33));
		persons.add(new Person("Ramdas", "ramdas@mail.com", 31));
		return persons;
	}
}

