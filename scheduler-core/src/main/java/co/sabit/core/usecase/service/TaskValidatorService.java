package co.sabit.core.usecase.service;

import co.sabit.core.domain.Task;
import co.sabit.core.port.output.QueryTaskPortOutput;
import co.sabit.core.usecase.TaskValidatorUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskValidatorService implements TaskValidatorUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskValidatorService.class);

    private final QueryTaskPortOutput queryRepository;

    public TaskValidatorService(QueryTaskPortOutput queryRepository) {
        LOGGER.warn("TaskValidatorService.TaskValidatorService");
        this.queryRepository = queryRepository;
    }

    @Override
    public Boolean isPresent(final Task object) {
        LOGGER.warn("TaskValidatorService.isPresent");
        return queryRepository.countTasksByIdentifier(object.getIdentifier()) > 0L ? Boolean.TRUE : Boolean.FALSE;
    }
}
