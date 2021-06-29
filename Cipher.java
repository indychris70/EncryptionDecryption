package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

abstract class Cipher {

    static void processInput(Input input, Algorithms algorithm) {
        if ("text".equals(input.getSource()) && "standard out".equals(input.getDestination())) {
            printProcessedInput(input, algorithm);
        } else if (!"text".equals(input.getSource()) && "standard out".equals(input.getDestination())) {
            fromFileToStandardOut(input, algorithm);
        } else if ("text".equals(input.getSource()) && !"standard out".equals(input.getDestination())) {
            fromTextToFile(input, algorithm);
        } else {
            fromFileToFile(input, algorithm);
        }
    }

    private static String process(Input input, Algorithms algorithm) {
        int minValue;
        int maxValue;
        switch (algorithm) {
            case STAGE1:
                return mirror(input.getText());
            case STAGE2:
                minValue = UnicodeCharacterSets.LOWER_CASE_LATIN.getMinDecValue();
                maxValue = UnicodeCharacterSets.LOWER_CASE_LATIN.getMaxDecValue();
                return shiftCharacters(input, minValue, maxValue);
            case STAGE3:
                minValue = UnicodeCharacterSets.BASIC_LATIN.getMinDecValue();
                maxValue = UnicodeCharacterSets.BASIC_LATIN.getMaxDecValue();
                return shiftCharacters(input, minValue, maxValue);
            default:
                return input.getText();
        }
    };

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

    private static void printProcessedInput(Input input, Algorithms algorithm) {
        System.out.println(process(input, algorithm));
    }

    private static void fromFileToStandardOut(Input input, Algorithms algorithm) {
        File inputFile = new File(input.getSource());
        try(Scanner s = new Scanner(inputFile)) {
            while (s.hasNext()) {
                input.setText(s.nextLine());
                printProcessedInput(input, algorithm);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: File Not Found");
            e.printStackTrace();
        }
    }

    private static void fromTextToFile(Input input, Algorithms algorithm) {
        File outputFile = new File(input.getDestination());
        try(FileWriter writer = new FileWriter(outputFile)) {
            writer.write(process(input, algorithm));
        } catch (IOException e) {
            System.out.println("Error IOException:");
            e.printStackTrace();
        }
    }

    private static void fromFileToFile(Input input, Algorithms algorithm) {
        File inputFile = new File(input.getSource());
        File outputFile = new File(input.getDestination());
        try(Scanner s = new Scanner(inputFile)) {
            try(FileWriter writer = new FileWriter(outputFile)) {
                while (s.hasNext()) {
                    input.setText(s.nextLine());
                    writer.write(process(input, algorithm));
                }
            } catch (IOException e) {
                System.out.println("Error IOException:");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File Not Found");
            e.printStackTrace();
        }
    }

    private static String shiftCharacters(Input input, int minValue, int maxValue) {
        int offset = input.getOperation().equals(Operation.ENC) ? input.getKeyInt() : -input.getKeyInt();
        StringBuilder returnValue = new StringBuilder(input.getText().length());
        for (int i = 0; i < input.getText().length(); i++) {
            returnValue.append(shiftChar(input.getText().charAt(i), offset, minValue, maxValue));
        }
        return returnValue.toString();
    }

    private static char shiftChar(char character, int offset, int minValue, int maxValue) {
        int newValue = character + offset;
        if (newValue > maxValue) {
            newValue = minValue + newValue - maxValue - 1;
        } else if (newValue < minValue) {
            newValue = maxValue - newValue + minValue - 1;
        }
        return (char) newValue;
    }
}