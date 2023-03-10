package com.example.speciality;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Speciality")
public class Speciality {
    @Id
    private Integer id;
    private String name;

    public Speciality() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
