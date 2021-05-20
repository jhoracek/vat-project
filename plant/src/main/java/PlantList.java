import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private static final String FILE_ITEM_DELIMITER = "\t";

    List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant) {
        plantList.add(plant);
    }

    public Plant getPlant(int index) {
       return plantList.get(index);
    }

    public void removePlant(int index) {
        plantList.remove(index);
    }

    public int size() {
        return plantList.size();
    }

public void importPlantsFromFile(String pathAndFile) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathAndFile)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                lineNumber++;
                try {
                    this.addPlant(Plant.parse(record, FILE_ITEM_DELIMITER));
                } catch (ParseException e) {
                    throw new PlantException("Invalid input file: "+pathAndFile+" line "+lineNumber+": "+e.getLocalizedMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Vstupní soubor "+pathAndFile+" nebyl nalezen: "+e.getLocalizedMessage());
        }
    }

    public void exportToFile(String pathAndFile) throws PlantException {
        int lineNumber = 0;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathAndFile)))){
            for (Plant plant : plantList) {
                String plantAsFileLine = plant.prepareOutputString(FILE_ITEM_DELIMITER);
                writer.println(plantAsFileLine);
                lineNumber++;
            }
        } catch (IOException e) {
            throw new PlantException("Error writing to : "+pathAndFile+" line "+lineNumber+": "+e.getLocalizedMessage());
        }

    }

}
