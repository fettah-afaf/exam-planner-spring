package com.ensah.core.services;

import com.ensah.core.bo.Salle;

import java.util.List;

public interface ISalleService {
    public List<Salle> getAllSalles();
    public Salle getSalleById(Long id);

}
