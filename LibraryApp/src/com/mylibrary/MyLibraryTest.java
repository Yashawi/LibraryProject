package com.mylibrary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLibraryTest {

	private Book b1;
	private Book b2;
	private Book b3;
	private Person p1;
	private Person p2;
	private Person p3;
	private MyLibrary ml;

	@BeforeEach
	void setUp() throws Exception {
		b1 = new Book("Learn Spring");
		b2 = new Book("Learn Java");
		b3 = new Book("Learn Oracle");
		p1 = new Person();
		p1.setName("John Doe");
		p2 = new Person();
		p2.setName("Jane Doe");
		p3 = new Person();
		p3.setName("Java Guru");
		ml = new MyLibrary("Test");
		
	}

	@Test
	void testMyLibrary() {
		assertEquals("Test", ml.name);
		assertTrue(ml.books instanceof ArrayList);
		assertTrue(ml.persons instanceof ArrayList);
	}
	
	@Test
	void testAddBook() {
		assertEquals(0,ml.getBooks().size());
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addBook(b3);
		assertEquals(3,ml.getBooks().size());
		assertEquals(0,ml.getBooks().indexOf(b1));
		assertEquals(2,ml.getBooks().indexOf(b3));
		ml.removeBook(b2);
		assertEquals(2,ml.getBooks().size());
		assertEquals(1,ml.getBooks().indexOf(b3));
		
		
	}
	
	@Test
	void testAddLibrary() {
		assertEquals(0,ml.getPersons().size());
		ml.addPerson(p1);
		ml.addPerson(p2);
		ml.addPerson(p3);
		assertEquals(3,ml.getPersons().size());
		assertEquals(0,ml.getPersons().indexOf(p1));
		assertEquals(2,ml.getPersons().indexOf(p3));
		ml.removePerson(p2);
		assertEquals(2,ml.getPersons().size());
		assertEquals(1,ml.getPersons().indexOf(p3));
		
	}
	
	@Test
	void testCheckOutBook()
	{
		addItems();
		assertTrue("Book did not checked out correctly",ml.checkOutBook(b1,p1));
		assertEquals("John Doe",b1.getPerson().getName());
		assertFalse("Book was already checked out",ml.checkOutBook(b1,p2));
		assertTrue("Book check in failed",ml.checkInBook(b1));
		assertFalse("Book is already checked in",ml.checkInBook(b1));
		assertFalse("Book was never checked out",ml.checkInBook(b2));
		ml.checkOutBook(b2,p2);
		assertFalse("Max Book limit reached",ml.checkOutBook(b3,p2));
		
	}

	private void addItems() {
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);
		ml.addPerson(p2);
		p2.setMaxBooks(1);
		
	}
	
	
	  @Test public void testGetBooksForPerson() 
	  { 
		  addItems();
	  assertEquals(0,ml.getBooksForPerson(p1).size());  
	  ml.checkOutBook(b1, p1);
	  ArrayList<Book> testBooks = ml.getBooksForPerson(p1);
	  assertEquals(1, testBooks.size());
	  assertEquals(0,testBooks.indexOf(b1));
	  ml.checkOutBook(b2, p1);
	  testBooks = ml.getBooksForPerson(p1);
	  assertEquals(2,testBooks.size());
	  assertEquals(1,testBooks.indexOf(b2));
	  }
	 
	  @Test
	    public void testGetAvailableBooks(){
	        addItems();
	        ArrayList<Book> testBooks = ml.getAvailableBooks();
	        assertEquals(2, testBooks.size());
	        assertEquals(1, testBooks.indexOf(b2));
	        ml.checkOutBook(b1, p1);
	        testBooks = ml.getAvailableBooks();
	        assertEquals(1, testBooks.size());
	        assertEquals(0, testBooks.indexOf(b2));
	        ml.checkOutBook(b2, p1);
	        testBooks = ml.getAvailableBooks();
	        assertEquals(0, testBooks.size());
	    }
	    
	    @Test
	    public void testGetUnAvailableBooks(){
	        addItems();
	        assertEquals(0,ml.getUnAvailableBooks().size());
	        ml.checkOutBook(b1, p1);
	        ArrayList<Book> testBooks = ml.getUnAvailableBooks();
	        assertEquals(1, testBooks.size());
	        assertEquals(0, testBooks.indexOf(b1));
	        ml.checkOutBook(b2,p1);    
	        testBooks = ml.getUnAvailableBooks();
	        assertEquals(2, testBooks.size());
	        assertEquals(1, testBooks.indexOf(b2));
	    }
	    
	    @Test
	    public void testToString(){
	        addItems();
	        assertEquals("Test : 2 Books: 2 Persons.",ml.toString());
	    }

}
