package fr.rstr.apo.seance11.exo1;

public class Nat implements NatInterface {

    @Override
    public Nat zero() {
        return new Nat();
    }

    @Override
    public NatInterface succ() {
        return null;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public NatInterface pred() {
        return null;
    }

    @Override
    public NatInterface add(NatInterface y) {
        return null;
    }

    @Override
    public NatInterface mult(NatInterface y) {
        return null;
    }

    @Override
    public NatInterface subtract(NatInterface y) {
        return null;
    }

    @Override
    public boolean leq(NatInterface y) {
        return false;
    }

    @Override
    public void afficher() {

    }

    @Override
    public boolean equals(NatInterface y) {
        return false;
    }
}
