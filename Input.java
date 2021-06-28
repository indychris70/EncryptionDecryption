package encryptdecrypt;

public class Input {
    private String text;
    private Operation operation;
    private String key;

    Input(Operation operation, String text, String key) {
        this.operation = operation;
        this.text = text;
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getKeyInt() {
        return Integer.parseInt(key);
    }
}
