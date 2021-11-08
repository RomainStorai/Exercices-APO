package fr.rstr.apo.parking;

public interface Reponse {

    /**
     * Méthode appelée lors de la réussite d'entrée ou sortie du parking. Si lors de la sortie l'abonnement est dépassé, le boolean sera vrai
     *
     * @param abonnementDepasse true si l'abonnement est dépassé lors de la sortie
     */
    public abstract void reussite(boolean abonnementDepasse);

    /**
     * Méthode appelée lors de l'échec d'entrée ou sortie dans un parking
     *
     * @param raison String raison de l'échec
     */
    public abstract void echec(String raison);

}
