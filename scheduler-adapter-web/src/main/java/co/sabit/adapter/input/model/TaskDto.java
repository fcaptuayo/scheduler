package co.sabit.adapter.input.model;

import co.sabit.core.domain.LifeTime;
import co.sabit.core.domain.Place;
import co.sabit.core.domain.Responsible;
import co.sabit.core.domain.Task;
import co.sabit.core.domain.error.BusinessError;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TaskDto {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskDto.class);

    private String addressPlace;

    private String codeCityPlace;

    private String codeCountryPlace;

    private String descriptionCityPlace;

    private String descriptionCountryPlace;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "America/Bogota")
    private Timestamp dueDateTask;

    private String edificePlace;

    private String floorPlace;

    private String namePlace;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
    private Timestamp startDateTask;

    private String responsibleNickname;

    private String typePlace;

    private TaskDto() {
        super();
    }

    public Task toDomain() throws BusinessError {
        LOGGER.warn("TaskDto.toDomain");
        LOGGER.warn(this.startDateTask.toString());
        LOGGER.warn(this.dueDateTask.toString());
        LOGGER.warn(this.addressPlace);
        LOGGER.warn(this.codeCityPlace);
        LOGGER.warn(this.descriptionCityPlace);
        LOGGER.warn(this.codeCountryPlace);
        LOGGER.warn(this.descriptionCountryPlace);
        LOGGER.warn(this.edificePlace);
        LOGGER.warn(this.floorPlace);
        LOGGER.warn(this.namePlace);
        LOGGER.warn(this.typePlace);
        LOGGER.warn(this.responsibleNickname);
        return Task.buildWithDefaultIdentifier(
                LifeTime.build(ZonedDateTime.of(dueDateTask.toLocalDateTime(), ZoneOffset.UTC), ZonedDateTime.of(startDateTask.toLocalDateTime(), ZoneOffset.UTC)),
                Place.build(addressPlace, codeCityPlace, descriptionCityPlace, codeCountryPlace, descriptionCountryPlace, edificePlace, floorPlace, namePlace, typePlace),
                Responsible.build(responsibleNickname)
        );
    }

    public String getAddressPlace() {
        return addressPlace;
    }

    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public String getCodeCityPlace() {
        return codeCityPlace;
    }

    public void setCodeCityPlace(String codeCityPlace) {
        this.codeCityPlace = codeCityPlace;
    }

    public String getCodeCountryPlace() {
        return codeCountryPlace;
    }

    public void setCodeCountryPlace(String codeCountryPlace) {
        this.codeCountryPlace = codeCountryPlace;
    }

    public String getDescriptionCityPlace() {
        return descriptionCityPlace;
    }

    public void setDescriptionCityPlace(String descriptionCityPlace) {
        this.descriptionCityPlace = descriptionCityPlace;
    }

    public String getDescriptionCountryPlace() {
        return descriptionCountryPlace;
    }

    public void setDescriptionCountryPlace(String descriptionCountryPlace) {
        this.descriptionCountryPlace = descriptionCountryPlace;
    }

    public Timestamp getDueDateTask() {
        return dueDateTask;
    }

    public void setDueDateTask(Timestamp dueDateTask) {
        this.dueDateTask = dueDateTask;
    }

    public String getEdificePlace() {
        return edificePlace;
    }

    public void setEdificePlace(String edificePlace) {
        this.edificePlace = edificePlace;
    }

    public String getFloorPlace() {
        return floorPlace;
    }

    public void setFloorPlace(String floorPlace) {
        this.floorPlace = floorPlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public Timestamp getStartDateTask() {
        return startDateTask;
    }

    public void setStartDateTask(Timestamp startDateTask) {
        this.startDateTask = startDateTask;
    }

    public String getResponsibleNickname() {
        return responsibleNickname;
    }

    public void setResponsibleNickname(String responsibleNickname) {
        this.responsibleNickname = responsibleNickname;
    }

    public String getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(String typePlace) {
        this.typePlace = typePlace;
    }
}
