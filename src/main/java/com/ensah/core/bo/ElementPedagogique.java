package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ElementPedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElementPedagogique;

    private String nom;




    @OneToMany(mappedBy = "elementPedagogique",cascade = CascadeType.ALL)
    private Set<Exam> examens;



    private String niveau;


    private String typeElement;

    @ManyToOne
    @JoinColumn(name = "id_coordinator")
    private Enseignant coordonnateur;

    @ManyToOne
    @JoinColumn(name = "id_professeur")
    private Enseignant professeur;



}
