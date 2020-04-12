package co.sabit.adapter.output.repository;

import co.sabit.adapter.output.model.TaskJpaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TaskQueryRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskQueryRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    public TaskQueryRepository(EntityManager entityManager) {
        LOGGER.warn("TaskRepository.TaskRepository");
        this.entityManager = entityManager;
    }

    public Long count() {
        LOGGER.warn("TaskRepository.count");
        return entityManager.createNamedQuery(TaskJpaEntity.COUNT_ALL, Long.class).getSingleResult();
    }

    public List<TaskJpaEntity> findAll() {
        LOGGER.warn("TaskRepository.findAll");
        return entityManager.createNamedQuery(TaskJpaEntity.GET_ALL, TaskJpaEntity.class).getResultList();
    }
}
