import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    private static final String INPUT_FILE = "vat-eu.csv";
    private static final String OUTPUT_FILE = "vat-eu-OUT.csv";

    public static void main(String[] args) {

        VatList list = new VatList();
        try {
            list.readVatFromFile(INPUT_FILE);
        } catch (VatException e) {
            e.printStackTrace();
        }

        String textBelowLine = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.getVatList(i).getStdVat() > 20 && !list.getVatList(i).isSpecVat()) {
                System.out.println(list.getVatList(i).getStateName() + " (" + list.getVatList(i).getStateCode() +
                        "): " + list.getVatList(i).getStdVat() + "%");
            } else {

                textBelowLine = textBelowLine + " " + list.getVatList(i).getStateCode();


            }
        }
        String[] codesUnderLine = textBelowLine.split(" ");
        Arrays.sort(codesUnderLine);
        String sortedCodes = Arrays.toString(codesUnderLine);


        System.out.println("====================");
        System.out.println("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: "+
                Arrays.toString(codesUnderLine));
    }
}
