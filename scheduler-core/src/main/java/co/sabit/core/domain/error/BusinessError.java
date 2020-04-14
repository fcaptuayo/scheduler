package co.sabit.core.domain.error;

import co.sabit.core.error.CoreError;

public abstract class BusinessError extends CoreError {
    public BusinessError(String message) {
        super(message);
    }
}
