package co.sabit.core.domain;

import co.sabit.core.domain.error.BusinessError;
import co.sabit.core.domain.error.PlaceError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Place {
    private static final Logger LOGGER = LoggerFactory.getLogger(Place.class);

    private final Address address;
    private final City city;
    private final Country country;
    private final Edifice edifice;
    private final Floor floor;
    private final Name name;
    private final Type type;

    private Place(
            final Address address,
            final City city,
            final Country country,
            final Edifice edifice,
            final Floor floor,
            final Name name,
            final Type type
    ) {
        LOGGER.warn("Place.Place");
        this.address = address;
        this.city = city;
        this.country = country;
        this.edifice = edifice;
        this.floor = floor;
        this.name = name;
        this.type = type;
    }

    public static class Address {
        private final String value;

        private Address(final String value) {
            this.value = value;
        }

        private void validate() throws BusinessError {
            if (this.value.isBlank()) throw new PlaceError.EmptyAddressValueError();
        }

        public String getValue() {
            return value;
        }
    }

    public static class City {
        private final String code;
        private final String description;

        private City(
                final String code,
                final String description
        ) {
            this.code = code;
            this.description = description;
        }

        private void validate() throws BusinessError {
            if (this.code.isBlank()) throw new PlaceError.EmptyCityCodeError();
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    public static class Country {
        private final String code;
        private final String description;

        private Country(
                final String code,
                final String description) {
            this.code = code;
            this.description = description;
        }

        private void validate() throws BusinessError {
            if (this.code.isBlank()) throw new PlaceError.EmptyCountryCodeError();
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }


    public static class Edifice {
        private final String value;

        private Edifice(
                final String value
        ) {
            this.value = value;
        }

        private void validate() throws BusinessError {
            if (this.value.isBlank()) throw new PlaceError.EmptyEdificeValueError();
        }

        public String getValue() {
            return value;
        }
    }

    public static class Floor {
        private final String value;

        private Floor(
                final String value
        ) {
            this.value = value;
        }

        private void validate() throws BusinessError {
            if (this.value.isBlank()) throw new PlaceError.EmptyEdificeValueError();
        }

        public String getValue() {
            return value;
        }
    }

    public static class Name {
        private final String value;

        private Name(
                final String value
        ) {
            this.value = value;
        }

        private void validate() throws BusinessError {
            if (this.value.isBlank()) throw new PlaceError.EmptyNameValueError();
        }

        public String getValue() {
            return value;
        }
    }

    public static class Type {
        private final TypePlace value;

        private Type(
                final String typePlace
        ) {
            value = ofStringToTypePlace(typePlace);
        }

        private void validate() throws BusinessError {
            if (this.value.equals(TypePlace.UNKNOWN)) throw new PlaceError.EmptyTypeValueError();
        }

        private TypePlace ofStringToTypePlace(final String typePlace) {
            if (Objects.nonNull(typePlace)) {
                final TypePlace typePlaceResult;
                switch (typePlace.trim().toUpperCase()) {
                    case "GENERIC":
                        typePlaceResult = TypePlace.GENERIC;
                        break;
                    case "OFFICIAL":
                        typePlaceResult = TypePlace.OFFICIAL;
                        break;
                    case "VIRTUAL":
                        typePlaceResult = TypePlace.VIRTUAL;
                        break;
                    default:
                        typePlaceResult = TypePlace.UNKNOWN;
                }
                return typePlaceResult;
            } else {
                return TypePlace.UNKNOWN;
            }
        }

        public String getValue() {
            return value.name();
        }
    }

    public enum TypePlace {
        GENERIC,
        OFFICIAL,
        UNKNOWN,
        VIRTUAL
    }

    public static Place build(
            final String address,
            final String codeCity,
            final String descriptionCity,
            final String codeCountry,
            final String descriptionCountry,
            final String edifice,
            final String floor,
            final String name,
            final String type
    ) throws BusinessError {
        LOGGER.warn("Place.build");
        Place object = new Place(
                new Address(address),
                new City(codeCity, descriptionCity),
                new Country(codeCountry, descriptionCountry),
                new Edifice(edifice),
                new Floor(floor),
                new Name(name),
                new Type(type)
        );
        object.validate();
        return object;
    }

    public void validate() throws BusinessError {
        this.address.validate();
        this.city.validate();
        this.country.validate();
        this.edifice.validate();
        this.floor.validate();
        this.name.validate();
        this.type.validate();
    }

    public Address getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public Edifice getEdifice() {
        return edifice;
    }

    public Floor getFloor() {
        return floor;
    }

    public Name getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
