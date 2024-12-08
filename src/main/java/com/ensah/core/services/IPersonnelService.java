package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Groupe;
import com.ensah.core.bo.Personnel;


public interface IPersonnelService {

	public void addPersonnel(Personnel pPerson);

	public void updatePersonnel(Personnel pPerson);

	public List<Personnel> getAllPersonnels();

	public void deletePersonnel(Long id);

	public Personnel getPersonnelById(Long id);
	
	public Personnel getPersonnelByCin(String cin);
	List<Groupe> getAllGroups();
	Groupe getGroupById(Long id);
	void addGroup(Groupe group);

	

	

}
