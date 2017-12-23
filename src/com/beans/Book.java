package com.beans;

public class Book {
	
	private String title;
	private String author;
	private String user;
	private boolean islend = false;
	

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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public boolean islend() {
		return islend;
	}
	public void setlend(boolean islend) {
		this.islend = islend;
	}
	
	

}
