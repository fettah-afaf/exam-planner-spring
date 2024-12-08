package com.ensah.core.services.impl;
import com.ensah.core.bo.Exam;
import com.ensah.core.reposetory.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ensah.core.services.IExamService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExamServiceImpl implements IExamService {
    @Autowired
    private IExamRepository examRepository;

    @Override
    public void addExam(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public void updateExam(Long id, Exam exam) {
        exam.setIdExem(id);
        examRepository.save(exam);
    }

    @Override
    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    @Override
    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

}
