package com.github.splendidpdf.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventCommand {

    EDIT_NAME("Edit name",
            "/edit_name"),

    EDIT_DESCRIPTION("Edit description",
            "/edit_desc"),

    EDIT_DATE("Edit date",
            "/edit_date");

    private final String name;

    private final String syntax;
}