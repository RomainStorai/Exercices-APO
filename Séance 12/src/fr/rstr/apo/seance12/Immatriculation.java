package fr.rstr.apo.seance12;

public class Immatriculation {

    private final String codePays, immatriculation;

    public Immatriculation(String codePays, String immatriculation) {
        this.codePays = codePays;
        this.immatriculation = immatriculation;
    }

    public String getCodePays() {
        return codePays;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    @Override
    public String toString() {
        return "Immatriculation " + codePays + " " + immatriculation;
    }
}
