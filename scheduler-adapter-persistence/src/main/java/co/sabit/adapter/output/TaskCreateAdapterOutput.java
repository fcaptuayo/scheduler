package co.sabit.adapter.output;

import co.sabit.adapter.output.mapper.TaskMapper;
import co.sabit.adapter.output.repository.TaskCommandRepository;
import co.sabit.adapter.output.repository.TaskQueryRepository;
import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.port.output.CreateTaskPortOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TaskCreateAdapterOutput implements CreateTaskPortOutput {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCreateAdapterOutput.class);

    private final TaskCommandRepository repository;

    public TaskCreateAdapterOutput(TaskCommandRepository repository) {
        LOGGER.warn("TaskCreateAdapterOutput.TaskCreateAdapterOutput");
        this.repository = repository;
    }

    @Override
    public Task insert(Task task) throws BusinessError {
        LOGGER.warn("TaskCreateAdapterOutput.insert");
        return TaskMapper.entityToDomain(repository.save(TaskMapper.domainToEntity(task)));
    }
}
