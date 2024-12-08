package com.ensah.core.bo;


import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
@PrimaryKeyJoinColumn(name = "idEnseignent")
public class Enseignant  extends Personnel{

    private String specialite;


    @OneToMany(mappedBy = "coordonnateur")
    private Set<Surveillance> surveillancesCoor=new HashSet<Surveillance>() ;
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "nom_enseignant_survellance",
            joinColumns = @JoinColumn(name = "id_entite_enseignant"),
            inverseJoinColumns = @JoinColumn(name = "id_entite_survellance")
    )
    private Set<Surveillance> surveillances=new HashSet<Surveillance>();




    private String departement;

    private String filiere;
    @OneToMany(mappedBy = "professeur")
    private Set<ElementPedagogique> elements;

    @OneToMany(mappedBy = "coordonnateur")
    private Set<ElementPedagogique> elementsCoor;












}

