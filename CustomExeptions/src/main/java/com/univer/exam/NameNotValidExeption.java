package com.univer.exam;

public class NameNotValidExeption extends RuntimeException{
  public NameNotValidExeption(String message){
    super(message);
    System.out.println("Name is invalid!");
  }

}
