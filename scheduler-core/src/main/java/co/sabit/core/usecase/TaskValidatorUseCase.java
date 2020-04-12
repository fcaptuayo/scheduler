package co.sabit.core.usecase;

import co.sabit.core.domain.Task;

public interface TaskValidatorUseCase {
    Boolean isPresent(final Task object);
}
