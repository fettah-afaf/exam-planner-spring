package com.ensah.core.services.impl;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Groupe;
import com.ensah.core.reposetory.IEnseignantRepository;
import com.ensah.core.reposetory.IGroupeRepository;
import com.ensah.core.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class GroupeServiceImp implements IGroupeService {
    @Autowired
    private IGroupeRepository groupeRepository;
    @Autowired
    private IEnseignantRepository enseignantRepository;

    public List<Groupe> getAllGroups() {
        return groupeRepository.findAll();
    }

    public Groupe getGroupById(Long id) {
        return groupeRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
    }

    public void addGroup(Groupe group) {
        groupeRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupeRepository.deleteById(id);
    }


    @Override
    public void addEnseignantToGroup(Long groupId, Enseignant enseignant) {
        Groupe group = groupeRepository.findById(groupId).orElseThrow(() -> new RuntimeException("Group not found"));
        enseignant.setGroupe(group); // Set the group in the enseignant
        group.getEnseignants().add(enseignant); // Add enseignant to the group
        enseignantRepository.save(enseignant); // Save the enseignant with the group set
        groupeRepository.save(group); // Save the group to update the association
    }
    @Override
    public void removeEnseignantFromGroup(Long groupId, Enseignant enseignant) {
        Groupe group = groupeRepository.findById(groupId).orElseThrow(() -> new RuntimeException("Group not found"));
        if (group.getEnseignants().contains(enseignant)) {
            group.getEnseignants().remove(enseignant);
            enseignant.setGroupe(null); // Clear the group in the enseignant
            enseignantRepository.save(enseignant); // Save changes to the enseignant
            groupeRepository.save(group); // Save changes to the group
        }
    }
}
