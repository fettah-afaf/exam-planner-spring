package com.ensah.core.controllers;

import com.ensah.core.bo.ElementPedagogique;
import com.ensah.core.bo.Exam;
import java.util.Date;

import com.ensah.core.bo.Salle;
import com.ensah.core.bo.Surveillance;
import com.ensah.core.services.IElementService;
import com.ensah.core.services.impl.ExamServiceImpl;
import com.ensah.core.services.impl.SalleServiceImpl;
import com.ensah.core.services.impl.SurveillanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/exams")
public class ExamController {
    @Autowired
    private IElementService elementService;


    @Autowired
    private ExamServiceImpl examService;

    @Autowired
    private SalleServiceImpl salleService;

    @Autowired
    private SurveillanceService surveillanceService;

   // @GetMapping("/add")
  //  public String showAddExamForm(Model model) {
    //    model.addAttribute("newExam", new Exam());
   //     return "add-exam-form";
  //  }

    @PostMapping("/add")
    public String addExam(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") Date date,
                          @DateTimeFormat(pattern = "HH:mm") @RequestParam("heureDebut") Date heureDebut,
                          @DateTimeFormat(pattern = "HH:mm") @RequestParam("heureFin") Date heureFin,
                          @RequestParam("duréeprévue") int duréeprévue,
                          @RequestParam("duréeréelle") int duréeréelle,
                          @RequestParam("typeExam") String typeExam,
                          @RequestParam("semestre") String semestre,
                          @RequestParam("session") String session,
                          @RequestParam("anneeAcademique") String anneeAcademique,
                          @RequestParam("elementPedagogique.idElementPedagogique") Long elementPedagogiqueId,
                          @RequestParam("selectedSalles") List<Long> selectedSalleIds,
                          Model model) {

        // Print all received parameters to the console for debugging
        System.out.println("Date: " + date);
        System.out.println("Heure début: " + heureDebut);
        System.out.println("Heure fin: " + heureFin);
        System.out.println("Durée prévue: " + duréeprévue);
        System.out.println("Durée réelle: " + duréeréelle);
        System.out.println("Type examen: " + typeExam);
        System.out.println("Semestre: " + semestre);
        System.out.println("Session: " + session);
        System.out.println("Année académique: " + anneeAcademique);
        System.out.println("Element pédagogique ID: " + elementPedagogiqueId);
        System.out.println("Selected salle IDs: " + selectedSalleIds);

        // Create and populate the newExam object
        Exam newExam = new Exam();
        newExam.setDate(date);
        newExam.setHeureDebut(heureDebut);
        newExam.setHeureFin(heureFin);
        newExam.setDuréeprévue(duréeprévue);
        newExam.setDuréeréelle(duréeréelle);
        newExam.setTypeExam(typeExam);
        newExam.setSemestre(semestre);
        newExam.setSession(session);
        newExam.setAnneeAcademique(anneeAcademique);


        // Set elementPedagogique
        ElementPedagogique elementPedagogique = elementService.getElementById(elementPedagogiqueId);
        newExam.setElementPedagogique(elementPedagogique);

        // Save the exam before setting the Surveillance objects
        examService.addExam(newExam);

        // Set selectedSalles
        if (selectedSalleIds != null) {
            Set<Salle> selectedSalles = selectedSalleIds.stream()
                    .map(salleService::getSalleById)
                    .collect(Collectors.toSet());
            for (Salle salle : selectedSalles) {
                Surveillance surveillance = new Surveillance();
                surveillance.setExam(newExam);
                surveillance.setSalle(salle);
                surveillanceService.addSurveillance(surveillance);
            }
        }
        // Optionally, redirect to another page
        return "redirect:/admin/exams";
    }


    @GetMapping("/edit/{id}")
    public String showEditExamForm(@PathVariable("id") Long id, Model model) {
        Exam exam = examService.getExamById(id);
        model.addAttribute("exam", exam);
        return "edit-exam-form";
    }

    @PostMapping("/edit/{id}")
    public String updateExam(@PathVariable("id") Long id, @ModelAttribute("exam") @Valid Exam exam,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "edit-exam-form";
        }
        examService.updateExam(id, exam);
        return "redirect:/admin/exams";
    }

    @GetMapping("/delete/{id}")
    public String deleteExam(@PathVariable("id") Long id) {
        examService.deleteExam(id);
        return "redirect:/admin/exams";
    }

    @GetMapping
    public String getAllExams(Model model) {
        List<Exam> exams = examService.getAllExams();
        model.addAttribute("newExam", new Exam());
        model.addAttribute("exams", exams);


        model.addAttribute("salles", salleService.getAllSalles());
        model.addAttribute("elements", elementService.getAllElements());



        return "admin/exams";
    }
}
