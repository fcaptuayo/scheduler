package co.sabit.core.port.input;

import co.sabit.core.domain.Identifier;
import co.sabit.core.domain.error.BusinessError;

public interface IdGeneratorAlgebra {

    Identifier generate() throws BusinessError;

}
