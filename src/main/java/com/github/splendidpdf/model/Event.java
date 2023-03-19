package com.github.splendidpdf.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
@EqualsAndHashCode(of = "id")
public class Event {

    @Id
    @SequenceGenerator(name = "event_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
    private Long id;

    private String name;

    private String description;

    private LocalDateTime localDateTime;

    private String linkMeet;

    @ManyToOne(fetch = FetchType.LAZY)
    private BotUser botUser;
}