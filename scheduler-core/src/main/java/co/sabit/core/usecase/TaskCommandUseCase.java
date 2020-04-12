package co.sabit.core.usecase;

import co.sabit.core.domain.*;
import co.sabit.core.error.CoreError;

public interface TaskCommandUseCase {
    Identifier create(Task object) throws CoreError;

    Identifier update(Task object) throws CoreError;
}
