package co.sabit.adapter.output.repository;

import co.sabit.core.domain.Task;
import co.sabit.core.port.output.CreateTaskPortOutput;

public class H2CreateTaskPortOutput implements CreateTaskPortOutput {

    public H2CreateTaskPortOutput() {
    }

    @Override
    public Task insert(final Task object) {
        return object;
    }
}
