package encryptdecrypt;

public class Mirror extends Cipher {
    Mirror() {}

    char getSubstitutionAlgorithmExpression(int charIndex) {
        return ALPHABET.charAt(LAST_ALPHABET_INDEX - charIndex);
    }

    public String encrypt(String input) {
        return substitutionAlgorithm(input);
    }
}
