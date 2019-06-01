package com.univer.exam;

public class AllExeptions extends  RuntimeException {

  public AllExeptions (String message) {
    super(message);
    System.out.println("Some input is invalid!");
  }

}
