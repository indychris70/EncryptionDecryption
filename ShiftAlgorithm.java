package encryptdecrypt;

public class ShiftAlgorithm extends Algorithm {
    @Override
    public String process(Message message) {
        return shift(message);
    }

    private String shift(Message message) {
        String text = message.getText();
        int offset = message.getOperation().equals(Operation.ENC) ? message.getKeyInt() : -message.getKeyInt();
        StringBuilder returnValue = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (UnicodeCharacterSets.LOWER_CASE_LATIN.inSet(c)) {
                returnValue.append(shiftChar(c, offset, UnicodeCharacterSets.LOWER_CASE_LATIN.getMinDecValue(), UnicodeCharacterSets.LOWER_CASE_LATIN.getMaxDecValue()));
            } else if (UnicodeCharacterSets.UPPER_CASE_LATIN.inSet(c)) {
                returnValue.append(shiftChar(c, offset, UnicodeCharacterSets.UPPER_CASE_LATIN.getMinDecValue(), UnicodeCharacterSets.UPPER_CASE_LATIN.getMaxDecValue()));
            } else {
                returnValue.append(c);
            }
        }
        return returnValue.toString();
    }

    private char shiftChar(char character, int offset, int minValue, int maxValue) {
        int newValue = character + offset;
        if (newValue > maxValue) {
            newValue = minValue + newValue - maxValue - 1;
        } else if (newValue < minValue) {
            newValue = maxValue - minValue + newValue + 1;
        }
        return (char) newValue;
    }
}
