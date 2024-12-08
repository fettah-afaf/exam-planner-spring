package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idAdministrateur")
public class Admin extends Personnel {

    private String profession;


    @OneToMany(mappedBy = "administrateur")
    private Set<Surveillance> surveillances;


    public String getProfession() {
        return profession;
    }


    public void setProfession(String profession) {
        this.profession = profession;
    }


    public Set<Surveillance> getSurveillances() {
        return surveillances;
    }


    public void setSurveillances(Set<Surveillance> surveillances) {
        this.surveillances = surveillances;
    }




}
