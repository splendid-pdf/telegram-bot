package com.github.splendidpdf.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PersonalMenuCommand {

    SHOW_PROFILE("Show my profile"),

    SHOW_GITHUB("Show github"),

    EVENTS_CALENDAR("Events calendar");

    private final String name;
}