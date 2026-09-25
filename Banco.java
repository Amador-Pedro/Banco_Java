package banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Banco {

    private String nome;
    private Map<integer, Conta> contasPorNumero;

    private Set<Cliente> clientesCadastrados;

    public Banco(String nome) {
        this.nome = nome;
        this.contasPorNumero = new HashMap<>();
        this.clientesCadastrados = new HashSet<>();
    }

    public void adicionarConta(Conta c) {
        if (c == null) {
            throw new IllegalArgumentException("Conta não pode ser nula.");
        }
        if (this.contasPorNumero.containskey(c.getNumero())) {
            System.err.println("Aviso: Conta número " + c.getNumero() + " já cadastrada. Registro ignorado.");
            return;
        }
        this.contasPorNumero.put(c.getNumero(), c);
    }

    public Conta buscarPorNumero(int numero) {
        for (Conta c : this.contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    public void listarContas() {
        System.out.println("=== CONTAS CADASTRADAS (ORDEM DE INSERÇÃO) - " + this.nome.toUpperCase() + " ===");
        
        for(Conta c : this.contasPorNumero.values()){
            System.out.println("Número:" + c.getNumero() + "|Titular:" + c.getTitular().getNome() + "|Saldo: R$" + c.getSaldo());
        }
    }

    public void imprimirTodosExtratos() {
        System.out.println("=== EXTRATOS CONSOLIDADOS - " + this.nome.toUpperCase() + " ===");
        
        for (Cliente cliente : this.clientesCadastrados) {
            System.out.println(cliente);
        }
    }

    public void imprimirOrdenadoPorNumero() {
        System.out.println("\n=== EXTRATOS ORDENADOS POR NÚMERO DA CONTA (ORDEM NATURAL) ===");
        List<Conta> ordenadas = new ArrayList<>(this.contas);
        Collections.sort(ordenadas);
        for (Conta c : ordenadas) {
            c.imprimirExtrato();
        }
    }

    public void imprimirOrdenadoPorTitular() {
        System.out.println("\n=== EXTRATOS ORDENADOS POR TITULAR (ORDEM ALFABÉTICA) ===");
        List<Conta> ordenadas = new ArrayList<>(this.contasPorNumero);
        ordenadas.sort(new TitularContaComparator());
        for (Conta c : ordenadas) {
            c.imprimirExtrato();
        }
    }

    public void exibirMapeamentoChaveValor(){
        System.out.println("\n=== Mapeamento Chave-Valor ===");

        this.contasPorNumero.forEach(numero, conta); ->(
        System.out.println("Chave: " + numero + "|Saldo: R$ " + conta.getsaldo());
        )
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return Collections.unmodifiableList(this.contas);
    }
}