package encryptdecrypt;

public class Mirror extends Cipher {

    public String encrypt(String input) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final int LAST_INDEX = alphabet.length() - 1;
        StringBuilder encrypted = new StringBuilder(input.length());
        int charIndex;
        for (int i = 0; i < input.length(); i++) {
            charIndex = alphabet.indexOf(input.charAt(i));
            if (charIndex != -1) {
                encrypted.append(alphabet.charAt(LAST_INDEX - charIndex));
            } else {
                encrypted.append(input.charAt(i));
            }
        }
        return encrypted.toString();
    }
}
