package com.playhouse.piweb.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

    @Entity
    @Table(name = "activities")
    public class Activity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idactivity")
        private int idActivity;

        @Column(name = "type")
        private String type;

        @Column(name = "description")
        private String description;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "idkinder")
        private Kindergarten kindergarten;

        public Activity(int idActivitie, String type, String description,  Kindergarten kindergarten) {
            this.idActivity = idActivitie;
            this.type = type;
            this.description = description;
            this.kindergarten = kindergarten;
        }

        public Activity() {
        }

        public int getIdActivitie() {
            return idActivity;
        }

        public void setIdActivitie(int idActivitie) {
            this.idActivity = idActivitie;
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

        public void setKindergarten(Kindergarten kindergarten) {
            this.kindergarten = kindergarten;
        }
}
