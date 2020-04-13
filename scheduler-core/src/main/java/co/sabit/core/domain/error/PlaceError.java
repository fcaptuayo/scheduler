package co.sabit.core.domain.error;

public class PlaceError extends BusinessError {

    public PlaceError(String message) {
        super(message);
    }

    public static final class EmptyAddressValueError extends PlaceError {
        public EmptyAddressValueError() {
            super("Invalid place: Empty address value.");
        }
    }

    public static final class EmptyCityCodeError extends PlaceError {
        public EmptyCityCodeError() {
            super("Invalid place: Empty city code.");
        }
    }

    public static final class EmptyCountryCodeError extends PlaceError {
        public EmptyCountryCodeError() {
            super("Invalid place: Empty country code.");
        }
    }

    public static final class EmptyEdificeValueError extends PlaceError {
        public EmptyEdificeValueError() {
            super("Invalid place: Empty edifice value.");
        }
    }

    public static final class EmptyNameValueError extends PlaceError {
        public EmptyNameValueError() {
            super("Invalid place: Empty name value.");
        }
    }

    public static final class EmptyTypeValueError extends PlaceError {
        public EmptyTypeValueError() {
            super("Invalid place: Empty name value.");
        }
    }
}
