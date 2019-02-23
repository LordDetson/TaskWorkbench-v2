package entity;

import java.util.Date;

public class Chief extends Humen {
    public Chief() {
    }

    public Chief(Integer id, String lastName, String name, String middleName, String login, String password, Date birthDate, String city, String country) {
        super(id, lastName, name, middleName, login, password, birthDate, city, country);
    }

    @Override
    public String toString() {
        return "Chief{" +
                "id=" + getId() +
                ", lastName='" + getLastName() + '\'' +
                ", name='" + getName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", birthDate=" + getBirthDate() +
                ", city='" + getCity() + '\'' +
                ", country='" + getCountry() + '\'' +
                '}';
    }
}
