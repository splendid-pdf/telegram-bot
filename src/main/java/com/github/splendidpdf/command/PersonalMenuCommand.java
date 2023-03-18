package com.github.splendidpdf.command;

import lombok.Getter;

@Getter
public enum PersonalMenuCommand {

    SHOW_PROFILE("Show my profile"),

    SHOW_GITHUB("Show github"),

    EVENTS_CALENDAR("Events calendar");

    private final String name;

    PersonalMenuCommand(String name) {
        this.name = name;
    }
}