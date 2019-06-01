package com.univer.exam;

public class EmailNotValidExeption extends  RuntimeException {

  public EmailNotValidExeption(String message) {
    super(message);
    System.out.println("Email is invalid!");
  }
}
