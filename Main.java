package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Message message = processArgs(args);
        Cipher.processMessage(message);
    }

    private static Message processArgs(String[] args) {
        Operation operation = Operation.ENC;
        String key = "0";
        String message = "";
        String value;
        String inputFileName = "";
        String outputFileName = "";
        Algorithm algorithm = getAlgorithm("shift");
        UnicodeCharacterSets characterSet = UnicodeCharacterSets.BASIC_LATIN;
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
                case "-alg":
                    algorithm = getAlgorithm(args[i + 1]);
                    break;
            }
        }
        return new Message(operation, message, key, inputFileName, outputFileName, algorithm, characterSet);
    }

    private static Algorithm getAlgorithm(String algorithmName) {
        switch (algorithmName) {
            case "unicode":
                return new UnicodeAlgorithm();
            case "mirror":
                return new MirrorAlgorithm();
            default:
                return new ShiftAlgorithm();
        }
    }
}
