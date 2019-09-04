package com.mylibrary;

public class Book {
	 String title;
	 String author;
	 Person p;

	 public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

	public Book(String title) {
		this.title = title;
		this.author ="Unknown Author";
	}

	public void setPerson(Person p2) {
		this.p = p2;
		
		
	}

	public Person getPerson() {
		
		return this.p;
	}

	@Override
	public String toString() {
		String str ="";
		if(getPerson()==null) {
			str = "Available";
		}
		else {
			str="checked out to "+getPerson().getName();
		}
		return   title + " by " +author+" : "+str;
	}
	
	
	
	

}
