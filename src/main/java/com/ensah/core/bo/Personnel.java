package com.ensah.core.bo;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity @Setter @Getter @Data @NoArgsConstructor
@AllArgsConstructor

@Inheritance(strategy = InheritanceType.JOINED)
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;
    @NotNull @NotBlank
    private	String nom;
    @NotNull @NotBlank
    private  String  prenom;
    private String email;

    @Column(unique = true)
    private String cin;

    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, targetEntity = Compte.class)
    private Set<Compte> comptes;





}