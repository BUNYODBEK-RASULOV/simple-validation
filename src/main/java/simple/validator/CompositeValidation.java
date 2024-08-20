package simple.validator;

import java.util.*;

public class CompositeValidation <T>  {

    public List<String> validMessage = new ArrayList<>();

    private T payload;
    private List<ValidationBase<T>> strategies;

    public CompositeValidation( List<ValidationBase<T>> validationStrategies, T payload) {
        if (validationStrategies == null || payload == null)
            throw new IllegalArgumentException("Validation strategies and payload must not be null");

        this.strategies=validationStrategies;
        this.payload = payload;
    }

    public void sortValidateByOrder() {
        strategies.sort(Comparator.comparingInt(ValidationBase<T>::order).reversed());
    }


    public boolean validate() {
        for (ValidationBase<T> strategy : strategies) {
            ValidPayload validate = strategy.validate(payload);
            if (validate !=null && !validate.isValid()) {
                validMessage.add(strategy.getVariableName() + validate.getValidMessage());
                return false;
            }
        }
        return true;
    }

    public String getErrorMessage() {
        StringBuilder errorMessages = new StringBuilder();
        for (String s : validMessage) { errorMessages.append(s);}
        return errorMessages.toString();
    }


    public List<String> getErrorMessageList() {
        return validMessage;
    }
}
