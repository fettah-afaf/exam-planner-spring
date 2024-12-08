package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Surveillance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSurveillance;



    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin administrateur ;

    @ManyToOne
    @JoinColumn(name = "idCordonnateur")
    private Enseignant coordonnateur ;

    @ManyToOne
    @JoinColumn(name = "id_salle")
    private Salle salle;

    @ManyToMany(mappedBy = "surveillances")
    private Set<Enseignant> enseignants;
    @ManyToOne
    @JoinColumn(name = "id_Exam")
    private Exam exam;




}
