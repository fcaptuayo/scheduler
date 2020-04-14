package co.sabit.core.usecase.program;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.Responsible;
import co.sabit.core.domain.Task;
import co.sabit.core.port.output.QueryTaskAlgebra;
import co.sabit.core.usecase.TaskQueryAlgebra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TaskQueryInterpreter implements TaskQueryAlgebra {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskQueryInterpreter.class);

    private final QueryTaskAlgebra queryRepository;

    public TaskQueryInterpreter(
            final QueryTaskAlgebra queryTaskAlgebra
    ) {
        LOGGER.warn("TaskQueryService.TaskQueryService");
        this.queryRepository = queryTaskAlgebra;
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
