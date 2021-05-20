import java.text.ParseException;
import java.time.LocalDate;

public class Plant {

    static final int DEFAULT_FREQ = 7;
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate lastWatering;
    private int freqOfWateringInDays;

    public Plant(String name, String notes, LocalDate planted, LocalDate lastWatering, int freqOfWateringInDays) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.lastWatering = lastWatering;
        this.freqOfWateringInDays = freqOfWateringInDays;
    }

    public Plant(String name, LocalDate planted, int freqOfWateringInDays) {
        this(name, "", planted, LocalDate.now(), freqOfWateringInDays);
    }

    public Plant(String name) {
        this(name, LocalDate.now(), DEFAULT_FREQ);
    }

    public String getWateringInfo() {
        return getName() + ", posledni zalivka:" + getlastWatering() + " " + getlastWatering()
                .plusDays(getfreqOfWateringInDays());
    }

    public String prepareOutputString(String delimiter) {
        return
                getName() + delimiter
                        + getNotes() + delimiter
                        + getfreqOfWateringInDays() + delimiter
                        + getlastWatering() + delimiter
                        + getPlanted();
    }

    public int getFreqOfWateringInDays() {
        return freqOfWateringInDays;
    }

    public LocalDate getLastWatering() {
        return lastWatering;
    }

    public void setFreqOfWateringInDays(int freqOfWateringInDays) {
        this.freqOfWateringInDays = freqOfWateringInDays;
    }

    public void setLastWatering(LocalDate lastWatering) {
        this.lastWatering = lastWatering;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public void setlastWatering(LocalDate lastWatering) throws PlantException {
        if (lastWatering.isBefore(getPlanted())) {
            throw new PlantException("Last watering day: " + lastWatering + " cannot be less than day " +
                    "of its planting.");
        }
        this.lastWatering = lastWatering;
    }

    public void setfreqOfWateringInDays(int freqOfWateringInDays) throws PlantException {
        if (freqOfWateringInDays <= 0) throw new PlantException("Allowed frequency should be at least 1 day. " +
                "Provided" + freqOfWateringInDays + " is not accepted. Please fix it.");
        this.freqOfWateringInDays = freqOfWateringInDays;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public LocalDate getlastWatering() {
        return lastWatering;
    }

    public int getfreqOfWateringInDays() {
        return freqOfWateringInDays;
    }

    public static Plant parse(String text, String delimiter) throws ParseException {
        String[] items = text.split(delimiter);

        int numberOfItems = items.length;
        if (numberOfItems != 5)
            throw new ParseException("Nesprávný počet položek na řádku! Očekáváme 5 položek, místo " + numberOfItems + " položek na řádku: " + text, 0);

        String name = items[0];
        String notes = items[1];
        int freqOfWateringInDays = Integer.parseInt(items[2]);
        LocalDate lastWatering = LocalDate.parse(items[3]);
        LocalDate planted = LocalDate.parse(items[4]);

        return new Plant(name, notes, planted, lastWatering, freqOfWateringInDays);
    }
}

