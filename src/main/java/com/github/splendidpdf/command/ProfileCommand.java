package com.github.splendidpdf.command;

import lombok.Getter;

@Getter
public enum ProfileCommand {

    REGISTER("/start"),

    EDIT_ROLE("edit role"),

    EDIT_LOCATION("edit location");

    private final String name;

    ProfileCommand(String name) {
        this.name = name;
    }

}
