package encryptdecrypt;

public class Message {
    private final Operation operation;
    private final String key;
    private String text;
    private final String source;
    private final String destination;
    private Algorithm algorithm;
    private final UnicodeCharacterSets characterSet;


    Message(Operation operation, String text, String key, String inputFileName, String outputFileName, Algorithm algorithm, UnicodeCharacterSets characterSet) {
        this.operation = operation;
        this.key = key;
        this.text = text;
        this.source = getSource(inputFileName);
        this.destination = getDestination(outputFileName);
        this.algorithm = algorithm;
        this.characterSet = characterSet;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getKeyInt() {
        return Integer.parseInt(key);
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UnicodeCharacterSets getCharacterSet() {
        return characterSet;
    }

    public String process() {
        return this.algorithm.process(this);
    }

    private String getSource(String inputFileName) {
        if (!inputFileName.isEmpty() && text.isEmpty()) {
            return inputFileName;
        } else {
            return "text";
        }
    }

    private String getDestination(String outputFileName) {
        if (outputFileName.isEmpty()) {
            return "standard out";
        } else {
            return outputFileName;
        }
    }
}
