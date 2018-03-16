package com.example.model;

public class Server {

	String name;
    int capacity;
    int id;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Server(String name, int capacity, int id) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.id = id;
	}
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
