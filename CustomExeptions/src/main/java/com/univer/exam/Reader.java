package com.univer.exam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

  public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

  //Name should not contain numbers
  public static boolean isNameValid(String name) {
    if (name.matches(".*\\d.*")) {
      return false;
    } else {
      return true;
    }
  }

  //password should be at least 8 characters long
  public static boolean isPasswordValid(String password) {
    if (password.length() < 8) {
      return false;
    } else {
      return true;
    }
  }

  //email should follow email pattern
  public static boolean isEmailvalid(String email) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
    return matcher.find();
  }

  //Custom validator function which uses disjunction and outputs false if any validation doesn't pass
  public static boolean validator(List<String> userInput)  throws EmailNotValidExeption,NameNotValidExeption,PasswordNotValidExeption{
    if (!isNameValid(userInput.get(0))) throw new NameNotValidExeption("Name is Invalid");
    if (!isPasswordValid(userInput.get(1))) throw new PasswordNotValidExeption("Password is Invalid");
    if (!isEmailvalid(userInput.get(2))) throw new EmailNotValidExeption("Email is Invalid");
      return true;
    }


  public static void main(String[] args) {
    List<String> userInput = new ArrayList<String>();
    System.out.println("Enter your username,password and email with space delimiter");
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    StringTokenizer stringTokenizer = new StringTokenizer(line);

    while (stringTokenizer.hasMoreTokens()) {
      String token = stringTokenizer.nextToken();

      try {
        userInput.add(token.toString());
      } catch (Exception e) {
        System.out.println("Something went wrong!");
      }
    }

    //Validate user input
    try {
       validator(userInput);
     }
    //Catch exeptions
    catch (EmailNotValidExeption | NameNotValidExeption | PasswordNotValidExeption ex) {
      ex.printStackTrace();
    }


    for (String token : userInput) {
      System.out.printf(" User entered from console %s \n", token);
    }
  }
}
