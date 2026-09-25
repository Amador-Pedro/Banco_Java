package banco;

import java.util.Objects;

public abstract class Conta implements Comparable<Conta> {

    private int numero;
    private double saldo;
    private Cliente titular;

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor depositado deve ser maior que zero.");
        }
        this.saldo += valor;
    }

    public abstract void sacar(double valor) throws SaldoInsuficienteException;

    public abstract void imprimirExtrato();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return this.numero == conta.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numero);
    }

    @Override
    public int compareTo(Conta outra) {
        return Integer.compare(this.numero, outra.numero);
    }
}