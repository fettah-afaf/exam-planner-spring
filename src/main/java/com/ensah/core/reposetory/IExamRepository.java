package com.ensah.core.reposetory;

import com.ensah.core.bo.Exam;
import com.ensah.core.bo.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamRepository extends JpaRepository<Exam, Long> {
}
