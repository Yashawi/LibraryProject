package com.mylibrary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	@Test
	void testBook() {
		Book b1 = new Book("Learn Java");
		assertEquals("Learn Java", b1.title);
		assertEquals("Unknown Author", b1.author);
		
		}
	@Test
	void testGetPerson() {
		Book b2 = new Book("Learn Spring");
		Person p2 = new Person();
		p2.setName("John Doe");
		b2.setPerson(p2);
		Person testPerson = b2.getPerson();
		String name = testPerson.getName();
		assertEquals(name, p2.getName());
	}
	
	@Test
	void testToString() {
		Book b3 = new Book("Learn Sql");
		Person p3 = new Person();
		p3.setName("Java Guru");
		assertEquals("Learn Sql by Unknown Author : Available", b3.toString());
		b3.setPerson(p3);
		assertEquals("Learn Sql by Unknown Author : checked out to Java Guru", b3.toString());
	}

}
