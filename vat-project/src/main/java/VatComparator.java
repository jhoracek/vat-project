import java.util.Comparator;

public class VatComparator implements Comparator<Vat> {

    @Override
    public int compare(Vat first, Vat second) {

        return second.getStdVat().compareTo(first.getStdVat());
    }
}
