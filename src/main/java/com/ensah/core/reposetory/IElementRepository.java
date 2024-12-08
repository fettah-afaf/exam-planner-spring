package com.ensah.core.reposetory;

import com.ensah.core.bo.ElementPedagogique;
import com.ensah.core.bo.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IElementRepository extends JpaRepository<ElementPedagogique, Long> {
}
