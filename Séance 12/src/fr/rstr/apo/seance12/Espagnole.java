package fr.rstr.apo.seance12;

import java.util.regex.Pattern;

public class Espagnole extends Immatriculation {

    private static final Pattern pattern = Pattern.compile("[1-9]{4} [A-Z]{3}");

    public Espagnole(String immatriculation) throws ImmatException {
        super("ES", immatriculation);
        if (!pattern.matcher(immatriculation).find())
            throw new ImmatException("L'immatriculation ne correspond pas au format espagnol. Exemple : 1234 AAA");
    }
}
