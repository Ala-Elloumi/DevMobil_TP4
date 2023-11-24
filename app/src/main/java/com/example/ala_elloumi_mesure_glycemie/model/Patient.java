package com.example.ala_elloumi_mesure_glycemie.model;

public class Patient {
    // Les attribues du classe Patient
    private int Age;
    private boolean Valeur;
    private float valeurMesure;
    private String Result;

    // Constructeur avec parametres
    public Patient(int Age, boolean Valeur, float valeurMesure) {
        this.Age = Age;
        this.Valeur = Valeur;
        this.valeurMesure = valeurMesure;
        calculer();
    }
    // Age getter
    public int getAge() {
        return Age;
    }
    // Valeur getter
    public boolean isValeur() {
        return Valeur;
    }
    // valeurMesure getter
    public float getValeurMesure() {
        return valeurMesure;
    }
    //result getter
    public String getResult() {
        return Result;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
    public void setValeur(Boolean Valeur) {
        this.Valeur = Valeur;
    }
    public void setValeurMesure(float valeurMesure) {
        this.valeurMesure = valeurMesure;
    }

    // Methode calculer
    private void calculer(){
        if (Valeur)
            if(Age>=13)
                if(valeurMesure<5.0)
                    Result="Le niveau de glycémie est bas";
                else if(valeurMesure>=5.0 && valeurMesure<=7.2)
                    Result="Le niveau de glycémie est normal";
                else
                    Result="Le niveau de glycémie est élevé";
            else if(Age>=6)
                if(valeurMesure<5.0)
                    Result="Le niveau de glycémie est bas";
                else if(valeurMesure>=5.0 && valeurMesure<=10.0)
                    Result="Le niveau de glycémie est normal";
                else 
                    Result="Le niveau de glycémie est élevé";
            else
                if(valeurMesure<5.5)
                    Result="Le niveau de glycémie est bas";
                else if(valeurMesure>=5.5 && valeurMesure<=10.0)
                    Result="Le niveau de glycémie est normal";
                else
                    Result="Le niveau de glycémie est élevé";
        else
            if(valeurMesure<=10.5)
                Result="Le niveau de glycémie est normal";
            else
                Result="Le niveau de glycémie est élevé";
    }

}
