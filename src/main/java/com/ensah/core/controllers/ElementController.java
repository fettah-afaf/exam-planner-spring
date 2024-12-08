package com.ensah.core.controllers;

import com.ensah.core.bo.ElementPedagogique;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.services.IElementService;
import com.ensah.core.services.IEnseignantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/elements")
public class ElementController {

    @Autowired
    private IElementService elementService;

    @Autowired
    private IEnseignantService enseignantService;

    @GetMapping
    public String listElements(Model model) {
        List<ElementPedagogique> elements = elementService.getAllElements();
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        model.addAttribute("newElement", new ElementPedagogique());
        model.addAttribute("elements", elements);
        model.addAttribute("enseignants", enseignants);
        return "admin/elements";
    }

    @PostMapping("/addElement")
    public String createElement(@ModelAttribute("newElement") ElementPedagogique element,
                                @RequestParam("professeurId") Long professeurId,
                                @RequestParam("coordonnateurId") Long coordonnateurId) {
        Enseignant professeur = enseignantService.getEnseignantById(professeurId);
        Enseignant coordonnateur = enseignantService.getEnseignantById(coordonnateurId);
        element.setProfesseur(professeur);
        element.setCoordonnateur(coordonnateur);
        elementService.saveElement(element);
        return "redirect:/admin/elements";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        ElementPedagogique element = elementService.getElementById(id);
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        System.out.println("id of editedelement is "+elementService.getElementById(id));
        model.addAttribute("editedElement", element);
        System.out.println("id of edited element model is "+element.getIdElementPedagogique());
        model.addAttribute("enseignants", enseignants);
        List<ElementPedagogique> elements = elementService.getAllElements();
        model.addAttribute("elements", elements);
        return "admin/editElement";
    }

    @RequestMapping("/editElement")
    public String updateElement(@ModelAttribute("editedElement") ElementPedagogique element,
                                @RequestParam("professeurId") Long professeurId,
                                @RequestParam("coordonnateurId") Long coordonnateurId) {
        ElementPedagogique neweelement=new ElementPedagogique();

        System.out.println("id of editedelement in the post mapping is "+element.getIdElementPedagogique());
        System.out.println("hello hello");


        BeanUtils.copyProperties(element, neweelement);
        System.out.println("id of editedelement is "+neweelement.getIdElementPedagogique());
        System.out.println("hello");


        Enseignant professeur = enseignantService.getEnseignantById(professeurId);
        Enseignant coordonnateur = enseignantService.getEnseignantById(coordonnateurId);
        neweelement.setProfesseur(professeur);
        neweelement.setCoordonnateur(coordonnateur);
        elementService.updateElement(neweelement);
        return "redirect:/admin/elements";
    }

    @GetMapping("/delete/{id}")
    public String deleteElement(@PathVariable("id") Long id) {
        elementService.deleteElement(id);
        return "redirect:/admin/elements";
    }
}
