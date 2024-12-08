package com.ensah.core.controllers;

import com.ensah.core.bo.Admin;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Personnel;
import com.ensah.core.models.PersonModel;
import com.ensah.core.services.impl.EnseignantServiceImpl;
import com.ensah.core.services.impl.GroupeServiceImp;
import com.ensah.core.services.impl.EnseignantServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ensah.core.bo.*;
import com.ensah.core.services.IPersonnelService;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/**
 * Ce controleur gère les personnels de type Admin et  Enseignant
 * 
 *
 *
 */

@Controller

@RequestMapping("/admin")

public class PersonneMngController {
	@Autowired
	private GroupeServiceImp groupeService;

	@Autowired
	private IPersonnelService personService;
	@Autowired

	 private EnseignantServiceImpl EnseignantService;

	@Autowired
	private HttpSession httpSession;
	
	
	/** Utilisé pour la journalisation */
	private Logger LOGGER = LoggerFactory.getLogger(getClass());


	public PersonneMngController() {


		
		
	}

	@GetMapping(value = "showForm")
	public String showForm(@RequestParam int typePerson, Model model) {

		PersonModel pmodel = new PersonModel(typePerson);
		model.addAttribute("personModel", pmodel);

		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par PersonModel pour une meilleur flexibilité

		List<Personnel> persons = personService.getAllPersonnels();
		List<PersonModel> modelPersons = new ArrayList<PersonModel>();
		// On copie les données des personnes vers le modèle
		for (int i = 0; i < persons.size(); i++) {
			PersonModel pm = new PersonModel();
			if (persons.get(i) instanceof Admin) {
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
				BeanUtils.copyProperties((Admin) persons.get(i), pm);
				// On fixe le type (cet attribut ne sera pas copié automatiquement)
				pm.setTypePerson(PersonModel.TYPE_Administrateur);

				// Mettre la personne dans le modèle
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof Enseignant) {
				System.out.println("id est :"+persons.get(i).getIdPersonnel());

				BeanUtils.copyProperties((Enseignant) persons.get(i), pm);

				pm.setTypePerson(PersonModel.TYPE_PROF);
				modelPersons.add(pm);}

		
		}

		// Mettre la liste des personnes dans le modèle de Spring MVC
		model.addAttribute("personList", modelPersons);

		return "admin/form";
	}


	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	public String process(@Valid @ModelAttribute("personModel") PersonModel person, BindingResult bindingResult,
			Model model, HttpServletRequest rq) {

		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			// rq.setAttribute("typePerson", +person.getTypePerson());
			return "admin/form";
		}

		// Copier les données de l'objet PersonModel vers l'objet Etudiant (cas du
		// formulaire de l'étudiant)
		if (person.getTypePerson() == PersonModel.TYPE_Administrateur) {
			Admin ad = new Admin();
			BeanUtils.copyProperties(person, ad);

			personService.addPersonnel(ad);

		}
		// Copier les données de l'objet PersonModel vers l'objet Enseignant (cas du
		// formulaire de l'Enseignant)

		else if (person.getTypePerson() == PersonModel.TYPE_PROF) {
			Enseignant prof = new Enseignant();
			BeanUtils.copyProperties(person, prof);
			personService.addPersonnel(prof);

		}


		// rediriger vers l'action shwoForm avec le meme type de personne
		return "redirect:/admin/showForm?typePerson=" + person.getTypePerson();
	}

	@RequestMapping(value = "updatePersonForm/{idPerson}", method = RequestMethod.GET)
	public String updatePersonForm(@PathVariable("idPerson") int idPerson, Model model) {

		// On reoit comme paramètre l'id de la personne à mettre à jour
		Personnel utl = personService.getPersonnelById(Long.valueOf(idPerson));

		// On construit le modèle
		PersonModel pm = new PersonModel();

		// En fonction due type de l'utilisateur à modifier
		// Ceci va nous pemettre d'afficher un formulaire adapté
		// slon le type de la personne
		if (utl instanceof Admin) {
			BeanUtils.copyProperties((Admin) utl, pm);
			pm.setTypePerson(PersonModel.TYPE_Administrateur);
		} else if (utl instanceof Enseignant) {
			BeanUtils.copyProperties((Enseignant) utl, pm);
			pm.setTypePerson(PersonModel.TYPE_PROF);
		}

		// Initialiser le modele avec la personne
		model.addAttribute("personModel", pm);

		return "admin/updateForm";
	}

	@RequestMapping(value = "serachPerson", method = RequestMethod.GET)
	public String serachPerson(@RequestParam String cin, Model model) {

		// On reoit comme paramètre l'id de la personne à mettre à jour
		Personnel utl = personService.getPersonnelByCin(cin);

		if (utl == null) {

			// Initialiser le modele avec la personne
			model.addAttribute("personModel", new ArrayList<PersonModel>());
		} else {

			// On construit le modèle
			PersonModel pm = new PersonModel();

			// En fonction due type de l'utilisateur à modifier
			// Ceci va nous pemettre d'afficher un formulaire adapté
			// slon le type de la personne
			if (utl instanceof Admin) {
				BeanUtils.copyProperties((Admin) utl, pm);
				pm.setTypePerson(PersonModel.TYPE_Administrateur);
			} else if (utl instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) utl, pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
			}
			List<PersonModel> modelPersons = new ArrayList<PersonModel>();
			modelPersons.add(pm);
			// Initialiser le modele avec la personne
			model.addAttribute("personList", modelPersons);
		}
		return "admin/listPersons";
	}

	@RequestMapping("updatePerson")
	public String updatePerson(@Valid @ModelAttribute("personModel") PersonModel person, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "admin/updateForm";
		}

		// On copie les données du modèle vers l'objet métier puis on appel le service
		// pour faire la mise à jour
		if (person.getTypePerson() == PersonModel.TYPE_Administrateur) {
			Admin ad = new Admin();
			BeanUtils.copyProperties(person, ad);

			personService.updatePersonnel(ad);

		} else if (person.getTypePerson() == PersonModel.TYPE_PROF) {
			Enseignant prof = new Enseignant();
			BeanUtils.copyProperties(person, prof);
			personService.updatePersonnel(prof);

		}

		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		return "admin/updateForm";
	}

	@RequestMapping("managePersons")
	public String managePersons(Model model) {

		List<Personnel> persons = personService.getAllPersonnels();
		List<PersonModel> modelPersons = new ArrayList<PersonModel>();

		// Copier les objets metier vers PersonModel plus flexible
		for (int i = 0; i < persons.size(); i++) {
			PersonModel pm = new PersonModel();
			if (persons.get(i) instanceof Admin) {
				BeanUtils.copyProperties((Admin) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_Administrateur);
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
				modelPersons.add(pm);
			}
		}

		model.addAttribute("personList", modelPersons);

		return "admin/listPersons";
	}

	@RequestMapping(value = "deletePerson/{idPerson}", method = RequestMethod.GET)
	public String delete(@PathVariable int idPerson) {

		personService.deletePersonnel(Long.valueOf(idPerson));

		return "redirect:/admin/managePersons";
	}
	@GetMapping("manageGroups")
	public String manageGroups(Model model) {
		List<Groupe> groups = personService.getAllGroups();
		model.addAttribute("groupList", groups);
		model.addAttribute("newGroup", new Groupe());
		return "admin/listGroups";
	}

	@PostMapping("addGroup")
	public String addGroup(@ModelAttribute("newGroup") Groupe newGroup, Model model) {
		personService.addGroup(newGroup);
		return "redirect:/admin/manageGroups";
	}

	@GetMapping("group/{id}")
	public String viewGroup(@PathVariable("id") Long id, Model model) {
		Groupe group = personService.getGroupById(id);
		if (group != null) {
			model.addAttribute("group", group);
			model.addAttribute("enseignants", group.getEnseignants());
		} else {
			model.addAttribute("error", "Group not found");
		}
		return "admin/viewGroup";
	}
	@GetMapping("updateGroupName/{idGroupe}")
	public String updateGroup(@PathVariable("idGroupe") Long id, Model model) {
		Groupe group = personService.getGroupById(id);
		if (group != null) {
			model.addAttribute("group", group);
			model.addAttribute("enseignants", group.getEnseignants());
			System.out.println("the profs:"+group.getEnseignants());
		} else {
			model.addAttribute("error", "Group not found");
		}
		return "admin/viewGroup";
	}
	@RequestMapping("updateGroupName")
	public String updateGroupName(@ModelAttribute("group") Groupe group) {
		// Retrieve the group by ID
		System.out.println("here s your group id "+group.getIdGroupe());
		Groupe group1 = new Groupe();
		if (group != null) {

		BeanUtils.copyProperties(group, group1);



			personService.addGroup(group1);
		}
		// Redirect to the group details page
		return "redirect:/admin/manageGroups" ;
	}
	@GetMapping("addProfGroupe/{idGroupe}")
	public String addProfToGroup(@PathVariable("idGroupe") Long id, Model model) {
		Groupe group = personService.getGroupById(id);
		if (group != null) {
			model.addAttribute("group", group);
			List<Enseignant> allEnseignants = EnseignantService.getEnseignantsNotInGroup(id);
			model.addAttribute("allEnseignants", allEnseignants);
			System.out.println("the size of the profs is " + allEnseignants.size());
		} else {
			model.addAttribute("error", "Group not found");
		}
		return "admin/addProfGroupe";
	}
	/*@GetMapping("addProf/{id}")
	public String addProf( @PathVariable("id") Long id,Model model) {
		Groupe groupProf=(Groupe) model.getAttribute("group");
		 Long idGroup=groupProf.getIdGroupe();
		 Enseignant enseignant=EnseignantService.getEnseignantById(id);
		 groupeService.addEnseignantToGroup(idGroup,enseignant);



		return "redirect:/admin/addProfGroupe"+idGroup;
	}*/
	@GetMapping("addProf/{id}")
	public String addProf(@PathVariable("id") Long id, @RequestParam("idGroupe") Long idGroupe) {
		Groupe group = groupeService.getGroupById(idGroupe);
		if (group == null) {
			// Handle the error if the group is not found
			return "redirect:/admin/manageGroups";
		}
		System.out.println("The id of the group selected is: " + idGroupe);
		System.out.println("The id of the prof selected is: " + id);

		Enseignant enseignant = EnseignantService.getEnseignantById(id);
		if (enseignant != null) {
			System.out.println("The enseignant id is: " + enseignant.getIdPersonnel());
			enseignant.setGroupe(group); // Set the group in the enseignant
			groupeService.addEnseignantToGroup(idGroupe, enseignant); // Save changes
		}
		return "redirect:/admin/addProfGroupe/" + idGroupe;
	}
	@GetMapping("deleteProf/{enseignantId}")
	public String deleteProfFromGroup(@PathVariable("enseignantId") Long enseignantId, @RequestParam("idGroupe") Long idGroupe) {
		Groupe group = groupeService.getGroupById(idGroupe);
		Enseignant enseignant = EnseignantService.getEnseignantById(enseignantId);

		if (group != null && enseignant != null) {
			groupeService.removeEnseignantFromGroup(idGroupe, enseignant);
		}
		return "redirect:/admin/updateGroupName/" + idGroupe; // Adjust the redirection URL as needed
	}
	@RequestMapping(value = "deleteGroup/{idGroup}", method = RequestMethod.GET)
	public String deleteGroup(@PathVariable Long idGroup) {

		groupeService.deleteGroup(Long.valueOf(idGroup));

		return "redirect:/admin/managePersons";
	}




}
