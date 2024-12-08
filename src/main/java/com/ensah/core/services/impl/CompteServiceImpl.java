package com.ensah.core.services.impl;

import java.util.List;

import com.ensah.core.bo.Personnel;
import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Role;
import com.ensah.core.bo.Compte;
import com.ensah.core.reposetory.IPersonnelRepository;
import com.ensah.core.reposetory.IRepositoryDao;
import com.ensah.core.reposetory.ICompteRepository;
import com.ensah.core.services.ICompteService;


@Service
@Transactional
public class CompteServiceImpl implements ICompteService {

	@Autowired
	private ICompteRepository userDao;

	@Autowired
	private IRepositoryDao roleDao;

	@Autowired
	private IPersonnelRepository personDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Role> getAllRoles() {
		return roleDao.findAll();
	}

	public List<Compte> getAllAccounts() {
		return userDao.findAll();
	}

	public String createUser(Long idRole, Long idPerson) {

		// récupérer la personne de la base de données
		Personnel person = personDao.findById(idPerson).get();

		// Créer le compte
		Compte userAccount = new Compte();

		// determiner la personne
		userAccount.setProprietaire(person);

		// Affecter le role
		userAccount.setRole(roleDao.findById(idRole).get());

		// génrer le mot de passe aléatoirement
		String generatedPass = generatePassayPassword();

		// hachage du mot de passe + gain de sel
		String encodedPass = passwordEncoder.encode(generatedPass);

		// affecter ce mot de passe
		userAccount.setPassword(encodedPass);

		// On construit un login de type "nom+prenom " s'il est dispo
		String login = person.getNom() + person.getPrenom();

		Compte account = userDao.getCompteByLogin(login);

		if (account == null) {

			userAccount.setLogin(login);

			// Créer le compte
			userDao.save(userAccount);
			return generatedPass;
		}

		int i = 0;

		// sinon, on cherche un login de type nom+prenom+"_"+ entier
		while (true) {

			login = person.getNom() + person.getPrenom() + "_" + i;
			account = userDao.getCompteByLogin(login);
			if (account == null) {
				userAccount.setLogin(login);

				// Créer le compte
				userDao.save(userAccount);
				return generatedPass;
			}

			i++;
		}
	}



	// génère le mot de passe. Il se base sur Passay
	public String generatePassayPassword() {
		CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);

		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = passwordGenerator.generatePassword(10, digits);

		return password;
	}

	@Override
	public Compte getAccountByUserName(String login) {
	

		return userDao.getCompteByLogin(login);
	}

}
