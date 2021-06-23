package com.example.sogneogcorona.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="kommune")
public class Kommune {

    @Id
    private int id;
    private String navn;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kommune")
    @OneToMany
    private Set<Sogne> sogne;

    public Kommune() {
    }

    public Set<Sogne> getSogne() {
        return sogne;
    }

    public void setSogne(Set<Sogne> sogne) {
        this.sogne = sogne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return id +
               " ";
    }
}
