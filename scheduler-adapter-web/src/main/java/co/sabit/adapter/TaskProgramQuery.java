package co.sabit.adapter;

import co.sabit.adapter.input.model.TaskSummaryDto;
import co.sabit.core.domain.Task;
import co.sabit.core.usecase.TaskQueryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TaskProgramQuery {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskProgramQuery.class);

    private final TaskQueryUseCase useCase;

    public TaskProgramQuery(TaskQueryUseCase useCase) {
        LOGGER.warn("TaskProgramQuery.TaskProgramQuery");
        this.useCase = useCase;
    }

    public List<TaskSummaryDto> retrieveAll() {
        LOGGER.warn("TaskProgramQuery.retrieveAll");
        List<Task> tasks = useCase.retrieveAll();
        List<TaskSummaryDto> result = new ArrayList<>();
        tasks.forEach(taskDomain -> {
            LOGGER.warn("TaskProgramQuery.retrieveAll.taskDomain" + taskDomain);
            result.add(TaskSummaryDto.domainToDto(taskDomain));
        });
        return result;
    }
}
