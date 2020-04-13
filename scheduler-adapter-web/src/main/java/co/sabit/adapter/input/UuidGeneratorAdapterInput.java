package co.sabit.adapter.input;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.port.input.IdGeneratorPortInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class UuidGeneratorAdapterInput implements IdGeneratorPortInput {
    private static final Logger LOGGER = LoggerFactory.getLogger(UuidGeneratorAdapterInput.class);

    @Override
    public Identifier generate() throws BusinessError {
        LOGGER.warn("UuidGeneratorAdapterInput.generate");
        return Identifier.build(UUID.randomUUID().toString().replace("-", ""));
    }
}
