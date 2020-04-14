package co.sabit.core.usecase;

import co.sabit.core.domain.Task;

public interface TaskValidatorAlgebra {
    Boolean isPresent(final Task object);
}
