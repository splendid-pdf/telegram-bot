package com.github.splendidpdf.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CallbackDataAndBotState {

    EDIT_NAME("Edit name", "/edit_name"),

    EDIT_DESCRIPTION("Edit description", "/edit_desc"),

    EDIT_DATE("Edit date", "/edit_date"),

    PROFILE_FAVORITES("Favorites event", "/profile_favorites"),

    PROFILE_EVENTS("My events", "/profile_events"),

    ADD_TO_FAVORITE("add to favorite", "/add_to_favorite"),

    PROFILE_ROLE("Role", "/profile_role"),

    PROFILE_LOCATION("Location", "/profile_location"),

    PROJECT_ADD("Add project", "/project_add"),

    PROJECT_DELETE("Delete project", "project_delete"),

    PROJECT_PEOPLE("Project participants", "/project_people"),

    PROJECT_ALL("All projects", "/project_all");

    private final String name;

    private final String syntax;
}