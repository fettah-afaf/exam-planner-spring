package com.ensah.core.services;

import java.util.List;


import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Role;



public interface ICompteService {
	
	public List<Role> getAllRoles();
	
	public List<Compte> getAllAccounts();
	
	public Compte getAccountByUserName(String login);
	
	public String createUser(Long idRole, Long idPerson);
	

}
