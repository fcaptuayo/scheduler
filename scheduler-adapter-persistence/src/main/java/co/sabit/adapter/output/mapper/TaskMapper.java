package co.sabit.adapter.output.mapper;

import co.sabit.adapter.output.model.TaskJpaEntity;
import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskMapper.class);

    public static Task entityToDomain(TaskJpaEntity objectEntity) throws BusinessError {
        LOGGER.warn("TaskMapper.entityToDomain");
        return TaskJpaEntity.entityToDomain(objectEntity);
    }

    public static TaskJpaEntity domainToEntity(Task objectDomain) {
        LOGGER.warn("TaskMapper.domainToEntity");
        return TaskJpaEntity.domainToEntity(objectDomain);
    }
}
