package br.com.impacta.myfirstproject.animal;

public class Main {
  public static void main(String[] args) {

    Animal[] animals = new Animal[10];

    animals[0] = new Man();
    animals[1] = new Cat();
    animals[2] = new Dog();
    animals[3] = new Man();
    animals[4] = new Cat();
    animals[5] = new Dog();
    animals[6] = new Man();
    animals[7] = new Cat();
    animals[8] = new Dog();
    animals[9] = new Man();

    for (Animal animal : animals) {
      System.out.println(animal.speak());
    }
  }
}
