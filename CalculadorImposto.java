package banco;

public class CalculadorImposto {

    private double totalImpostos;

    public CalculadorImposto() {
        this.totalImpostos = 0.0;
    }

    public void registrarTributo(Tributavel item) {
        if (item != null) {
            double imposto = item.getValorImposto();
            this.totalImpostos += imposto;
            System.out.println("Tributo registrado: R$ " + imposto);
        }
    }

    public double getTotalImpostos() {
        return totalImpostos;
    }
}