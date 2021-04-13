package com.playhouse.piweb.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idevent")
    private int idEvent;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private Parent parent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idkinder" )
    private Kindergarten kindergarten;
    //constructor
    public Event(int idEvent, String type, String description, Parent parent, Kindergarten kindergarten) {
        this.idEvent = idEvent;
        this.type = type;
        this.description = description;
        this.parent = parent;
        this.kindergarten = kindergarten;
    }
    //Constructor General
    public Event() {
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Kindergarten getKindergarten() {
        return kindergarten;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setKindergarten(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }
}
