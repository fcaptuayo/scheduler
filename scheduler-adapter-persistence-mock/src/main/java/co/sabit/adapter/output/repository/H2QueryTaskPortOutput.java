package co.sabit.adapter.output.repository;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.Responsible;
import co.sabit.core.domain.Task;
import co.sabit.core.port.output.QueryTaskPortOutput;

import java.util.List;

public class H2QueryTaskPortOutput implements QueryTaskPortOutput {

    @Override
    public List<Task> retrieveAllTask() {
        return null;
    }

    @Override
    public List<Task> retrieveTasksByIdentifier(Identifier identifier) {
        return null;
    }

    @Override
    public Long countTasksByIdentifier(Identifier identifier) {
        return 1L;
    }

    @Override
    public List<Task> retrieveTaskByResponsible(Responsible responsible) {
        return null;
    }

    @Override
    public Long countTasksByResponsible(Responsible responsible) {
        return 1L;
    }
}
