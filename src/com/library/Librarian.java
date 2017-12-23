package com.library;

import com.beans.Book;
import com.beans.User;
import com.dao.BookStoreDAO;
import com.dao.IBookStore;
import com.dao.IUserDAO;
import com.dao.UserDAO;

public class Librarian implements ILibrarian{
	
	IBookStore bookStore = new BookStoreDAO();
	IUserDAO userDAO = new UserDAO();
	
	public boolean addBook(String title) {
		Book book = new Book();
		book.setTitle(title);
		bookStore.addBook(book);
		return true;
	}
	
	public String lendBook(String title,String userName) {
		Book book = new Book();
		book.setTitle(title);
		try {
			bookStore.lendBook(title, userName);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "lended successfully";
	}
	
	public String returnBook(String title,String userName) {
		Book book = new Book();
		book.setTitle(title);
		try {
			bookStore.returnBook(title, userName);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "returned successfully";
	}

	@Override
	public void addUser(String userName, int bookLimit) {
		User user = new User();
		user.setName(userName);
		user.setBooksLimit(bookLimit);
		userDAO.addUser(user);
		
	}

}
