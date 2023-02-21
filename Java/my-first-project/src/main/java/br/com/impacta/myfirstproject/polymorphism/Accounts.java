package br.com.impacta.myfirstproject.polymorphism;

public class Accounts {
  public static void showCalculation(MathOperation operation, double x, double y) {
    System.out.println("The result is: " + operation.calculate(x, y));
  }

  public static void main(String[] args) {
    Accounts.showCalculation(new Sum(), 5, 5);
    Accounts.showCalculation(new Subtraction(), 5, 5);
    Accounts.showCalculation(new Multiplication(), 5, 5);
    Accounts.showCalculation(new Division(), 5, 5);
  }
}
