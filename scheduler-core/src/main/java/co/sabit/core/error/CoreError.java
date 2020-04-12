package co.sabit.core.error;

public abstract class CoreError extends Exception {
    private final String value;

    public CoreError(final String message) {
        this.value = message;
    }

    public String getValue() {
        return value;
    }
}
