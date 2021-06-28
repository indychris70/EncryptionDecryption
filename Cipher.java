package encryptdecrypt;

abstract class Cipher {
    abstract String encrypt(String input);

    public void printEncryptedValue(String input) {
        System.out.println(encrypt(input));
    }
}
