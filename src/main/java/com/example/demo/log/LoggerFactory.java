package com.example.demo.log;

public class LoggerFactory {

	  private LoggerFactory() {

	  }

	  public static Logger getLogger(LoggerType loggerType) {
	    Logger logger;

	    switch (loggerType) {
	      case DATABASE:
	        logger = DatabaseLogger.getInstance();
	        break;
	      default:
	        logger = FileLogger.getInstance();
	    }
	    return logger;
	  }

	  public enum LoggerType {
	    DATABASE, FILE;
	  }

	}