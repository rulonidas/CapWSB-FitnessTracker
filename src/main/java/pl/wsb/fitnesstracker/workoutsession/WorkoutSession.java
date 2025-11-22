package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import pl.wsb.fitnesstracker.training.api.Training;

@Entity
@Table(name = "workout_session")
@Getter


// TODO: Define the Event entity with appropriate fields and annotations
public class WorkoutSession {

    private final Training training;
    @Id
    private int id;

    private int trainingId;

    private String timestamp;

    private double startLatitude;

    private double startLongitude;

    private double endLatitude;

    private double endLongitude;

    private double altitude;
    public WorkoutSession(
            Training training,
            String timestamp,
            double startLatitude,
            double startLongitude,
            double endLatitude,
            double endLongitude,
            double altitude) {
        this.training = training;
        this.timestamp = timestamp;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.altitude = altitude;

    }
}
