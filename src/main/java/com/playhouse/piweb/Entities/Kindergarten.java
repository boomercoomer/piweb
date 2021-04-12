package com.playhouse.piweb.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "kindergartens")
public class Kindergarten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkinder")
    private int idKinder;

    @Column(name = "namekinder")
    private String nameKinder;

    @Column(name = "description")
    private String description;

    @Column(name = "contact")
    private String contact;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "kindergarten")
    private List<Activity> activities;
    //@JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "kindergarten")
    private List<Event> events;


    //@JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "kindergarten")
    private List<Feedback> feedbacks;

    @OneToMany()
    @JoinColumn(name="idagent")
    private List<Agent> agents;

    @OneToMany(mappedBy = "kindergartenChild")
    private List<Child> children;

    @Column(name = "creationdate",nullable = false)
    private Date creationDate;

    @Column(name = "phonekinder" , nullable = false)
    private String phoneKinder;

    public Kindergarten() {
    }

    public int getIdKinder() {
        return idKinder;
    }

    public void setIdKinder(int idKinder) {
        this.idKinder = idKinder;
    }

    public String getNameKinder() {
        return nameKinder;
    }

    public void setNameKinder(String nameKinder) {
        this.nameKinder = nameKinder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPhoneKinder() {
        return phoneKinder;
    }

    public void setPhoneKinder(String phoneKinder) {
        this.phoneKinder = phoneKinder;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Kindergarten(int idKinder, String nameKinder, String description, String contact, List<Activity> activities, List<Event> events, List<Feedback> feedbacks, List<Agent> agents, List<Child> children, Date creationDate, String phoneKinder) {
        this.idKinder = idKinder;
        this.nameKinder = nameKinder;
        this.description = description;
        this.contact = contact;
        this.activities = activities;
        this.events = events;
        this.feedbacks = feedbacks;
        this.agents = agents;
        this.children = children;
        this.creationDate = creationDate;
        this.phoneKinder = phoneKinder;
    }
}
