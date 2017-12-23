package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.beans.Book;
import com.beans.User;

public class BookStoreDAO implements IBookStore{

	private Map<String,List<Book>> bookMap = DataStore.getInstance().getBookMap();


	public boolean addBook(Book book) {

		if(book == null) {
			return false;
		}
		List<Book> bookList = null;
		if(bookMap.containsKey(book.getTitle())) {
			bookList = bookMap.get(book.getTitle());
		}else {
			bookList =  new ArrayList<>();
		}
		bookList.add(book);
		bookMap.put(book.getTitle(), bookList);

		return true;
	}

	public Book lendBook(String title,String userName) throws Exception {

		if(!bookMap.containsKey(title)) {
			throw new Exception("No Books found in this title"+title);
		}

		List<Book> bookList = bookMap.get(title);
        
		User user = DataStore.getInstance().getUserMap().get(userName);
		checkUserLimit(user,title);
		if(!bookList.isEmpty()) {
			int bookIndex = getBookIndexNotLended(bookList);
			if(bookIndex == -1) {
				throw new Exception("Books that with title("+title+") already lended,No books is in the rack");
			}
			Book book = bookList.get(bookIndex);

			book.setlend(true);
			book.setUser(userName);
			bookList.add(bookIndex, book);
			bookMap.put("title", bookList);
			
			user.setBooksTaken(ArrayUtils.add(user.getBooksTaken(), title));
			return book;


		}else {
			throw new Exception("Books that with title("+title+") already lended,No books is in the rack");
		}

	}

	public boolean returnBook(String title,String userName) throws Exception {

		if(!bookMap.containsKey(title)) {
			throw new Exception("No Books rack found in this title,please add as new book to the book rack!..");
		}

		List<Book> bookList = bookMap.get(title);
		 
		User user = DataStore.getInstance().getUserMap().get(userName);
		user.setBooksTaken(ArrayUtils.removeElement(user.getBooksTaken(), title));
		int bookIndex = getUserBookIndex(bookList,userName);
		if(bookIndex == -1) {
			throw new Exception("User Name and book title not matching!..");
		}
		Book book = bookList.get(bookIndex);

		book.setlend(false);
		book.setUser(null);
		bookList.add(bookIndex, book);
		bookMap.put("title", bookList);
		return true;
	}
	
	

	private boolean checkUserLimit(User user,String title) throws Exception {
		String[] bookList = user.getBooksTaken();
		
		for (int i = 0; i < bookList.length; i++) {
			if(title.equalsIgnoreCase(bookList[i])) {
				throw new Exception("user already taken this book");
			}
		}
		return false;
	}
	

	private int getUserBookIndex(List<Book> bookList,String userName) {
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if(book.getUser().equalsIgnoreCase(userName)) {
				return i;
			}
		}

		return -1;
	}

	private int getBookIndexNotLended(List<Book> bookList) {

		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if(!book.islend()) {
				return i;
			}
		}

		return -1;
	}

}
