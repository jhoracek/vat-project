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

        for (int i = 0; i < list.size(); i++) {
            if (list.getVatList(i).getStdVat() > 20 && !list.getVatList(i).isSpecVat()) {
                System.out.println(list.getVatList(i).getStateName() + " (" + list.getVatList(i).getStateCode() +
                        "): " + list.getVatList(i).getStdVat() + "%");
            }
        }
        System.out.println("====================");
        for (int i = 0; i < list.size(); i++) {
            if (list.getVatList(i).getStdVat() <= 20 || list.getVatList(i).isSpecVat()) {
                System.out.println("VAT Rate 20 % and less or they use special VAT rate:"+
                        list.getVatList(i).getStateName());
            }
        }
    }
}
