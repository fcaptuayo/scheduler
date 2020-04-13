package co.sabit.adapter;

import co.sabit.adapter.input.model.TaskDto;
import co.sabit.adapter.input.model.TaskIdentifierDto;
import co.sabit.core.error.CoreError;
import co.sabit.core.usecase.TaskCommandUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskProgramCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskProgramCommand.class);

    private final TaskCommandUseCase useCase;

    public TaskProgramCommand(TaskCommandUseCase useCase) {
        LOGGER.warn("TaskProgramCommand.TaskProgramCommand");
        this.useCase = useCase;
    }

    public TaskIdentifierDto createTask(TaskDto taskDto) throws CoreError {
        LOGGER.warn("TaskProgramCommand.createTask");
        return TaskIdentifierDto.domainToDto(useCase.create(taskDto.toDomain()));
    }

    public TaskIdentifierDto updateTask(TaskDto taskDto) throws CoreError {
        LOGGER.warn("TaskProgramCommand.updateTask");
        return TaskIdentifierDto.domainToDto(useCase.update(taskDto.toDomain()));
    }
}
