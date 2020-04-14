package co.sabit.adapter.output.program;

import co.sabit.adapter.output.mapper.TaskMapper;
import co.sabit.adapter.output.repository.TaskCommandRepository;
import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.port.output.CreateTaskAlgebra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TaskCreateInterpreterPersistence implements CreateTaskAlgebra {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCreateInterpreterPersistence.class);

    private final TaskCommandRepository repository;

    public TaskCreateInterpreterPersistence(TaskCommandRepository repository) {
        LOGGER.warn("TaskCreateAdapterOutput.TaskCreateAdapterOutput");
        this.repository = repository;
    }

    @Override
    public Task insert(Task task) throws BusinessError {
        LOGGER.warn("TaskCreateAdapterOutput.insert");
        return TaskMapper.entityToDomain(repository.save(TaskMapper.domainToEntity(task)));
    }
}
