package co.sabit.adapter.output.model;

import co.sabit.core.domain.*;
import co.sabit.core.domain.error.BusinessError;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "tasks")
@NamedQueries({
        @NamedQuery(name = TaskJpaEntity.COUNT_ALL, query = "SELECT COUNT(TSK.id) FROM TaskJpaEntity TSK"),
        @NamedQuery(name = TaskJpaEntity.COUNT_BY_IDENTIFIER, query = "SELECT COUNT(TSK.id) FROM TaskJpaEntity TSK WHERE TSK.identifier = :" + TaskJpaEntity.PARAMETER_IDENTIFIER),
        @NamedQuery(name = TaskJpaEntity.GET_ALL, query = "SELECT TSK FROM TaskJpaEntity TSK")
})
public class TaskJpaEntity {
    public static final String COUNT_ALL = "TaskJpaEntity.countAll";
    public static final String COUNT_BY_IDENTIFIER = "TaskJpaEntity.countByIdentifier";
    public static final String GET_ALL = "TaskJpaEntity.getAll";
    public static final String PARAMETER_IDENTIFIER = "identifier";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "due_date", length = 200, nullable = false)
    private ZonedDateTime dueDate;

    @Column(name = "identifier", length = 200, nullable = false)
    private String identifier;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id", nullable = false)
    private PlaceJpaEntity place;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "responsible_id", nullable = false)
    private ResponsibleJpaEntity responsible;

    @Column(name = "start_date", length = 200, nullable = false)
    private ZonedDateTime startDate;

    public TaskJpaEntity() {
    }

    public TaskJpaEntity(ZonedDateTime dueDate, String identifier, PlaceJpaEntity place, ResponsibleJpaEntity responsible, ZonedDateTime startDate) {
        this.dueDate = dueDate;
        this.identifier = identifier;
        this.place = place;
        this.responsible = responsible;
        this.startDate = startDate;
    }

    public static TaskJpaEntity domainToEntity(final Task objectDomain) {
        return new TaskJpaEntity(
                objectDomain.getLifeTime().getDueDate().getValue(),
                objectDomain.getIdentifier().getReference().getValue(),
                new PlaceJpaEntity(
                        objectDomain.getPlace().getAddress().getValue(),
                        new CityJpaEntity(
                                objectDomain.getPlace().getCity().getCode(),
                                new CountryJpaEntity(
                                        objectDomain.getPlace().getCountry().getCode(),
                                        objectDomain.getPlace().getCountry().getDescription()
                                ),
                                objectDomain.getPlace().getCity().getDescription()
                        ),
                        objectDomain.getPlace().getEdifice().getValue(),
                        objectDomain.getPlace().getFloor().getValue(),
                        objectDomain.getPlace().getName().getValue(),
                        objectDomain.getPlace().getType().getValue()
                ),
                new ResponsibleJpaEntity(
                        objectDomain.getResponsible().getNickname().getValue()
                ),
                objectDomain.getLifeTime().getStartDate().getValue()
        );
    }

    public static Task entityToDomain(final TaskJpaEntity objectEntity) throws BusinessError {
        return Task.build(
                Identifier.build(
                        objectEntity.identifier
                ),
                LifeTime.build(
                        objectEntity.dueDate,
                        objectEntity.startDate
                ),
                Place.build(
                        objectEntity.place.getAddress(),
                        objectEntity.place.getCity().getCode(),
                        objectEntity.place.getCity().getDescription(),
                        objectEntity.place.getCity().getCountry().getCode(),
                        objectEntity.place.getCity().getCountry().getDescription(),
                        objectEntity.place.getEdifice(),
                        objectEntity.place.getFloor(),
                        objectEntity.place.getName(),
                        objectEntity.place.getType()
                ),
                Responsible.build(
                        objectEntity.responsible.getNickname()
                )
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(ZonedDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public PlaceJpaEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceJpaEntity place) {
        this.place = place;
    }

    public ResponsibleJpaEntity getResponsible() {
        return responsible;
    }

    public void setResponsible(ResponsibleJpaEntity responsible) {
        this.responsible = responsible;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }
}
