package encryptdecrypt;

public enum UnicodeCharacterSets {
    BASIC_LATIN(32, 126),
    LOWER_CASE_LATIN(97, 122),
    UPPER_CASE_LATIN(65, 90);

    private int minDecValue;
    private int maxDecValue;

    UnicodeCharacterSets(int minDecValue, int maxDecValue) {
        this.minDecValue = minDecValue;
        this.maxDecValue = maxDecValue;
    }

    public int getMaxDecValue() {
        return maxDecValue;
    }

    public int getMinDecValue() {
        return minDecValue;
    }

    public boolean inSet(char character) {
        return character >= minDecValue && character <= maxDecValue;
    }
}
