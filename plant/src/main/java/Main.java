import java.time.LocalDate;

public class Main {

    private static final String INPUT_FILE = "kvetiny.txt";
    private static final String OUTPUT_FILE = "vystup.txt";

    public static void main(String[] args) {
        PlantList list = new PlantList();
        try {
            list.importPlantsFromFile(INPUT_FILE);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getPlant(i).getWateringInfo());
        }
        list.addPlant(new Plant("Amarylis v obýváku"));
        list.addPlant(new Plant("Bazalka v kuchyni", LocalDate.now(), 3));
        list.removePlant(1);

        try {
            list.exportToFile(OUTPUT_FILE);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
