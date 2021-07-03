package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

abstract class Cipher {

    static void processMessage(Message message) {
        if ("text".equals(message.getSource()) && "standard out".equals(message.getDestination())) {
            printProcessedInput(message);
        } else if (!"text".equals(message.getSource()) && "standard out".equals(message.getDestination())) {
            fromFileToStandardOut(message);
        } else if ("text".equals(message.getSource()) && !"standard out".equals(message.getDestination())) {
            fromTextToFile(message);
        } else {
            fromFileToFile(message);
        }
    }

    private static void printProcessedInput(Message message) {
        System.out.println(message.process());
    }

    private static void fromFileToStandardOut(Message message) {
        File inputFile = new File(message.getSource());
        try(Scanner s = new Scanner(inputFile)) {
            while (s.hasNext()) {
                message.setText(s.nextLine());
                printProcessedInput(message);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: File Not Found");
            e.printStackTrace();
        }
    }

    private static void fromTextToFile(Message message) {
        File outputFile = new File(message.getDestination());
        try(FileWriter writer = new FileWriter(outputFile)) {
            writer.write(message.process());
        } catch (IOException e) {
            System.out.println("Error IOException:");
            e.printStackTrace();
        }
    }

    private static void fromFileToFile(Message message) {
        File inputFile = new File(message.getSource());
        File outputFile = new File(message.getDestination());
        try(Scanner s = new Scanner(inputFile)) {
            try(FileWriter writer = new FileWriter(outputFile)) {
                while (s.hasNext()) {
                    message.setText(s.nextLine());
                    writer.write(message.process());
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
}