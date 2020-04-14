package co.sabit.core.domain;

import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.domain.error.LifeTimeError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class LifeTime {
    private static final Logger LOGGER = LoggerFactory.getLogger(LifeTime.class);

    private final DueDateLife dueDate;
    private final StartDateLife startDate;

    private LifeTime(
            final DueDateLife dueDate,
            final StartDateLife startDate
    ) {
        LOGGER.warn("LifeTime.LifeTime");
        this.dueDate = dueDate;
        this.startDate = startDate;
    }

    public static class DueDateLife {
        private final ZonedDateTime value;

        private DueDateLife(final ZonedDateTime dueDate) {
            value = dueDate;
        }

        private void validate() throws BusinessError {
            LOGGER.warn("LifeTime.DueDateLife.validate" + this.value);
            if (ZonedDateTime.now(ZoneOffset.UTC).isAfter(this.value))
                throw new LifeTimeError.InvalidDueDateLifeValueError();
        }

        public ZonedDateTime getValue() {
            return value;
        }
    }

    public static class StartDateLife {
        private final ZonedDateTime value;

        private StartDateLife(final ZonedDateTime startDate) {
            value = startDate;
        }

        private void validate() throws BusinessError {
            LOGGER.warn("LifeTime.StartDateLife.validate" + this.value);
            if (ZonedDateTime.now(ZoneOffset.UTC).isAfter(this.value))
                throw new LifeTimeError.InvalidStartDateLifeValueError();
        }

        public ZonedDateTime getValue() {
            return value;
        }
    }

    public static LifeTime build(
            final ZonedDateTime dueDate,
            final ZonedDateTime startDate
    ) throws BusinessError {
        LOGGER.warn("LifeTime.build");
        LifeTime object = new LifeTime(
                new DueDateLife(dueDate),
                new StartDateLife(startDate)
        );
        object.validate();
        return object;
    }

    public void validate() throws BusinessError {
        if (this.dueDate.value.isBefore(this.startDate.value))
            throw new LifeTimeError.InvalidDueDateLifeValueError();
        else if (this.startDate.value.isAfter(this.dueDate.value))
            throw new LifeTimeError.InvalidStartDateLifeValueError();
        else {
            this.dueDate.validate();
            this.startDate.validate();
        }
    }

    public StartDateLife getStartDate() {
        return startDate;
    }

    public DueDateLife getDueDate() {
        return dueDate;
    }
}
