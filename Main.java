package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Input input = getInput(args);
        Cipher.processInput(input, Algorithms.STAGE3);
    }

    private static Input getInput(String[] args) {
        Operation operation = Operation.ENC;
        String key = "0";
        String message = "";
        String value;
        String inputFileName = "";
        String outputFileName = "";
        for (int i = 0; i < args.length; i++) {
            value = args[i];
            switch (value) {
                case "-mode":
                    operation = Operation.valueOf(args[i + 1].toUpperCase());
                    break;
                case "-key":
                    key = args[i + 1];
                    break;
                case "-data":
                    message = args[i + 1];
                    break;
                case "-in":
                    inputFileName = args[i + 1];
                    break;
                case "-out":
                    outputFileName = args[i + 1];
                    break;
            }
        }
        return new Input(operation, message, key, inputFileName, outputFileName);
    }
}
