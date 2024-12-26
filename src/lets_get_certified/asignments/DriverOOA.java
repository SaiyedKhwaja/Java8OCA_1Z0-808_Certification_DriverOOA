package lets_get_certified.asignments;

import java.util.ArrayList;
import java.util.List;

interface Excercise {
    double distanceCovered();

    void move();
}

interface OlymicSport {

}

interface BallSport {
}

public class DriverOOA {
    public static void main(String[] args) {

        List<Excercise> exercises = new ArrayList<>();

        Excercise soccer = new Soccer(12.5);
        exercises.add(soccer);

        Excercise sprint = new Sprint(0.1);
        exercises.add(sprint);

        Excercise stroll = new Stroll(10.0);
        exercises.add(stroll);

        Excercise raceWalking = new RaceWalking(5.0);
        exercises.add(raceWalking);

        performExercises(exercises);
    }

    public static void performExercises(List<Excercise> exercises) {
        for (Excercise exercise : exercises) {

            System.out.println(exercise.getClass().getSimpleName() + " - Distance: " + exercise.distanceCovered() + " km");

            if (exercise instanceof BallSport) {
                System.out.println(exercise.getClass().getSimpleName());
            }
            if (exercise instanceof OlymicSport) {
                System.out.println(exercise.getClass().getSimpleName());
            }
            exercise.move();
        }
    }
}

abstract class Run implements Excercise {
    private double distanceKm;

    public Run(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double distanceCovered() {
        return distanceKm;
    }

    public abstract void move();
}

abstract class Walk implements Excercise {

    private double distanceKm;

    public Walk(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    @Override
    public double distanceCovered() {
        return distanceKm;
    }

    public abstract void move();
}

class Soccer extends Run implements BallSport {
    public Soccer(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public void move() {
        System.out.println("Soccer::moving()");
    }
}

class Sprint extends Run {
    public Sprint(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public void move() {
        System.out.println("Sprint::moving()");
    }
}

class Stroll extends Walk {

    public Stroll(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public void move() {
        System.out.println("Stroll::moving()");
    }
}

class RaceWalking extends Walk implements OlymicSport {

    public RaceWalking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public void move() {
        System.out.println("RaceWalking::moving()");
    }
}







