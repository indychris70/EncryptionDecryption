package encryptdecrypt;

public class OffsetN extends Cipher {
    private int key;

    OffsetN(String offset) {
        this.key = Integer.parseInt(offset);
    }

    char getSubstitutionAlgorithmExpression(int charIndex) {
        return ALPHABET.charAt((charIndex + key) % ALPHABET.length());
    }

    public String encrypt(String input) {
        return substitutionAlgorithm(input);
    }
}
