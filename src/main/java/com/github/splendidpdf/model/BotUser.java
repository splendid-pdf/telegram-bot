package com.github.splendidpdf.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(of = "telegramId")
public class BotUser {

    @Id
    @SequenceGenerator(name = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;

    private Long telegramId;

    private String username;

    private Double longitude;

    private Double Latitude;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private TimeZone timeZone;

    @OneToMany(mappedBy = "botUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Event> events;

    public void addEvent(Event event) {
        event.setBotUser(this);
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }
}