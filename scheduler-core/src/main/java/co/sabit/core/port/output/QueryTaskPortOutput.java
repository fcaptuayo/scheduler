package co.sabit.core.port.output;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.Responsible;
import co.sabit.core.domain.Task;

import java.util.List;

public interface QueryTaskPortOutput {
    List<Task> retrieveAllTask();

    List<Task> retrieveTasksByIdentifier(Identifier identifier);

    Long countTasksByIdentifier(Identifier identifier);

    List<Task> retrieveTaskByResponsible(Responsible responsible);

    Long countTasksByResponsible(Responsible responsible);
}
