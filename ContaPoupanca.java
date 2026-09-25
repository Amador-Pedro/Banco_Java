package banco;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca(int numero, Cliente titular, double taxaRendimento) {
        super(numero, titular);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido: " + valor);
        }

        if (valor > this.getSaldo()) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente na Conta Poupança #" + this.getNumero() + 
                ". Tentativa: R$ " + valor + " | Saldo Atual: R$ " + this.getSaldo()
            );
        }

        this.setSaldo(this.getSaldo() - valor);
    }

    public void renderJuros() {
        double rendimento = this.getSaldo() * this.taxaRendimento;
        this.setSaldo(this.getSaldo() + rendimento);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("------------------------------------------");
        System.out.println("EXTRATO: CONTA POUPANÇA #" + this.getNumero());
        System.out.println("Titular: " + this.getTitular().getNome());
        System.out.println("Saldo Real: R$ " + this.getSaldo());
        System.out.println("------------------------------------------");
    }
}