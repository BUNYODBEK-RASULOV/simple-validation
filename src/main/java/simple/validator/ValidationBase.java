package simple.validator;


public interface ValidationBase<T> {
    ValidPayload validate(T t);

    default int order(){ return 0; }

    default String getVariableName() { return " "; }

}
