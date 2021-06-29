package encryptdecrypt;

public class Input {
    private final Operation operation;
    private final String key;
    private String text;
    private final String source;
    private final String destination;


    Input(Operation operation, String text, String key, String inputFileName, String outputFileName) {
        this.operation = operation;
        this.key = key;
        this.text = text;
        this.source = getSource(inputFileName);
        this.destination = getDestination(outputFileName);
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
