package com.github.splendidpdf.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProfileCommand {

    REGISTER("/start"),

    EDIT_ROLE("edit role"),

    EDIT_LOCATION("edit location");

    private final String name;
}
