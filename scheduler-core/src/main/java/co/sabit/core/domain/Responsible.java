package co.sabit.core.domain;

import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.domain.error.ResponsibleError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Responsible {
    private static final Logger LOGGER = LoggerFactory.getLogger(Responsible.class);

    private final Nickname nickname;

    private Responsible(
            final Nickname nickname
    ) {
        LOGGER.warn("Responsible.Responsible");
        this.nickname = nickname;
    }

    public static class Nickname {
        private final String value;

        private Nickname(final String dueDate) {
            value = dueDate;
        }

        private void validate() throws BusinessError {
            if (this.value.isBlank())
                throw new ResponsibleError.EmptyNicknameValueError();
        }

        public String getValue() {
            return value;
        }
    }

    public static Responsible build(
            final String nickname
    ) throws BusinessError {
        LOGGER.warn("Place.build");
        Responsible object = new Responsible(
                new Nickname(nickname)
        );
        object.validate();
        return object;
    }

    public void validate() throws BusinessError {
        this.nickname.validate();
    }

    public Nickname getNickname() {
        return nickname;
    }
}
