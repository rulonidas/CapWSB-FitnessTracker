package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.training.api.Training;

import java.util.Date;

@Entity
@Table(name = "workout_session")
@Getter

public class WorkoutSession {

    @Id

    private Long id;


    @Transient
    private Training training;


    @Column(name = "training_id", nullable = false)
    private Long trainingId;


    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    @Column(name = "start_latitude")
    private double startLatitude;

    @Column(name = "start_longitude")
    private double startLongitude;

    @Column(name = "end_latitude")
    private double endLatitude;

    @Column(name = "end_longitude")
    private double endLongitude;

    @Column(name = "altitude")
    private double altitude;

    public WorkoutSession(
            Training training,
            Date timestamp,
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
