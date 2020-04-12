package co.sabit.adapter.output.model;

import javax.persistence.*;

@Entity
@Table(name = "places")
public class PlaceJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private CityJpaEntity city;

    @Column(name = "edifice", length = 200, nullable = false)
    private String edifice;

    @Column(name = "floor", length = 200, nullable = false)
    private String floor;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "type", length = 200, nullable = false)
    private String type;

    public PlaceJpaEntity() {
    }

    public PlaceJpaEntity(String address, CityJpaEntity city, String edifice, String floor, String name, String type) {
        this.address = address;
        this.city = city;
        this.edifice = edifice;
        this.floor = floor;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CityJpaEntity getCity() {
        return city;
    }

    public void setCity(CityJpaEntity city) {
        this.city = city;
    }

    public String getEdifice() {
        return edifice;
    }

    public void setEdifice(String edifice) {
        this.edifice = edifice;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
