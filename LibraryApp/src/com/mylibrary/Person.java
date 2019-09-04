package com.mylibrary;

import java.util.ArrayList;

public class Person {
	private String name;
	private int maxBooks;
	
	public Person()
	{
		this.name = "Unknown Name";
		this.maxBooks = 3;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxBooks() {
		return maxBooks;
	}

	public void setMaxBooks(int maxBooks) {
		this.maxBooks = maxBooks;
	}


	@Override
	public String toString() {
		return  getName()+" ("+getMaxBooks()+" books)";
	}

	
	

}
