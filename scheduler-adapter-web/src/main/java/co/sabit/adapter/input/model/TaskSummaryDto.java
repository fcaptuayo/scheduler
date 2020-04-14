package co.sabit.adapter.input.model;

import co.sabit.core.domain.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;

public class TaskSummaryDto {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskSummaryDto.class);

    private String addressPlace;

    private String codeCityPlace;

    private String codeCountryPlace;

    private String descriptionCityPlace;

    private String descriptionCountryPlace;

    private String dueDateTask;

    private String edificePlace;

    private String floorPlace;

    private String identifier;

    private String namePlace;

    private String startDateTask;

    private String responsibleNickname;

    private String typePlace;

    public TaskSummaryDto() {
        super();
    }

    public TaskSummaryDto(
            final String addressPlace,
            final String codeCityPlace,
            final String codeCountryPlace,
            final String descriptionCityPlace,
            final String descriptionCountryPlace,
            final String dueDateTask,
            final String edificePlace,
            final String floorPlace,
            final String identifier,
            final String namePlace,
            final String startDateTask,
            final String responsibleNickname,
            final String typePlace
    ) {
        LOGGER.warn("TaskSummaryDto.TaskDto");
        this.addressPlace = addressPlace;
        this.codeCityPlace = codeCityPlace;
        this.codeCountryPlace = codeCountryPlace;
        this.descriptionCityPlace = descriptionCityPlace;
        this.descriptionCountryPlace = descriptionCountryPlace;
        this.dueDateTask = dueDateTask;
        this.edificePlace = edificePlace;
        this.floorPlace = floorPlace;
        this.identifier = identifier;
        this.namePlace = namePlace;
        this.startDateTask = startDateTask;
        this.responsibleNickname = responsibleNickname;
        this.typePlace = typePlace;
    }

    public static TaskSummaryDto domainToDto(
            final Task domain
    ) {
        LOGGER.warn("TaskSummaryDto.domainToDto");
        return new TaskSummaryDto(
                domain.getPlace().getAddress().getValue(),
                domain.getPlace().getCity().getCode(),
                domain.getPlace().getCountry().getCode(),
                domain.getPlace().getCity().getDescription(),
                domain.getPlace().getCountry().getDescription(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(
                        domain.getLifeTime().getDueDate().getValue()
                ),
                domain.getPlace().getEdifice().getValue(),
                domain.getPlace().getFloor().getValue(),
                domain.getIdentifier().getReference().getValue(),
                domain.getPlace().getName().getValue(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(
                        domain.getLifeTime().getStartDate().getValue()
                ),
                domain.getResponsible().getNickname().getValue(),
                domain.getPlace().getType().getValue()
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

    public String getDueDateTask() {
        return dueDateTask;
    }

    public void setDueDateTask(String dueDateTask) {
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getStartDateTask() {
        return startDateTask;
    }

    public void setStartDateTask(String startDateTask) {
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
