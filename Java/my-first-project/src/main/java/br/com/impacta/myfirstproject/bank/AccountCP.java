package br.com.impacta.myfirstproject.bank;

public class AccountCP implements Account {
  private String owner;
  private double amount;
  private String accountNumber;

  @Override
  public String sacar(double amount) {
    if (amount > (this.amount)) {
      return "Saldo insuficiente";
    }

    this.amount -= amount;

    return "Você sacou " + amount + " e agora seu saldo é de " + this.amount;
  }

  @Override
  public String depositar(double amount) {
    this.amount += amount;

    return "Você depositou " + amount + " e agora seu saldo é de " + this.amount;
  }

  @Override
  public String imprimirExtrato() {
    return "Seu saldo é de " + this.amount;
  }

  @Override
  public String calcularJuros(double amount) {
    return "Os juros serão de " + this.amount * 0.05;
  }

  @Override
  public String transferir(double amount, String accountNumber) {
    if (amount > this.amount) {
      return "Saldo insuficiente para transferência";
    }

    this.amount -= amount;

    return "Você transferiu " + amount + " para a conta número " + accountNumber + " e agora seu saldo é de "
        + this.amount;
  }
}
