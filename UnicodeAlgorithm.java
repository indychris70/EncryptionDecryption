package encryptdecrypt;

public class UnicodeAlgorithm extends Algorithm {
    @Override
    public String process(Message message) {
        return shiftCharacters(message);
    }

    private String shiftCharacters(Message message) {
        int minValue = message.getCharacterSet().getMinDecValue();
        int maxValue = message.getCharacterSet().getMaxDecValue();
        int offset = message.getOperation().equals(Operation.ENC) ? message.getKeyInt() : -message.getKeyInt();
        StringBuilder returnValue = new StringBuilder(message.getText().length());
        for (int i = 0; i < message.getText().length(); i++) {
            returnValue.append(shiftChar(message.getText().charAt(i), offset, minValue, maxValue));
        }
        return returnValue.toString();
    }

    private char shiftChar(char character, int offset, int minValue, int maxValue) {
        int newValue = character + offset;
        if (newValue > maxValue) {
            newValue = minValue + newValue - maxValue - 1;
        } else if (newValue < minValue) {
            newValue = maxValue - newValue + minValue - 1;
        }
        return (char) newValue;
    }
}
