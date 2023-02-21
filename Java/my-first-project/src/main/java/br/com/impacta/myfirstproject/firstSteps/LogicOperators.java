package br.com.impacta.myfirstproject.firstSteps;

public class LogicOperators {

  public static boolean checkAnd(int x, int y) {
    return x == 10 && y != 2;
  }

  public static boolean checkOr(int x, int y) {
    return x == 10 || y != 2;
  }

  public static boolean checkNot(int x) {
    return x != 10;
  }

  public static void main(String[] args) {

    System.out.println(checkNot(10));
    System.out.println(checkNot(5) + "\n");

    System.out.println(checkOr(9, 2));
    System.out.println(checkOr(10, 2));
    System.out.println(checkOr(10, 3));
    System.out.println(checkNot(5) + "\n");

    System.out.println(checkAnd(11, 3));
    System.out.println(checkAnd(11, 2));
    System.out.println(checkAnd(10, 3));
    System.out.println(checkAnd(10, 2));
  }

}