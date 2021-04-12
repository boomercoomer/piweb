package com.playhouse.piweb.Entities;


import javax.persistence.*;
@MappedSuperclass
//@Entity
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser",length = 45,nullable = false)
    private int iduser;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false )
    private String email;

    @Column(name = "login", nullable = false )
    private String login;

    @Column(name = "password", nullable = false )
    private String password;

    @Column(name="phonenumber",nullable = false)
    private String phoneNumber;

    @Column(name="address",nullable = false)
    private String address;

    public User(int iduser, String firstName, String lastName, String email, String login, String password, String phoneNumber, String address) {
        this.iduser = iduser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User() {

    }

    public int getUserid() {
        return iduser;
    }

    public void setUserid(int userid) {
        this.iduser = userid;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
