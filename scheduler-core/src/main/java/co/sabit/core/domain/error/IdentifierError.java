package co.sabit.core.domain.error;

public class IdentifierError extends BusinessError {
    public IdentifierError(String message) {
        super(message);
    }

    public static final class EmptyIDReferenceError extends IdentifierError {
        public EmptyIDReferenceError() {
            super("Invalid identifier: Empty id reference.");
        }
    }
}
