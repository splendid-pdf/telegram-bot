package com.github.splendidpdf.model;


import com.github.splendidpdf.command.Command;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "telegramId")
@NoArgsConstructor
@AllArgsConstructor
public class BotUser {

    @Id
    @SequenceGenerator(name = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;

    private Long telegramId;

    private String username;

    private Double longitude;

    private Double Latitude;

//    @Enumerated(EnumType.STRING)
//    private Command lastCommand;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private TimeZone timeZone;

}
