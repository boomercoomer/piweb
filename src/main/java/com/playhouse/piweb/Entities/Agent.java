package com.playhouse.piweb.Entities;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agent extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idkinder", nullable = true)
    private Kindergarten kindergarten;

    public Agent(int userid, String firstName, String lastName, String email, String login, String password, String phoneNumber, String address, Kindergarten kindergarten) {
        super(userid, firstName, lastName, email, login, password, phoneNumber, address);
        this.kindergarten = kindergarten;
    }

    public Agent(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }

    public Agent() {

    }

    public Kindergarten getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }
}

