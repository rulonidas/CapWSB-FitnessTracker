package pl.wsb.fitnesstracker.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "event")
@Getter
@NoArgsConstructor
public class Event {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


    @Column(name = "start_time", nullable = false)
    private Date startTime;


    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    public Event(String name,
                 String description,
                 Date startTime,
                 Date endTime,
                 String country,
                 String city) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.country = country;
        this.city = city;
    }
}
