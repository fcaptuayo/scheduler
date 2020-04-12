package co.sabit.core.usecase;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.Responsible;
import co.sabit.core.domain.Task;

import java.util.List;

public interface TaskQueryUseCase {
    List<Task> retrieveAll();

    List<Task> retrieveTasksByIdentifier(Identifier identifier);

    List<Task> retrieveTaskByResponsible(Responsible responsible);
}
