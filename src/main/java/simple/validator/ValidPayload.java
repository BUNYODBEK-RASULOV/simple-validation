package simple.validator;

public class ValidPayload {
    private boolean valid;
    private String validMessage;

    public ValidPayload(String validMessage) {
        this.validMessage = validMessage;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setValidMessage(String validMessage) {
        this.validMessage = validMessage;
    }

    public boolean isValid() {
        return valid;
    }

    public String getValidMessage() {
        return validMessage;
    }

    public ValidPayload() {}
}
