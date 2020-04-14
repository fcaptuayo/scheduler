package co.sabit.core.usecase.program;

import co.sabit.core.domain.Task;
import co.sabit.core.port.output.QueryTaskAlgebra;
import co.sabit.core.usecase.TaskValidatorAlgebra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskValidatorInterpreter implements TaskValidatorAlgebra {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskValidatorInterpreter.class);

    private final QueryTaskAlgebra queryRepository;

    public TaskValidatorInterpreter(QueryTaskAlgebra queryRepository) {
        LOGGER.warn("TaskValidatorService.TaskValidatorService");
        this.queryRepository = queryRepository;
    }

    @Override
    public Boolean isPresent(final Task object) {
        LOGGER.warn("TaskValidatorService.isPresent");
        return queryRepository.countTasksByIdentifier(object.getIdentifier()) > 0L ? Boolean.TRUE : Boolean.FALSE;
    }
}
