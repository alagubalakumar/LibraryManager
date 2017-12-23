package com.dao;

import com.beans.Book;

public interface IBookStore {
	
	public boolean addBook(Book book);
	public Book lendBook(String title,String userName) throws Exception;
	boolean returnBook(String title,String userName) throws Exception;

}
