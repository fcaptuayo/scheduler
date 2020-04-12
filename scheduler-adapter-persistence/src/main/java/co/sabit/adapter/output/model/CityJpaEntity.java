package co.sabit.adapter.output.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class CityJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "code", length = 200, nullable = false)
    private String code;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryJpaEntity country;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    public CityJpaEntity() {
    }

    public CityJpaEntity(String code, CountryJpaEntity country, String description) {
        this.code = code;
        this.country = country;
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

    public CountryJpaEntity getCountry() {
        return country;
    }

    public void setCountry(CountryJpaEntity country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
