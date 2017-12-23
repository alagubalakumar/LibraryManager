package com.library;

public interface ILibrarian {
	
	public boolean addBook(String title);
	public String lendBook(String title,String userName);
	public String returnBook(String title,String userName);
	public void addUser(String userName,int bookLimit);

}
