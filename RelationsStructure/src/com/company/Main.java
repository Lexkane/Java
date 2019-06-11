package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //сканером зчитуємо число елементів
        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();
        //створюємо масив відношень
        Relations rel= new Relations(size);
        //додаємо відношення
        rel.addRelation(2,3);
        rel.addRelation(1,2);
        rel.addRelation(1,3);
        //друкуємо всі відношення
        rel.printRelations();
        //обнуляємо відношення
        rel.resetRelations();

    }
}
