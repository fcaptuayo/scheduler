package co.sabit.adapter.output.program;

import co.sabit.adapter.output.mapper.TaskMapper;
import co.sabit.adapter.output.repository.TaskCommandRepository;
import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.port.output.UpdateTaskAlgebra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskUpdateInterpreterPersistence implements UpdateTaskAlgebra {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskUpdateInterpreterPersistence.class);

    private final TaskCommandRepository repository;

    public TaskUpdateInterpreterPersistence(TaskCommandRepository repository) {
        LOGGER.warn("TaskUpdateAdapterOutput.TaskUpdateAdapterOutput");
        this.repository = repository;
    }

    @Override
    public Task update(Task task) throws BusinessError {
        LOGGER.warn("TaskUpdateAdapterOutput.update");
        return TaskMapper.entityToDomain(repository.update(TaskMapper.domainToEntity(task)));
    }
}
