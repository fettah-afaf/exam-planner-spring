package com.ensah.core.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long> {
	public Compte getCompteByLogin(String username);

}
