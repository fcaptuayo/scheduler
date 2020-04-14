package co.sabit.adapter.output.repository;

import co.sabit.core.domain.Task;
import co.sabit.core.port.output.CreateTaskAlgebra;

public class CreateTaskInterpreterPersistenceMock implements CreateTaskAlgebra {
    @Override
    public Task insert(final Task object) {
        return object;
    }
}
