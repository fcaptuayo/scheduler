package co.sabit.core.port.output;

import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;

public interface UpdateTaskAlgebra {
    Task update(Task task) throws BusinessError;
}
