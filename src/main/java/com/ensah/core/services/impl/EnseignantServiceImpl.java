package com.ensah.core.services.impl;

import java.util.List;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.reposetory.IEnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ensah.core.services.IEnseignantService;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService {

    @Autowired
    private IEnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    public void addEnseignant(Enseignant enseignant) {
        enseignantRepository.save(enseignant);
    }

    public void updateEnseignant(Enseignant enseignant) {
        enseignantRepository.save(enseignant);
    }
    public List<Enseignant> getEnseignantsNotInGroup(Long groupId) {
        return enseignantRepository.findByGroupeIsNullOrGroupe_IdGroupeNot(groupId);
    }
}
