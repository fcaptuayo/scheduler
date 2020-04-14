package co.sabit.adapter.input.program;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.port.input.IdGeneratorAlgebra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class UuidGeneratorInterpreterWeb implements IdGeneratorAlgebra {
    private static final Logger LOGGER = LoggerFactory.getLogger(UuidGeneratorInterpreterWeb.class);

    @Override
    public Identifier generate() throws BusinessError {
        LOGGER.warn("UuidGeneratorAdapterInput.generate");
        return Identifier.build(UUID.randomUUID().toString().replace("-", ""));
    }
}
