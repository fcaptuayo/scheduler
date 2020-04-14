package co.sabit.core.usecase.program;

import co.sabit.core.domain.*;
import co.sabit.core.error.CoreError;
import co.sabit.core.error.ServiceError;
import co.sabit.core.port.input.IdGeneratorAlgebra;
import co.sabit.core.port.output.CreateTaskAlgebra;
import co.sabit.core.port.output.UpdateTaskAlgebra;
import co.sabit.core.usecase.TaskCommandAlgebra;
import co.sabit.core.usecase.TaskValidatorAlgebra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskCommandInterpreter implements TaskCommandAlgebra {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCommandInterpreter.class);

    private final CreateTaskAlgebra repositoryCreate;
    private final UpdateTaskAlgebra repositoryUpdate;
    private final TaskValidatorAlgebra validator;
    private final IdGeneratorAlgebra idGeneratorAlgebra;

    public TaskCommandInterpreter(
            CreateTaskAlgebra repositoryCreate,
            UpdateTaskAlgebra repositoryUpdate,
            TaskValidatorAlgebra validator,
            IdGeneratorAlgebra idGeneratorAlgebra
    ) {
        LOGGER.warn("TaskCommandService.TaskCommandService");
        this.repositoryCreate = repositoryCreate;
        this.repositoryUpdate = repositoryUpdate;
        this.validator = validator;
        this.idGeneratorAlgebra = idGeneratorAlgebra;
    }

    @Override
    public Identifier create(final Task object) throws CoreError {
        LOGGER.warn("TaskCommandService.create");
        Task objectToSave = Task.build(
                idGeneratorAlgebra.generate(),
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
