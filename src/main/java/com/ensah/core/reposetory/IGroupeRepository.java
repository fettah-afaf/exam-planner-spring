package com.ensah.core.reposetory;

import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupeRepository extends JpaRepository<Groupe, Long> {
}
