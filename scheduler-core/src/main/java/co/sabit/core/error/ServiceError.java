package co.sabit.core.error;

public class ServiceError extends CoreError {

    public ServiceError(String message) {
        super(message);
    }

    public static final class ExistTask extends ServiceError {
        public ExistTask() {
            super("Invalid validation:Exist task");
        }
    }

    public static final class NotExistTask extends ServiceError {
        public NotExistTask() {
            super("Invalid validation:Not Exist task");
        }
    }
}
