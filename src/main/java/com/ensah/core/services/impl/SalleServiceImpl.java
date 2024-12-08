package com.ensah.core.services.impl;

import com.ensah.core.bo.Salle;
import com.ensah.core.reposetory.ISalleRepository;
import com.ensah.core.services.ISalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class SalleServiceImpl  implements ISalleService {
    @Autowired
    private ISalleRepository salleRepository;

    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }
    public Salle getSalleById(Long id) {
        return salleRepository.findById(id).orElse(null);
    }
}
