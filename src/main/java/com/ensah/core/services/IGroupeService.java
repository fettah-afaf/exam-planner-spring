package com.ensah.core.services;

import com.ensah.core.bo.Enseignant;

public interface IGroupeService {
    public void addEnseignantToGroup(Long groupId, Enseignant enseignant);
    public void removeEnseignantFromGroup(Long groupId, Enseignant enseignant);
}
