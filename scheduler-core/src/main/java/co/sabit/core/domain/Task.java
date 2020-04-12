package co.sabit.core.domain;

import co.sabit.core.domain.error.BusinessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

    private final Identifier identifier;
    private final LifeTime lifeTime;
    private final Place place;
    private final Responsible responsible;

    private Task(
            final Identifier identifier,
            final LifeTime lifeTime,
            final Place place,
            final Responsible responsible
    ) {
        LOGGER.warn("Task.Task");
        this.identifier = identifier;
        this.lifeTime = lifeTime;
        this.place = place;
        this.responsible = responsible;
    }

    public static Task buildWithDefaultIdentifier(
            final LifeTime lifeTime,
            final Place place,
            final Responsible responsible
    ) throws BusinessError {
        LOGGER.warn("Task.buildWithDefaultIdentifier");
        Task object = new Task(
                Identifier.DEFAULT,
                lifeTime,
                place,
                responsible
        );
        object.validate();
        return object;
    }

    public static Task build(
            final Identifier identifier,
            final LifeTime lifeTime,
            final Place place,
            final Responsible responsible
    ) throws BusinessError {
        LOGGER.warn("Task.build");
        Task object = new Task(
                identifier,
                lifeTime,
                place,
                responsible
        );
        object.validate();
        return object;
    }

    public void validate() throws BusinessError {
        this.getIdentifier().validate();
        this.getLifeTime().validate();
        this.getPlace().validate();
        this.getResponsible().validate();
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public LifeTime getLifeTime() {
        return lifeTime;
    }

    public Place getPlace() {
        return place;
    }

    public Responsible getResponsible() {
        return responsible;
    }
}
