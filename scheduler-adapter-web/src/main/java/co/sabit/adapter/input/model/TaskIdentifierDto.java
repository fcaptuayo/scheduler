package co.sabit.adapter.input.model;

import co.sabit.core.domain.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskIdentifierDto {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskIdentifierDto.class);

    private String identifier;

    public TaskIdentifierDto() {
        super();
    }

    public TaskIdentifierDto(
            final String identifier
    ) {
        LOGGER.warn("TaskIdentifierDto.TaskIdentifierDto");
        this.identifier = identifier;
    }

    public static TaskIdentifierDto domainToDto(
            final Identifier identifier
    ) {
        LOGGER.warn("TaskIdentifierDto.domainToDto");
        return new TaskIdentifierDto(identifier.getReference().getValue());
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
