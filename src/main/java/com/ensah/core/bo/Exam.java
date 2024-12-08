package com.ensah.core.bo;

import java.io.File;
import java.util.*;
import java.sql.Time;
import java.util.Date;


import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExem;
    @Temporal(TemporalType.DATE)

    private Date date;
    @Temporal(TemporalType.TIME)
    private Date  heureDebut;

    public String getTypeExam() {
        return typeExam;
    }

    public void setTypeExam(String typeExam) {
        this.typeExam = typeExam;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSession() {
        return session;
    }

    @Temporal(TemporalType.TIME)

    private Date heureFin;
    private int duréeprévue;

    public void setPv(File pv) {
        this.pv = pv;
    }

    public File getExamPaper() {
        return examPaper;
    }

    public File getPv() {
        return pv;
    }

    public String getRapportText() {
        return rapportText;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public Set<Surveillance> getSurveillances() {
        return Surveillances;
    }

    public ElementPedagogique getElementPedagogique() {
        return elementPedagogique;
    }

    public void setExamPaper(File examPaper) {
        this.examPaper = examPaper;
    }



    public void setRapportText(String rapportText) {
        this.rapportText = rapportText;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public void setSurveillances(Set<Surveillance> surveillances) {
        Surveillances = surveillances;
    }

    public void setElementPedagogique(ElementPedagogique elementPedagogique) {
        this.elementPedagogique = elementPedagogique;
    }

    private int duréeréelle;


    private File examPaper;
    private File pv;
    private String rapportText;
    private String anneeAcademique;

    private String typeExam;
    @OneToMany(mappedBy = "exam")
    private Set<Surveillance> Surveillances;

    private String semestre;


    private String session;
    @ManyToOne
    @JoinColumn(name = "id_element")
    private ElementPedagogique elementPedagogique;
    public Exam(Long idExem, Date date, Date heureDebut, Date heureFin, int duréeprévue, int duréeréelle,
              File pv, String typeExam, String semestre, String  session) {
        super();
        this.idExem = idExem;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.duréeprévue = duréeprévue;
        this.duréeréelle = duréeréelle;

        this.pv = pv;

        this.typeExam = typeExam;
        this.semestre = semestre;
        this.session = session;
    }

    public Exam(Long idExem, Date date, Date heureDebut, Date heureFin, int duréeprévue, int duréeréelle, File examPaper, File pv, String rapportText, String anneeAcademique, String typeExam, Set<Surveillance> surveillances, String semestre, String session, ElementPedagogique elementPedagogique) {
        this.idExem = idExem;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.duréeprévue = duréeprévue;
        this.duréeréelle = duréeréelle;

        this.pv = pv;
        this.examPaper = examPaper;

        this.rapportText = rapportText;
        this.anneeAcademique = anneeAcademique;
        this.typeExam = typeExam;
        Surveillances = surveillances;
        this.semestre = semestre;
        this.session = session;
        this.elementPedagogique = elementPedagogique;
    }

    public Exam() {}
    public Long getIdExem() {
        return idExem;
    }
    public void setIdExem(Long idExem) {
        this.idExem = idExem;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getHeureDebut() {
        return heureDebut;
    }
    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }
    public Date getHeureFin() {
        return heureFin;
    }
    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }
    public int getDuréeprévue() {
        return duréeprévue;
    }
    public void setDuréeprévue(int duréeprévue) {
        this.duréeprévue = duréeprévue;
    }
    public int getDuréeréelle() {
        return duréeréelle;
    }
    public void setDuréeréelle(int duréeréelle) {
        this.duréeréelle = duréeréelle;
    }




    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    

    @Override
    public String toString() {
        return "Exam [idExem=" + idExem + ", date=" + date + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin
                + ", duréeprévue=" + duréeprévue + ", duréeréelle=" + duréeréelle  + ", pv="
                + pv + ", typeExam=" + typeExam + ", semestre=" + semestre + ", session="
                + session + "]";
    }

}
