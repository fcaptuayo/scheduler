package co.sabit.core.usecase.service;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.Responsible;
import co.sabit.core.domain.Task;
import co.sabit.core.port.output.QueryTaskPortOutput;
import co.sabit.core.usecase.TaskQueryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TaskQueryService implements TaskQueryUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskQueryService.class);

    private final QueryTaskPortOutput queryRepository;

    public TaskQueryService(
            final QueryTaskPortOutput queryTaskPortOutput
    ) {
        LOGGER.warn("TaskQueryService.TaskQueryService");
        this.queryRepository = queryTaskPortOutput;
    }

    @Override
    public List<Task> retrieveAll() {
        LOGGER.warn("TaskQueryService.retrieveAll");
        LOGGER.warn("TaskQueryService.retrieveAll" + queryRepository);
        return queryRepository.retrieveAllTask();
    }

    @Override
    public List<Task> retrieveTasksByIdentifier(final Identifier identifier) {
        LOGGER.warn("TaskQueryService.retrieveTasksByIdentifier");
        return queryRepository.retrieveTasksByIdentifier(identifier);
    }

    @Override
    public List<Task> retrieveTaskByResponsible(final Responsible responsible) {
        LOGGER.warn("TaskQueryService.retrieveTaskByResponsible");
        return queryRepository.retrieveTaskByResponsible(responsible);
    }
}
