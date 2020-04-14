package co.sabit.core.domain;

import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.domain.error.IdentifierError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Identifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(Identifier.class);
    public static final Identifier DEFAULT = new Identifier(Id.DEFAULT_ID);

    private final Id reference;

    private Identifier(
            final Id reference
    ) {
        LOGGER.warn("Identifier.Identifier");
        this.reference = reference;
    }

    public static class Id {
        private static final Id DEFAULT_ID = new Id("DEFAULT");
        private final String value;

        private Id(final String value) {
            this.value = value;
        }

        private void validate() throws BusinessError {
            if (this.value.isBlank()) throw new IdentifierError.EmptyIDReferenceError();
        }

        public String getValue() {
            return value;
        }
    }

    public static Identifier build(
            final String reference
    ) throws BusinessError {
        LOGGER.warn("Identifier.build");
        Identifier object = new Identifier(
                new Id(reference)
        );
        object.validate();
        return object;
    }

    public void validate() throws BusinessError {
        this.reference.validate();
    }

    public Id getReference() {
        return this.reference;
    }
}
