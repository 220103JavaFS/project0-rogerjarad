


package com.revature.models;

import java.util.Objects;

public class Login {


    public enum LoginType {
        CUSTOMER, EMPLOYEE, MANAGER, INVALID
    }

    int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LoginType loginType;

    public Login() {
    }

    public Login(int id, String firstName, String lastName, String email, String password, LoginType loginType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.loginType = loginType;
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Login(int id, String firstName, String lastName, String email, String password, String loginType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.loginType = stringToLoginType(loginType);
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

    public LoginType getPersonType() {
        return loginType;
    }

    public void setPersonType(LoginType loginType) {
        this.loginType = loginType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return getId() == login.getId() && Objects.equals(getFirstName(), login.getFirstName()) && Objects.equals(getLastName(), login.getLastName()) && Objects.equals(getEmail(), login.getEmail()) && Objects.equals(getPassword(), login.getPassword()) && getPersonType() == login.getPersonType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getPersonType());
    }

    private LoginType stringToLoginType(String r) {

        switch(r){
            case "CUSTOMER":
                return LoginType.CUSTOMER;
            case "EMPLOYEE":
                return LoginType.EMPLOYEE;
            case "MANAGER":
                return LoginType.MANAGER;
            default:
                return LoginType.INVALID;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", personType=" + loginType +
                '}';
    }
}
