package com.revature.models;

import java.util.Objects;

public class People {


    int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String bday;
    private String roletype;

    public People() {
    }

    public People(int id, String firstName, String lastName, String email, String password, String bday, String roletype) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bday = bday;
        this.roletype = roletype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return getId() == people.getId() && Objects.equals(getFirstName(), people.getFirstName()) && Objects.equals(getLastName(), people.getLastName()) && Objects.equals(getEmail(), people.getEmail()) && Objects.equals(getPassword(), people.getPassword()) && Objects.equals(getBday(), people.getBday()) && Objects.equals(getRoletype(), people.getRoletype());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getBday(), getRoletype());
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bday='" + bday + '\'' +
                ", roletype='" + roletype + '\'' +
                '}';
    }
}
