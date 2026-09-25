package banco;

public class ContaCorrente extends Conta implements Tributavel {

    private double limite;

    public ContaCorrente(int numero, Cliente titular, double limite) {
        super(numero, titular);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido: " + valor);
        }

        double saldoDisponivel = this.getSaldo() + this.limite;

        if (valor > saldoDisponivel) {
            throw new SaldoInsuficienteException(
                "Limite insuficiente na Conta Corrente #" + this.getNumero() + 
                ". Tentativa: R$ " + valor + " | Saldo + Limite: R$ " + saldoDisponivel
            );
        }

        this.setSaldo(this.getSaldo() - valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("------------------------------------------");
        System.out.println("EXTRATO: CONTA CORRENTE #" + this.getNumero());
        System.out.println("Titular: " + this.getTitular().getNome());
        System.out.println("Saldo Real: R$ " + this.getSaldo());
        System.out.println("Limite: R$ " + this.limite);
        System.out.println("------------------------------------------");
    }

    @Override
    public double getValorImposto() {
        return 15.00;
    }
}