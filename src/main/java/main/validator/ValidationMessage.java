package main.validator;

public class ValidationMessage {
    String message;

    public ValidationMessage(String message) {
        this.message = message;
    }

    public ValidationMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
