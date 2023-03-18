package com.github.splendidpdf.command;

import lombok.Getter;

@Getter
public enum EventCommand {

    EDIT_NAME("Edit name"),

    EDIT_DESCRIPTION("Edit description"),

    EDIT_DATE("Edit date");

    private final String name;

    EventCommand(String name) {
        this.name = name;
    }
}