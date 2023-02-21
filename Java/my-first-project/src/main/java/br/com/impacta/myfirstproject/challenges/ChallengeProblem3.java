package br.com.impacta.myfirstproject.challenges;

import java.util.Scanner;

public class ChallengeProblem3 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Informe sua idade:");
    int age = Integer.parseInt(scan.nextLine());

    if (age >= 45 && age <= 55) {
      System.out.println("Deve tomar Astrazeneca");
    } else {
      System.out.println("Deve tomar Pfizer ou Moderna");
    }

    scan.close();
  }
}
