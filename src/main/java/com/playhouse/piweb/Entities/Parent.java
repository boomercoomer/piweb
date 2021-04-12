package com.playhouse.piweb.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parents")
public class Parent extends User {

    @Column(name = "isdelegate")
    private Boolean isDelegate ;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;

    @OneToMany()
    @JoinColumn(name = "idevent")
    private List<Event> events;

    public Boolean getDelegate() {
        return isDelegate;
    }

    public void setDelegate(Boolean delegate) {
        isDelegate = delegate;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Parent(int iduser, String firstName, String lastName, String email, String login, String password, String phoneNumber, String address, Boolean isDelegate, List<Child> children, List<Event> events) {
        super(iduser, firstName, lastName, email, login, password, phoneNumber, address);
        this.isDelegate = isDelegate;
        this.children = children;
        this.events = events;
    }

    public Parent(Boolean isDelegate, List<Child> children, List<Event> events) {
        this.isDelegate = isDelegate;
        this.children = children;
        this.events = events;
    }

    public Parent() {
        super();
    }
}
