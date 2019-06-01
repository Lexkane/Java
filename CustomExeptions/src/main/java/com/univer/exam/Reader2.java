package com.univer.exam;

import java.io.Console;
import java.util.Scanner;

public class Reader2 {

  public static void main(String[] args) {

    String line=null;
    Console console = System.console();

    if (console !=null){
      Scanner scanner = new Scanner(console.reader());
      line=console.readLine();
    }

  }

}
