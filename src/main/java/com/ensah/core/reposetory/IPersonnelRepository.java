package com.ensah.core.reposetory;

import com.ensah.core.bo.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonnelRepository extends JpaRepository<Personnel, Long> {

	Personnel getPersonnelByCin(String cin);

}
