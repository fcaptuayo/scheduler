package co.sabit.core.domain.error;

public class LifeTimeError extends BusinessError {

    public LifeTimeError(String message) {
        super(message);
    }

    public static final class InvalidStartDateLifeValueError extends LifeTimeError {
        public InvalidStartDateLifeValueError() {
            super("Invalid lifeTime: Invalid start date value.");
        }
    }

    public static final class InvalidDueDateLifeValueError extends LifeTimeError {
        public InvalidDueDateLifeValueError() {
            super("Invalid lifeTime: Invalid due date value.");
        }
    }
}
