class Training {
    private int avgPulse;
    private int duration;
    private int athleteWeight;

    public Training(int avgPulse, int duration, int athleteWeight) {
        this.avgPulse = avgPulse;
        this.duration = duration;
        this.athleteWeight = athleteWeight;
    }
    public double Calories() {
        return 0.014 * athleteWeight * duration * (0.12 * avgPulse - 7);
    }
    public void printTraining() {
        System.out.print("Duration: " + duration + " min. ");
    }
}
class RunningTraining extends Training {
    private double distance;
    public RunningTraining(int avgPulse, int duration, int athleteWeight, double distance) {
        super(avgPulse, duration, athleteWeight);
        this.distance=distance;
    }

    @Override
    public void printTraining() {
        System.out.print("Running training! ");
        super.printTraining();
        System.out.print("Distance: " + distance + " km. ");
    }
}

class CrossFitTraining extends Training{
    private double weight;

    public CrossFitTraining(int avgPulse, int duration, int athleteWeight, double weight) {
        super(avgPulse, duration, athleteWeight);
        this.weight=weight;
    }

    @Override
    public void printTraining() {
        System.out.print("CrossFit training! ");
        super.printTraining();
        System.out.print("Weight: " + weight + " kg. ");
    }
}

class KickBoxingTraining extends Training {

    public KickBoxingTraining(int avgPulse, int duration, int athleteWeight) {
        super(avgPulse, duration, athleteWeight);
    }

    @Override
    public void printTraining() {
        System.out.print("KickBoxing training! ");
        super.printTraining();
    }
}

public class FitnessTracker {
    public static void main (String[]args) {
        Training[] trainings = new Training[4];
        trainings[0] = new RunningTraining(150, 60, 75, 10);
        trainings[1] = new RunningTraining(130, 20, 87, 5);
        trainings[2] = new CrossFitTraining(140, 60, 75, 90);
        trainings[3] = new KickBoxingTraining(150, 80, 76);

        for (Training training : trainings) {

            training.printTraining();
            System.out.print("Calories burned: " + training.Calories());
            System.out.println();
        }
    }
}