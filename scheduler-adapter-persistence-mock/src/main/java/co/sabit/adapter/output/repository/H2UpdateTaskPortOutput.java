package co.sabit.adapter.output.repository;

import co.sabit.core.domain.Task;
import co.sabit.core.port.output.UpdateTaskPortOutput;

public class H2UpdateTaskPortOutput implements UpdateTaskPortOutput {
    @Override
    public Task update(Task object) {
        return object;
    }
}
