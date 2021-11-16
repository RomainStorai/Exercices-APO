package fr.rstr.apo.seance12;

import java.util.regex.Pattern;

public class Francaise extends Immatriculation {

    private static final Pattern pattern = Pattern.compile("[A-Z]{2}-[1-9]{3}-[A-Z]{2}");

    public Francaise(String immatriculation) throws ImmatException {
        super("F", immatriculation);
        if (!pattern.matcher(immatriculation).find())
            throw new ImmatException("L'immatriculation ne correspond pas au format français. Exemple : AA-123-AA");
    }
}
