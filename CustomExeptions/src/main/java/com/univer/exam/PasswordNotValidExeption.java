package com.univer.exam;

public class PasswordNotValidExeption extends  RuntimeException{
  public PasswordNotValidExeption (String message){
    super(message);
    System.out.println("Password is invalid!");
  }
}
