package cardGameExceptions;

public class StackUnderflowException extends CardGameExceptions{

    public StackUnderflowException(String message) {
        super(message);
    }
    public StackUnderflowException() {
        super();
    }
}
