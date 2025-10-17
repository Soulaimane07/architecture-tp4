package org.yourcompany.yourproject.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@NamedNativeQuery(name = "findBetweenDateNative", query = "select * from machine where dateAchat between :d1 and :d2", resultClass = Machine.class)
@NamedQuery(name = "findBetweenDate", query = "from Machine where dateAchat between :d1 and :d2")
public class Machine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    
    @ManyToOne
    private Salle salle;

    public Machine(){}

    public Machine(String ref, Date dateAchat, Salle salle) {
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.salle = salle;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Salle getSalle() {
        return salle;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}