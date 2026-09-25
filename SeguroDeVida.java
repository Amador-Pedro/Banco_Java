package banco;

public class SeguroDeVida implements Tributavel {

    private int numeroApolice;
    private Cliente titular;
    private double valorApolice;

    public SeguroDeVida(int numeroApolice, Cliente titular, double valorApolice) {
        this.numeroApolice = numeroApolice;
        this.titular = titular;
        this.valorApolice = valorApolice;
    }

    public int getNumeroApolice() {
        return numeroApolice;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getValorApolice() {
        return valorApolice;
    }

    @Override
    public double getValorImposto() {
        return 40.00 + (this.valorApolice * 0.02);
    }
}