package br.com.impacta.myfirstproject.challenges;

import java.util.Scanner;

public class ChallengeProblem1 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.println("Digite o número 1: ");
    int x = scan.nextInt();

    System.out.println("Digite o número 2: ");
    int y = scan.nextInt();

    if (x > y) {
      System.out.println("X é maior do que Y.");
    } else if (x < y) {
      System.out.println("X é menor do que Y.");
    } else {
      System.out.println("Os números são iguais.");
    }
  }
}
