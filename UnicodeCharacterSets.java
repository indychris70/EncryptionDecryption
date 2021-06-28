package encryptdecrypt;

public enum UnicodeCharacterSets {
    BASIC_LATIN(32, 126),
    LOWER_CASE_LATIN(97, 122);

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
}
