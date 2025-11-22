package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "workout_session")
@Getter


// TODO: Define the Event entity with appropriate fields and annotations
public class WorkoutSession {

    @Id
    private int id;
    private int trainingId;
    private String timestamp;
    private double startLatitude;
    private double startLongitude;
    private double endLatitude;
    private double endLongitude;
    private double altitude;
}
