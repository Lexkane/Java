package com.company;

import java.util.Arrays;

public class Relations {

  private int [][] rel;
  private int numberOfElements;


  public Relations( int number){

    rel = new int[number][number];
  }


  public void resetRelations(){
     for (int p=0;p<rel.length;p++)
      for (int r=0;r<rel.length;r++)
       rel[p][r]=0;

  }

  @Override
  public String toString() {
    return "Relations{" +
        "rel=" + Arrays.toString(rel) +
        ", numberOfElements=" + numberOfElements +
        '}';
  }
  public int length(){
    return rel.length;
  }

  public void printRelations(){
    for (int p=0;p<rel.length;p++) {
      for (int r = 0; r < rel.length ; r++)
        if (rel[p][r] == 1) {
          System.out.printf("Elements %d and %d have relation", p, r);
        }
    }
  }

  public void addRelation(int k,int j){
    if ((k>=0) && (j>=0)){
    rel[k][j]=1; }
    else{
      System.out.println("Not correct arguments");
    }
  }

  public int checkRelation(int k,int j) {
    if ((k >= 0 ) && (j >= 0 )) {
      return rel[k][j];
    }
    else throw  new ArrayIndexOutOfBoundsException();
  }


}
