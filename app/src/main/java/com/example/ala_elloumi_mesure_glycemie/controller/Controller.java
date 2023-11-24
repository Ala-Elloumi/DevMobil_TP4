package com.example.ala_elloumi_mesure_glycemie.controller;

import com.example.ala_elloumi_mesure_glycemie.model.Patient;

public class Controller {
    // Attribue Patient
    private static Patient patient;

    // Attribue Singleton du classe Controller
    private static Controller instance = null;

    // Constructeur par default
    private Controller() {
        super();
    }
    // Methode createPatient
    public void createPatient(int age,boolean valeur,float valeurMesure){
        patient=new Patient(age,valeur,valeurMesure);
    }
    // Methode getReponse
    public String getReponse(){
        return patient.getResult();
    }

    // Methode getInstance
    public static final Controller getInstance(){
        if(Controller.instance == null)
            Controller.instance = new Controller();
        return Controller.instance;
    }
}
