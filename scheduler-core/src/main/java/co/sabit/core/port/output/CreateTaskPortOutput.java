package co.sabit.core.port.output;

import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;

public interface CreateTaskPortOutput {
    Task insert(Task task) throws BusinessError;
}
