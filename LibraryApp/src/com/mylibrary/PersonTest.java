package com.mylibrary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPerson() {
		Person p1 = new Person();
		assertEquals("Unknown Name", p1.getName());
		assertEquals(3, p1.getMaxBooks());
	}

	@Test
	void testSetName() {
		Person p2 = new Person();
		p2.setName("John Doe");
		assertEquals("John Doe", p2.getName());
	}

	@Test
	void testSetMaxBooks() {
		Person p3 = new Person();
		p3.setMaxBooks(10);
		assertEquals(10, p3.getMaxBooks());
	}
	
	@Test
	void testToString() {
		Person p4 = new Person();
		p4.setName("Jane Doe");
		p4.setMaxBooks(5);
		String str = "Jane Doe (5 books)";
		assertEquals(str,p4.toString());
	}

}
