public class Vat {
    private String stateCode;
    private String stateName;
    private int stdVat;
    private float redVat;
    private boolean specVat;

    public Vat(String stateCode, String stateName, int stdVat, float redVat, boolean specVat) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.stdVat = stdVat;
        this.redVat = redVat;
        this.specVat = specVat;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getStdVat() {
        return stdVat;
    }

    public void setStdVat(int stdVat) {
        this.stdVat = stdVat;
    }

    public float getRedVat() {
        return redVat;
    }

    public void setRedVat(float redVat) {
        this.redVat = redVat;
    }

    public boolean isSpecVat() {
        return specVat;
    }

    public void setSpecVat(boolean specVat) {
        this.specVat = specVat;
    }

    public static String formatText(String text) {
        String formatedText = text;
        if (text.contains(",")) {        // commas not supported, needs to be replaced by dots
            formatedText = text.replace(',', '.');
        } else if (text.contains("  ")) {     // 2 blank spaces are not allowed, needs to be replaced by tab
            formatedText = text.replaceAll("\\s+", "\t");
        }
        return formatedText;
    }
        public static Vat parse (String text, String delimiter) throws VatException {

            String[] items = formatText(text).split(delimiter);
            int numOfItems = items.length;
            if (numOfItems != 5) {
                throw new VatException("Incorrect number of items on 1 line. We expect 5 items instead of current " +
                        numOfItems + " items. Problematic line: " + text);
            }

            String stateCode = items[0];
            String stateName = items[1];
            int stdVat = Integer.parseInt(items[2]);
            float redVat = Float.parseFloat(items[3]);
            Boolean specVat = Boolean.parseBoolean(items[4]);

            return new Vat(stateCode, stateName, stdVat, redVat, specVat);
        }
    }


