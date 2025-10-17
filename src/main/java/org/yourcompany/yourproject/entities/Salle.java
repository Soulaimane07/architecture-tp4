package org.yourcompany.yourproject.entities;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "salles")
public class Salle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    
    @OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
    private List<Machine> machines;

    public Salle() {
    }

    public Salle(String code) {
        this.code = code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}