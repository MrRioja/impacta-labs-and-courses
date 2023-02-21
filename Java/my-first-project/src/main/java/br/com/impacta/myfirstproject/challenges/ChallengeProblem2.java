package br.com.impacta.myfirstproject.challenges;

import java.util.Scanner;

public class ChallengeProblem2 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.println("Digite o número 1: ");
    int x = scan.nextInt();

    if (x % 2 == 0) {
      System.out.println("O número é par");
    } else {
      System.out.println("O número é impar");
    }

  }
}
