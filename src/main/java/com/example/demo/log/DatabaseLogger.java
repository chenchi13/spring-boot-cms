package com.example.demo.log;

public class DatabaseLogger implements Logger {

	  private static DatabaseLogger instance = null;
	
	  private DatabaseLogger() {
	  
	  }
	 
	  public static DatabaseLogger getInstance() {
	      if (instance == null) {
	          instance = new DatabaseLogger();
	      }
	      return instance;
	  }
	  
	  
	  @Override
	  public void log(String message) {
	    System.out.println("Logging to database: " + message);
	  }

	}