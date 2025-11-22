package pl.wsb.fitnesstracker.userevent;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.event.Event;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;

@Entity
@Table(name = "user_event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "status", nullable = false)
    private String status; // np. REGISTERED, CANCELED, FINISHED


    @Column(name = "registered_at", nullable = false)
    private Date registeredAt;

    public UserEvent(
            final User user,
            final Event event,
            final String status,
            final Date registeredAt
    ) {
        this.user = user;
        this.event = event;
        this.status = status;
        this.registeredAt = registeredAt;
    }
}
