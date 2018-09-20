package com.example.demo.log;

public class FileLogger implements Logger {

	  private static FileLogger instance = null;
		
	  private FileLogger() {
	  
	  }
	 
	  public static FileLogger getInstance() {
	      if (instance == null) {
	          instance = new FileLogger();
	      }
	      return instance;
	  }
	  
	  @Override
	  public void log(String message) {
	    System.out.println("Logging to file: " + message);
	  }

	}