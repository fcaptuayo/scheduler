package co.sabit.core.domain.error;

public class ResponsibleError extends BusinessError {

    public ResponsibleError(String message) {
        super(message);
    }

    public static final class EmptyIdValueError extends ResponsibleError {
        public EmptyIdValueError() {
            super("Invalid place: Empty id value.");
        }
    }

    public static final class EmptyNicknameValueError extends ResponsibleError {
        public EmptyNicknameValueError() {
            super("Invalid place: Empty nickname value.");
        }
    }
}
