package co.sabit.adapter.output.repository;

import co.sabit.core.domain.Task;
import co.sabit.core.port.output.UpdateTaskAlgebra;

public class UpdateTaskInterpreterPersistenceMock implements UpdateTaskAlgebra {
    @Override
    public Task update(Task object) {
        return object;
    }
}
