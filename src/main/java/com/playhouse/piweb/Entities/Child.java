package com.playhouse.piweb.Entities;

import javax.persistence.*;

@Entity
public class Child {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idchild")
  private int idChild;

  @ManyToOne
  @JoinColumn(name = "idkinder")
  private Kindergarten kindergartenChild;

   @ManyToOne
   @JoinColumn(name = "iduser")
   private Parent parent;

  @Column(name = "firstname",nullable = false)
  private String firstName ;

  @Column(name = "lastname",nullable = false)
    private String lastName;

  @Column(name="health")
  private String health;

  @Column(name = "age" ,nullable = false)
  private int age;
}
