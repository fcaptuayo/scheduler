package co.sabit.adapter.output;

import co.sabit.adapter.output.mapper.TaskMapper;
import co.sabit.adapter.output.repository.TaskCommandRepository;
import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.port.output.UpdateTaskPortOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskUpdateAdapterOutput implements UpdateTaskPortOutput {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskUpdateAdapterOutput.class);

    private final TaskCommandRepository repository;

    public TaskUpdateAdapterOutput(TaskCommandRepository repository) {
        LOGGER.warn("TaskUpdateAdapterOutput.TaskUpdateAdapterOutput");
        this.repository = repository;
    }

    @Override
    public Task update(Task task) throws BusinessError {
        LOGGER.warn("TaskUpdateAdapterOutput.update");
        return TaskMapper.entityToDomain(repository.update(TaskMapper.domainToEntity(task)));
    }
}
