import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final String INPUT_FILE = "vat-eu.csv";
    private static final String OUTPUT_FILE = "vat-over-20.txt";

    public static void main(String[] args) {

        VatList list = new VatList();
        try {
            list.readVatFromFile(INPUT_FILE);
        } catch (VatException e) {
            e.printStackTrace();
        }

        List<Vat> codesAboveLineList = new ArrayList<>();
        List<String> codesUnderLineList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.getVatList(i).getStdVat() > 20 && !list.getVatList(i).isSpecVat()) {
                codesAboveLineList.add(list.getVatList(i));
                Collections.sort(codesAboveLineList, new VatComparator());
                try {
                    list.writeVatToFile(OUTPUT_FILE);
                } catch (VatException e) {
                    e.printStackTrace();
                }

            } else {
                codesUnderLineList.add(list.getVatList(i).getStateCode());
            }
        }
        for (Vat textAbove : codesAboveLineList) {
            System.out.println(textAbove.getStateName() + " (" + textAbove.getStateCode() + "):  "
                    + textAbove.getStdVat() + "%");
        }
        System.out.println("============================================");
        System.out.print("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
        int i = 0;
        for (String code : codesUnderLineList) {
            if (i++ != codesUnderLineList.size() - 1) {
                System.out.print(code + ", ");
            } else System.out.print(code);
        }
    }
}

