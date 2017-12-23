package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beans.Book;
import com.beans.User;

class DataStore
{
 
 private static DataStore dataStore = null;
 private Map<String,List<Book>> bookMap = new HashMap<>();
 private Map<String, User> userMap = new HashMap<>();


 private DataStore()
 {
 }

 
 public static DataStore getInstance()
 {
     if (dataStore == null)
    	 dataStore = new DataStore();

     return dataStore;
 }


public Map<String, List<Book>> getBookMap() {
	return bookMap;
}


public void setBookMap(Map<String, List<Book>> bookMap) {
	this.bookMap = bookMap;
}


public Map<String, User> getUserMap() {
	return userMap;
}


public void setUserMap(Map<String, User> userMap) {
	this.userMap = userMap;
}
}
