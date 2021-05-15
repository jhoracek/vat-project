import java.time.LocalDate;

public class Plant {

    private String name;
    private LocalDate planted;
    private LocalDate watering;
    private int freqOfWatering;


    public void getWateringInfo() {
        System.out.println(name + watering + freqOfWatering);
    }

    public Plant(String name, LocalDate planted, LocalDate watering, int freqOfWatering) {
        this.name = name;
        this.planted = planted;
        this.watering = watering;
        this.freqOfWatering = freqOfWatering;
    }

    public Plant(String name, LocalDate watering) {
        this.name = name;
        this.watering = watering.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public void setFreqOfWatering(int freqOfWatering) {
        this.freqOfWatering = freqOfWatering;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public int getFreqOfWatering() {
        return freqOfWatering;
    }

    public Plant(LocalDate planted, LocalDate watering, int freqOfWatering) {
        this.planted = planted;
        this.watering = watering;
        this.freqOfWatering = freqOfWatering;
    }
}
