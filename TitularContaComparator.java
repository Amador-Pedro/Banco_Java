package banco;

import java.util.Comparator;

public class TitularContaComparator implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
        String nome1 = c1.getTitular().getNome();
        String nome2 = c2.getTitular().getNome();
        return nome1.compareToIgnoreCase(nome2);
    }
}