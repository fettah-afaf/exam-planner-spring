package com.ensah.core.reposetory;

import com.ensah.core.bo.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEnseignantRepository extends JpaRepository<Enseignant, Long> {
    List<Enseignant> findByGroupeIsNullOrGroupe_IdGroupeNot(Long groupId);

}
