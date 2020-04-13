package co.sabit.adapter.output.model;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class CountryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "code", length = 200, nullable = false)
    private String code;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    public CountryJpaEntity() {
    }

    public CountryJpaEntity(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
