package entity;


import java.util.Date;

public class Humen {
    private Integer id;
    private String lastName;
    private String name;
    private String middleName;
    private String login;
    private String password;
    private Date birthDate;
    private String city;
    private String country;

    public Humen() {
    }

    public Humen(Integer id, String lastName, String name, String middleName, String login, String password, Date birthDate, String city, String country) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.city = city;
        this.country = country;
    }

    public Humen(String lastName, String name, String middleName, String login, String password, Date birthDate, String city, String country) {
        this.id = null;
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.city = city;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Humen humen = (Humen) o;

        if (id != null ? !id.equals(humen.id) : humen.id != null) return false;
        if (lastName != null ? !lastName.equals(humen.lastName) : humen.lastName != null) return false;
        if (name != null ? !name.equals(humen.name) : humen.name != null) return false;
        if (middleName != null ? !middleName.equals(humen.middleName) : humen.middleName != null) return false;
        if (login != null ? !login.equals(humen.login) : humen.login != null) return false;
        if (password != null ? !password.equals(humen.password) : humen.password != null) return false;
        if (birthDate != null ? !birthDate.equals(humen.birthDate) : humen.birthDate != null) return false;
        if (city != null ? !city.equals(humen.city) : humen.city != null) return false;
        return country != null ? country.equals(humen.country) : humen.country == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Humen{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
