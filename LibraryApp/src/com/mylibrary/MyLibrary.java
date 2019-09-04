package com.mylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MyLibrary {
	
	ArrayList<Book> books;
	ArrayList<Person> persons;
	ArrayList<Book> booksgiven = new ArrayList<Book>();
	public MyLibrary(String name) {
		this.name = name ;
		this.books = new ArrayList<>();
		this.persons = new ArrayList<>();
	}
	String name;
	 public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public String getName() {
		return name;
	}

	public void addBook(Book b) {
		
	this.books.add(b);
		
	}

	public void removeBook(Book b2) {
		this.books.remove(b2);
		
	}

	public void addPerson(Person p1) {
		
		this.persons.add(p1);
	}

	public void removePerson(Person p2) {
		
		this.persons.remove(p2);
		
	}

	public boolean checkOutBook(Book book, Person person) {
		int bookCount = getBooksForPerson(person).size();
		if(book.getPerson()==null && bookCount < person.getMaxBooks()) 
		{
			book.setPerson(person);
			this.booksgiven.add(book);
			return true;
		}
		return false;
	}

	public boolean checkInBook(Book book) {
		if(book.getPerson()!=null)
		{
			book.setPerson(null);
			return true;
		}
		return false;
	}

	public ArrayList<Book> getBooksForPerson(Person person) {
		ArrayList<Book> books = new ArrayList<Book>();
		for(Book book : this.books) {
			if(book.getPerson()!=null && book.getPerson().getName().equals(person.getName()))
			books.add(book);	
		}
				
		return books;
	}

	
	public ArrayList<Book> getAvailableBooks() {
		ArrayList<Book> b = new ArrayList<Book>();
		for(Book book : this.books)
		{
			if(this.booksgiven != null && this.booksgiven.contains(book))
				continue;
			else
				b.add(book);
		}
		return b;	
		}
		
	private void getAvailableBooknames() {
		 
		for(Book book : this.books)
		{
			if(this.booksgiven != null && this.booksgiven.contains(book))
			{
				continue;
			}
			else 
			{
				System.out.println(book.getTitle());
			}
		}
		
	}
	 
	

	public ArrayList<Book> getUnAvailableBooks() {
		
		ArrayList<Book> b = new ArrayList<Book>();
		for(Book book : this.books) {
			if(this.booksgiven != null && this.booksgiven.contains(book))
			{
				b.add(book);
			}
			
		}
		return b;
	}
	
	
	@Override
	public String toString() {
		return  name + " : " +books.size() +" Books: " + persons.size() + " Persons.";
				
	}
	
	private void getRegisteredPersons() {
		for(Person person:this.persons)
		{
			System.out.println(person.getName()+" with limit "+person.getMaxBooks()+" books");
		}
		
	}


	void printStatus() {
		System.out.println("\nStatus Report of MyLibrary : "+name);
		for(Book book:this.books)
		{
			System.out.println(book);
		}
		for(Person person:this.persons) {
			int bookcount=getBooksForPerson(person).size();
			System.out.println(person+" has "+bookcount+" of MyLibrary books");
		}
		System.out.println("Books Available: "+getAvailableBooks().size());
		System.out.println("****************** Done Status ******************");
	}
	
	public static void main(String[] args)
	{
		MyLibrary myLibrary = new MyLibrary("Test Library");
		Book b1 = new Book("Learn Java");
		Book b2 = new Book("Learn Spring");
		Book b3 = new Book("Learn Hibernate");
		Person p1 = new Person();
		p1.setName("John Doe");
		Person p2 = new Person();
		p2.setName("Jane Doe");
		Person p3 = new Person();
		p3.setName("Java Guru");
		myLibrary.addBook(b1);
		myLibrary.addBook(b2);
		myLibrary.addBook(b3);
		myLibrary.addPerson(p1);
		myLibrary.addPerson(p2);
		myLibrary.addPerson(p3);
		System.out.println("\t\t\t\t***************************************Library created**********************************");
	    System.out.println("\t\t\t\t**************************NAME OF MY LIBRARY IS : "+myLibrary.name+"**************************\n");
		System.out.println("AVAILABLE BOOKS IN "+myLibrary.name+"  ARE :");
		myLibrary.getAvailableBooknames();
		System.out.println("REGISTERED PERSONS WITH LIBRARY ARE: ");
		myLibrary.getRegisteredPersons();
		myLibrary.printStatus();
		myLibrary.checkOutBook(b1, p1);
		myLibrary.printStatus();
		myLibrary.checkOutBook(b2, p1);
		myLibrary.printStatus();
		myLibrary.checkInBook(b2);
		myLibrary.checkInBook(b2);
		myLibrary.printStatus();

		
	}


	
}
