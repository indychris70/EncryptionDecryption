package encryptdecrypt;

abstract class Cipher {

    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final int LAST_ALPHABET_INDEX = ALPHABET.length() - 1;

    abstract char getSubstitutionAlgorithmExpression(int charIndex);

    abstract String encrypt(String input);

    String substitutionAlgorithm(String input) {
        StringBuilder encrypted = new StringBuilder(input.length());
        int charIndex;
        for (int i = 0; i < input.length(); i++) {
            charIndex = ALPHABET.indexOf(input.charAt(i));
            if (charIndex != -1) {
                encrypted.append(getSubstitutionAlgorithmExpression(charIndex));
            } else {
                encrypted.append(input.charAt(i));
            }
        }
        return encrypted.toString();
    }

    void printEncrytpedInput(String input) {
        System.out.println(encrypt(input));
    }
}