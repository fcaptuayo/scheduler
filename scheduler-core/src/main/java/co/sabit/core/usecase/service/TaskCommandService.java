package co.sabit.core.usecase.service;

import co.sabit.core.domain.*;
import co.sabit.core.error.CoreError;
import co.sabit.core.error.ServiceError;
import co.sabit.core.port.input.IdGeneratorPortInput;
import co.sabit.core.port.output.CreateTaskPortOutput;
import co.sabit.core.port.output.UpdateTaskPortOutput;
import co.sabit.core.usecase.TaskCommandUseCase;
import co.sabit.core.usecase.TaskValidatorUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskCommandService implements TaskCommandUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCommandService.class);

    private final CreateTaskPortOutput repositoryCreate;
    private final UpdateTaskPortOutput repositoryUpdate;
    private final TaskValidatorUseCase validator;
    private final IdGeneratorPortInput idGeneratorPortInput;

    public TaskCommandService(
            CreateTaskPortOutput repositoryCreate,
            UpdateTaskPortOutput repositoryUpdate,
            TaskValidatorUseCase validator,
            IdGeneratorPortInput idGeneratorPortInput
    ) {
        LOGGER.warn("TaskCommandService.TaskCommandService");
        this.repositoryCreate = repositoryCreate;
        this.repositoryUpdate = repositoryUpdate;
        this.validator = validator;
        this.idGeneratorPortInput = idGeneratorPortInput;
    }

    @Override
    public Identifier create(final Task object) throws CoreError {
        LOGGER.warn("TaskCommandService.create");
        Task objectToSave = Task.build(
                idGeneratorPortInput.generate(),
                object.getLifeTime(),
                object.getPlace(),
                object.getResponsible()
        );
        if (Boolean.TRUE.equals(validator.isPresent(objectToSave))) throw new ServiceError.ExistTask();
        return repositoryCreate.insert(objectToSave).getIdentifier();
    }

    @Override
    public Identifier update(final Task object) throws CoreError {
        LOGGER.warn("TaskCommandService.update");
        if (Boolean.FALSE.equals(validator.isPresent(object))) throw new ServiceError.NotExistTask();
        return repositoryUpdate.update(object).getIdentifier();
    }
}
