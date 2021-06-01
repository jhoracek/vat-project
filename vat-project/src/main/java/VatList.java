import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VatList {
    private static final String FILE_ITEM_DELIMITER = "\t";
    List<Vat> vatList = new ArrayList<>();

    public void addVat(Vat vat) {
        vatList.add(vat);
    }

    public Vat getVatList(int index) {
        return vatList.get(index);
    }

    public int size() {
        return vatList.size();
    }

    public void readVatFromFile(String pathAndFile) throws VatException {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(pathAndFile)))) {
            int lineNumber = 0;
            while (sc.hasNextLine()) {
                String record = sc.nextLine();
                lineNumber++;
                this.addVat(Vat.parse(record, FILE_ITEM_DELIMITER));
            }
        } catch (FileNotFoundException e) {
            throw new VatException("Input file " + pathAndFile + " has not been found: " + e.getLocalizedMessage());
        }
    }

    public void writeVatToFile(String outFile) throws VatException {
        int lineNumber = 0;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile)))) {
            for (Vat vat : vatList) {
                String vatAsFileLine = vat.getDescription();
                writer.println(vatAsFileLine);
                lineNumber++;
            }
        } catch (IOException e) {
            throw new VatException("Output file" + outFile + " cannot be created. " + e.getLocalizedMessage());
        }
    }
}
