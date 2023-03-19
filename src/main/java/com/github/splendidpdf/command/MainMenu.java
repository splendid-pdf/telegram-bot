package com.github.splendidpdf.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MainMenu {

    EVENTS_CALENDAR("\uD83D\uDDD3 Events calendar"),
    CREATE_EVENT("\uD83D\uDCEC Create event"),
    MY_PROFILE("\uD83D\uDC54 My profile"),
    PROJECT("\uD83D\uDDC2 Git projects");

    private final String name;
}