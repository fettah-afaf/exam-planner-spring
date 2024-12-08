package com.ensah.core.services.impl;

import java.util.List;

import com.ensah.core.bo.Groupe;
import com.ensah.core.bo.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.reposetory.IPersonnelRepository;
import com.ensah.core.reposetory.IGroupeRepository;
import com.ensah.core.services.IPersonnelService;


@Service
@Transactional
public class PersonnelServiceImpl implements IPersonnelService {

	@Autowired
	private IPersonnelRepository personDao;

	public List<Personnel> getAllPersonnels() {

		return personDao.findAll();
	}

	public void deletePersonnel(Long id) {
		personDao.deleteById(id);

	}

	public Personnel getPersonnelById(Long id) {
		return personDao.findById(id).get();

	}

	public void addPersonnel(Personnel pPerson) {
		personDao.save(pPerson);

	}

	public void updatePersonnel(Personnel pPerson) {
		personDao.save(pPerson);

	}


	public Personnel getPersonnelByCin(String cin) {

		return personDao.getPersonnelByCin(cin);

	}
	@Autowired
	private IGroupeRepository groupeRepository;

	// Existing methods...

	@Override
	public List<Groupe> getAllGroups() {
		return groupeRepository.findAll();
	}

	@Override
	public Groupe getGroupById(Long id) {
		return groupeRepository.findById(id).orElse(null);
	}

	@Override
	public void addGroup(Groupe group) {
		groupeRepository.save(group);
	}


}
