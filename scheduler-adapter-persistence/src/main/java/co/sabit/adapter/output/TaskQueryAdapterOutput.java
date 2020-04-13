package co.sabit.adapter.output;

import co.sabit.adapter.output.mapper.TaskMapper;
import co.sabit.adapter.output.model.TaskJpaEntity;
import co.sabit.adapter.output.repository.TaskQueryRepository;
import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.Responsible;
import co.sabit.core.domain.Task;
import co.sabit.core.error.CoreError;
import co.sabit.core.port.output.QueryTaskPortOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TaskQueryAdapterOutput implements QueryTaskPortOutput {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskQueryAdapterOutput.class);
    private final TaskQueryRepository repository;

    public TaskQueryAdapterOutput(TaskQueryRepository repository) {
        LOGGER.warn("TaskQueryAdapterOutput.TaskQueryAdapterOutput");
        this.repository = repository;
    }

    private List<Task> mapToListDomainTask(Iterable<TaskJpaEntity> listEntityObjects) {
        LOGGER.warn("TaskQueryAdapterOutput.mapToListDomainTask");
        List<Task> listObjects = new ArrayList<>();
        listEntityObjects.forEach(a -> {
            try {
                listObjects.add(TaskMapper.entityToDomain(a));
            } catch (CoreError error) {
                LOGGER.warn(error.getValue());
            }
        });
        return listObjects;
    }

    @Override
    public Long countTasksByIdentifier(Identifier identifier) {
        LOGGER.warn("TaskQueryAdapterOutput.countTasksByIdentifier");
        return repository.countByIdentifier(identifier);
    }

    @Override
    public Long countTasksByResponsible(Responsible responsible) {
        LOGGER.warn("TaskQueryAdapterOutput.countTasksByResponsible");
        return repository.count();
    }

    @Override
    public List<Task> retrieveAllTask() {
        LOGGER.warn("TaskQueryAdapterOutput.retrieveAllTask");
        return this.mapToListDomainTask(repository.findAll());
    }

    @Override
    public List<Task> retrieveTasksByIdentifier(Identifier identifier) {
        LOGGER.warn("TaskQueryAdapterOutput.retrieveTasksByIdentifier");
        return this.mapToListDomainTask(repository.findAll());
    }

    @Override
    public List<Task> retrieveTaskByResponsible(Responsible responsible) {
        LOGGER.warn("TaskQueryAdapterOutput.retrieveTaskByResponsible");
        return this.mapToListDomainTask(repository.findAll());
    }
}
