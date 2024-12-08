package com.ensah.core.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class PersonModel {

	public static final int TYPE_PROF = 1;
	public static final int TYPE_Administrateur = 2;



	
	private Long idPersonnel;

	@NotBlank(message = "This field is required")
	private String nom;

	@NotBlank(message = "This field is required")
	private String prenom;
	
	@NotBlank(message = "This field is required")
	private String cin;


	
	@NotEmpty
	private String email;



	private String specialite;

	private String profession;
	private String departement;

	private String filiere;

	private int typePerson;
	
	
	public PersonModel() {
		
	}

	public String getDepartement() {
		return departement;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public PersonModel(int typePerson) {
		this.typePerson = typePerson;
	}




	public Long getIdPersonnel() {
		return idPersonnel;
	}

	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}







	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}



	public int getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(int typePerson) {
		this.typePerson = typePerson;
	}

	public static int getTypeProf() {
		return TYPE_PROF;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProfession() {
		return profession;
	}

	public static int getTypeAdminstrateur() {
		return TYPE_Administrateur;
	}




	@Override
	public String toString() {
		return "PersonModel [idPersonnel=" + idPersonnel + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", email=" + email +  ",departement"+ departement

		+",filiere"+ filiere + ", specialite=" + specialite  +  ", profession=" + profession + ", typePerson="
				+ typePerson + "]";
	}

}
