package com.ensah.core.services;

import com.ensah.core.bo.Exam;

import java.util.List;

public interface IExamService {
    void addExam(Exam exam);

    void updateExam(Long id, Exam exam);

    void deleteExam(Long id);

    Exam getExamById(Long id);

    List<Exam> getAllExams();
}
