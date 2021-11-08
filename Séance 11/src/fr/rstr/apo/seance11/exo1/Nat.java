package fr.rstr.apo.seance11.exo1;

public class Nat implements NatInterface {

    private final Nat predecesseur;

    public Nat() {
        predecesseur = null;
    }

    public Nat(Nat suiv) {
        this.predecesseur = suiv;
    }

    @Override
    public NatInterface zero() {
        return new Nat();
    }

    @Override
    public NatInterface succ() {
        return new Nat(this);
    }

    @Override
    public int intValue() {
        if (isZero())
            return 0;
        return predecesseur.intValue() + 1;
    }

    @Override
    public boolean isZero() {
        return predecesseur == null;
    }

    @Override
    public NatInterface pred() {
        return predecesseur;
    }

    @Override
    public NatInterface add(NatInterface y) {
        if (y.isZero())
            return this;
        return this.add(y.pred()).succ();
    }

    @Override
    public NatInterface mult(NatInterface y) {
        if (y.isZero())
            return zero();
        return this.mult(y.pred()).add(this);
    }

    @Override
    public NatInterface subtract(NatInterface y) throws Exception {
        if (this.leq(y))
            throw new Exception();
        if (y.isZero())
            return this;
        return this.subtract(y.pred()).pred();
    }

    @Override
    public boolean leq(NatInterface y) {
        if (y.isZero())
            return false;
        if (isZero())
            return true;
        return pred().leq(y.pred());
    }

    @Override
    public void afficher() {
        System.out.println("Valeur : " + intValue());
    }

    @Override
    public boolean equals(NatInterface y) {
        if (isZero() && y.isZero())
            return true;
        if (y.isZero())
            return false;
        return this.pred().equals(y.pred());
    }

    @Override
    public String toString() {
        return String.valueOf(intValue());
    }
}
