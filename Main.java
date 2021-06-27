package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = getInput();
        String offset = getInput();
        Cipher cipher = new OffsetN(offset);
        cipher.printEncrytpedInput(input);
    }

    private static String getInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}
