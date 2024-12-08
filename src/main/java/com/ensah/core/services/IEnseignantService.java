package com.ensah.core.services;

import java.util.List;
import com.ensah.core.bo.Enseignant;

public interface IEnseignantService {

    public void addEnseignant(Enseignant enseignant);

    public void updateEnseignant(Enseignant enseignant);

    public List<Enseignant> getAllEnseignants();

    public void deleteEnseignant(Long id);

    public Enseignant getEnseignantById(Long id);
}
