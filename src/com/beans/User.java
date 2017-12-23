package com.beans;

public class User {
	
	private String name;
	private String[] booksTaken = new String[10];
	private int booksLimit;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getBooksTaken() {
		return booksTaken;
	}
	public void setBooksTaken(String[] booksTaken) {
		this.booksTaken = booksTaken;
	}
	public int getBooksLimit() {
		return booksLimit;
	}
	public void setBooksLimit(int booksLimit) {
		this.booksLimit = booksLimit;
		
	}

}
