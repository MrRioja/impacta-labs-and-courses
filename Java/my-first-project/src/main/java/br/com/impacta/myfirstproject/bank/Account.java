package br.com.impacta.myfirstproject.bank;

public interface Account {
  String sacar(double amount);

  String depositar(double amount);

  String imprimirExtrato();

  String calcularJuros(double amount);

  String transferir(double amount, String accountNumber);
}
