package encryptdecrypt;

public class MirrorAlgorithm extends Algorithm {
    @Override
    public String process(Message message) {
        return mirror(message.getText());
    }

    private static String mirror(String input) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        final int LAST_ALPHABET_INDEX = ALPHABET.length() - 1;
        StringBuilder returnValue = new StringBuilder(input.length());
        int charIndex;
        for (int i = 0; i < input.length(); i++) {
            charIndex = ALPHABET.indexOf(input.charAt(i));
            if (charIndex != -1) {
                returnValue.append(ALPHABET.charAt(LAST_ALPHABET_INDEX - charIndex));
            } else {
                returnValue.append(input.charAt(i));
            }
        }
        return returnValue.toString();
    }
}
