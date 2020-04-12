package co.sabit.adapter.output.repository;

import co.sabit.adapter.output.model.TaskJpaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Objects;

@Transactional
public class TaskCommandRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCommandRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    public TaskCommandRepository(EntityManager entityManager) {
        LOGGER.warn("TaskCommandRepository.TaskCommandRepository");
        this.entityManager = entityManager;
    }

    public TaskJpaEntity save(TaskJpaEntity object) {
        LOGGER.warn("TaskCommandRepository.save");
        if (Objects.isNull(object.getId())) entityManager.persist(object);
        return object;
    }

    public TaskJpaEntity update(TaskJpaEntity object) {
        LOGGER.warn("TaskCommandRepository.update");
        return entityManager.merge(object);
    }
}
