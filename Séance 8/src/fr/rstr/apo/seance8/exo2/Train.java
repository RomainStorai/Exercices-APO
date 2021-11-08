package fr.rstr.apo.seance8.exo2;

import java.util.ArrayList;

public class Train extends SegmentTrain {

    private final ArrayList<SegmentTrain> segments = new ArrayList<>();

    public Train(String reference) {
        super(reference, 0, 0, 0);
    }

    public void ajouterSegment(SegmentTrain segmentTrain) {
        segmentTrain.setAssignation(this);
        segments.add(segmentTrain);
    }

    public void enleverSegment(SegmentTrain segmentTrain) {
        segmentTrain.setAssignation(null);
        segments.remove(segmentTrain);
    }

    public void enleverSegment(int position) {
        enleverSegment(segments.get(position));
    }

    @Override
    public void setAssignation(Train ignored) {
        // Désactivation
    }

    @Override
    public double getPoidMax() {
        return segments.stream().mapToDouble(SegmentTrain::getPoidMax).sum();
    }

    @Override
    public double getCharge() {
        return segments.stream().mapToDouble(SegmentTrain::getCharge).sum();
    }

    @Override
    public double getLongueur() {
        return segments.stream().mapToDouble(SegmentTrain::getLongueur).sum();
    }

    @Override
    public double getPoidVide() {
        return segments.stream().mapToDouble(SegmentTrain::getPoidVide).sum();
    }

    @Override
    public String toString() {
        return "Train{" +
                "segments=" + segments +
                '}';
    }
}
