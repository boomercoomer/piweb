package com.playhouse.piweb.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfeedback")
    private int idFeedback;

    @Column(name = "note",nullable = false)
    private int note;

    @Column(name = "subjectfeedback")
    private String subjectFeedback;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idkinder" )
    private Kindergarten kindergarten;

    public Feedback(int idFeedback, int note, String subjectFeedback, Kindergarten kindergarten) {
        this.idFeedback = idFeedback;
        this.note = note;
        this.subjectFeedback = subjectFeedback;
        this.kindergarten = kindergarten;
    }

    public Feedback() {
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getSubjectFeedback() {
        return subjectFeedback;
    }

    public void setSubjectFeedback(String subjectFeedback) {
        this.subjectFeedback = subjectFeedback;
    }

    public Kindergarten getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }
}
