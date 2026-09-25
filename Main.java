package banco;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA BANCÁRIO - DEMO AULA 08 (COLLECTIONS & ORDENAÇÃO) ===\n");

        Cliente cli1 = new Cliente("Beatriz Lima", "111.111.111-11");
        Cliente cli2 = new Cliente("Carlos Drummond", "222.222.222-22");
        Cliente cli3 = new Cliente("Ana Nery", "333.333.333-33");

        ContaCorrente c1 = new ContaCorrente(3002, cli1, 500.0);
        ContaPoupanca c2 = new ContaPoupanca(1005, cli2, 0.05);
        ContaCorrente c3 = new ContaCorrente(2001, cli3, 1000.0);

        // 1. Validação de Identidade (Ponteiro vs Domínio)
        ContaCorrente cDuplicada = new ContaCorrente(3002, cli1, 200.0);
        System.out.println("c1 == cDuplicada (memória): " + (c1 == cDuplicada));
        System.out.println("c1.equals(cDuplicada) (regra de negócio): " + c1.equals(cDuplicada));
        System.out.println("Hashcode c1: " + c1.hashCode() + " | Hashcode cDuplicada: " + cDuplicada.hashCode() + "\n");

        // 2. Operações no Repositório Banco
        Banco banco = new Banco("Banco Universitário CEUB");
        banco.adicionarConta(c1);
        banco.adicionarConta(c2);
        banco.adicionarConta(c3);
        
        // Tentativa de duplicata barrada pelo contains/equals
        banco.adicionarConta(cDuplicada);

        // Depósitos de saldo
        c1.depositar(1500.0);
        c2.depositar(3200.0);
        c3.depositar(800.0);

        // 3. Relatórios com Visões Distintas de Ordenação
        banco.imprimirOrdenadoPorNumero();
        banco.imprimirOrdenadoPorTitular();
    }
}